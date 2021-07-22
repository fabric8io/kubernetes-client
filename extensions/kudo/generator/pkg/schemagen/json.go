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
package schemagen

type JSONSchema struct {
	ID          string                            `json:"id"`
	Schema      string                            `json:"$schema"`
	Description string                            `json:"description,omitempty"`
	Definitions map[string]JSONPropertyDescriptor `json:"definitions"`
	JSONDescriptor
	*JSONObjectDescriptor
	Resources map[string]*JSONObjectDescriptor `json:"resources,omitempty"`
}

type JSONDescriptor struct {
	Type          string        `json:"type"`
	Description   string        `json:"description"`
	Default       string        `json:"default,omitempty"`
	Required      bool          `json:"required,omitempty"`
	Minimum       float32       `json:"minimum,omitempty"`
	Maximum       float32       `json:"maximum,omitempty"`
	MinItems      int           `json:"minItems,omitempty"`
	MaxItems      int           `json:"maxItems,omitempty"`
	MinLength     int           `json:"minLength,omitempty"`
	MaxLength     int           `json:"maxLength,omitempty"`
	Pattern       string        `json:"pattern,omitempty"`
	Enum          []interface{} `json:"enum,omitempty"`
	JavaOmitEmpty bool          `json:"javaOmitEmpty,omitempty"`
}

type JSONObjectDescriptor struct {
	Properties           map[string]JSONPropertyDescriptor `json:"properties,omitempty"`
	AdditionalProperties bool                              `json:"additionalProperties"`
}

type JSONArrayDescriptor struct {
	Items JSONPropertyDescriptor `json:"items"`
}

type JSONReferenceDescriptor struct {
	Reference string `json:"$ref"`
}

type JavaTypeDescriptor struct {
	JavaType string `json:"javaType"`
}

type JavaInterfacesDescriptor struct {
	JavaInterfaces []string `json:"javaInterfaces,omitempty"`
}

type JavaExtendsDescriptor struct {
	Reference string `json:"$ref,omitempty"`
	JavaType  string `json:"Extends,omitempty"`
}

type JSONPropertyDescriptor struct {
	*JSONDescriptor
	*JSONReferenceDescriptor
	*JSONObjectDescriptor
	*JSONArrayDescriptor
	*JSONMapDescriptor
	*JavaTypeDescriptor
	*JavaInterfacesDescriptor
	JavaExtends *JavaExtendsDescriptor `json:"extends,omitempty"`
}

type JSONMapDescriptor struct {
	MapValueType JSONPropertyDescriptor `json:"additionalProperty"`
}
