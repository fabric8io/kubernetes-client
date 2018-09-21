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
package simple

import (
	"k8s.io/kubernetes/third_party/forked/gonum/graph"
)

// DirectedAcyclicGraph implements graph.Directed using UndirectedGraph,
// which only stores one edge for any node pair.
type DirectedAcyclicGraph struct {
	*UndirectedGraph
}

func NewDirectedAcyclicGraph(self, absent float64) *DirectedAcyclicGraph {
	return &DirectedAcyclicGraph{
		UndirectedGraph: NewUndirectedGraph(self, absent),
	}
}

func (g *DirectedAcyclicGraph) HasEdgeFromTo(u, v graph.Node) bool {
	edge := g.UndirectedGraph.EdgeBetween(u, v)
	if edge == nil {
		return false
	}
	return (edge.From().ID() == u.ID())
}

func (g *DirectedAcyclicGraph) From(n graph.Node) []graph.Node {
	if !g.Has(n) {
		return nil
	}

	fid := n.ID()
	nodes := make([]graph.Node, 0, g.UndirectedGraph.edges[n.ID()].Len())
	g.UndirectedGraph.edges[n.ID()].Visit(func(neighbor int, edge graph.Edge) {
		if edge.From().ID() == fid {
			nodes = append(nodes, g.UndirectedGraph.nodes[edge.To().ID()])
		}
	})
	return nodes
}

func (g *DirectedAcyclicGraph) VisitFrom(n graph.Node, visitor func(neighbor graph.Node) (shouldContinue bool)) {
	if !g.Has(n) {
		return
	}
	fid := n.ID()
	g.UndirectedGraph.edges[n.ID()].Visit(func(neighbor int, edge graph.Edge) {
		if edge.From().ID() == fid {
			if !visitor(g.UndirectedGraph.nodes[edge.To().ID()]) {
				return
			}
		}
	})
}

func (g *DirectedAcyclicGraph) To(n graph.Node) []graph.Node {
	if !g.Has(n) {
		return nil
	}

	tid := n.ID()
	nodes := make([]graph.Node, 0, g.UndirectedGraph.edges[n.ID()].Len())
	g.UndirectedGraph.edges[n.ID()].Visit(func(neighbor int, edge graph.Edge) {
		if edge.To().ID() == tid {
			nodes = append(nodes, g.UndirectedGraph.nodes[edge.From().ID()])
		}
	})
	return nodes
}

func (g *DirectedAcyclicGraph) VisitTo(n graph.Node, visitor func(neighbor graph.Node) (shouldContinue bool)) {
	if !g.Has(n) {
		return
	}
	tid := n.ID()
	g.UndirectedGraph.edges[n.ID()].Visit(func(neighbor int, edge graph.Edge) {
		if edge.To().ID() == tid {
			if !visitor(g.UndirectedGraph.nodes[edge.From().ID()]) {
				return
			}
		}
	})
}
