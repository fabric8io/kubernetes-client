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
	"encoding/json"
	"errors"
	"fmt"
	"testing"

	"github.com/openshift/origin/pkg/oc/admin/diagnostics/diagnostics/log"

	securityapi "github.com/openshift/origin/pkg/security/apis/security"
)

type fakeSccDiagnostic struct {
	fakeDiagnostic
	fakeScc securityapi.SecurityContextConstraints
}

func newFakeSccDiagnostic(t *testing.T) *fakeSccDiagnostic {
	return &fakeSccDiagnostic{
		fakeDiagnostic: *newFakeDiagnostic(t),
	}
}

func (f *fakeSccDiagnostic) getScc(name string) (*securityapi.SecurityContextConstraints, error) {
	json, _ := json.Marshal(f.fakeScc)
	f.test.Logf(">> test#getScc(%s), err: %s, scc:%s", name, f.err, string(json))
	if f.err != nil {
		return nil, f.err
	}
	return &f.fakeScc, nil
}

func (f *fakeSccDiagnostic) addSccFor(name string, project string) {
	f.fakeScc.Users = append(f.fakeScc.Users, fmt.Sprintf("system:serviceaccount:%s:%s", project, name))
}

func TestCheckSccWhenClientReturnsError(t *testing.T) {
	d := newFakeSccDiagnostic(t)
	d.err = errors.New("client error")

	checkSccs(d, d, fakeProject)

	d.assertMessage("AGL0705", "Exp error when client returns error getting SCC", log.ErrorLevel)
	d.dumpMessages()
}

func TestCheckSccWhenMissingPrivelegedUsers(t *testing.T) {
	d := newFakeSccDiagnostic(t)

	checkSccs(d, d, fakeProject)

	d.assertMessage("AGL0710", "Exp error when SCC is missing exp service acount", log.ErrorLevel)
	d.dumpMessages()
}

func TestCheckSccWhenEverytingExists(t *testing.T) {
	d := newFakeSccDiagnostic(t)
	d.addSccFor(fluentdServiceAccountName, fakeProject)

	checkSccs(d, d, fakeProject)

	d.assertNoErrors()
	d.dumpMessages()
}
