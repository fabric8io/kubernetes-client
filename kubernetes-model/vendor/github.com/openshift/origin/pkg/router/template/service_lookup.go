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
package templaterouter

import (
	"time"

	"k8s.io/apimachinery/pkg/api/errors"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/runtime/schema"
	"k8s.io/apimachinery/pkg/util/wait"
	"k8s.io/apimachinery/pkg/watch"
	"k8s.io/client-go/tools/cache"
	api "k8s.io/kubernetes/pkg/apis/core"
	kcoreclient "k8s.io/kubernetes/pkg/client/clientset_generated/internalclientset/typed/core/internalversion"
)

// ServiceLookup is an interface for fetching the service associated with the given endpoints
type ServiceLookup interface {
	LookupService(*api.Endpoints) (*api.Service, error)
}

func NewListWatchServiceLookup(svcGetter kcoreclient.ServicesGetter, resync time.Duration) ServiceLookup {
	svcStore := cache.NewStore(cache.MetaNamespaceKeyFunc)
	lw := &cache.ListWatch{
		ListFunc: func(options metav1.ListOptions) (runtime.Object, error) {
			return svcGetter.Services(api.NamespaceAll).List(options)
		},
		WatchFunc: func(options metav1.ListOptions) (watch.Interface, error) {
			return svcGetter.Services(api.NamespaceAll).Watch(options)
		},
	}
	go cache.NewReflector(lw, &api.Service{}, svcStore, resync).Run(wait.NeverStop)

	return &serviceLWLookup{
		store: svcStore,
	}
}

type serviceLWLookup struct {
	store cache.Store
}

func (c *serviceLWLookup) LookupService(endpoints *api.Endpoints) (*api.Service, error) {
	var rawSvc interface{}
	var ok bool
	var err error

	if rawSvc, ok, err = c.store.Get(endpoints); err != nil {
		return nil, err
	} else if !ok {
		return nil, errors.NewNotFound(schema.GroupResource{
			Group:    api.GroupName,
			Resource: "Service",
		}, endpoints.Name)
	}

	return rawSvc.(*api.Service), nil
}
