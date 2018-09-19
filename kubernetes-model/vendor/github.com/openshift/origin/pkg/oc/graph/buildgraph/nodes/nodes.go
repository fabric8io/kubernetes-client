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
package nodes

import (
	"github.com/gonum/graph"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
	osgraph "github.com/openshift/origin/pkg/oc/graph/genericgraph"
)

// EnsureBuildConfigNode adds a graph node for the specific build config if it does not exist
func EnsureBuildConfigNode(g osgraph.MutableUniqueGraph, config *buildapi.BuildConfig) *BuildConfigNode {
	return osgraph.EnsureUnique(
		g,
		BuildConfigNodeName(config),
		func(node osgraph.Node) graph.Node {
			return &BuildConfigNode{
				Node:        node,
				BuildConfig: config,
			}
		},
	).(*BuildConfigNode)
}

// EnsureSourceRepositoryNode adds the specific BuildSource to the graph if it does not already exist.
func EnsureSourceRepositoryNode(g osgraph.MutableUniqueGraph, source buildapi.BuildSource) *SourceRepositoryNode {
	switch {
	case source.Git != nil:
	default:
		return nil
	}
	return osgraph.EnsureUnique(g,
		SourceRepositoryNodeName(source),
		func(node osgraph.Node) graph.Node {
			return &SourceRepositoryNode{node, source}
		},
	).(*SourceRepositoryNode)
}

// EnsureBuildNode adds a graph node for the build if it does not already exist.
func EnsureBuildNode(g osgraph.MutableUniqueGraph, build *buildapi.Build) *BuildNode {
	return osgraph.EnsureUnique(g,
		BuildNodeName(build),
		func(node osgraph.Node) graph.Node {
			return &BuildNode{node, build}
		},
	).(*BuildNode)
}
