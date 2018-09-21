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
	templatecontroller "github.com/openshift/origin/pkg/template/controller"
)

func RunTemplateInstanceController(ctx ControllerContext) (bool, error) {
	saName := bootstrappolicy.InfraTemplateInstanceControllerServiceAccountName

	restConfig, err := ctx.ClientBuilder.Config(saName)
	if err != nil {
		return true, err
	}

	go templatecontroller.NewTemplateInstanceController(
		restConfig,
		ctx.ClientBuilder.KubeInternalClientOrDie(saName),
		ctx.ClientBuilder.OpenshiftInternalBuildClientOrDie(saName),
		ctx.ClientBuilder.OpenshiftInternalTemplateClientOrDie(saName),
		ctx.TemplateInformers.Template().InternalVersion().TemplateInstances(),
	).Run(5, ctx.Stop)

	return true, nil
}
