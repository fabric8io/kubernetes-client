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
	"github.com/openshift/origin/pkg/cmd/server/bootstrappolicy"
	projectcontroller "github.com/openshift/origin/pkg/project/controller"
)

func RunOriginNamespaceController(ctx ControllerContext) (bool, error) {
	controller := projectcontroller.NewProjectFinalizerController(
		ctx.ExternalKubeInformers.Core().V1().Namespaces(),
		ctx.ClientBuilder.ClientOrDie(bootstrappolicy.InfraOriginNamespaceServiceAccountName),
	)
	go controller.Run(ctx.Stop, 5)
	return true, nil
}
