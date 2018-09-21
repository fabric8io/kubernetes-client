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
package version

import (
	"testing"
)

func TestLastSemanticVersion(t *testing.T) {
	testCases := []struct {
		in, out string
	}{
		{"v1.3", "v1.3"},
		{"v1.3+dirty", "v1.3"},
		{"v1.3-11+abcdef-dirty", "v1.3-11"},
		{"v1.3-11+abcdef", "v1.3-11"},
		{"v1.3-11", "v1.3-11"},
		{"v1.3.0+abcdef", "v1.3.0"},
		{"v1.3+abcdef", "v1.3"},
		{"v1.3.0-alpha.1", "v1.3.0-alpha.1"},
		{"v1.3.0-alpha.1-dirty", "v1.3.0-alpha.1-dirty"},
		{"v1.3.0-alpha.1+abc-dirty", "v1.3.0-alpha.1"},
		{"v1.3.0-alpha.1+abcdef-dirty", "v1.3.0-alpha.1"},
	}
	for _, test := range testCases {
		out := Info{GitVersion: test.in}.LastSemanticVersion()
		if out != test.out {
			t.Errorf("expected %s for %s, got %s", test.out, test.in, out)
		}
	}
}
