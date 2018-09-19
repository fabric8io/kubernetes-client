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
package aggregated_logging

import (
	"fmt"

	"k8s.io/apimachinery/pkg/util/sets"
	"k8s.io/kubernetes/pkg/apis/rbac"
)

const clusterReaderRoleBindingRoleName = "cluster-reader"

var clusterReaderRoleBindingNames = sets.NewString(fluentdServiceAccountName)

const clusterReaderUnboundServiceAccount = `
The ServiceAccount '%[1]s' is not a cluster-reader in the '%[2]s' project.  This
is required to enable Fluentd to look up pod metadata for the logs it gathers.
As a user with a cluster-admin role, you can grant the permissions by running
the following:

  $ oc adm policy add-cluster-role-to-user cluster-reader system:serviceaccount:%[2]s:%[1]s
`

func checkClusterRoleBindings(r diagnosticReporter, adapter clusterRoleBindingsAdapter, project string) {
	r.Debug("AGL0600", "Checking ClusterRoleBindings...")
	crbs, err := adapter.listClusterRoleBindings()
	if err != nil {
		r.Error("AGL0605", err, fmt.Sprintf("There was an error while trying to retrieve the ClusterRoleBindings for the logging stack: %s", err))
		return
	}
	boundServiceAccounts := sets.NewString()
	for _, crb := range crbs.Items {
		if crb.RoleRef.Name != clusterReaderRoleBindingRoleName {
			continue
		}
		for _, subject := range crb.Subjects {
			if subject.Kind == rbac.ServiceAccountKind && subject.Namespace == project {
				boundServiceAccounts.Insert(subject.Name)
			}
		}
	}
	for _, name := range clusterReaderRoleBindingNames.List() {
		if !boundServiceAccounts.Has(name) {
			r.Error("AGL0610", nil, fmt.Sprintf(clusterReaderUnboundServiceAccount, name, project))
		}
	}
}
