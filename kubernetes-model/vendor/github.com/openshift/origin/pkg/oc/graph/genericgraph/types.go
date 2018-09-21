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
package genericgraph

import (
	"fmt"

	"github.com/gonum/graph"

	"k8s.io/apimachinery/pkg/api/meta"
	"k8s.io/apimachinery/pkg/runtime"
)

const (
	UnknownNodeKind = "UnknownNode"
)

const (
	UnknownEdgeKind = "UnknownEdge"
	// ReferencedByEdgeKind is the kind to use if you're building reverse links that don't have a specific edge in the other direction
	// other uses are discouraged.  You should create a kind for your edge
	ReferencedByEdgeKind = "ReferencedBy"
	// ContainsEdgeKind is the kind to use if one node's contents logically contain another node's contents.  A given node can only have
	// a single inbound Contais edge.  The code does not prevent contains cycles, but that's insane, don't do that.
	ContainsEdgeKind = "Contains"
)

func GetUniqueRuntimeObjectNodeName(nodeKind string, obj runtime.Object) UniqueName {
	meta, err := meta.Accessor(obj)
	if err != nil {
		panic(err)
	}

	return UniqueName(fmt.Sprintf("%s|%s/%s", nodeKind, meta.GetNamespace(), meta.GetName()))
}

// GetTopLevelContainerNode traverses the reverse ContainsEdgeKind edges until it finds a node
// that does not have an inbound ContainsEdgeKind edge.  This could be the node itself
func GetTopLevelContainerNode(g Graph, containedNode graph.Node) graph.Node {
	// my kingdom for a LinkedHashSet
	visited := map[int]bool{}
	prevContainingNode := containedNode

	for {
		visited[prevContainingNode.ID()] = true
		currContainingNode := GetContainingNode(g, prevContainingNode)

		if currContainingNode == nil {
			return prevContainingNode
		}
		if _, alreadyVisited := visited[currContainingNode.ID()]; alreadyVisited {
			panic(fmt.Sprintf("contains cycle in %v", visited))
		}

		prevContainingNode = currContainingNode
	}
}

// GetContainingNode returns the direct predecessor that is linked to the node by a ContainsEdgeKind.  It returns
// nil if no container is found.
func GetContainingNode(g Graph, containedNode graph.Node) graph.Node {
	for _, node := range g.To(containedNode) {
		edge := g.Edge(node, containedNode)

		if g.EdgeKinds(edge).Has(ContainsEdgeKind) {
			return node
		}
	}

	return nil
}
