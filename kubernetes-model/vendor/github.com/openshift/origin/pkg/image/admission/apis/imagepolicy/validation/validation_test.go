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
package validation

import (
	"testing"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"

	"github.com/openshift/origin/pkg/image/admission/apis/imagepolicy"
)

func TestValidation(t *testing.T) {
	if errs := Validate(&imagepolicy.ImagePolicyConfig{}); len(errs) != 0 {
		t.Fatal(errs)
	}
	if errs := Validate(&imagepolicy.ImagePolicyConfig{
		ExecutionRules: []imagepolicy.ImageExecutionPolicyRule{
			{
				ImageCondition: imagepolicy.ImageCondition{
					MatchImageLabels: []metav1.LabelSelector{
						{MatchLabels: map[string]string{"test": "other"}},
					},
				},
			},
		},
	}); len(errs) != 0 {
		t.Fatal(errs)
	}
	if errs := Validate(&imagepolicy.ImagePolicyConfig{
		ExecutionRules: []imagepolicy.ImageExecutionPolicyRule{
			{
				ImageCondition: imagepolicy.ImageCondition{
					MatchImageLabels: []metav1.LabelSelector{
						{MatchLabels: map[string]string{"": ""}},
					},
				},
			},
		},
	}); len(errs) == 0 {
		t.Fatal(errs)
	}
	if errs := Validate(&imagepolicy.ImagePolicyConfig{
		ExecutionRules: []imagepolicy.ImageExecutionPolicyRule{
			{ImageCondition: imagepolicy.ImageCondition{Name: "test"}},
			{ImageCondition: imagepolicy.ImageCondition{Name: "test"}},
		},
	}); len(errs) == 0 {
		t.Fatal(errs)
	}

	if errs := Validate(&imagepolicy.ImagePolicyConfig{
		ResolveImages: imagepolicy.DoNotAttempt,
		ResolutionRules: []imagepolicy.ImageResolutionPolicyRule{
			{TargetResource: metav1.GroupResource{Resource: "test"}, Policy: imagepolicy.Attempt},
		},
	}); len(errs) != 0 {
		t.Fatal(errs)
	}

	if errs := Validate(&imagepolicy.ImagePolicyConfig{
		ResolveImages: imagepolicy.DoNotAttempt,
		ResolutionRules: []imagepolicy.ImageResolutionPolicyRule{
			{TargetResource: metav1.GroupResource{Resource: "test"}},
		},
	}); len(errs) == 0 {
		t.Fatal(errs)
	}

	if errs := Validate(&imagepolicy.ImagePolicyConfig{
		ResolveImages: imagepolicy.DoNotAttempt,
		ResolutionRules: []imagepolicy.ImageResolutionPolicyRule{
			{Policy: imagepolicy.Attempt},
		},
	}); len(errs) == 0 {
		t.Fatal(errs)
	}

	if errs := Validate(&imagepolicy.ImagePolicyConfig{
		ResolveImages: imagepolicy.DoNotAttempt,
		ExecutionRules: []imagepolicy.ImageExecutionPolicyRule{
			{ImageCondition: imagepolicy.ImageCondition{Name: "test", MatchDockerImageLabels: []imagepolicy.ValueCondition{{}}}},
		},
	}); len(errs) == 0 {
		t.Fatal(errs)
	}
	if errs := Validate(&imagepolicy.ImagePolicyConfig{
		ResolveImages: imagepolicy.DoNotAttempt,
		ExecutionRules: []imagepolicy.ImageExecutionPolicyRule{
			{ImageCondition: imagepolicy.ImageCondition{Name: "test", MatchImageLabels: []metav1.LabelSelector{{}}}},
		},
	}); len(errs) == 0 {
		t.Fatal(errs)
	}
	if errs := Validate(&imagepolicy.ImagePolicyConfig{
		ResolveImages: imagepolicy.DoNotAttempt,
		ExecutionRules: []imagepolicy.ImageExecutionPolicyRule{
			{ImageCondition: imagepolicy.ImageCondition{Name: "test", MatchImageAnnotations: []imagepolicy.ValueCondition{{}}}},
		},
	}); len(errs) == 0 {
		t.Fatal(errs)
	}
}
