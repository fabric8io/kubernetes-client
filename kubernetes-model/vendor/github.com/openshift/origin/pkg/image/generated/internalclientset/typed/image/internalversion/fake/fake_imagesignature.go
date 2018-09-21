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
package fake

import (
	image "github.com/openshift/origin/pkg/image/apis/image"
	v1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	schema "k8s.io/apimachinery/pkg/runtime/schema"
	testing "k8s.io/client-go/testing"
)

// FakeImageSignatures implements ImageSignatureInterface
type FakeImageSignatures struct {
	Fake *FakeImage
}

var imagesignaturesResource = schema.GroupVersionResource{Group: "image.openshift.io", Version: "", Resource: "imagesignatures"}

var imagesignaturesKind = schema.GroupVersionKind{Group: "image.openshift.io", Version: "", Kind: "ImageSignature"}

// Create takes the representation of a imageSignature and creates it.  Returns the server's representation of the imageSignature, and an error, if there is any.
func (c *FakeImageSignatures) Create(imageSignature *image.ImageSignature) (result *image.ImageSignature, err error) {
	obj, err := c.Fake.
		Invokes(testing.NewRootCreateAction(imagesignaturesResource, imageSignature), &image.ImageSignature{})
	if obj == nil {
		return nil, err
	}
	return obj.(*image.ImageSignature), err
}

// Delete takes name of the imageSignature and deletes it. Returns an error if one occurs.
func (c *FakeImageSignatures) Delete(name string, options *v1.DeleteOptions) error {
	_, err := c.Fake.
		Invokes(testing.NewRootDeleteAction(imagesignaturesResource, name), &image.ImageSignature{})
	return err
}
