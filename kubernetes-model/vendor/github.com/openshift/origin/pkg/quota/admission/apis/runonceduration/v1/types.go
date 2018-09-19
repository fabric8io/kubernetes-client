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

// RunOnceDurationConfig is the configuration for the RunOnceDuration plugin.
// It specifies a maximum value for ActiveDeadlineSeconds for a run-once pod.
// The project that contains the pod may specify a different setting. That setting will
// take precedence over the one configured for the plugin here.
type RunOnceDurationConfig struct {
	metav1.TypeMeta `json:",inline"`

	// ActiveDeadlineSecondsOverride is the maximum value to set on containers of run-once pods
	// Only a positive value is valid. Absence of a value means that the plugin
	// won't make any changes to the pod
	// TODO: change the external name of this field to reflect that it is a limit, not an override
	// It is kept this way for compatibility. Only change it in a new version of the API.
	ActiveDeadlineSecondsOverride *int64 `json:"activeDeadlineSecondsOverride,omitempty" description:"maximum value for activeDeadlineSeconds in run-once pods"`
}
