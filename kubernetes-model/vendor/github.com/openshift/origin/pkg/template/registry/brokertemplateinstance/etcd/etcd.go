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
	"k8s.io/apiserver/pkg/registry/generic"
	"k8s.io/apiserver/pkg/registry/generic/registry"
	"k8s.io/apiserver/pkg/registry/rest"

	templateapi "github.com/openshift/origin/pkg/template/apis/template"
	"github.com/openshift/origin/pkg/template/registry/brokertemplateinstance"
	"github.com/openshift/origin/pkg/util/restoptions"
)

// REST implements a RESTStorage for brokertemplateinstances against etcd
type REST struct {
	*registry.Store
}

var _ rest.StandardStorage = &REST{}

// NewREST returns a RESTStorage object that will work against brokertemplateinstances.
func NewREST(optsGetter restoptions.Getter) (*REST, error) {
	store := &registry.Store{
		NewFunc:                  func() runtime.Object { return &templateapi.BrokerTemplateInstance{} },
		NewListFunc:              func() runtime.Object { return &templateapi.BrokerTemplateInstanceList{} },
		DefaultQualifiedResource: templateapi.Resource("brokertemplateinstances"),

		CreateStrategy: brokertemplateinstance.Strategy,
		UpdateStrategy: brokertemplateinstance.Strategy,
		DeleteStrategy: brokertemplateinstance.Strategy,
	}

	options := &generic.StoreOptions{RESTOptions: optsGetter}
	if err := store.CompleteWithOptions(options); err != nil {
		return nil, err
	}

	return &REST{store}, nil
}
