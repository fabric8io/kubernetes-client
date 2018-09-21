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
package kubegraph

import (
	"sort"

	"k8s.io/kubernetes/pkg/controller/deployment/util"

	osgraph "github.com/openshift/origin/pkg/oc/graph/genericgraph"
	kubegraph "github.com/openshift/origin/pkg/oc/graph/kubegraph/nodes"
)

// RelevantDeployments returns the active deployment and a list of inactive deployments (in order from newest to oldest)
func RelevantDeployments(g osgraph.Graph, dNode *kubegraph.DeploymentNode) (*kubegraph.ReplicaSetNode, []*kubegraph.ReplicaSetNode) {
	allDeployments := []*kubegraph.ReplicaSetNode{}
	uncastDeployments := g.SuccessorNodesByEdgeKind(dNode, DeploymentEdgeKind)
	if len(uncastDeployments) == 0 {
		return nil, []*kubegraph.ReplicaSetNode{}
	}

	for i := range uncastDeployments {
		allDeployments = append(allDeployments, uncastDeployments[i].(*kubegraph.ReplicaSetNode))
	}

	sort.Sort(RecentDeploymentReferences(allDeployments))

	deploymentRevision, _ := util.Revision(dNode.Deployment)
	firstRSRevision, _ := util.Revision(allDeployments[0].ReplicaSet)

	if deploymentRevision == firstRSRevision {
		return allDeployments[0], allDeployments[1:]
	}

	return nil, allDeployments
}

type RecentDeploymentReferences []*kubegraph.ReplicaSetNode

func (m RecentDeploymentReferences) Len() int      { return len(m) }
func (m RecentDeploymentReferences) Swap(i, j int) { m[i], m[j] = m[j], m[i] }
func (m RecentDeploymentReferences) Less(i, j int) bool {
	firstRev, _ := util.Revision(m[i].ReplicaSet)
	secondRev, _ := util.Revision(m[j].ReplicaSet)
	return firstRev > secondRev
}
