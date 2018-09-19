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
package internalversion

import (
	image "github.com/openshift/origin/pkg/image/apis/image"
	rest "k8s.io/client-go/rest"
)

// ImageStreamImportsGetter has a method to return a ImageStreamImportInterface.
// A group's client should implement this interface.
type ImageStreamImportsGetter interface {
	ImageStreamImports(namespace string) ImageStreamImportInterface
}

// ImageStreamImportInterface has methods to work with ImageStreamImport resources.
type ImageStreamImportInterface interface {
	Create(*image.ImageStreamImport) (*image.ImageStreamImport, error)
	ImageStreamImportExpansion
}

// imageStreamImports implements ImageStreamImportInterface
type imageStreamImports struct {
	client rest.Interface
	ns     string
}

// newImageStreamImports returns a ImageStreamImports
func newImageStreamImports(c *ImageClient, namespace string) *imageStreamImports {
	return &imageStreamImports{
		client: c.RESTClient(),
		ns:     namespace,
	}
}

// Create takes the representation of a imageStreamImport and creates it.  Returns the server's representation of the imageStreamImport, and an error, if there is any.
func (c *imageStreamImports) Create(imageStreamImport *image.ImageStreamImport) (result *image.ImageStreamImport, err error) {
	result = &image.ImageStreamImport{}
	err = c.client.Post().
		Namespace(c.ns).
		Resource("imagestreamimports").
		Body(imageStreamImport).
		Do().
		Into(result)
	return
}
