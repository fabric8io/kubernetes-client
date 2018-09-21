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
	internalversion "github.com/openshift/origin/pkg/image/generated/internalclientset/typed/image/internalversion"
	rest "k8s.io/client-go/rest"
	testing "k8s.io/client-go/testing"
)

type FakeImage struct {
	*testing.Fake
}

func (c *FakeImage) Images() internalversion.ImageResourceInterface {
	return &FakeImages{c}
}

func (c *FakeImage) ImageSignatures() internalversion.ImageSignatureInterface {
	return &FakeImageSignatures{c}
}

func (c *FakeImage) ImageStreams(namespace string) internalversion.ImageStreamInterface {
	return &FakeImageStreams{c, namespace}
}

func (c *FakeImage) ImageStreamImages(namespace string) internalversion.ImageStreamImageInterface {
	return &FakeImageStreamImages{c, namespace}
}

func (c *FakeImage) ImageStreamImports(namespace string) internalversion.ImageStreamImportInterface {
	return &FakeImageStreamImports{c, namespace}
}

func (c *FakeImage) ImageStreamMappings(namespace string) internalversion.ImageStreamMappingInterface {
	return &FakeImageStreamMappings{c, namespace}
}

func (c *FakeImage) ImageStreamTags(namespace string) internalversion.ImageStreamTagInterface {
	return &FakeImageStreamTags{c, namespace}
}

// RESTClient returns a RESTClient that is used to communicate
// with API server by this client implementation.
func (c *FakeImage) RESTClient() rest.Interface {
	var ret *rest.RESTClient
	return ret
}
