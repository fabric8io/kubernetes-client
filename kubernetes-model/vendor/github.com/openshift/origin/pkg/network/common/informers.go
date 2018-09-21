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
package common

import (
	"fmt"
	"reflect"

	"k8s.io/apimachinery/pkg/runtime"
	utilruntime "k8s.io/apimachinery/pkg/util/runtime"
	"k8s.io/apimachinery/pkg/watch"
	kcache "k8s.io/client-go/tools/cache"
)

type InformerAddOrUpdateFunc func(interface{}, interface{}, watch.EventType)
type InformerDeleteFunc func(interface{})

func InformerFuncs(objType runtime.Object, addOrUpdateFunc InformerAddOrUpdateFunc, deleteFunc InformerDeleteFunc) kcache.ResourceEventHandlerFuncs {
	handlerFuncs := kcache.ResourceEventHandlerFuncs{}
	if addOrUpdateFunc != nil {
		handlerFuncs.AddFunc = func(obj interface{}) {
			addOrUpdateFunc(obj, nil, watch.Added)
		}
		handlerFuncs.UpdateFunc = func(old, cur interface{}) {
			addOrUpdateFunc(cur, old, watch.Modified)
		}
	}
	if deleteFunc != nil {
		handlerFuncs.DeleteFunc = func(obj interface{}) {
			if reflect.TypeOf(objType) != reflect.TypeOf(obj) {
				tombstone, ok := obj.(kcache.DeletedFinalStateUnknown)
				if !ok {
					utilruntime.HandleError(fmt.Errorf("Couldn't get object from tombstone: %+v", obj))
					return
				}

				obj = tombstone.Obj
				if reflect.TypeOf(objType) != reflect.TypeOf(obj) {
					utilruntime.HandleError(fmt.Errorf("Tombstone contained object, expected resource type: %v but got: %v", reflect.TypeOf(objType), reflect.TypeOf(obj)))
					return
				}
			}
			deleteFunc(obj)
		}
	}
	return handlerFuncs
}
