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
package v1

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
)

// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object

// IngressAdmissionConfig is the configuration for the the ingress
// controller limiter plugin. It changes the behavior of ingress
// objects to behave better with openshift routes and routers.
// *NOTE* This has security implications in the router when handling
// ingress objects
type IngressAdmissionConfig struct {
	metav1.TypeMeta `json:",inline"`

	// AllowHostnameChanges when false or unset openshift does not
	// allow changing or adding hostnames to ingress objects. If set
	// to true then hostnames can be added or modified which has
	// security implications in the router.
	AllowHostnameChanges bool `json:"allowHostnameChanges"`
}
