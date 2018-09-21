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
	"k8s.io/api/core/v1"
	kapi "k8s.io/kubernetes/pkg/apis/core"

	"github.com/openshift/origin/pkg/api/apihelpers"
)

const (
	// These constants are here to create a name that is short enough to survive chopping by generate name
	maxNameLength             = 63
	randomLength              = 5
	maxSecretPrefixNameLength = maxNameLength - randomLength
)

func GetDockercfgSecretNamePrefix(serviceAccount *kapi.ServiceAccount) string {
	return apihelpers.GetName(serviceAccount.Name, "dockercfg-", maxSecretPrefixNameLength)
}

// GetTokenSecretNamePrefix creates the prefix used for the generated SA token secret. This is compatible with kube up until
// long names, at which point we hash the SA name and leave the "token-" intact.  Upstream clips the value and generates a random
// string.
// TODO fix the upstream implementation to be more like this.
func GetTokenSecretNamePrefix(serviceAccount *kapi.ServiceAccount) string {
	return apihelpers.GetName(serviceAccount.Name, "token-", maxSecretPrefixNameLength)
}

func GetDockercfgSecretNamePrefixV1(serviceAccount *v1.ServiceAccount) string {
	return apihelpers.GetName(serviceAccount.Name, "dockercfg-", maxSecretPrefixNameLength)
}

// GetTokenSecretNamePrefix creates the prefix used for the generated SA token secret. This is compatible with kube up until
// long names, at which point we hash the SA name and leave the "token-" intact.  Upstream clips the value and generates a random
// string.
// TODO fix the upstream implementation to be more like this.
func GetTokenSecretNamePrefixV1(serviceAccount *v1.ServiceAccount) string {
	return apihelpers.GetName(serviceAccount.Name, "token-", maxSecretPrefixNameLength)
}
