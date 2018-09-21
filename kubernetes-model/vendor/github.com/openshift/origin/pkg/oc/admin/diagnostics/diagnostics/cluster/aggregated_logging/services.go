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

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/util/sets"
)

var expectedLoggingServices = sets.NewString("logging-es", "logging-es-cluster", "logging-kibana")
var optionalLoggingServices = sets.NewString("logging-es-ops", "logging-es-ops-cluster", "logging-kibana-ops", "logging-mux")
var loggingServices = expectedLoggingServices.Union(optionalLoggingServices)

const serviceNotFound = `
Expected to find '%s' among the logging services for the project but did not.  
`
const serviceOptionalNotFound = `
Looked for '%s' among the logging services for the project but did not find it.
This optional component may not have been specified by logging install options.
`

// checkServices looks to see if the aggregated logging services exist
func checkServices(r diagnosticReporter, adapter servicesAdapter, project string) {
	r.Debug("AGL0200", fmt.Sprintf("Checking for services in project '%s' with selector '%s'", project, loggingSelector.AsSelector()))
	serviceList, err := adapter.services(project, metav1.ListOptions{LabelSelector: loggingSelector.AsSelector().String()})
	if err != nil {
		r.Error("AGL0205", err, fmt.Sprintf("There was an error while trying to retrieve the logging services: %s", err))
		return
	}
	foundServices := sets.NewString()
	for _, service := range serviceList.Items {
		foundServices.Insert(service.ObjectMeta.Name)
		r.Debug("AGL0210", fmt.Sprintf("Retrieved service '%s'", service.ObjectMeta.Name))
	}
	for _, service := range loggingServices.List() {
		if foundServices.Has(service) {
			checkServiceEndpoints(r, adapter, project, service)
		} else {
			if optionalLoggingServices.Has(service) {
				r.Info("AGL0215", fmt.Sprintf(serviceOptionalNotFound, service))
			} else {
				r.Error("AGL0217", nil, fmt.Sprintf(serviceNotFound, service))
			}
		}
	}
}

// checkServiceEndpoints validates if there is an available endpoint for the service.
func checkServiceEndpoints(r diagnosticReporter, adapter servicesAdapter, project string, service string) {
	endpoints, err := adapter.endpointsForService(project, service)
	if err != nil {
		r.Warn("AGL0220", err, fmt.Sprintf("Unable to retrieve endpoints for service '%s': %s", service, err))
		return
	}
	if len(endpoints.Subsets) == 0 {
		r.Error("AGL0225", nil, fmt.Sprintf("There are no endpoints found for service '%s'. This means that no pods provide this service and this component is not functioning.", service))
	}
}
