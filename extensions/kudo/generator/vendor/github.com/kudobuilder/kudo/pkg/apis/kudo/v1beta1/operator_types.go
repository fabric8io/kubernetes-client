/*

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package v1beta1

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
)

// OperatorSpec defines the desired state of Operator
type OperatorSpec struct {
	Description       string        `json:"description,omitempty"`
	KudoVersion       string        `json:"kudoVersion,omitempty"`
	KubernetesVersion string        `json:"kubernetesVersion,omitempty"`
	Maintainers       []*Maintainer `json:"maintainers,omitempty"`
	URL               string        `json:"url,omitempty"`
}

// Maintainer describes an Operator maintainer.
type Maintainer struct {
	// Name is a user name or organization name.
	Name string `json:"name,omitempty"`

	// Email is an optional email address to contact the named maintainer.
	Email string `json:"email,omitempty"`
}

// OperatorStatus defines the observed state of Operator
type OperatorStatus struct {
	// INSERT ADDITIONAL STATUS FIELD - define observed state of cluster
	// Important: Run "make" to regenerate code after modifying this file
}

// +genclient
// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object

// Operator is the Schema for the operator API
// +k8s:openapi-gen=true
type Operator struct {
	metav1.TypeMeta   `json:",inline"`
	metav1.ObjectMeta `json:"metadata,omitempty"`

	Spec   OperatorSpec   `json:"spec,omitempty"`
	Status OperatorStatus `json:"status,omitempty"`
}

// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object

// OperatorList contains a list of Operator
type OperatorList struct {
	metav1.TypeMeta `json:",inline"`
	metav1.ListMeta `json:"metadata,omitempty"`
	Items           []Operator `json:"items"`
}

func init() {
	SchemeBuilder.Register(&Operator{}, &OperatorList{})
}
