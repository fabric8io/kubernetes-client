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
package openshift

import (
	"fmt"

	etcdversion "github.com/coreos/etcd/version"
	"github.com/openshift/origin/pkg/version"
	kubeversion "k8s.io/kubernetes/pkg/version"
)

// Info contains versioning information.
// TODO: Add []string of api versions supported? It's still unclear
// how we'll want to distribute that information.
type Info struct {
	version.Info

	EtcdVersion string
	KubeVersion string
}

// Get returns the overall codebase version. It's for detecting
// what code a binary was built from.
func Get() Info {
	return Info{
		Info:        version.Get(),
		KubeVersion: kubeversion.Get().String(),
		EtcdVersion: etcdversion.Version,
	}
}

// String returns info as a human-friendly version string.
func (info Info) String() string {
	kubeVersion := info.KubeVersion
	if len(kubeVersion) == 0 {
		kubeVersion = "unknown"
	}

	etcdVersion := info.EtcdVersion
	if len(etcdVersion) == 0 {
		etcdVersion = "unknown"
	}

	return fmt.Sprintf("%s\nkubernetes %s\netcd %s", info.Info, kubeVersion, etcdVersion)
}
