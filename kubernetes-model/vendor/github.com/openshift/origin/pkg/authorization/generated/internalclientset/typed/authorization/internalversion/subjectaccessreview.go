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
	authorization "github.com/openshift/origin/pkg/authorization/apis/authorization"
	rest "k8s.io/client-go/rest"
)

// SubjectAccessReviewsGetter has a method to return a SubjectAccessReviewInterface.
// A group's client should implement this interface.
type SubjectAccessReviewsGetter interface {
	SubjectAccessReviews() SubjectAccessReviewInterface
}

// SubjectAccessReviewInterface has methods to work with SubjectAccessReview resources.
type SubjectAccessReviewInterface interface {
	Create(*authorization.SubjectAccessReview) (*authorization.SubjectAccessReviewResponse, error)

	SubjectAccessReviewExpansion
}

// subjectAccessReviews implements SubjectAccessReviewInterface
type subjectAccessReviews struct {
	client rest.Interface
}

// newSubjectAccessReviews returns a SubjectAccessReviews
func newSubjectAccessReviews(c *AuthorizationClient) *subjectAccessReviews {
	return &subjectAccessReviews{
		client: c.RESTClient(),
	}
}

// Create takes the representation of a subjectAccessReview and creates it.  Returns the server's representation of the subjectAccessReviewResponse, and an error, if there is any.
func (c *subjectAccessReviews) Create(subjectAccessReview *authorization.SubjectAccessReview) (result *authorization.SubjectAccessReviewResponse, err error) {
	result = &authorization.SubjectAccessReviewResponse{}
	err = c.client.Post().
		Resource("subjectaccessreviews").
		Body(subjectAccessReview).
		Do().
		Into(result)
	return
}
