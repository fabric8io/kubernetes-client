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
// Copyright 2015 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package precis

import (
	"testing"

	"golang.org/x/text/runes"
)

// Compile-time regression test to ensure that Class is a Set
var _ runes.Set = (*class)(nil)

// Ensure that certain characters are (or are not) in the identifer class.
func TestClassContains(t *testing.T) {
	tests := []struct {
		name       string
		class      *class
		allowed    []rune
		disallowed []rune
	}{
		{
			name:       "Identifier",
			class:      identifier,
			allowed:    []rune("Aa0\u0021\u007e\u00df\u3007"),
			disallowed: []rune("\u2150\u2100\u2200\u3164\u2190\u2600\u303b\u1e9b"),
		},
		{
			name:       "Freeform",
			class:      freeform,
			allowed:    []rune("Aa0\u0021\u007e\u00df\u3007 \u2150\u2100\u2200\u2190\u2600\u1e9b"),
			disallowed: []rune("\u3164\u303b"),
		},
	}

	for _, rt := range tests {
		for _, r := range rt.allowed {
			if !rt.class.Contains(r) {
				t.Errorf("Class %s should contain %U", rt.name, r)
			}
		}
		for _, r := range rt.disallowed {
			if rt.class.Contains(r) {
				t.Errorf("Class %s should not contain %U", rt.name, r)
			}
		}
	}
}
