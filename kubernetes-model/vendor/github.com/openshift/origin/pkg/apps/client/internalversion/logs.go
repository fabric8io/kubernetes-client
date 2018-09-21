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
package internalversion

import (
	rest "k8s.io/client-go/rest"
	"k8s.io/kubernetes/pkg/api/legacyscheme"

	appsapi "github.com/openshift/origin/pkg/apps/apis/apps"
)

type RolloutLogInterface interface {
	Logs(name string, options appsapi.DeploymentLogOptions) *rest.Request
}

func NewRolloutLogClient(c rest.Interface, ns string) RolloutLogInterface {
	return &rolloutLogs{client: c, ns: ns}
}

type rolloutLogs struct {
	client rest.Interface
	ns     string
}

func (c *rolloutLogs) Logs(name string, options appsapi.DeploymentLogOptions) *rest.Request {
	return c.client.
		Get().
		Namespace(c.ns).
		Resource("deploymentConfigs").
		Name(name).
		SubResource("log").
		VersionedParams(&options, legacyscheme.ParameterCodec)
}
