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
package deploymentconfigs

import (
	"bytes"
	"fmt"

	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/kubernetes/pkg/kubectl"
	kinternalprinters "k8s.io/kubernetes/pkg/printers/internalversion"

	appsapi "github.com/openshift/origin/pkg/apps/apis/apps"
	appsclient "github.com/openshift/origin/pkg/apps/generated/internalclientset"
	appsinternal "github.com/openshift/origin/pkg/apps/generated/internalclientset/typed/apps/internalversion"
)

func NewDeploymentConfigRollbacker(appsClient appsclient.Interface) kubectl.Rollbacker {
	return &DeploymentConfigRollbacker{dn: appsClient.Apps()}
}

// DeploymentConfigRollbacker is an implementation of the kubectl Rollbacker interface
// for deployment configs.
type DeploymentConfigRollbacker struct {
	dn appsinternal.DeploymentConfigsGetter
}

var _ kubectl.Rollbacker = &DeploymentConfigRollbacker{}

// Rollback the provided deployment config to a specific revision. If revision is zero, we will
// rollback to the previous deployment.
func (r *DeploymentConfigRollbacker) Rollback(obj runtime.Object, updatedAnnotations map[string]string, toRevision int64, dryRun bool) (string, error) {
	config, ok := obj.(*appsapi.DeploymentConfig)
	if !ok {
		return "", fmt.Errorf("passed object is not a deployment config: %#v", obj)
	}
	if config.Spec.Paused {
		return "", fmt.Errorf("cannot rollback a paused config; resume it first with 'rollout resume dc/%s' and try again", config.Name)
	}

	rollback := &appsapi.DeploymentConfigRollback{
		Name:               config.Name,
		UpdatedAnnotations: updatedAnnotations,
		Spec: appsapi.DeploymentConfigRollbackSpec{
			Revision:        toRevision,
			IncludeTemplate: true,
		},
	}

	rolledback, err := r.dn.DeploymentConfigs(config.Namespace).Rollback(config.Name, rollback)
	if err != nil {
		return "", err
	}

	if dryRun {
		out := bytes.NewBuffer([]byte("\n"))
		kinternalprinters.DescribePodTemplate(rolledback.Spec.Template, kinternalprinters.NewPrefixWriter(out))
		return out.String(), nil
	}

	_, err = r.dn.DeploymentConfigs(config.Namespace).Update(rolledback)
	if err != nil {
		return "", err
	}

	return "rolled back", nil
}
