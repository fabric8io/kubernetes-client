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

// SubjectRulesReviewsGetter has a method to return a SubjectRulesReviewInterface.
// A group's client should implement this interface.
type SubjectRulesReviewsGetter interface {
	SubjectRulesReviews(namespace string) SubjectRulesReviewInterface
}

// SubjectRulesReviewInterface has methods to work with SubjectRulesReview resources.
type SubjectRulesReviewInterface interface {
	Create(*authorization.SubjectRulesReview) (*authorization.SubjectRulesReview, error)
	SubjectRulesReviewExpansion
}

// subjectRulesReviews implements SubjectRulesReviewInterface
type subjectRulesReviews struct {
	client rest.Interface
	ns     string
}

// newSubjectRulesReviews returns a SubjectRulesReviews
func newSubjectRulesReviews(c *AuthorizationClient, namespace string) *subjectRulesReviews {
	return &subjectRulesReviews{
		client: c.RESTClient(),
		ns:     namespace,
	}
}

// Create takes the representation of a subjectRulesReview and creates it.  Returns the server's representation of the subjectRulesReview, and an error, if there is any.
func (c *subjectRulesReviews) Create(subjectRulesReview *authorization.SubjectRulesReview) (result *authorization.SubjectRulesReview, err error) {
	result = &authorization.SubjectRulesReview{}
	err = c.client.Post().
		Namespace(c.ns).
		Resource("subjectrulesreviews").
		Body(subjectRulesReview).
		Do().
		Into(result)
	return
}
