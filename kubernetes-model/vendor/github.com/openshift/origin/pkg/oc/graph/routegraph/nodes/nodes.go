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
package nodes

import (
	"github.com/gonum/graph"

	osgraph "github.com/openshift/origin/pkg/oc/graph/genericgraph"
	routeapi "github.com/openshift/origin/pkg/route/apis/route"
)

// EnsureRouteNode adds a graph node for the specific route if it does not exist
func EnsureRouteNode(g osgraph.MutableUniqueGraph, route *routeapi.Route) *RouteNode {
	return osgraph.EnsureUnique(
		g,
		RouteNodeName(route),
		func(node osgraph.Node) graph.Node {
			return &RouteNode{
				Node:  node,
				Route: route,
			}
		},
	).(*RouteNode)
}
