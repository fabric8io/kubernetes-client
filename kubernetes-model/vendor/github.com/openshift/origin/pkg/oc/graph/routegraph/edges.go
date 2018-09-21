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
package routegraph

import (
	"github.com/gonum/graph"

	kapi "k8s.io/kubernetes/pkg/apis/core"

	osgraph "github.com/openshift/origin/pkg/oc/graph/genericgraph"
	kubegraph "github.com/openshift/origin/pkg/oc/graph/kubegraph/nodes"
	routegraph "github.com/openshift/origin/pkg/oc/graph/routegraph/nodes"
)

const (
	// ExposedThroughRouteEdgeKind is an edge from a route to any object that
	// is exposed through routes
	ExposedThroughRouteEdgeKind = "ExposedThroughRoute"
)

// AddRouteEdges adds an edge that connect a service to a route in the given graph
func AddRouteEdges(g osgraph.MutableUniqueGraph, node *routegraph.RouteNode) {
	syntheticService := &kapi.Service{}
	syntheticService.Namespace = node.Namespace
	syntheticService.Name = node.Spec.To.Name

	serviceNode := kubegraph.FindOrCreateSyntheticServiceNode(g, syntheticService)
	g.AddEdge(node, serviceNode, ExposedThroughRouteEdgeKind)

	for _, svc := range node.Spec.AlternateBackends {
		syntheticService := &kapi.Service{}
		syntheticService.Namespace = node.Namespace
		syntheticService.Name = svc.Name

		serviceNode := kubegraph.FindOrCreateSyntheticServiceNode(g, syntheticService)
		g.AddEdge(node, serviceNode, ExposedThroughRouteEdgeKind)
	}
}

// AddAllRouteEdges adds service edges to all route nodes in the given graph
func AddAllRouteEdges(g osgraph.MutableUniqueGraph) {
	for _, node := range g.(graph.Graph).Nodes() {
		if routeNode, ok := node.(*routegraph.RouteNode); ok {
			AddRouteEdges(g, routeNode)
		}
	}
}
