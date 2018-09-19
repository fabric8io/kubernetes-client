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
package build

import (
	"testing"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	kapi "k8s.io/kubernetes/pkg/apis/core"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
)

func TestBuildStrategy(t *testing.T) {
	ctx := apirequest.NewDefaultContext()
	if !Strategy.NamespaceScoped() {
		t.Errorf("Build is namespace scoped")
	}
	if Strategy.AllowCreateOnUpdate() {
		t.Errorf("Build should not allow create on update")
	}
	build := &buildapi.Build{
		ObjectMeta: metav1.ObjectMeta{Name: "buildid", Namespace: "default"},
		Spec: buildapi.BuildSpec{
			CommonSpec: buildapi.CommonSpec{
				Source: buildapi.BuildSource{
					Git: &buildapi.GitBuildSource{
						URI: "http://github.com/my/repository",
					},
					ContextDir: "context",
				},
				Strategy: buildapi.BuildStrategy{
					DockerStrategy: &buildapi.DockerBuildStrategy{},
				},
				Output: buildapi.BuildOutput{
					To: &kapi.ObjectReference{
						Kind: "DockerImage",
						Name: "repository/data",
					},
				},
			},
		},
	}
	Strategy.PrepareForCreate(ctx, build)
	if len(build.Status.Phase) == 0 || build.Status.Phase != buildapi.BuildPhaseNew {
		t.Errorf("Build phase is not New")
	}
	errs := Strategy.Validate(ctx, build)
	if len(errs) != 0 {
		t.Errorf("Unexpected error validating %v", errs)
	}

	build.ResourceVersion = "foo"
	errs = Strategy.ValidateUpdate(ctx, build, build)
	if len(errs) != 0 {
		t.Errorf("Unexpected error validating %v", errs)
	}
	invalidBuild := &buildapi.Build{}
	errs = Strategy.Validate(ctx, invalidBuild)
	if len(errs) == 0 {
		t.Errorf("Expected error validating")
	}
}
