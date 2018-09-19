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
package graph

import (
	"fmt"
	"strings"

	"github.com/gonum/graph/concrete"
)

// FilterPackages receives a graph and a set of packagePrefixes contained within the graph.
// Returns a new graph with the sub-tree for each node matching the packagePrefix collapsed
// into just that node. Relationships among packagePrefixes are kept: edges originating from
// packagePrefix subpackages are re-written to originate from the packagePrefix, and edges
// terminating at packagePrefix subpackages are re-written to terminate at the packagePrefix.
func FilterPackages(g *MutableDirectedGraph, packagePrefixes []string) (*MutableDirectedGraph, error) {
	collapsedGraph := NewMutableDirectedGraph(g.rootNodeNames)

	// copy all nodes to new graph
	for _, n := range g.Nodes() {
		node, ok := n.(*Node)
		if !ok {
			continue
		}

		collapsedNodeName := getFilteredNodeName(packagePrefixes, node.UniqueName)
		_, exists := collapsedGraph.NodeByName(collapsedNodeName)
		if exists {
			continue
		}

		err := collapsedGraph.AddNode(&Node{
			UniqueName: collapsedNodeName,
			Id:         n.ID(),
			LabelName:  labelNameForNode(collapsedNodeName),
		})
		if err != nil {
			return nil, err
		}
	}

	// add edges to collapsed graph
	for _, from := range g.Nodes() {
		node, ok := from.(*Node)
		if !ok {
			return nil, fmt.Errorf("expected nodes in graph to be of type *Node")
		}

		fromNodeName := getFilteredNodeName(packagePrefixes, node.UniqueName)
		fromNode, exists := collapsedGraph.NodeByName(fromNodeName)
		if !exists {
			return nil, fmt.Errorf("expected node with name %q to exist in collapsed graph", fromNodeName)
		}

		for _, to := range g.From(from) {
			node, ok := to.(*Node)
			if !ok {
				return nil, fmt.Errorf("expected nodes in graph to be of type *Node")
			}

			toNodeName := getFilteredNodeName(packagePrefixes, node.UniqueName)
			if fromNodeName == toNodeName {
				continue
			}

			toNode, exists := collapsedGraph.NodeByName(toNodeName)
			if !exists {
				return nil, fmt.Errorf("expected node with name %q to exist in collapsed graph", toNodeName)
			}

			if collapsedGraph.HasEdgeFromTo(fromNode, toNode) {
				continue
			}

			collapsedGraph.SetEdge(concrete.Edge{
				F: fromNode,
				T: toNode,
			}, 0)
		}
	}

	return collapsedGraph, nil
}

func getFilteredNodeName(collapsedPrefixes []string, packageName string) string {
	for _, prefix := range collapsedPrefixes {
		if strings.HasPrefix(packageName, prefix) {
			return prefix
		}
	}

	return packageName
}
