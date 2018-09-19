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
package podautoscaler

import (
	"k8s.io/apimachinery/pkg/runtime/schema"

	apimeta "k8s.io/apimachinery/pkg/api/meta"
)

func overrideMappingsForOapiDeploymentConfig(mappings []*apimeta.RESTMapping, err error, targetGK schema.GroupKind) ([]*apimeta.RESTMapping, error) {
	if (targetGK == schema.GroupKind{Kind: "DeploymentConfig"}) {
		err = nil
		// NB: we don't convert to apps.openshift.io here since the patched scale client
		// will do it for us.
		mappings = []*apimeta.RESTMapping{
			{
				Resource:         "deploymentconfigs",
				GroupVersionKind: targetGK.WithVersion("v1"),
			},
		}
	}
	return mappings, err
}
