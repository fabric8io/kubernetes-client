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
package fake

import (
	security "github.com/openshift/origin/pkg/security/apis/security"
	schema "k8s.io/apimachinery/pkg/runtime/schema"
	testing "k8s.io/client-go/testing"
)

// FakePodSecurityPolicySubjectReviews implements PodSecurityPolicySubjectReviewInterface
type FakePodSecurityPolicySubjectReviews struct {
	Fake *FakeSecurity
	ns   string
}

var podsecuritypolicysubjectreviewsResource = schema.GroupVersionResource{Group: "security.openshift.io", Version: "", Resource: "podsecuritypolicysubjectreviews"}

var podsecuritypolicysubjectreviewsKind = schema.GroupVersionKind{Group: "security.openshift.io", Version: "", Kind: "PodSecurityPolicySubjectReview"}

// Create takes the representation of a podSecurityPolicySubjectReview and creates it.  Returns the server's representation of the podSecurityPolicySubjectReview, and an error, if there is any.
func (c *FakePodSecurityPolicySubjectReviews) Create(podSecurityPolicySubjectReview *security.PodSecurityPolicySubjectReview) (result *security.PodSecurityPolicySubjectReview, err error) {
	obj, err := c.Fake.
		Invokes(testing.NewCreateAction(podsecuritypolicysubjectreviewsResource, c.ns, podSecurityPolicySubjectReview), &security.PodSecurityPolicySubjectReview{})

	if obj == nil {
		return nil, err
	}
	return obj.(*security.PodSecurityPolicySubjectReview), err
}
