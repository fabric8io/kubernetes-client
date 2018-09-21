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

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	kapi "k8s.io/kubernetes/pkg/apis/core"

	"github.com/openshift/origin/pkg/oc/admin/diagnostics/diagnostics/log"
)

type mockServiceAccountDiagnostic struct {
	accounts kapi.ServiceAccountList
	fakeDiagnostic
}

func newMockServiceAccountDiagnostic(t *testing.T) *mockServiceAccountDiagnostic {
	return &mockServiceAccountDiagnostic{
		accounts:       kapi.ServiceAccountList{},
		fakeDiagnostic: *newFakeDiagnostic(t),
	}
}

func (m *mockServiceAccountDiagnostic) serviceAccounts(project string, options metav1.ListOptions) (*kapi.ServiceAccountList, error) {
	if m.err != nil {
		return &m.accounts, m.err
	}
	return &m.accounts, nil
}

func (d *mockServiceAccountDiagnostic) addServiceAccountNamed(name string) {
	meta := metav1.ObjectMeta{Name: name}
	d.accounts.Items = append(d.accounts.Items, kapi.ServiceAccount{ObjectMeta: meta})
}

func TestCheckingServiceAccountsWhenFailedResponseFromClient(t *testing.T) {
	d := newMockServiceAccountDiagnostic(t)
	d.err = errors.New("Some Error")
	checkServiceAccounts(d, d, fakeProject)
	d.assertMessage("AGL0505",
		"Exp an error when unable to retrieve service accounts because of a client error",
		log.ErrorLevel)
}

func TestCheckingServiceAccountsWhenMissingExpectedServiceAccount(t *testing.T) {
	d := newMockServiceAccountDiagnostic(t)
	d.addServiceAccountNamed("foobar")

	checkServiceAccounts(d, d, fakeProject)
	d.assertMessage("AGL0515",
		"Exp an error when an expected service account was not found.",
		log.ErrorLevel)
}

func TestCheckingServiceAccountsIsOk(t *testing.T) {
	d := newMockServiceAccountDiagnostic(t)

	for _, name := range serviceAccountNames.List() {
		d.addServiceAccountNamed(name)
	}

	checkServiceAccounts(d, d, fakeProject)
	d.assertNoErrors()
}
