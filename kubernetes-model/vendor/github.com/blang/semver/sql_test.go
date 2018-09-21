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
package semver

import (
	"testing"
)

type scanTest struct {
	val         interface{}
	shouldError bool
	expected    string
}

var scanTests = []scanTest{
	{"1.2.3", false, "1.2.3"},
	{[]byte("1.2.3"), false, "1.2.3"},
	{7, true, ""},
	{7e4, true, ""},
	{true, true, ""},
}

func TestScanString(t *testing.T) {
	for _, tc := range scanTests {
		s := &Version{}
		err := s.Scan(tc.val)
		if tc.shouldError {
			if err == nil {
				t.Fatalf("Scan did not return an error on %v (%T)", tc.val, tc.val)
			}
		} else {
			if err != nil {
				t.Fatalf("Scan returned an unexpected error: %s (%T) on %v (%T)", tc.val, tc.val, tc.val, tc.val)
			}
			if val, _ := s.Value(); val != tc.expected {
				t.Errorf("Wrong Value returned, expected %q, got %q", tc.expected, val)
			}
		}
	}
}
