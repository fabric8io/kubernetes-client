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
package util

import (
	"errors"

	kerrors "k8s.io/apimachinery/pkg/api/errors"
	"k8s.io/apimachinery/pkg/runtime/schema"
	"k8s.io/apiserver/pkg/authentication/user"
	"k8s.io/kubernetes/pkg/apis/authorization"
	"k8s.io/kubernetes/pkg/client/clientset_generated/internalclientset/typed/authorization/internalversion"
)

// AddUserToSAR adds the requisite user information to a SubjectAccessReview.
// It returns the modified SubjectAccessReview.
func AddUserToSAR(user user.Info, sar *authorization.SubjectAccessReview) *authorization.SubjectAccessReview {
	sar.Spec.User = user.GetName()
	// reminiscent of the bad old days of C.  Copies copy the min number of elements of both source and dest
	sar.Spec.Groups = make([]string, len(user.GetGroups()))
	copy(sar.Spec.Groups, user.GetGroups())
	sar.Spec.Extra = map[string]authorization.ExtraValue{}

	for k, v := range user.GetExtra() {
		sar.Spec.Extra[k] = authorization.ExtraValue(v)
	}

	return sar
}

// Authorize verifies that a given user is permitted to carry out a given
// action.  If this cannot be determined, or if the user is not permitted, an
// error is returned.
func Authorize(sarClient internalversion.SubjectAccessReviewInterface, user user.Info, resourceAttributes *authorization.ResourceAttributes) error {
	sar := AddUserToSAR(user, &authorization.SubjectAccessReview{
		Spec: authorization.SubjectAccessReviewSpec{
			ResourceAttributes: resourceAttributes,
		},
	})

	resp, err := sarClient.Create(sar)
	if err == nil && resp != nil && resp.Status.Allowed {
		return nil
	}

	if err == nil {
		err = errors.New(resp.Status.Reason)
	}
	return kerrors.NewForbidden(schema.GroupResource{Group: resourceAttributes.Group, Resource: resourceAttributes.Resource}, resourceAttributes.Name, err)
}
