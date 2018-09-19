/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package integration

import (
	"io/ioutil"
	"testing"

	"k8s.io/apimachinery/pkg/api/errors"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"

	authorizationclient "github.com/openshift/origin/pkg/authorization/generated/internalclientset"
	authorizationinterfaces "github.com/openshift/origin/pkg/authorization/interfaces"
	"github.com/openshift/origin/pkg/cmd/server/bootstrappolicy"
	policy "github.com/openshift/origin/pkg/oc/admin/policy"
	testutil "github.com/openshift/origin/test/util"
	testserver "github.com/openshift/origin/test/util/server"
)

func TestPolicyCommands(t *testing.T) {
	masterConfig, clusterAdminKubeConfig, err := testserver.StartTestMasterAPI()
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	defer testserver.CleanupMasterEtcd(t, masterConfig)

	clusterAdminClientConfig, err := testutil.GetClusterAdminClientConfig(clusterAdminKubeConfig)
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}

	const projectName = "hammer-project"

	_, haroldConfig, err := testserver.CreateNewProject(clusterAdminClientConfig, projectName, "harold")
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	haroldAuthorizationClient := authorizationclient.NewForConfigOrDie(haroldConfig).Authorization()

	addViewer := policy.RoleModificationOptions{
		RoleName:            bootstrappolicy.ViewRoleName,
		RoleBindingAccessor: policy.NewLocalRoleBindingAccessor(projectName, haroldAuthorizationClient),
		Users:               []string{"valerie"},
		Groups:              []string{"my-group"},
	}

	if err := addViewer.AddRole(); err != nil {
		t.Fatalf("unexpected error: %v", err)
	}

	viewers, err := haroldAuthorizationClient.RoleBindings(projectName).Get("view", metav1.GetOptions{})
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	binding := authorizationinterfaces.NewLocalRoleBindingAdapter(viewers)
	if !binding.Users().Has("valerie") {
		t.Errorf("expected valerie in users: %v", binding.Users())
	}
	if !binding.Groups().Has("my-group") {
		t.Errorf("expected my-group in groups: %v", binding.Groups())
	}

	removeValerie := policy.RemoveFromProjectOptions{
		BindingNamespace: projectName,
		Client:           haroldAuthorizationClient,
		Users:            []string{"valerie"},
		Out:              ioutil.Discard,
	}
	if err := removeValerie.Run(); err != nil {
		t.Fatalf("unexpected error: %v", err)
	}

	viewers, err = haroldAuthorizationClient.RoleBindings(projectName).Get("view", metav1.GetOptions{})
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	binding = authorizationinterfaces.NewLocalRoleBindingAdapter(viewers)
	if binding.Users().Has("valerie") {
		t.Errorf("unexpected valerie in users: %v", binding.Users())
	}
	if !binding.Groups().Has("my-group") {
		t.Errorf("expected my-group in groups: %v", binding.Groups())
	}

	removeMyGroup := policy.RemoveFromProjectOptions{
		BindingNamespace: projectName,
		Client:           haroldAuthorizationClient,
		Groups:           []string{"my-group"},
		Out:              ioutil.Discard,
	}
	if err := removeMyGroup.Run(); err != nil {
		t.Fatalf("unexpected error: %v", err)
	}

	// Check that the removal of the last subject caused the rolebinding to be
	// removed as well
	viewers, err = haroldAuthorizationClient.RoleBindings(projectName).Get("view", metav1.GetOptions{})
	if !errors.IsNotFound(err) {
		t.Fatalf("unexpected error: %v", err)
	}
	binding = authorizationinterfaces.NewLocalRoleBindingAdapter(viewers)
	if binding.Users().Has("valerie") {
		t.Errorf("unexpected valerie in users: %v", binding.Users())
	}
	if binding.Groups().Has("my-group") {
		t.Errorf("unexpected my-group in groups: %v", binding.Groups())
	}

}
