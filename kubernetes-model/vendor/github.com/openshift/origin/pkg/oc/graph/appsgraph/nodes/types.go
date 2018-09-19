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
	"reflect"

	appsapi "github.com/openshift/origin/pkg/apps/apis/apps"
	osgraph "github.com/openshift/origin/pkg/oc/graph/genericgraph"
)

var (
	DeploymentConfigNodeKind = reflect.TypeOf(appsapi.DeploymentConfig{}).Name()
)

func DeploymentConfigNodeName(o *appsapi.DeploymentConfig) osgraph.UniqueName {
	return osgraph.GetUniqueRuntimeObjectNodeName(DeploymentConfigNodeKind, o)
}

type DeploymentConfigNode struct {
	osgraph.Node
	DeploymentConfig *appsapi.DeploymentConfig

	IsFound bool
}

func (n DeploymentConfigNode) Found() bool {
	return n.IsFound
}

func (n DeploymentConfigNode) Object() interface{} {
	return n.DeploymentConfig
}

func (n DeploymentConfigNode) String() string {
	return string(DeploymentConfigNodeName(n.DeploymentConfig))
}

func (*DeploymentConfigNode) Kind() string {
	return DeploymentConfigNodeKind
}
