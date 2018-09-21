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
	"testing"

	"k8s.io/apimachinery/pkg/runtime"

	v1 "github.com/openshift/api/route/v1"
	"github.com/openshift/origin/pkg/api/apihelpers/apitesting"
	"github.com/openshift/origin/pkg/route/apis/route"
)

func TestFieldSelectorConversions(t *testing.T) {
	apitesting.FieldKeyCheck{
		SchemeBuilder: []func(*runtime.Scheme) error{LegacySchemeBuilder.AddToScheme, route.LegacySchemeBuilder.AddToScheme},
		Kind:          LegacySchemeGroupVersion.WithKind("Route"),
		// Ensure previously supported labels have conversions. DO NOT REMOVE THINGS FROM THIS LIST
		AllowedExternalFieldKeys: []string{"spec.host", "spec.path", "spec.to.name"},
		FieldKeyEvaluatorFn:      route.RouteFieldSelector,
	}.Check(t)

	apitesting.FieldKeyCheck{
		SchemeBuilder: []func(*runtime.Scheme) error{SchemeBuilder.AddToScheme, route.SchemeBuilder.AddToScheme},
		Kind:          SchemeGroupVersion.WithKind("Route"),
		// Ensure previously supported labels have conversions. DO NOT REMOVE THINGS FROM THIS LIST
		AllowedExternalFieldKeys: []string{"spec.host", "spec.path", "spec.to.name"},
		FieldKeyEvaluatorFn:      route.RouteFieldSelector,
	}.Check(t)
}

func TestSupportingCamelConstants(t *testing.T) {
	scheme := runtime.NewScheme()
	LegacySchemeBuilder.AddToScheme(scheme)

	for k, v := range map[v1.TLSTerminationType]v1.TLSTerminationType{
		"Reencrypt":   v1.TLSTerminationReencrypt,
		"Edge":        v1.TLSTerminationEdge,
		"Passthrough": v1.TLSTerminationPassthrough,
	} {
		obj := &v1.Route{
			Spec: v1.RouteSpec{
				TLS: &v1.TLSConfig{Termination: k},
			},
		}
		scheme.Default(obj)
		if obj.Spec.TLS.Termination != v {
			t.Errorf("%s: did not default termination: %#v", k, obj)
		}
	}
}
