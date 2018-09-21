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

	securityapi "github.com/openshift/origin/pkg/security/apis/security"
	"github.com/openshift/origin/pkg/security/registry/securitycontextconstraints"
)

// REST implements a RESTStorage for security context constraints against etcd
type REST struct {
	*registry.Store
}

var _ rest.StandardStorage = &REST{}
var _ rest.ShortNamesProvider = &REST{}

// ShortNames implements the ShortNamesProvider interface. Returns a list of short names for a resource.
func (r *REST) ShortNames() []string {
	return []string{"scc"}
}

// NewREST returns a RESTStorage object that will work against security context constraints objects.
func NewREST(optsGetter generic.RESTOptionsGetter) *REST {
	store := &registry.Store{
		NewFunc:     func() runtime.Object { return &securityapi.SecurityContextConstraints{} },
		NewListFunc: func() runtime.Object { return &securityapi.SecurityContextConstraintsList{} },
		ObjectNameFunc: func(obj runtime.Object) (string, error) {
			return obj.(*securityapi.SecurityContextConstraints).Name, nil
		},
		PredicateFunc:            securitycontextconstraints.Matcher,
		DefaultQualifiedResource: securityapi.Resource("securitycontextconstraints"),

		CreateStrategy:      securitycontextconstraints.Strategy,
		UpdateStrategy:      securitycontextconstraints.Strategy,
		DeleteStrategy:      securitycontextconstraints.Strategy,
		ReturnDeletedObject: true,
	}
	options := &generic.StoreOptions{RESTOptions: optsGetter, AttrFunc: securitycontextconstraints.GetAttrs}
	if err := store.CompleteWithOptions(options); err != nil {
		panic(err) // TODO: Propagate error up
	}
	return &REST{store}
}

// LegacyREST allows us to wrap and alter some behavior
type LegacyREST struct {
	*REST
}

func (r *LegacyREST) Categories() []string {
	return []string{}
}
