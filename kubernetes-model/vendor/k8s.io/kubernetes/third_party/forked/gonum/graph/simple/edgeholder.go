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

import "k8s.io/kubernetes/third_party/forked/gonum/graph"

// edgeHolder represents a set of edges, with no more than one edge to or from a particular neighbor node
type edgeHolder interface {
	// Visit invokes visitor with each edge and the id of the neighbor node in the edge
	Visit(visitor func(neighbor int, edge graph.Edge))
	// Delete removes edges to or from the specified neighbor
	Delete(neighbor int) edgeHolder
	// Set stores the edge to or from the specified neighbor
	Set(neighbor int, edge graph.Edge) edgeHolder
	// Get returns the edge to or from the specified neighbor
	Get(neighbor int) (graph.Edge, bool)
	// Len returns the number of edges
	Len() int
}

// sliceEdgeHolder holds a list of edges to or from self
type sliceEdgeHolder struct {
	self  int
	edges []graph.Edge
}

func (e *sliceEdgeHolder) Visit(visitor func(neighbor int, edge graph.Edge)) {
	for _, edge := range e.edges {
		if edge.From().ID() == e.self {
			visitor(edge.To().ID(), edge)
		} else {
			visitor(edge.From().ID(), edge)
		}
	}
}
func (e *sliceEdgeHolder) Delete(neighbor int) edgeHolder {
	edges := e.edges[:0]
	for i, edge := range e.edges {
		if edge.From().ID() == e.self {
			if edge.To().ID() == neighbor {
				continue
			}
		} else {
			if edge.From().ID() == neighbor {
				continue
			}
		}
		edges = append(edges, e.edges[i])
	}
	e.edges = edges
	return e
}
func (e *sliceEdgeHolder) Set(neighbor int, newEdge graph.Edge) edgeHolder {
	for i, edge := range e.edges {
		if edge.From().ID() == e.self {
			if edge.To().ID() == neighbor {
				e.edges[i] = newEdge
				return e
			}
		} else {
			if edge.From().ID() == neighbor {
				e.edges[i] = newEdge
				return e
			}
		}
	}

	if len(e.edges) < 4 {
		e.edges = append(e.edges, newEdge)
		return e
	}

	h := mapEdgeHolder(make(map[int]graph.Edge, len(e.edges)+1))
	for i, edge := range e.edges {
		if edge.From().ID() == e.self {
			h[edge.To().ID()] = e.edges[i]
		} else {
			h[edge.From().ID()] = e.edges[i]
		}
	}
	h[neighbor] = newEdge
	return h
}
func (e *sliceEdgeHolder) Get(neighbor int) (graph.Edge, bool) {
	for _, edge := range e.edges {
		if edge.From().ID() == e.self {
			if edge.To().ID() == neighbor {
				return edge, true
			}
		} else {
			if edge.From().ID() == neighbor {
				return edge, true
			}
		}
	}
	return nil, false
}
func (e *sliceEdgeHolder) Len() int {
	return len(e.edges)
}

// mapEdgeHolder holds a map of neighbors to edges
type mapEdgeHolder map[int]graph.Edge

func (e mapEdgeHolder) Visit(visitor func(neighbor int, edge graph.Edge)) {
	for neighbor, edge := range e {
		visitor(neighbor, edge)
	}
}
func (e mapEdgeHolder) Delete(neighbor int) edgeHolder {
	delete(e, neighbor)
	return e
}
func (e mapEdgeHolder) Set(neighbor int, edge graph.Edge) edgeHolder {
	e[neighbor] = edge
	return e
}
func (e mapEdgeHolder) Get(neighbor int) (graph.Edge, bool) {
	edge, ok := e[neighbor]
	return edge, ok
}
func (e mapEdgeHolder) Len() int {
	return len(e)
}
