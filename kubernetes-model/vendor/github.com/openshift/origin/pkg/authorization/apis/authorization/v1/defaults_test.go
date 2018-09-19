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
package v1

import (
	"reflect"
	"testing"

	runtime "k8s.io/apimachinery/pkg/runtime"

	v1 "github.com/openshift/api/authorization/v1"
	authorizationapi "github.com/openshift/origin/pkg/authorization/apis/authorization"
)

var scheme = runtime.NewScheme()

func init() {
	LegacySchemeBuilder.AddToScheme(scheme)
	authorizationapi.LegacySchemeBuilder.AddToScheme(scheme)
	SchemeBuilder.AddToScheme(scheme)
	authorizationapi.SchemeBuilder.AddToScheme(scheme)
}

func TestDefaults(t *testing.T) {
	obj := &v1.PolicyRule{
		APIGroups: nil,
		Verbs:     []string{authorizationapi.VerbAll},
		Resources: []string{authorizationapi.ResourceAll},
	}
	out := &authorizationapi.PolicyRule{}
	if err := scheme.Convert(obj, out, nil); err != nil {
		t.Fatal(err)
	}
	if !reflect.DeepEqual(out.APIGroups, []string{authorizationapi.APIGroupAll}) {
		t.Errorf("did not default api groups: %#v", out)
	}
}
