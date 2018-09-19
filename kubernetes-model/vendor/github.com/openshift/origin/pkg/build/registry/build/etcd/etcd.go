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
package etcd

import (
	"k8s.io/apimachinery/pkg/runtime"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/apiserver/pkg/registry/generic"
	"k8s.io/apiserver/pkg/registry/generic/registry"
	"k8s.io/apiserver/pkg/registry/rest"
	"k8s.io/apiserver/pkg/storage"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
	"github.com/openshift/origin/pkg/build/registry/build"
	"github.com/openshift/origin/pkg/util/restoptions"
)

type REST struct {
	*registry.Store
}

var _ rest.StandardStorage = &REST{}
var _ rest.CategoriesProvider = &REST{}

// Categories implements the CategoriesProvider interface. Returns a list of categories a resource is part of.
func (r *REST) Categories() []string {
	return []string{"all"}
}

// NewREST returns a RESTStorage object that will work against Build objects.
func NewREST(optsGetter restoptions.Getter) (*REST, *DetailsREST, error) {
	store := &registry.Store{
		NewFunc:                  func() runtime.Object { return &buildapi.Build{} },
		NewListFunc:              func() runtime.Object { return &buildapi.BuildList{} },
		DefaultQualifiedResource: buildapi.Resource("builds"),

		CreateStrategy: build.Strategy,
		UpdateStrategy: build.Strategy,
		DeleteStrategy: build.Strategy,
	}

	options := &generic.StoreOptions{
		RESTOptions: optsGetter,
		AttrFunc:    storage.AttrFunc(storage.DefaultNamespaceScopedAttr).WithFieldMutation(buildapi.BuildFieldSelector),
	}
	if err := store.CompleteWithOptions(options); err != nil {
		return nil, nil, err
	}

	detailsStore := *store
	detailsStore.UpdateStrategy = build.DetailsStrategy

	return &REST{store}, &DetailsREST{&detailsStore}, nil
}

type DetailsREST struct {
	store *registry.Store
}

var _ rest.Updater = &DetailsREST{}

// New returns an empty object that can be used with Update after request data has been put into it.
func (r *DetailsREST) New() runtime.Object {
	return r.store.New()
}

// Update finds a resource in the storage and updates it.
func (r *DetailsREST) Update(ctx apirequest.Context, name string, objInfo rest.UpdatedObjectInfo, createValidation rest.ValidateObjectFunc, updateValidation rest.ValidateObjectUpdateFunc) (runtime.Object, bool, error) {
	return r.store.Update(ctx, name, objInfo, createValidation, updateValidation)
}

// LegacyREST allows us to wrap and alter some behavior
type LegacyREST struct {
	*REST
}

func (r *LegacyREST) Categories() []string {
	return []string{}
}
