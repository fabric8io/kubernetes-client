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
package serialization

import (
	"k8s.io/apimachinery/pkg/runtime"
)

// DecodeNestedRawExtensionOrUnknown
func DecodeNestedRawExtensionOrUnknown(d runtime.Decoder, ext *runtime.RawExtension) {
	if ext.Raw == nil || ext.Object != nil {
		return
	}
	obj, gvk, err := d.Decode(ext.Raw, nil, nil)
	if err != nil {
		unk := &runtime.Unknown{Raw: ext.Raw}
		if runtime.IsNotRegisteredError(err) {
			if _, gvk, err := d.Decode(ext.Raw, nil, unk); err == nil {
				unk.APIVersion = gvk.GroupVersion().String()
				unk.Kind = gvk.Kind
				ext.Object = unk
				return
			}
		}
		// TODO: record mime-type with the object
		if gvk != nil {
			unk.APIVersion = gvk.GroupVersion().String()
			unk.Kind = gvk.Kind
		}
		obj = unk
	}
	ext.Object = obj
}

// EncodeNestedRawExtension will encode the object in the RawExtension (if not nil) or
// return an error.
func EncodeNestedRawExtension(e runtime.Encoder, ext *runtime.RawExtension) error {
	if ext.Raw != nil || ext.Object == nil {
		return nil
	}
	data, err := runtime.Encode(e, ext.Object)
	if err != nil {
		return err
	}
	ext.Raw = data
	return nil
}
