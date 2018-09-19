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
	"testing"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	autoscalingapi "k8s.io/kubernetes/pkg/apis/autoscaling"
	"k8s.io/kubernetes/pkg/apis/batch"
	kapi "k8s.io/kubernetes/pkg/apis/core"

	testutil "github.com/openshift/origin/test/util"
	testserver "github.com/openshift/origin/test/util/server"
)

func TestExtensionsAPIDisabledAutoscaleBatchEnabled(t *testing.T) {
	const projName = "ext-disabled-batch-enabled-proj"

	masterConfig, err := testserver.DefaultMasterOptions()
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	defer testserver.CleanupMasterEtcd(t, masterConfig)

	// Disable all extensions API versions
	// Leave autoscaling/batch APIs enabled
	masterConfig.KubernetesMasterConfig.DisabledAPIGroupVersions = map[string][]string{"extensions": {"*"}}

	clusterAdminKubeConfig, err := testserver.StartConfiguredMaster(masterConfig)
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}

	clusterAdminKubeClient, err := testutil.GetClusterAdminKubeClient(clusterAdminKubeConfig)
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}

	clusterAdminClientConfig, err := testutil.GetClusterAdminClientConfig(clusterAdminKubeConfig)
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}

	// create the containing project
	if _, _, err := testserver.CreateNewProject(clusterAdminClientConfig, projName, "admin"); err != nil {
		t.Fatalf("unexpected error creating the project: %v", err)
	}
	projectAdminKubeClient, _, err := testutil.GetClientForUser(clusterAdminClientConfig, "admin")
	if err != nil {
		t.Fatalf("unexpected error getting project admin client: %v", err)
	}
	if err := testutil.WaitForPolicyUpdate(projectAdminKubeClient.Authorization(), projName, "get", autoscalingapi.Resource("horizontalpodautoscalers"), true); err != nil {
		t.Fatalf("unexpected error waiting for policy update: %v", err)
	}

	validJob := &batch.Job{
		ObjectMeta: metav1.ObjectMeta{Name: "myjob"},
		Spec: batch.JobSpec{
			Template: kapi.PodTemplateSpec{
				Spec: kapi.PodSpec{
					Containers:    []kapi.Container{{Name: "mycontainer", Image: "myimage"}},
					RestartPolicy: kapi.RestartPolicyNever,
				},
			},
		},
	}

	// make sure autoscaling and batch API objects can be listed and created
	if _, err := projectAdminKubeClient.Batch().Jobs(projName).List(metav1.ListOptions{}); err != nil {
		t.Fatalf("unexpected error: %#v", err)
	}
	if _, err := projectAdminKubeClient.Batch().Jobs(projName).Create(validJob); err != nil {
		t.Fatalf("unexpected error: %#v", err)
	}

	// Delete the containing project
	if err := testutil.DeleteAndWaitForNamespaceTermination(clusterAdminKubeClient, projName); err != nil {
		t.Fatalf("unexpected error: %#v", err)
	}

	// recreate the containing project
	if _, _, err := testserver.CreateNewProject(clusterAdminClientConfig, projName, "admin"); err != nil {
		t.Fatalf("unexpected error creating the project: %v", err)
	}
	projectAdminKubeClient, _, err = testutil.GetClientForUser(clusterAdminClientConfig, "admin")
	if err != nil {
		t.Fatalf("unexpected error getting project admin client: %v", err)
	}
	if err := testutil.WaitForPolicyUpdate(projectAdminKubeClient.Authorization(), projName, "get", autoscalingapi.Resource("horizontalpodautoscalers"), true); err != nil {
		t.Fatalf("unexpected error waiting for policy update: %v", err)
	}

	// make sure the created objects got cleaned up by namespace deletion
	if jobs, err := projectAdminKubeClient.Batch().Jobs(projName).List(metav1.ListOptions{}); err != nil {
		t.Fatalf("unexpected error: %#v", err)
	} else if len(jobs.Items) > 0 {
		t.Fatalf("expected 0 Job objects, got %#v", jobs.Items)
	}
}
