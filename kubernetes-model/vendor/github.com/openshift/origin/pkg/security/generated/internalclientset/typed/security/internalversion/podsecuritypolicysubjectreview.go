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
package internalversion

import (
	security "github.com/openshift/origin/pkg/security/apis/security"
	rest "k8s.io/client-go/rest"
)

// PodSecurityPolicySubjectReviewsGetter has a method to return a PodSecurityPolicySubjectReviewInterface.
// A group's client should implement this interface.
type PodSecurityPolicySubjectReviewsGetter interface {
	PodSecurityPolicySubjectReviews(namespace string) PodSecurityPolicySubjectReviewInterface
}

// PodSecurityPolicySubjectReviewInterface has methods to work with PodSecurityPolicySubjectReview resources.
type PodSecurityPolicySubjectReviewInterface interface {
	Create(*security.PodSecurityPolicySubjectReview) (*security.PodSecurityPolicySubjectReview, error)
	PodSecurityPolicySubjectReviewExpansion
}

// podSecurityPolicySubjectReviews implements PodSecurityPolicySubjectReviewInterface
type podSecurityPolicySubjectReviews struct {
	client rest.Interface
	ns     string
}

// newPodSecurityPolicySubjectReviews returns a PodSecurityPolicySubjectReviews
func newPodSecurityPolicySubjectReviews(c *SecurityClient, namespace string) *podSecurityPolicySubjectReviews {
	return &podSecurityPolicySubjectReviews{
		client: c.RESTClient(),
		ns:     namespace,
	}
}

// Create takes the representation of a podSecurityPolicySubjectReview and creates it.  Returns the server's representation of the podSecurityPolicySubjectReview, and an error, if there is any.
func (c *podSecurityPolicySubjectReviews) Create(podSecurityPolicySubjectReview *security.PodSecurityPolicySubjectReview) (result *security.PodSecurityPolicySubjectReview, err error) {
	result = &security.PodSecurityPolicySubjectReview{}
	err = c.client.Post().
		Namespace(c.ns).
		Resource("podsecuritypolicysubjectreviews").
		Body(podSecurityPolicySubjectReview).
		Do().
		Into(result)
	return
}
