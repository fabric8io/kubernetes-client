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
package resourceaccessreview

import (
	api "github.com/openshift/origin/pkg/authorization/apis/authorization"
	"k8s.io/apimachinery/pkg/runtime"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/apiserver/pkg/registry/rest"
)

type Registry interface {
	CreateResourceAccessReview(ctx apirequest.Context, resourceAccessReview *api.ResourceAccessReview) (*api.ResourceAccessReviewResponse, error)
}

type Storage interface {
	Create(ctx apirequest.Context, obj runtime.Object, _ rest.ValidateObjectFunc, _ bool) (runtime.Object, error)
}

type storage struct {
	Storage
}

func NewRegistry(s Storage) Registry {
	return &storage{s}
}

func (s *storage) CreateResourceAccessReview(ctx apirequest.Context, resourceAccessReview *api.ResourceAccessReview) (*api.ResourceAccessReviewResponse, error) {
	obj, err := s.Create(ctx, resourceAccessReview, nil, false)
	if err != nil {
		return nil, err
	}
	return obj.(*api.ResourceAccessReviewResponse), nil
}
