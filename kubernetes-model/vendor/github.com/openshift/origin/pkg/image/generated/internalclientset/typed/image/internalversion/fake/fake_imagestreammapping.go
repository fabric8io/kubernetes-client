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

// FakeImageStreamMappings implements ImageStreamMappingInterface
type FakeImageStreamMappings struct {
	Fake *FakeImage
	ns   string
}

var imagestreammappingsResource = schema.GroupVersionResource{Group: "image.openshift.io", Version: "", Resource: "imagestreammappings"}

var imagestreammappingsKind = schema.GroupVersionKind{Group: "image.openshift.io", Version: "", Kind: "ImageStreamMapping"}

// Create takes the representation of a imageStreamMapping and creates it.  Returns the server's representation of the status, and an error, if there is any.
func (c *FakeImageStreamMappings) Create(imageStreamMapping *image.ImageStreamMapping) (result *v1.Status, err error) {
	obj, err := c.Fake.
		Invokes(testing.NewCreateAction(imagestreammappingsResource, c.ns, imageStreamMapping), &v1.Status{})

	if obj == nil {
		return nil, err
	}
	return obj.(*v1.Status), err
}
