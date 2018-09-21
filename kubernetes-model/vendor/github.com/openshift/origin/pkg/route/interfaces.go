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
package route

import (
	api "github.com/openshift/origin/pkg/route/apis/route"
)

// AllocationPlugin is the interface the route controller dispatches
// requests for RouterShard allocation and name generation.
type AllocationPlugin interface {
	Allocate(*api.Route) (*api.RouterShard, error)
	GenerateHostname(*api.Route, *api.RouterShard) string
}

// RouteAllocator is the interface for the route allocation controller
// which handles requests for RouterShard allocation and name generation.
type RouteAllocator interface {
	AllocateRouterShard(*api.Route) (*api.RouterShard, error)
	GenerateHostname(*api.Route, *api.RouterShard) string
}
