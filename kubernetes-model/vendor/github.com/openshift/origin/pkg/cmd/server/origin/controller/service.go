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
	"time"

	configapi "github.com/openshift/origin/pkg/cmd/server/apis/config"
	"github.com/openshift/origin/pkg/cmd/server/bootstrappolicy"
	"github.com/openshift/origin/pkg/cmd/server/crypto"
	servingcertcontroller "github.com/openshift/origin/pkg/service/controller/servingcert"
)

type ServiceServingCertsControllerOptions struct {
	Signer *configapi.CertInfo
}

func (c *ServiceServingCertsControllerOptions) RunController(ctx ControllerContext) (bool, error) {
	if c.Signer == nil || len(c.Signer.CertFile) == 0 || len(c.Signer.KeyFile) == 0 {
		return false, nil
	}
	ca, err := crypto.GetCA(c.Signer.CertFile, c.Signer.KeyFile, "")
	if err != nil {
		return true, fmt.Errorf("service serving cert controller: %v", err)
	}

	servingCertController := servingcertcontroller.NewServiceServingCertController(
		ctx.ExternalKubeInformers.Core().V1().Services(),
		ctx.ExternalKubeInformers.Core().V1().Secrets(),
		ctx.ClientBuilder.ClientOrDie(bootstrappolicy.InfraServiceServingCertServiceAccountName).Core(),
		ctx.ClientBuilder.ClientOrDie(bootstrappolicy.InfraServiceServingCertServiceAccountName).Core(),
		ca,
		"cluster.local",
		2*time.Minute,
	)
	servingCertUpdateController := servingcertcontroller.NewServiceServingCertUpdateController(
		ctx.ExternalKubeInformers.Core().V1().Services(),
		ctx.ExternalKubeInformers.Core().V1().Secrets(),
		ctx.ClientBuilder.ClientOrDie(bootstrappolicy.InfraServiceServingCertServiceAccountName).Core(),
		ca,
		"cluster.local",
		20*time.Minute,
	)

	go servingCertController.Run(1, ctx.Stop)
	go servingCertUpdateController.Run(5, ctx.Stop)

	return true, nil
}
