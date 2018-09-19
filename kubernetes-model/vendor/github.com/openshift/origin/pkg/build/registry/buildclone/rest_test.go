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
package buildclone

import (
	"testing"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	apiserverrest "k8s.io/apiserver/pkg/registry/rest"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
	_ "github.com/openshift/origin/pkg/build/apis/build/install"
	"github.com/openshift/origin/pkg/build/generator"
)

func TestCreateClone(t *testing.T) {
	rest := CloneREST{&generator.BuildGenerator{Client: generator.TestingClient{
		CreateBuildFunc: func(ctx apirequest.Context, build *buildapi.Build) error {
			return nil
		},
		GetBuildFunc: func(ctx apirequest.Context, name string, options *metav1.GetOptions) (*buildapi.Build, error) {
			return &buildapi.Build{}, nil
		},
	}}}

	_, err := rest.Create(apirequest.NewDefaultContext(), &buildapi.BuildRequest{ObjectMeta: metav1.ObjectMeta{Name: "name"}}, apiserverrest.ValidateAllObjectFunc, false)
	if err != nil {
		t.Errorf("Unexpected error %v", err)
	}
}

func TestCreateCloneValidationError(t *testing.T) {
	rest := CloneREST{&generator.BuildGenerator{}}
	_, err := rest.Create(apirequest.NewDefaultContext(), &buildapi.BuildRequest{}, apiserverrest.ValidateAllObjectFunc, false)
	if err == nil {
		t.Error("Expected object got none!")
	}
}
