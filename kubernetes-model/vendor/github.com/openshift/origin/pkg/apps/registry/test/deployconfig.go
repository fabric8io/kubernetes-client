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
	"sync"

	appsapi "github.com/openshift/origin/pkg/apps/apis/apps"
	metainternal "k8s.io/apimachinery/pkg/apis/meta/internalversion"
	"k8s.io/apimachinery/pkg/fields"
	"k8s.io/apimachinery/pkg/labels"
	"k8s.io/apimachinery/pkg/watch"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
)

type DeploymentConfigRegistry struct {
	Err               error
	DeploymentConfig  *appsapi.DeploymentConfig
	DeploymentConfigs *appsapi.DeploymentConfigList
	sync.Mutex
}

func NewDeploymentConfigRegistry() *DeploymentConfigRegistry {
	return &DeploymentConfigRegistry{}
}

func (r *DeploymentConfigRegistry) ListDeploymentConfigs(ctx apirequest.Context, label labels.Selector, field fields.Selector) (*appsapi.DeploymentConfigList, error) {
	r.Lock()
	defer r.Unlock()

	return r.DeploymentConfigs, r.Err
}

func (r *DeploymentConfigRegistry) GetDeploymentConfig(ctx apirequest.Context, id string) (*appsapi.DeploymentConfig, error) {
	r.Lock()
	defer r.Unlock()

	return r.DeploymentConfig, r.Err
}

func (r *DeploymentConfigRegistry) CreateDeploymentConfig(ctx apirequest.Context, image *appsapi.DeploymentConfig) error {
	r.Lock()
	defer r.Unlock()

	r.DeploymentConfig = image
	return r.Err
}

func (r *DeploymentConfigRegistry) UpdateDeploymentConfig(ctx apirequest.Context, image *appsapi.DeploymentConfig) error {
	r.Lock()
	defer r.Unlock()

	r.DeploymentConfig = image
	return r.Err
}

func (r *DeploymentConfigRegistry) DeleteDeploymentConfig(ctx apirequest.Context, id string) error {
	r.Lock()
	defer r.Unlock()

	return r.Err
}

func (r *DeploymentConfigRegistry) WatchDeploymentConfigs(ctx apirequest.Context, options *metainternal.ListOptions) (watch.Interface, error) {
	return nil, r.Err
}
