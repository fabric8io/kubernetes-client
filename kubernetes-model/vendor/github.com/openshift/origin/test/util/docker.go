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
package util

import (
	dockerClient "github.com/fsouza/go-dockerclient"
	"github.com/golang/glog"
)

// RequireDocker ensures that a new docker client can be created and that a ListImages command can be run on the client
// or it fails with glog.Fatal
func RequireDocker() {
	client, err := NewDockerClient()

	if err != nil {
		glog.Fatalf("unable to create docker client for testing: %v", err)
	}

	//simple test to make sure you can take action with the client
	_, err = client.ListImages(dockerClient.ListImagesOptions{All: false})

	if err != nil {
		glog.Fatalf("unable to create docker client for testing: %v", err)
	}
}

// newDockerClient creates a docker client using the env var DOCKER_ENDPOINT or, if not supplied, uses the default
// docker endpoint /var/run/docker.sock
func NewDockerClient() (*dockerClient.Client, error) {
	return dockerClient.NewClientFromEnv()
}
