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
package openshift

import (
	"strings"
	"testing"
)

func TestCommandFor(t *testing.T) {
	cmd := CommandFor("openshift-router")
	if !strings.HasPrefix(cmd.Use, "openshift-router ") {
		t.Errorf("expected command to start with prefix: %#v", cmd)
	}

	cmd = CommandFor("unknown")
	if cmd.Use != "openshift" {
		t.Errorf("expected command to be openshift: %#v", cmd)
	}
}
