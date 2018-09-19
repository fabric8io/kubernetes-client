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
package oauthclient

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"

	oauthapi "github.com/openshift/api/oauth/v1"
)

// Getter exposes a way to get a specific client.  This is useful for other registries to get scope limitations
// on particular clients.   This interface will make its easier to write a future cache on it
type Getter interface {
	Get(name string, options metav1.GetOptions) (*oauthapi.OAuthClient, error)
}
