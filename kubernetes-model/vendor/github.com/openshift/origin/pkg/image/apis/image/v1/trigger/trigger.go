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
package trigger

// TriggerAnnotationKey is the annotation used on resources to signal they wish to have
// container image references changed when an image stream tag is updated. Today, only
// containers can be specified by fieldPath.
const TriggerAnnotationKey = "image.openshift.io/triggers"

// ObjectFieldTrigger links a field on the current object to another object for mutation.
type ObjectFieldTrigger struct {
	// from is the object this should trigger from. The kind and name fields must be set.
	From ObjectReference `json:"from"`
	// fieldPath is a JSONPath string to the field to edit on the object. Required.
	FieldPath string `json:"fieldPath"`
	// paused is true if this trigger is temporarily disabled. Optional.
	Paused bool `json:"paused,omitempty"`
}

// ObjectReference identifies an object by its name and kind.
type ObjectReference struct {
	// kind is the referenced object's schema.
	Kind string `json:"kind"`
	// name is the name of the object.
	Name string `json:"name"`
	// namespace is the namespace the object is located in. Optional if the object is not
	// namespaced, or if left empty on a namespaced object, means the current namespace.
	Namespace string `json:"namespace,omitempty"`
	// apiVersion is the group and version the type exists in. Optional.
	APIVersion string `json:"apiVersion,omitempty"`
}
