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
	"fmt"
	"reflect"

	kapi "k8s.io/api/core/v1"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/kubernetes/pkg/kubectl"

	appsapi "github.com/openshift/api/apps/v1"
)

var basic = kubectl.BasicReplicationController{}

type BasicDeploymentConfigController struct{}

func (BasicDeploymentConfigController) ParamNames() []kubectl.GeneratorParam {
	return basic.ParamNames()
}

func (BasicDeploymentConfigController) Generate(genericParams map[string]interface{}) (runtime.Object, error) {
	obj, err := basic.Generate(genericParams)
	if err != nil {
		return nil, err
	}
	switch t := obj.(type) {
	case *kapi.ReplicationController:
		obj = &appsapi.DeploymentConfig{
			ObjectMeta: t.ObjectMeta,
			Spec: appsapi.DeploymentConfigSpec{
				Selector: t.Spec.Selector,
				Replicas: *t.Spec.Replicas, // the generator never leaves this nil
				Template: t.Spec.Template,
			},
		}
	default:
		return nil, fmt.Errorf("unrecognized object type: %v", reflect.TypeOf(t))
	}
	return obj, nil
}
