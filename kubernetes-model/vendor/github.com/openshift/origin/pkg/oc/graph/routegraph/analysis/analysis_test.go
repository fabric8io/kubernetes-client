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
package analysis

import (
	"testing"

	osgraph "github.com/openshift/origin/pkg/oc/graph/genericgraph"
	osgraphtest "github.com/openshift/origin/pkg/oc/graph/genericgraph/test"
	routeedges "github.com/openshift/origin/pkg/oc/graph/routegraph"
)

func TestPortMappingIssues(t *testing.T) {
	// Multiple service ports - no route port specified
	g, _, err := osgraphtest.BuildGraph("../../../graph/genericgraph/test/missing-route-port.yaml")
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	routeedges.AddAllRouteEdges(g)

	markers := FindPortMappingIssues(g, osgraph.DefaultNamer)
	if expected, got := 1, len(markers); expected != got {
		t.Fatalf("expected %d markers, got %d", expected, got)
	}
	if expected, got := MissingRoutePortWarning, markers[0].Key; expected != got {
		t.Fatalf("expected %s marker key, got %s", expected, got)
	}

	// Dangling route
	g, _, err = osgraphtest.BuildGraph("../../../graph/genericgraph/test/lonely-route.yaml")
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	routeedges.AddAllRouteEdges(g)

	markers = FindPortMappingIssues(g, osgraph.DefaultNamer)
	if expected, got := 1, len(markers); expected != got {
		t.Fatalf("expected %d markers, got %d", expected, got)
	}
	if expected, got := MissingServiceWarning, markers[0].Key; expected != got {
		t.Fatalf("expected %s marker key, got %s", expected, got)
	}

	// Wrong named route port
	g, _, err = osgraphtest.BuildGraph("../../../graph/genericgraph/test/wrong-numeric-port.yaml")
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	routeedges.AddAllRouteEdges(g)

	markers = FindPortMappingIssues(g, osgraph.DefaultNamer)
	if expected, got := 1, len(markers); expected != got {
		t.Fatalf("expected %d markers, got %d", expected, got)
	}
	if expected, got := WrongRoutePortWarning, markers[0].Key; expected != got {
		t.Fatalf("expected %s marker key, got %s", expected, got)
	}

	// Wrong numeric route port
	g, _, err = osgraphtest.BuildGraph("../../../graph/genericgraph/test/wrong-named-port.yaml")
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	routeedges.AddAllRouteEdges(g)

	markers = FindPortMappingIssues(g, osgraph.DefaultNamer)
	if expected, got := 1, len(markers); expected != got {
		t.Fatalf("expected %d markers, got %d", expected, got)
	}
	if expected, got := WrongRoutePortWarning, markers[0].Key; expected != got {
		t.Fatalf("expected %s marker key, got %s", expected, got)
	}
}

func TestPathBasedPassthroughRoutes(t *testing.T) {
	g, _, err := osgraphtest.BuildGraph("../../../graph/genericgraph/test/invalid-route.yaml")
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	routeedges.AddAllRouteEdges(g)

	markers := FindPathBasedPassthroughRoutes(g, osgraph.DefaultNamer)
	if expected, got := 1, len(markers); expected != got {
		t.Fatalf("expected %d markers, got %d", expected, got)
	}
	if expected, got := PathBasedPassthroughErr, markers[0].Key; expected != got {
		t.Fatalf("expected %s marker key, got %s", expected, got)
	}
}

func TestMissingRouter(t *testing.T) {
	g, _, err := osgraphtest.BuildGraph("../../../graph/genericgraph/test/lonely-route.yaml")
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	routeedges.AddAllRouteEdges(g)

	markers := FindMissingRouter(g, osgraph.DefaultNamer)
	if expected, got := 1, len(markers); expected != got {
		t.Fatalf("expected %d markers, got %d", expected, got)
	}
	if expected, got := MissingRequiredRouterErr, markers[0].Key; expected != got {
		t.Fatalf("expected %s marker key, got %s", expected, got)
	}
}
