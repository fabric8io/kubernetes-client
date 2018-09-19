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
)

const sccPrivilegedName = "privileged"

var sccPrivilegedNames = sets.NewString(fluentdServiceAccountName)

const sccPrivilegedUnboundServiceAccount = `
The ServiceAccount '%[1]s' does not have a privileged SecurityContextConstraint for project '%[2]s'.  As a
user with a cluster-admin role, you can grant the permissions by running
the following:

  $ oc adm policy add-scc-to-user privileged system:serviceaccount:%[2]s:%[1]s
`

func checkSccs(r diagnosticReporter, adapter sccAdapter, project string) {
	r.Debug("AGL0700", "Checking SecurityContextConstraints...")
	scc, err := adapter.getScc(sccPrivilegedName)
	if err != nil {
		r.Error("AGL0705", err, fmt.Sprintf("There was an error while trying to retrieve the SecurityContextConstraints for the logging stack: %s", err))
		return
	}
	privilegedUsers := sets.NewString()
	for _, user := range scc.Users {
		privilegedUsers.Insert(user)
	}
	for _, name := range sccPrivilegedNames.List() {
		if !privilegedUsers.Has(fmt.Sprintf("system:serviceaccount:%s:%s", project, name)) {
			r.Error("AGL0710", nil, fmt.Sprintf(sccPrivilegedUnboundServiceAccount, name, project))
		}
	}
}
