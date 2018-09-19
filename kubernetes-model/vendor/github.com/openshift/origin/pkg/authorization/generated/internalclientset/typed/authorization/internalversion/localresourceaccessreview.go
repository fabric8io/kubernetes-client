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

// LocalResourceAccessReviewsGetter has a method to return a LocalResourceAccessReviewInterface.
// A group's client should implement this interface.
type LocalResourceAccessReviewsGetter interface {
	LocalResourceAccessReviews(namespace string) LocalResourceAccessReviewInterface
}

// LocalResourceAccessReviewInterface has methods to work with LocalResourceAccessReview resources.
type LocalResourceAccessReviewInterface interface {
	Create(*authorization.LocalResourceAccessReview) (*authorization.ResourceAccessReviewResponse, error)

	LocalResourceAccessReviewExpansion
}

// localResourceAccessReviews implements LocalResourceAccessReviewInterface
type localResourceAccessReviews struct {
	client rest.Interface
	ns     string
}

// newLocalResourceAccessReviews returns a LocalResourceAccessReviews
func newLocalResourceAccessReviews(c *AuthorizationClient, namespace string) *localResourceAccessReviews {
	return &localResourceAccessReviews{
		client: c.RESTClient(),
		ns:     namespace,
	}
}

// Create takes the representation of a localResourceAccessReview and creates it.  Returns the server's representation of the resourceAccessReviewResponse, and an error, if there is any.
func (c *localResourceAccessReviews) Create(localResourceAccessReview *authorization.LocalResourceAccessReview) (result *authorization.ResourceAccessReviewResponse, err error) {
	result = &authorization.ResourceAccessReviewResponse{}
	err = c.client.Post().
		Namespace(c.ns).
		Resource("localresourceaccessreviews").
		Body(localResourceAccessReview).
		Do().
		Into(result)
	return
}
