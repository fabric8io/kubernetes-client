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
	"net"
	"time"

	"github.com/openshift/origin/pkg/cmd/server/bootstrappolicy"
	"github.com/openshift/origin/pkg/service/controller/ingressip"
)

type IngressIPControllerConfig struct {
	IngressIPNetworkCIDR string
	IngressIPSyncPeriod  time.Duration
}

func (c *IngressIPControllerConfig) RunController(ctx ControllerContext) (bool, error) {
	if len(c.IngressIPNetworkCIDR) == 0 {
		return true, nil
	}

	_, ipNet, err := net.ParseCIDR(c.IngressIPNetworkCIDR)
	if err != nil {
		return false, fmt.Errorf("unable to start ingress IP controller: %v", err)
	}

	if ipNet.IP.IsUnspecified() {
		// TODO: Is this an error?
		return true, nil
	}

	ingressIPController := ingressip.NewIngressIPController(
		ctx.ExternalKubeInformers.Core().V1().Services().Informer(),
		ctx.ClientBuilder.ClientOrDie(bootstrappolicy.InfraServiceIngressIPControllerServiceAccountName),
		ipNet,
		c.IngressIPSyncPeriod,
	)
	go ingressIPController.Run(ctx.Stop)

	return true, nil
}
