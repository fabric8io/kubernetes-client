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
	"github.com/golang/glog"

	kapiv1 "k8s.io/api/core/v1"
	sacontroller "k8s.io/kubernetes/pkg/controller/serviceaccount"

	"github.com/openshift/origin/pkg/cmd/server/bootstrappolicy"
	serviceaccountcontrollers "github.com/openshift/origin/pkg/serviceaccounts/controllers"
)

type ServiceAccountControllerOptions struct {
	ManagedNames []string
}

func (c *ServiceAccountControllerOptions) RunController(ctx ControllerContext) (bool, error) {
	if len(c.ManagedNames) == 0 {
		glog.Infof("Skipped starting Service Account Manager, no managed names specified")
		return false, nil
	}

	options := sacontroller.DefaultServiceAccountsControllerOptions()
	options.ServiceAccounts = []kapiv1.ServiceAccount{}

	for _, saName := range c.ManagedNames {
		// the upstream controller does this one, so we don't have to
		if saName == "default" {
			continue
		}
		sa := kapiv1.ServiceAccount{}
		sa.Name = saName

		options.ServiceAccounts = append(options.ServiceAccounts, sa)
	}

	controller, err := sacontroller.NewServiceAccountsController(
		ctx.ExternalKubeInformers.Core().V1().ServiceAccounts(),
		ctx.ExternalKubeInformers.Core().V1().Namespaces(),
		ctx.ClientBuilder.ClientOrDie(bootstrappolicy.InfraServiceAccountControllerServiceAccountName),
		options)
	if err != nil {
		return true, nil
	}
	go controller.Run(3, ctx.Stop)

	return true, nil
}

func RunServiceAccountPullSecretsController(ctx ControllerContext) (bool, error) {
	kc := ctx.ClientBuilder.ClientOrDie(bootstrappolicy.InfraServiceAccountPullSecretsControllerServiceAccountName)

	go serviceaccountcontrollers.NewDockercfgDeletedController(
		ctx.ExternalKubeInformers.Core().V1().Secrets(),
		kc,
		serviceaccountcontrollers.DockercfgDeletedControllerOptions{},
	).Run(ctx.Stop)

	go serviceaccountcontrollers.NewDockercfgTokenDeletedController(
		ctx.ExternalKubeInformers.Core().V1().Secrets(),
		kc,
		serviceaccountcontrollers.DockercfgTokenDeletedControllerOptions{},
	).Run(ctx.Stop)

	dockerURLsInitialized := make(chan struct{})
	dockercfgController := serviceaccountcontrollers.NewDockercfgController(
		ctx.ExternalKubeInformers.Core().V1().ServiceAccounts(),
		ctx.ExternalKubeInformers.Core().V1().Secrets(),
		kc,
		serviceaccountcontrollers.DockercfgControllerOptions{DockerURLsInitialized: dockerURLsInitialized},
	)
	go dockercfgController.Run(5, ctx.Stop)

	dockerRegistryControllerOptions := serviceaccountcontrollers.DockerRegistryServiceControllerOptions{
		RegistryNamespace:     "default",
		RegistryServiceName:   "docker-registry",
		DockercfgController:   dockercfgController,
		DockerURLsInitialized: dockerURLsInitialized,
	}
	go serviceaccountcontrollers.NewDockerRegistryServiceController(
		ctx.ExternalKubeInformers.Core().V1().Secrets(),
		kc,
		dockerRegistryControllerOptions,
	).Run(10, ctx.Stop)

	return true, nil
}
