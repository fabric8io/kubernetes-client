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
)

func TestMultipleEdgeKindsBetweenTheSameNodes(t *testing.T) {
	g := New()

	fooNode := makeTestNode(g, "foo")
	barNode := makeTestNode(g, "bar")

	g.AddEdge(fooNode, barNode, "first")
	g.AddEdge(fooNode, barNode, "second")

	edge := g.Edge(fooNode, barNode)
	if !g.EdgeKinds(edge).Has("first") {
		t.Errorf("expected first, got %v", edge)
	}
	if !g.EdgeKinds(edge).Has("second") {
		t.Errorf("expected second, got %v", edge)
	}
}
