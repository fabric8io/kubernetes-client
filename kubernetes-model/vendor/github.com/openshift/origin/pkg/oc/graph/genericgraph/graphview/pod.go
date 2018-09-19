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
package graphview

import (
	osgraph "github.com/openshift/origin/pkg/oc/graph/genericgraph"
	kubegraph "github.com/openshift/origin/pkg/oc/graph/kubegraph/nodes"
)

type Pod struct {
	Pod *kubegraph.PodNode
}

// AllPods returns all Pods and the set of covered NodeIDs
func AllPods(g osgraph.Graph, excludeNodeIDs IntSet) ([]Pod, IntSet) {
	covered := IntSet{}
	pods := []Pod{}

	for _, uncastNode := range g.NodesByKind(kubegraph.PodNodeKind) {
		if excludeNodeIDs.Has(uncastNode.ID()) {
			continue
		}

		pod, covers := NewPod(g, uncastNode.(*kubegraph.PodNode))
		covered.Insert(covers.List()...)
		pods = append(pods, pod)
	}

	return pods, covered
}

// NewPod returns the Pod and a set of all the NodeIDs covered by the Pod
func NewPod(g osgraph.Graph, podNode *kubegraph.PodNode) (Pod, IntSet) {
	covered := IntSet{}
	covered.Insert(podNode.ID())

	podView := Pod{}
	podView.Pod = podNode

	return podView, covered
}
