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
package user

import (
	"fmt"
	"strings"
	"testing"

	securityapi "github.com/openshift/origin/pkg/security/apis/security"
)

func TestMustRunAsOptions(t *testing.T) {
	var uid int64 = 1
	tests := map[string]struct {
		opts *securityapi.RunAsUserStrategyOptions
		pass bool
	}{
		"invalid opts": {
			opts: &securityapi.RunAsUserStrategyOptions{},
			pass: false,
		},
		"valid opts": {
			opts: &securityapi.RunAsUserStrategyOptions{UID: &uid},
			pass: true,
		},
	}
	for name, tc := range tests {
		_, err := NewMustRunAs(tc.opts)
		if err != nil && tc.pass {
			t.Errorf("%s expected to pass but received error %v", name, err)
		}
		if err == nil && !tc.pass {
			t.Errorf("%s expected to fail but did not receive an error", name)
		}
	}
}

func TestMustRunAsGenerate(t *testing.T) {
	var uid int64 = 1
	opts := &securityapi.RunAsUserStrategyOptions{UID: &uid}
	mustRunAs, err := NewMustRunAs(opts)
	if err != nil {
		t.Fatalf("unexpected error initializing NewMustRunAs %v", err)
	}
	generated, err := mustRunAs.Generate(nil, nil)
	if err != nil {
		t.Fatalf("unexpected error generating uid %v", err)
	}
	if *generated != uid {
		t.Errorf("generated uid does not equal configured uid")
	}
}

func TestMustRunAsValidate(t *testing.T) {
	var uid int64 = 1
	var badUID int64 = 2
	opts := &securityapi.RunAsUserStrategyOptions{UID: &uid}
	mustRunAs, err := NewMustRunAs(opts)
	if err != nil {
		t.Fatalf("unexpected error initializing NewMustRunAs %v", err)
	}

	errs := mustRunAs.Validate(nil, nil, nil, nil, nil)
	expectedMessage := "runAsUser: Required value"
	if len(errs) == 0 {
		t.Errorf("expected errors from nil runAsUser but got none")
	} else if !strings.Contains(errs[0].Error(), expectedMessage) {
		t.Errorf("expected error to contain %q but it did not: %v", expectedMessage, errs)
	}

	errs = mustRunAs.Validate(nil, nil, nil, nil, &badUID)
	expectedMessage = fmt.Sprintf("runAsUser: Invalid value: %d: must be: %d", badUID, uid)
	if len(errs) == 0 {
		t.Errorf("expected errors from mismatch uid but got none")
	} else if !strings.Contains(errs[0].Error(), expectedMessage) {
		t.Errorf("expected error to contain %q but it did not: %v", expectedMessage, errs)
	}

	errs = mustRunAs.Validate(nil, nil, nil, nil, &uid)
	if len(errs) != 0 {
		t.Errorf("expected no errors from matching uid but got %v", errs)
	}
}
