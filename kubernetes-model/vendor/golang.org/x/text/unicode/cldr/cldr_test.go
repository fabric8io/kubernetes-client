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
// Copyright 2014 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package cldr

import "testing"

func TestParseDraft(t *testing.T) {
	tests := []struct {
		in    string
		draft Draft
		err   bool
	}{
		{"unconfirmed", Unconfirmed, false},
		{"provisional", Provisional, false},
		{"contributed", Contributed, false},
		{"approved", Approved, false},
		{"", Approved, false},
		{"foo", Approved, true},
	}
	for _, tt := range tests {
		if d, err := ParseDraft(tt.in); d != tt.draft || (err != nil) != tt.err {
			t.Errorf("%q: was %v, %v; want %v, %v", tt.in, d, err != nil, tt.draft, tt.err)
		}
	}
}
