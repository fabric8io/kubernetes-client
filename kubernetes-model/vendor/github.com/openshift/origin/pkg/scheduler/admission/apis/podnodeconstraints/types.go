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
package podnodeconstraints

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
)

// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object

// PodNodeConstraintsConfig is the configuration for the pod node name
// and node selector constraint plug-in. For accounts, serviceaccounts,
// and groups which lack the "pods/binding" permission, Loading this
// plugin will prevent setting NodeName on pod specs and will prevent
// setting NodeSelectors whose labels appear in the blacklist field
// "NodeSelectorLabelBlacklist"
type PodNodeConstraintsConfig struct {
	metav1.TypeMeta
	// NodeSelectorLabelBlacklist specifies a list of labels which cannot be set by entities without the "pods/binding" permission
	NodeSelectorLabelBlacklist []string
}
