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

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
)

type BuildLogInterface interface {
	Logs(name string, options buildapi.BuildLogOptions) *rest.Request
}

func NewBuildLogClient(c rest.Interface, ns string) BuildLogInterface {
	return &buildLogs{client: c, ns: ns}
}

type buildLogs struct {
	client rest.Interface
	ns     string
}

func (c *buildLogs) Logs(name string, options buildapi.BuildLogOptions) *rest.Request {
	return c.client.
		Get().
		Namespace(c.ns).
		Resource("builds").
		Name(name).
		SubResource("log").
		VersionedParams(&options, legacyscheme.ParameterCodec)
}
