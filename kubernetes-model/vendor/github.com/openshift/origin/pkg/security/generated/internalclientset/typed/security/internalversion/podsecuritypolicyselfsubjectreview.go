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

// PodSecurityPolicySelfSubjectReviewsGetter has a method to return a PodSecurityPolicySelfSubjectReviewInterface.
// A group's client should implement this interface.
type PodSecurityPolicySelfSubjectReviewsGetter interface {
	PodSecurityPolicySelfSubjectReviews(namespace string) PodSecurityPolicySelfSubjectReviewInterface
}

// PodSecurityPolicySelfSubjectReviewInterface has methods to work with PodSecurityPolicySelfSubjectReview resources.
type PodSecurityPolicySelfSubjectReviewInterface interface {
	Create(*security.PodSecurityPolicySelfSubjectReview) (*security.PodSecurityPolicySelfSubjectReview, error)
	PodSecurityPolicySelfSubjectReviewExpansion
}

// podSecurityPolicySelfSubjectReviews implements PodSecurityPolicySelfSubjectReviewInterface
type podSecurityPolicySelfSubjectReviews struct {
	client rest.Interface
	ns     string
}

// newPodSecurityPolicySelfSubjectReviews returns a PodSecurityPolicySelfSubjectReviews
func newPodSecurityPolicySelfSubjectReviews(c *SecurityClient, namespace string) *podSecurityPolicySelfSubjectReviews {
	return &podSecurityPolicySelfSubjectReviews{
		client: c.RESTClient(),
		ns:     namespace,
	}
}

// Create takes the representation of a podSecurityPolicySelfSubjectReview and creates it.  Returns the server's representation of the podSecurityPolicySelfSubjectReview, and an error, if there is any.
func (c *podSecurityPolicySelfSubjectReviews) Create(podSecurityPolicySelfSubjectReview *security.PodSecurityPolicySelfSubjectReview) (result *security.PodSecurityPolicySelfSubjectReview, err error) {
	result = &security.PodSecurityPolicySelfSubjectReview{}
	err = c.client.Post().
		Namespace(c.ns).
		Resource("podsecuritypolicyselfsubjectreviews").
		Body(podSecurityPolicySelfSubjectReview).
		Do().
		Into(result)
	return
}
