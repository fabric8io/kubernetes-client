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
	"errors"
	"testing"

	"github.com/openshift/origin/pkg/oc/admin/diagnostics/diagnostics/log"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	kapi "k8s.io/kubernetes/pkg/apis/core"
)

type fakeServicesDiagnostic struct {
	list kapi.ServiceList
	fakeDiagnostic
	endpoints   map[string]kapi.Endpoints
	endpointErr error
}

func newFakeServicesDiagnostic(t *testing.T) *fakeServicesDiagnostic {
	return &fakeServicesDiagnostic{
		list:           kapi.ServiceList{},
		fakeDiagnostic: *newFakeDiagnostic(t),
		endpoints:      map[string]kapi.Endpoints{},
	}
}

func (f *fakeServicesDiagnostic) services(project string, options metav1.ListOptions) (*kapi.ServiceList, error) {
	if f.err != nil {
		return &f.list, f.err
	}
	return &f.list, nil
}
func (f *fakeServicesDiagnostic) endpointsForService(project string, service string) (*kapi.Endpoints, error) {
	if f.endpointErr != nil {
		return nil, f.endpointErr
	}
	endpoints, _ := f.endpoints[service]
	return &endpoints, nil
}

func (f *fakeServicesDiagnostic) addEndpointSubsetTo(service string) {
	endpoints := kapi.Endpoints{}
	endpoints.Subsets = []kapi.EndpointSubset{{}}
	f.endpoints[service] = endpoints
}

func (f *fakeServicesDiagnostic) addServiceNamed(name string) {
	meta := metav1.ObjectMeta{Name: name}
	f.list.Items = append(f.list.Items, kapi.Service{ObjectMeta: meta})
}

// Test error from client
func TestCheckingServicesWhenFailedResponseFromClient(t *testing.T) {
	d := newFakeServicesDiagnostic(t)
	d.err = errors.New("an error")
	checkServices(d, d, fakeProject)
	d.assertMessage("AGL0205",
		"Exp an error when unable to retrieve services because of a client error",
		log.ErrorLevel)
}

func TestCheckingServicesWhenMissingServices(t *testing.T) {
	d := newFakeServicesDiagnostic(t)
	d.addServiceNamed("logging-es")

	checkServices(d, d, fakeProject)
	d.assertMessage("AGL0215",
		"Exp an info when an expected service is not found",
		log.InfoLevel)
}

func TestCheckingServicesWarnsWhenRetrievingEndpointsErrors(t *testing.T) {
	d := newFakeServicesDiagnostic(t)
	d.addServiceNamed("logging-es")
	d.endpointErr = errors.New("an endpoint error")

	checkServices(d, d, fakeProject)
	d.assertMessage("AGL0220",
		"Exp a warning when there is an error retrieving endpoints for a service",
		log.WarnLevel)
}

func TestCheckingServicesWarnsWhenServiceHasNoEndpoints(t *testing.T) {
	d := newFakeServicesDiagnostic(t)
	for _, service := range loggingServices.List() {
		d.addServiceNamed(service)
	}

	checkServices(d, d, fakeProject)
	d.assertMessage("AGL0225",
		"Exp an error when an existing service has no endpoints",
		log.ErrorLevel)
}

func TestCheckingServicesHasNoErrorsOrWarningsForExpServices(t *testing.T) {
	d := newFakeServicesDiagnostic(t)
	for _, service := range loggingServices.List() {
		d.addServiceNamed(service)
		d.addEndpointSubsetTo(service)
	}

	checkServices(d, d, fakeProject)
	d.assertNoErrors()
	d.assertNoWarnings()
}
