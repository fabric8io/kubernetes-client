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
	"k8s.io/api/core/v1"
	"k8s.io/apimachinery/pkg/util/sets"
)

type FakeDeploymentStore struct {
	Deployment *v1.ReplicationController
	Err        error
}

func NewFakeDeploymentStore(deployment *v1.ReplicationController) FakeDeploymentStore {
	return FakeDeploymentStore{Deployment: deployment}
}

func (s FakeDeploymentStore) Add(obj interface{}) error {
	return s.Err
}

func (s FakeDeploymentStore) Update(obj interface{}) error {
	return s.Err
}

func (s FakeDeploymentStore) Delete(obj interface{}) error {
	return s.Err
}

func (s FakeDeploymentStore) List() []interface{} {
	return []interface{}{s.Deployment}
}

func (s FakeDeploymentStore) ContainedIDs() sets.String {
	return sets.NewString()
}

func (s FakeDeploymentStore) Get(obj interface{}) (item interface{}, exists bool, err error) {
	return s.GetByKey("")
}

func (s FakeDeploymentStore) GetByKey(id string) (item interface{}, exists bool, err error) {
	if s.Err != nil {
		return nil, false, err
	}
	if s.Deployment == nil {
		return nil, false, nil
	}

	return s.Deployment, true, nil
}

func (s FakeDeploymentStore) Replace(list []interface{}) error {
	return nil
}
