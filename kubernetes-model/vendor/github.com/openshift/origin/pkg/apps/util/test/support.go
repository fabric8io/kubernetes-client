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
	"fmt"

	"k8s.io/apimachinery/pkg/api/errors"
	"k8s.io/apimachinery/pkg/runtime/schema"
	"k8s.io/kubernetes/pkg/kubectl"
)

type FakeScaler struct {
	Events []ScaleEvent
}

type ScaleEvent struct {
	Name string
	Size uint
}

func (t *FakeScaler) Scale(namespace, name string, newSize uint, preconditions *kubectl.ScalePrecondition, retry, wait *kubectl.RetryParams) error {
	t.Events = append(t.Events, ScaleEvent{name, newSize})
	return nil
}

func (t *FakeScaler) ScaleSimple(namespace, name string, preconditions *kubectl.ScalePrecondition, newSize uint) (string, error) {
	return "", fmt.Errorf("unexpected call to ScaleSimple")
}

type FakeLaggedScaler struct {
	Events     []ScaleEvent
	RetryCount int
}

func (t *FakeLaggedScaler) Scale(namespace, name string, newSize uint, preconditions *kubectl.ScalePrecondition, retry, wait *kubectl.RetryParams) error {
	if t.RetryCount != 2 {
		t.RetryCount += 1
		// This is faking a real error from the
		// "k8s.io/apiserver/pkg/admission/plugin/namespace/lifecycle" package.
		return errors.NewForbidden(schema.GroupResource{Resource: "ReplicationController"}, name, fmt.Errorf("%s: not yet ready to handle request", name))
	}
	t.Events = append(t.Events, ScaleEvent{name, newSize})
	return nil
}

func (t *FakeLaggedScaler) ScaleSimple(namespace, name string, preconditions *kubectl.ScalePrecondition, newSize uint) (string, error) {
	return "", nil
}
