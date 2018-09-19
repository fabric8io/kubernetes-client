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
	"reflect"

	osgraph "github.com/openshift/origin/pkg/oc/graph/genericgraph"
	routeapi "github.com/openshift/origin/pkg/route/apis/route"
)

var (
	RouteNodeKind = reflect.TypeOf(routeapi.Route{}).Name()
)

func RouteNodeName(o *routeapi.Route) osgraph.UniqueName {
	return osgraph.GetUniqueRuntimeObjectNodeName(RouteNodeKind, o)
}

type RouteNode struct {
	osgraph.Node
	*routeapi.Route
}

func (n RouteNode) Object() interface{} {
	return n.Route
}

func (n RouteNode) String() string {
	return string(RouteNodeName(n.Route))
}

func (*RouteNode) Kind() string {
	return RouteNodeKind
}
