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
	"k8s.io/apimachinery/pkg/runtime"
	kapi "k8s.io/kubernetes/pkg/apis/core"

	deployercontroller "github.com/openshift/origin/pkg/apps/controller/deployer"
	deployconfigcontroller "github.com/openshift/origin/pkg/apps/controller/deploymentconfig"
	"github.com/openshift/origin/pkg/cmd/server/bootstrappolicy"
)

type DeployerControllerConfig struct {
	ImageName     string
	ClientEnvVars []kapi.EnvVar

	Codec runtime.Codec
}

type DeploymentConfigControllerConfig struct {
	Codec runtime.Codec
}

func (c *DeployerControllerConfig) RunController(ctx ControllerContext) (bool, error) {
	kubeClient, err := ctx.ClientBuilder.Client(bootstrappolicy.InfraDeployerControllerServiceAccountName)
	if err != nil {
		return true, err
	}

	go deployercontroller.NewDeployerController(
		ctx.ExternalKubeInformers.Core().V1().ReplicationControllers(),
		ctx.ExternalKubeInformers.Core().V1().Pods(),
		kubeClient,
		bootstrappolicy.DeployerServiceAccountName,
		c.ImageName,
		c.ClientEnvVars,
		c.Codec,
	).Run(5, ctx.Stop)

	return true, nil
}

func (c *DeploymentConfigControllerConfig) RunController(ctx ControllerContext) (bool, error) {
	saName := bootstrappolicy.InfraDeploymentConfigControllerServiceAccountName

	kubeClient, err := ctx.ClientBuilder.Client(saName)
	if err != nil {
		return true, err
	}

	go deployconfigcontroller.NewDeploymentConfigController(
		ctx.AppInformers.Apps().InternalVersion().DeploymentConfigs(),
		ctx.ExternalKubeInformers.Core().V1().ReplicationControllers(),
		ctx.ClientBuilder.OpenshiftInternalAppsClientOrDie(saName),
		kubeClient,
		c.Codec,
	).Run(5, ctx.Stop)

	return true, nil
}
