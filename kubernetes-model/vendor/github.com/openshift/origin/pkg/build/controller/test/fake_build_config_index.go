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
	buildapi "github.com/openshift/origin/pkg/build/apis/build"
	buildlister "github.com/openshift/origin/pkg/build/generated/listers/build/internalversion"
	"k8s.io/apimachinery/pkg/labels"
)

type FakeBuildConfigIndex struct {
	Build *buildapi.BuildConfig
	Err   error
}

func NewFakeBuildConfigIndex(build *buildapi.BuildConfig) buildlister.BuildConfigLister {
	return &FakeBuildConfigIndex{Build: build}
}

func (i *FakeBuildConfigIndex) List(label labels.Selector) ([]*buildapi.BuildConfig, error) {
	return []*buildapi.BuildConfig{i.Build}, nil
}

func (i *FakeBuildConfigIndex) BuildConfigs(ns string) buildlister.BuildConfigNamespaceLister {
	return i
}

func (i *FakeBuildConfigIndex) Get(name string) (*buildapi.BuildConfig, error) {
	return i.Build, nil
}
