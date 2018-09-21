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
package controller

import (
	"fmt"

	utilwait "k8s.io/apimachinery/pkg/util/wait"

	configapi "github.com/openshift/origin/pkg/cmd/server/apis/config"
	"github.com/openshift/origin/pkg/cmd/server/bootstrappolicy"
	"github.com/openshift/origin/pkg/network"
	networkinformers "github.com/openshift/origin/pkg/network/generated/informers/internalversion"
	sdnmaster "github.com/openshift/origin/pkg/network/master"
)

type SDNControllerConfig struct {
	NetworkConfig configapi.MasterNetworkConfig
}

func (c *SDNControllerConfig) RunController(ctx ControllerContext) (bool, error) {
	if !network.IsOpenShiftNetworkPlugin(c.NetworkConfig.NetworkPluginName) {
		return false, nil
	}

	networkClient := ctx.ClientBuilder.OpenshiftInternalNetworkClientOrDie(bootstrappolicy.InfraSDNControllerServiceAccountName)
	networkInformers := networkinformers.NewSharedInformerFactory(networkClient, network.DefaultInformerResyncPeriod)

	if err := sdnmaster.Start(
		c.NetworkConfig,
		networkClient,
		ctx.ClientBuilder.KubeInternalClientOrDie(bootstrappolicy.InfraSDNControllerServiceAccountName),
		ctx.InternalKubeInformers,
		networkInformers,
	); err != nil {
		return false, fmt.Errorf("failed to start SDN plugin controller: %v", err)
	}

	networkInformers.Start(utilwait.NeverStop)

	return true, nil
}
