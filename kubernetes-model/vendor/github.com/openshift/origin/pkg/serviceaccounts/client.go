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
package serviceaccounts

import (
	kapi "k8s.io/kubernetes/pkg/apis/core"
)

// IsValidServiceAccountToken returns true if the given secret contains a service account token valid for the given service account
// TODO, these should collapse onto the upstream method
func IsValidServiceAccountToken(serviceAccount *kapi.ServiceAccount, secret *kapi.Secret) bool {
	if secret.Type != kapi.SecretTypeServiceAccountToken {
		return false
	}
	if secret.Namespace != serviceAccount.Namespace {
		return false
	}
	if secret.Annotations[kapi.ServiceAccountNameKey] != serviceAccount.Name {
		return false
	}
	if secret.Annotations[kapi.ServiceAccountUIDKey] != string(serviceAccount.UID) {
		return false
	}
	if len(secret.Data[kapi.ServiceAccountTokenKey]) == 0 {
		return false
	}
	return true
}
