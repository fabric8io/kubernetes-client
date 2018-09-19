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
	"strings"

	"k8s.io/apiserver/pkg/authentication/user"
	"k8s.io/apiserver/pkg/authorization/authorizer"

	authorizationapi "github.com/openshift/origin/pkg/authorization/apis/authorization"
)

// ToDefaultAuthorizationAttributes coerces Action to authorizer.Attributes.
func ToDefaultAuthorizationAttributes(user user.Info, namespace string, in authorizationapi.Action) authorizer.Attributes {
	tokens := strings.SplitN(in.Resource, "/", 2)
	resource := ""
	subresource := ""
	switch {
	case len(tokens) == 2:
		subresource = tokens[1]
		fallthrough
	case len(tokens) == 1:
		resource = tokens[0]
	}

	return &authorizer.AttributesRecord{
		User:            user,
		Verb:            in.Verb,
		Namespace:       namespace,
		APIGroup:        in.Group,
		APIVersion:      in.Version,
		Resource:        resource,
		Subresource:     subresource,
		Name:            in.ResourceName,
		ResourceRequest: !in.IsNonResourceURL,
		Path:            in.Path,
	}
}
