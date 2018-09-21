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
package allocation

import (
	"github.com/golang/glog"

	"github.com/openshift/origin/pkg/route"
	routeapi "github.com/openshift/origin/pkg/route/apis/route"
)

// RouteAllocationController abstracts the details of how routes are
// allocated to router shards.
type RouteAllocationController struct {
	Plugin route.AllocationPlugin
}

// AllocateRouterShard allocates a router shard for the given route.
func (c *RouteAllocationController) AllocateRouterShard(route *routeapi.Route) (*routeapi.RouterShard, error) {

	glog.V(4).Infof("Allocating router shard for Route: %s [alias=%s]",
		route.Name, route.Spec.Host)

	shard, err := c.Plugin.Allocate(route)

	if err != nil {
		glog.Errorf("unable to allocate router shard: %v", err)
		return shard, err
	}

	glog.V(4).Infof("Route %s allocated to shard %s [suffix=%s]",
		route.Name, shard.ShardName, shard.DNSSuffix)

	return shard, err
}

// GenerateHostname generates a host name for the given route and router shard combination.
func (c *RouteAllocationController) GenerateHostname(route *routeapi.Route, shard *routeapi.RouterShard) string {
	glog.V(4).Infof("Generating host name for Route: %s", route.Name)

	s := c.Plugin.GenerateHostname(route, shard)

	glog.V(4).Infof("Route: %s, generated host name/alias=%s",
		route.Name, s)

	return s
}
