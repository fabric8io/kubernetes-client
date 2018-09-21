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
	"k8s.io/apimachinery/pkg/apis/meta/v1/unstructured"
	"k8s.io/apimachinery/pkg/runtime"

	"github.com/openshift/api/pkg/serialization"
)

var _ runtime.NestedObjectDecoder = &Template{}
var _ runtime.NestedObjectEncoder = &Template{}

// DecodeNestedObjects decodes the object as a runtime.Unknown with JSON content.
func (c *Template) DecodeNestedObjects(d runtime.Decoder) error {
	for i := range c.Objects {
		if c.Objects[i].Object != nil {
			continue
		}
		c.Objects[i].Object = &runtime.Unknown{
			ContentType: "application/json",
			Raw:         c.Objects[i].Raw,
		}
	}
	return nil
}
func (c *Template) EncodeNestedObjects(e runtime.Encoder) error {
	for i := range c.Objects {
		if err := serialization.EncodeNestedRawExtension(unstructured.UnstructuredJSONScheme, &c.Objects[i]); err != nil {
			return err
		}
	}
	return nil
}
