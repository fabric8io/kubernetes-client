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

	"github.com/openshift/origin/pkg/api/apihelpers/apitesting"
	userapi "github.com/openshift/origin/pkg/user/apis/user"
)

func TestFieldSelectorConversions(t *testing.T) {
	apitesting.FieldKeyCheck{
		SchemeBuilder: []func(*runtime.Scheme) error{LegacySchemeBuilder.AddToScheme, userapi.LegacySchemeBuilder.AddToScheme},
		Kind:          LegacySchemeGroupVersion.WithKind("Identity"),
		// Ensure previously supported labels have conversions. DO NOT REMOVE THINGS FROM THIS LIST
		AllowedExternalFieldKeys: []string{"providerName", "providerUserName", "user.name", "user.uid"},
		FieldKeyEvaluatorFn:      userapi.IdentityFieldSelector,
	}.Check(t)

	apitesting.FieldKeyCheck{
		SchemeBuilder: []func(*runtime.Scheme) error{SchemeBuilder.AddToScheme, userapi.SchemeBuilder.AddToScheme},
		Kind:          SchemeGroupVersion.WithKind("Identity"),
		// Ensure previously supported labels have conversions. DO NOT REMOVE THINGS FROM THIS LIST
		AllowedExternalFieldKeys: []string{"providerName", "providerUserName", "user.name", "user.uid"},
		FieldKeyEvaluatorFn:      userapi.IdentityFieldSelector,
	}.Check(t)
}
