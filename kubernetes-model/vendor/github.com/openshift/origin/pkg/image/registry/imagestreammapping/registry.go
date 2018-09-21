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
package imagestreammapping

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"

	imageapi "github.com/openshift/origin/pkg/image/apis/image"
)

// Registry is an interface for things that know how to store ImageStreamMapping objects.
type Registry interface {
	// CreateImageStreamMapping creates a new image stream mapping.
	CreateImageStreamMapping(ctx apirequest.Context, mapping *imageapi.ImageStreamMapping) (*metav1.Status, error)
}

// Storage is an interface for a standard REST Storage backend
type Storage interface {
	Create(ctx apirequest.Context, obj runtime.Object) (runtime.Object, error)
}

// storage puts strong typing around storage calls
type storage struct {
	Storage
}

// NewRegistry returns a new Registry interface for the given Storage. Any mismatched
// types will panic.
func NewRegistry(s Storage) Registry {
	return &storage{s}
}

// CreateImageStreamMapping will create an image stream mapping.
func (s *storage) CreateImageStreamMapping(ctx apirequest.Context, mapping *imageapi.ImageStreamMapping) (*metav1.Status, error) {
	obj, err := s.Create(ctx, mapping)
	if err != nil {
		return nil, err
	}
	return obj.(*metav1.Status), nil
}
