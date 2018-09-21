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
package dockerhelper

import (
	"io"

	"github.com/docker/engine-api/types"
	"github.com/docker/engine-api/types/container"
	"github.com/docker/engine-api/types/network"
)

type Interface interface {
	Endpoint() string
	Info() (*types.Info, error)
	ServerVersion() (*types.Version, error)
	ContainerCreate(config *container.Config, hostConfig *container.HostConfig, networkingConfig *network.NetworkingConfig, name string) (*types.ContainerCreateResponse, error)
	ContainerList(options types.ContainerListOptions) ([]types.Container, error)
	ContainerInspect(container string) (*types.ContainerJSON, error)
	ContainerRemove(container string, options types.ContainerRemoveOptions) error
	ContainerLogs(container string, options types.ContainerLogsOptions, stdOut, stdErr io.Writer) error
	ContainerStart(container string) error
	ContainerStop(container string, timeout int) error
	ContainerWait(container string) (int, error)
	CopyToContainer(container string, dest string, src io.Reader, options types.CopyToContainerOptions) error
	CopyFromContainer(container string, src string) (io.ReadCloser, error)
	ContainerExecCreate(container string, config types.ExecConfig) (*types.ContainerExecCreateResponse, error)
	ContainerExecAttach(execID string, stdIn io.Reader, stdOut, stdErr io.Writer) error
	ContainerExecInspect(execID string) (*types.ContainerExecInspect, error)
	ImageInspectWithRaw(imageID string, getSize bool) (*types.ImageInspect, []byte, error)
	ImagePull(ref string, options types.ImagePullOptions, writer io.Writer) error
}
