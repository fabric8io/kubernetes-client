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

	kapierrors "k8s.io/apimachinery/pkg/api/errors"
	metainternal "k8s.io/apimachinery/pkg/apis/meta/internalversion"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/watch"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
)

type BuildConfigRegistry struct {
	Err             error
	BuildConfigs    *buildapi.BuildConfigList
	BuildConfig     *buildapi.BuildConfig
	DeletedConfigID string
	sync.Mutex
}

func (r *BuildConfigRegistry) ListBuildConfigs(ctx apirequest.Context, options *metainternal.ListOptions) (*buildapi.BuildConfigList, error) {
	r.Lock()
	defer r.Unlock()
	return r.BuildConfigs, r.Err
}

func (r *BuildConfigRegistry) GetBuildConfig(ctx apirequest.Context, id string, options *metav1.GetOptions) (*buildapi.BuildConfig, error) {
	r.Lock()
	defer r.Unlock()
	if r.BuildConfig != nil && r.BuildConfig.Name == id {
		return r.BuildConfig, r.Err
	}
	return nil, kapierrors.NewNotFound(buildapi.Resource("buildconfig"), id)
}

func (r *BuildConfigRegistry) CreateBuildConfig(ctx apirequest.Context, config *buildapi.BuildConfig) error {
	r.Lock()
	defer r.Unlock()
	r.BuildConfig = config
	return r.Err
}

func (r *BuildConfigRegistry) UpdateBuildConfig(ctx apirequest.Context, config *buildapi.BuildConfig) error {
	r.Lock()
	defer r.Unlock()
	r.BuildConfig = config
	return r.Err
}

func (r *BuildConfigRegistry) DeleteBuildConfig(ctx apirequest.Context, id string) error {
	r.Lock()
	defer r.Unlock()
	r.DeletedConfigID = id
	r.BuildConfig = nil
	return r.Err
}

func (r *BuildConfigRegistry) WatchBuildConfigs(ctx apirequest.Context, options *metainternal.ListOptions) (watch.Interface, error) {
	return nil, r.Err
}
