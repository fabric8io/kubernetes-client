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
package middleware

import (
	"fmt"

	"github.com/docker/distribution"
	"github.com/docker/distribution/context"
	"github.com/docker/distribution/registry/storage"
)

// InitFunc is the type of a RegistryMiddleware factory function and is
// used to register the constructor for different RegistryMiddleware backends.
type InitFunc func(ctx context.Context, registry distribution.Namespace, options map[string]interface{}) (distribution.Namespace, error)

var middlewares map[string]InitFunc
var registryoptions []storage.RegistryOption

// Register is used to register an InitFunc for
// a RegistryMiddleware backend with the given name.
func Register(name string, initFunc InitFunc) error {
	if middlewares == nil {
		middlewares = make(map[string]InitFunc)
	}
	if _, exists := middlewares[name]; exists {
		return fmt.Errorf("name already registered: %s", name)
	}

	middlewares[name] = initFunc

	return nil
}

// Get constructs a RegistryMiddleware with the given options using the named backend.
func Get(ctx context.Context, name string, options map[string]interface{}, registry distribution.Namespace) (distribution.Namespace, error) {
	if middlewares != nil {
		if initFunc, exists := middlewares[name]; exists {
			return initFunc(ctx, registry, options)
		}
	}

	return nil, fmt.Errorf("no registry middleware registered with name: %s", name)
}

// RegisterOptions adds more options to RegistryOption list. Options get applied before
// any other configuration-based options.
func RegisterOptions(options ...storage.RegistryOption) error {
	registryoptions = append(registryoptions, options...)
	return nil
}

// GetRegistryOptions returns list of RegistryOption.
func GetRegistryOptions() []storage.RegistryOption {
	return registryoptions
}
