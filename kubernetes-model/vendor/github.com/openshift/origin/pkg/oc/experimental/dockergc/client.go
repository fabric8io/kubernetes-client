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
package dockergc

import (
	"context"
	"time"

	dockerapi "github.com/docker/engine-api/client"
	dockertypes "github.com/docker/engine-api/types"
)

type dockerClient struct {
	// timeout is the timeout of short running docker operations.
	timeout time.Duration
	// docker API client
	client *dockerapi.Client
}

func newDockerClient(timeout time.Duration) (*dockerClient, error) {
	client, err := dockerapi.NewEnvClient()
	if err != nil {
		return nil, err
	}
	return &dockerClient{
		client:  client,
		timeout: timeout,
	}, nil
}

func clientErr(ctx context.Context, err error) error {
	if ctx.Err() != nil {
		return ctx.Err()
	}
	return err
}

func (c *dockerClient) getTimeoutContext() (context.Context, context.CancelFunc) {
	return context.WithTimeout(context.Background(), c.timeout)
}

func (c *dockerClient) Info() (*dockertypes.Info, error) {
	ctx, cancel := c.getTimeoutContext()
	defer cancel()
	info, err := c.client.Info(ctx)
	if err := clientErr(ctx, err); err != nil {
		return nil, err
	}
	return &info, nil
}

func (c *dockerClient) ContainerList(options dockertypes.ContainerListOptions) ([]dockertypes.Container, error) {
	ctx, cancel := c.getTimeoutContext()
	defer cancel()
	containers, err := c.client.ContainerList(ctx, options)
	if err := clientErr(ctx, err); err != nil {
		return nil, err
	}
	return containers, nil
}

func (c *dockerClient) ContainerRemove(id string, opts dockertypes.ContainerRemoveOptions) error {
	ctx, cancel := c.getTimeoutContext()
	defer cancel()
	err := c.client.ContainerRemove(ctx, id, opts)
	return clientErr(ctx, err)
}

func (c *dockerClient) ImageList(opts dockertypes.ImageListOptions) ([]dockertypes.Image, error) {
	ctx, cancel := c.getTimeoutContext()
	defer cancel()
	images, err := c.client.ImageList(ctx, opts)
	if err := clientErr(ctx, err); err != nil {
		return nil, err
	}
	return images, nil
}

func (c *dockerClient) ImageRemove(image string, opts dockertypes.ImageRemoveOptions) error {
	ctx, cancel := c.getTimeoutContext()
	defer cancel()
	_, err := c.client.ImageRemove(ctx, image, opts)
	return clientErr(ctx, err)
}
