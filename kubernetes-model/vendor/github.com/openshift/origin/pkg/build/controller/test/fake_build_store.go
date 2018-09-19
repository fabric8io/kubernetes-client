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
	"k8s.io/apimachinery/pkg/util/sets"
)

type FakeBuildStore struct {
	Build *buildapi.Build
	Err   error
}

func NewFakeBuildStore(build *buildapi.Build) FakeBuildStore {
	return FakeBuildStore{Build: build}
}

func (s FakeBuildStore) Add(obj interface{}) error {
	return s.Err
}

func (s FakeBuildStore) Update(obj interface{}) error {
	return s.Err
}

func (s FakeBuildStore) Delete(obj interface{}) error {
	return s.Err
}

func (s FakeBuildStore) Resync() error {
	return s.Err
}

func (s FakeBuildStore) List() []interface{} {
	return []interface{}{s.Build}
}

func (s FakeBuildStore) ListKeys() []string {
	return []string{"build"}
}

func (s FakeBuildStore) ContainedIDs() sets.String {
	return sets.NewString()
}

func (s FakeBuildStore) Get(obj interface{}) (interface{}, bool, error) {
	return s.GetByKey("")
}

func (s FakeBuildStore) GetByKey(id string) (interface{}, bool, error) {
	if s.Err != nil {
		return nil, false, s.Err
	}
	if s.Build == nil {
		return nil, false, nil
	}

	return s.Build, true, nil
}

func (s FakeBuildStore) Replace(list []interface{}, resourceVersion string) error {
	return nil
}
