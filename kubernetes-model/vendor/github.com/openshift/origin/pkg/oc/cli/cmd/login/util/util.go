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
	restclient "k8s.io/client-go/rest"

	authorizationapi "github.com/openshift/origin/pkg/authorization/apis/authorization"
	authorizationclient "github.com/openshift/origin/pkg/authorization/generated/internalclientset"
)

func CanRequestProjects(config *restclient.Config, defaultNamespace string) (bool, error) {
	oClient, err := authorizationclient.NewForConfig(config)
	if err != nil {
		return false, err
	}

	sar := &authorizationapi.SubjectAccessReview{
		Action: authorizationapi.Action{
			Namespace: defaultNamespace,
			Verb:      "list",
			Resource:  "projectrequests",
		},
	}

	listResponse, err := oClient.Authorization().SubjectAccessReviews().Create(sar)
	if err != nil {
		return false, err
	}

	sar = &authorizationapi.SubjectAccessReview{
		Action: authorizationapi.Action{
			Namespace: defaultNamespace,
			Verb:      "create",
			Resource:  "projectrequests",
		},
	}

	createResponse, err := oClient.Authorization().SubjectAccessReviews().Create(sar)
	if err != nil {
		return false, err
	}

	return (listResponse.Allowed && createResponse.Allowed), nil
}
