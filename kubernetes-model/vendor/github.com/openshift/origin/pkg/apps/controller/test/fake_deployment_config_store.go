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
	"k8s.io/apimachinery/pkg/util/sets"

	appsapi "github.com/openshift/origin/pkg/apps/apis/apps"
)

type FakeDeploymentConfigStore struct {
	DeploymentConfig *appsapi.DeploymentConfig
	Err              error
}

func NewFakeDeploymentConfigStore(deployment *appsapi.DeploymentConfig) FakeDeploymentConfigStore {
	return FakeDeploymentConfigStore{DeploymentConfig: deployment}
}

func (s FakeDeploymentConfigStore) Add(obj interface{}) error {
	return s.Err
}

func (s FakeDeploymentConfigStore) Update(obj interface{}) error {
	return s.Err
}

func (s FakeDeploymentConfigStore) Delete(obj interface{}) error {
	return s.Err
}

func (s FakeDeploymentConfigStore) List() []interface{} {
	return []interface{}{s.DeploymentConfig}
}

func (s FakeDeploymentConfigStore) ContainedIDs() sets.String {
	return sets.NewString()
}

func (s FakeDeploymentConfigStore) Get(obj interface{}) (item interface{}, exists bool, err error) {
	return s.GetByKey("")
}

func (s FakeDeploymentConfigStore) GetByKey(id string) (item interface{}, exists bool, err error) {
	if s.Err != nil {
		return nil, false, err
	}
	if s.DeploymentConfig == nil {
		return nil, false, nil
	}

	return s.DeploymentConfig, true, nil
}

func (s FakeDeploymentConfigStore) Replace(list []interface{}) error {
	return nil
}
