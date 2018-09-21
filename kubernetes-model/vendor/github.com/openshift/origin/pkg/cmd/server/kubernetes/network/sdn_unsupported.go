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
// +build !linux

package network

import (
	"fmt"

	kclientset "k8s.io/client-go/kubernetes"
	kinternalclientset "k8s.io/kubernetes/pkg/client/clientset_generated/internalclientset"
	kinternalinformers "k8s.io/kubernetes/pkg/client/informers/informers_generated/internalversion"
	"k8s.io/kubernetes/pkg/proxy/apis/kubeproxyconfig"

	configapi "github.com/openshift/origin/pkg/cmd/server/apis/config"
	"github.com/openshift/origin/pkg/network"
	networkinformers "github.com/openshift/origin/pkg/network/generated/informers/internalversion"
	networkclient "github.com/openshift/origin/pkg/network/generated/internalclientset"
)

func NewSDNInterfaces(options configapi.NodeConfig, networkClient networkclient.Interface,
	kubeClientset kclientset.Interface, kubeClient kinternalclientset.Interface,
	internalKubeInformers kinternalinformers.SharedInformerFactory,
	internalNetworkInformers networkinformers.SharedInformerFactory,
	proxyconfig *kubeproxyconfig.KubeProxyConfiguration) (network.NodeInterface, network.ProxyInterface, error) {

	return nil, nil, fmt.Errorf("SDN not supported on this platform")
}
