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
package testing

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime/schema"
)

// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object

type TestConfig struct {
	metav1.TypeMeta `json:",inline"`
	Item1           string   `json:"item1"`
	Item2           []string `json:"item2"`
}

// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object

type TestConfigV1 struct {
	metav1.TypeMeta `json:",inline"`
	Item1           string   `json:"item1"`
	Item2           []string `json:"item2"`
}

// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object
type OtherTestConfig2 struct {
	metav1.TypeMeta
	Thing string `json:"thing"`
}

// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object
type OtherTestConfig2V2 struct {
	metav1.TypeMeta
	Thing string `json:"thing"`
}

func (obj *TestConfig) GetObjectKind() schema.ObjectKind         { return &obj.TypeMeta }
func (obj *TestConfigV1) GetObjectKind() schema.ObjectKind       { return &obj.TypeMeta }
func (obj *OtherTestConfig2) GetObjectKind() schema.ObjectKind   { return &obj.TypeMeta }
func (obj *OtherTestConfig2V2) GetObjectKind() schema.ObjectKind { return &obj.TypeMeta }
