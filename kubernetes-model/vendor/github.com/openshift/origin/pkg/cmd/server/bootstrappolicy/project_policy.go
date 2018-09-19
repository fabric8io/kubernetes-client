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
package bootstrappolicy

import (
	"k8s.io/apiserver/pkg/authentication/serviceaccount"
	"k8s.io/kubernetes/pkg/apis/rbac"
)

func GetBootstrapServiceAccountProjectRoleBindings(namespace string) []rbac.RoleBinding {
	return []rbac.RoleBinding{
		newOriginRoleBindingForClusterRole(ImagePullerRoleBindingName, ImagePullerRoleName, namespace).
			Groups(serviceaccount.MakeNamespaceGroupName(namespace)).
			BindingOrDie(),
		newOriginRoleBindingForClusterRole(ImageBuilderRoleBindingName, ImageBuilderRoleName, namespace).
			SAs(namespace, BuilderServiceAccountName).
			BindingOrDie(),
		newOriginRoleBindingForClusterRole(DeployerRoleBindingName, DeployerRoleName, namespace).
			SAs(namespace, DeployerServiceAccountName).
			BindingOrDie(),
	}
}
