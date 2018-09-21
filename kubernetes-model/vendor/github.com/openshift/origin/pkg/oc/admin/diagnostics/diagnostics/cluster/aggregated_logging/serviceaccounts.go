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
	"strings"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/util/sets"
)

var serviceAccountNames = sets.NewString("aggregated-logging-kibana", "aggregated-logging-curator", "aggregated-logging-elasticsearch", fluentdServiceAccountName)

const serviceAccountsMissing = `
Did not find ServiceAccounts: %s.  The logging infrastructure will not function 
properly without them.  You may need to re-run the installer.
`

func checkServiceAccounts(d diagnosticReporter, f saAdapter, project string) {
	d.Debug("AGL0500", fmt.Sprintf("Checking ServiceAccounts in project '%s'...", project))
	saList, err := f.serviceAccounts(project, metav1.ListOptions{})
	if err != nil {
		d.Error("AGL0505", err, fmt.Sprintf("There was an error while trying to retrieve the pods for the AggregatedLogging stack: %s", err))
		return
	}
	foundNames := sets.NewString()
	for _, sa := range saList.Items {
		foundNames.Insert(sa.ObjectMeta.Name)
	}
	missing := sets.NewString()
	for _, name := range serviceAccountNames.List() {
		if !foundNames.Has(name) {
			missing.Insert(name)
		}
	}
	if missing.Len() != 0 {
		d.Error("AGL0515", nil, fmt.Sprintf(serviceAccountsMissing, strings.Join(missing.List(), ",")))
	}
}
