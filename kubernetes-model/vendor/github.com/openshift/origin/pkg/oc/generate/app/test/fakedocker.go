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
package test

import (
	docker "github.com/fsouza/go-dockerclient"
)

type FakeDockerClient struct {
	// list result
	Images []docker.APIImages
	// inspect result
	Image      *docker.Image
	ListErr    error
	InspectErr error
}

func (f FakeDockerClient) ListImages(opts docker.ListImagesOptions) ([]docker.APIImages, error) {
	return f.Images, f.ListErr
}
func (f FakeDockerClient) InspectImage(name string) (*docker.Image, error) {
	return f.Image, f.InspectErr
}
