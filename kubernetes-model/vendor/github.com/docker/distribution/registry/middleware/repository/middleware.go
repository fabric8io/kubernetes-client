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
)

// InitFunc is the type of a RepositoryMiddleware factory function and is
// used to register the constructor for different RepositoryMiddleware backends.
type InitFunc func(ctx context.Context, repository distribution.Repository, options map[string]interface{}) (distribution.Repository, error)

var middlewares map[string]InitFunc

// Register is used to register an InitFunc for
// a RepositoryMiddleware backend with the given name.
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

// Get constructs a RepositoryMiddleware with the given options using the named backend.
func Get(ctx context.Context, name string, options map[string]interface{}, repository distribution.Repository) (distribution.Repository, error) {
	if middlewares != nil {
		if initFunc, exists := middlewares[name]; exists {
			return initFunc(ctx, repository, options)
		}
	}

	return nil, fmt.Errorf("no repository middleware registered with name: %s", name)
}
