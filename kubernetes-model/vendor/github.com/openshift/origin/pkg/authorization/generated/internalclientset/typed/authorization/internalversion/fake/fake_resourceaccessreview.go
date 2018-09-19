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
	authorization "github.com/openshift/origin/pkg/authorization/apis/authorization"
	schema "k8s.io/apimachinery/pkg/runtime/schema"
	testing "k8s.io/client-go/testing"
)

// FakeResourceAccessReviews implements ResourceAccessReviewInterface
type FakeResourceAccessReviews struct {
	Fake *FakeAuthorization
}

var resourceaccessreviewsResource = schema.GroupVersionResource{Group: "authorization.openshift.io", Version: "", Resource: "resourceaccessreviews"}

var resourceaccessreviewsKind = schema.GroupVersionKind{Group: "authorization.openshift.io", Version: "", Kind: "ResourceAccessReview"}

// Create takes the representation of a resourceAccessReview and creates it.  Returns the server's representation of the resourceAccessReviewResponse, and an error, if there is any.
func (c *FakeResourceAccessReviews) Create(resourceAccessReview *authorization.ResourceAccessReview) (result *authorization.ResourceAccessReviewResponse, err error) {
	obj, err := c.Fake.
		Invokes(testing.NewRootCreateAction(resourceaccessreviewsResource, resourceAccessReview), &authorization.ResourceAccessReviewResponse{})
	if obj == nil {
		return nil, err
	}
	return obj.(*authorization.ResourceAccessReviewResponse), err
}
