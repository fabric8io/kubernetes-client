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
package restoptions

import (
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/apiserver/pkg/registry/generic/registry"
)

// DefaultKeyFunctions sets the default behavior for storage key generation onto a Store.
func DefaultKeyFunctions(store *registry.Store, prefix string, isNamespaced bool) {
	if isNamespaced {
		if store.KeyRootFunc == nil {
			store.KeyRootFunc = func(ctx apirequest.Context) string {
				return registry.NamespaceKeyRootFunc(ctx, prefix)
			}
		}
		if store.KeyFunc == nil {
			store.KeyFunc = func(ctx apirequest.Context, name string) (string, error) {
				return registry.NamespaceKeyFunc(ctx, prefix, name)
			}
		}
	} else {
		if store.KeyRootFunc == nil {
			store.KeyRootFunc = func(ctx apirequest.Context) string {
				return prefix
			}
		}
		if store.KeyFunc == nil {
			store.KeyFunc = func(ctx apirequest.Context, name string) (string, error) {
				return registry.NoNamespaceKeyFunc(ctx, prefix, name)
			}
		}
	}
}
