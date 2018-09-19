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
	"fmt"
	"strings"

	"github.com/gonum/graph"

	osgraph "github.com/openshift/origin/pkg/oc/graph/genericgraph"
	kubeedges "github.com/openshift/origin/pkg/oc/graph/kubegraph"
	kubegraph "github.com/openshift/origin/pkg/oc/graph/kubegraph/nodes"
)

const (
	DuelingReplicationControllerWarning = "DuelingReplicationControllers"
)

func FindDuelingReplicationControllers(g osgraph.Graph, f osgraph.Namer) []osgraph.Marker {
	markers := []osgraph.Marker{}

	for _, uncastRCNode := range g.NodesByKind(kubegraph.ReplicationControllerNodeKind) {
		rcNode := uncastRCNode.(*kubegraph.ReplicationControllerNode)

		for _, uncastPodNode := range g.PredecessorNodesByEdgeKind(rcNode, kubeedges.ManagedByControllerEdgeKind) {
			podNode := uncastPodNode.(*kubegraph.PodNode)

			// check to see if this pod is managed by more than one RC
			uncastOwningRCs := g.SuccessorNodesByEdgeKind(podNode, kubeedges.ManagedByControllerEdgeKind)
			if len(uncastOwningRCs) > 1 {
				involvedRCNames := []string{}
				relatedNodes := []graph.Node{uncastPodNode}

				for _, uncastOwningRC := range uncastOwningRCs {
					if uncastOwningRC.ID() == rcNode.ID() {
						continue
					}
					owningRC := uncastOwningRC.(*kubegraph.ReplicationControllerNode)
					involvedRCNames = append(involvedRCNames, f.ResourceName(owningRC))

					relatedNodes = append(relatedNodes, uncastOwningRC)
				}

				markers = append(markers, osgraph.Marker{
					Node:         rcNode,
					RelatedNodes: relatedNodes,

					Severity: osgraph.WarningSeverity,
					Key:      DuelingReplicationControllerWarning,
					Message:  fmt.Sprintf("%s is competing for %s with %s", f.ResourceName(rcNode), f.ResourceName(podNode), strings.Join(involvedRCNames, ", ")),
				})
			}
		}
	}

	return markers
}
