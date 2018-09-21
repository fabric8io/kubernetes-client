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
package storagemiddleware

import (
	"fmt"

	storagedriver "github.com/docker/distribution/registry/storage/driver"
)

// InitFunc is the type of a StorageMiddleware factory function and is
// used to register the constructor for different StorageMiddleware backends.
type InitFunc func(storageDriver storagedriver.StorageDriver, options map[string]interface{}) (storagedriver.StorageDriver, error)

var storageMiddlewares map[string]InitFunc

// Register is used to register an InitFunc for
// a StorageMiddleware backend with the given name.
func Register(name string, initFunc InitFunc) error {
	if storageMiddlewares == nil {
		storageMiddlewares = make(map[string]InitFunc)
	}
	if _, exists := storageMiddlewares[name]; exists {
		return fmt.Errorf("name already registered: %s", name)
	}

	storageMiddlewares[name] = initFunc

	return nil
}

// Get constructs a StorageMiddleware with the given options using the named backend.
func Get(name string, options map[string]interface{}, storageDriver storagedriver.StorageDriver) (storagedriver.StorageDriver, error) {
	if storageMiddlewares != nil {
		if initFunc, exists := storageMiddlewares[name]; exists {
			return initFunc(storageDriver, options)
		}
	}

	return nil, fmt.Errorf("no storage middleware registered with name: %s", name)
}
