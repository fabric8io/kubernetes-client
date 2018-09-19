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
package buildgraph

import (
	"fmt"
	"testing"

	"github.com/gonum/graph"

	"k8s.io/apimachinery/pkg/api/meta"
	"k8s.io/apimachinery/pkg/runtime"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
	nodes "github.com/openshift/origin/pkg/oc/graph/buildgraph/nodes"
	osgraph "github.com/openshift/origin/pkg/oc/graph/genericgraph"
)

type objectifier interface {
	Object() interface{}
}

func TestNamespaceEdgeMatching(t *testing.T) {
	g := osgraph.New()

	fn := func(namespace string, g osgraph.Interface) {
		bc := &buildapi.BuildConfig{}
		bc.Namespace = namespace
		bc.Name = "the-bc"
		nodes.EnsureBuildConfigNode(g, bc)

		b := &buildapi.Build{}
		b.Namespace = namespace
		b.Name = "the-build"
		b.Labels = map[string]string{buildapi.BuildConfigLabel: "the-bc"}
		b.Annotations = map[string]string{buildapi.BuildConfigAnnotation: "the-bc"}
		nodes.EnsureBuildNode(g, b)
	}

	fn("ns", g)
	fn("other", g)
	AddAllBuildEdges(g)

	if len(g.Edges()) != 2 {
		t.Fatal(g)
	}
	for _, edge := range g.Edges() {
		nsTo, err := namespaceFor(edge.To())
		if err != nil {
			t.Fatal(err)
		}
		nsFrom, err := namespaceFor(edge.From())
		if err != nil {
			t.Fatal(err)
		}
		if nsFrom != nsTo {
			t.Errorf("edge %#v crosses namespace: %s %s", edge, nsFrom, nsTo)
		}
	}
}

func namespaceFor(node graph.Node) (string, error) {
	obj := node.(objectifier).Object()
	switch t := obj.(type) {
	case runtime.Object:
		meta, err := meta.Accessor(t)
		if err != nil {
			return "", err
		}
		return meta.GetNamespace(), nil
	default:
		return "", fmt.Errorf("unknown object: %#v", obj)
	}
}
