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
	"testing"

	"github.com/gonum/graph"
)

func makeTestNode(g MutableUniqueGraph, name string) graph.Node {
	return EnsureUnique(g,
		UniqueName(name),
		func(node Node) graph.Node {
			return node
		},
	)
}

func TestContainsNavigation(t *testing.T) {
	g := New()

	aNode := makeTestNode(g, "a")
	bNode := makeTestNode(g, "b")
	cNode := makeTestNode(g, "c")

	g.AddEdge(aNode, bNode, ContainsEdgeKind)
	g.AddEdge(bNode, cNode, ContainsEdgeKind)

	topA := GetTopLevelContainerNode(g, aNode)
	if e, a := aNode.ID(), topA.ID(); e != a {
		t.Errorf("expected %v, got %v", e, a)
	}

	topB := GetTopLevelContainerNode(g, bNode)
	if e, a := aNode.ID(), topB.ID(); e != a {
		t.Errorf("expected %v, got %v", e, a)
	}

	topC := GetTopLevelContainerNode(g, cNode)
	if e, a := aNode.ID(), topC.ID(); e != a {
		t.Errorf("expected %v, got %v", e, a)
	}

	containsB := GetContainingNode(g, bNode)
	if containsB == nil {
		t.Fatal(g)
	}

	if e, a := aNode.ID(), containsB.ID(); e != a {
		t.Errorf("expected %v, got %v", e, a)
	}

	containsC := GetContainingNode(g, cNode)
	if e, a := bNode.ID(), containsC.ID(); e != a {
		t.Errorf("expected %v, got %v", e, a)
	}
}

func TestOnlyOneContainseEdge(t *testing.T) {
	g := New()

	aNode := makeTestNode(g, "a")
	bNode := makeTestNode(g, "b")
	cNode := makeTestNode(g, "c")

	g.AddEdge(aNode, bNode, ContainsEdgeKind)

	defer func() {
		if r := recover(); r == nil {
			t.Errorf("expected to recover panic!")
		}
	}()
	g.AddEdge(cNode, bNode, ContainsEdgeKind)
}
