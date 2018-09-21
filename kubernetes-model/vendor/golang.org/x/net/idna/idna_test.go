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
// Copyright 2012 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package idna

import (
	"testing"
)

var idnaTestCases = [...]struct {
	ascii, unicode string
}{
	// Labels.
	{"books", "books"},
	{"xn--bcher-kva", "bücher"},

	// Domains.
	{"foo--xn--bar.org", "foo--xn--bar.org"},
	{"golang.org", "golang.org"},
	{"example.xn--p1ai", "example.рф"},
	{"xn--czrw28b.tw", "商業.tw"},
	{"www.xn--mller-kva.de", "www.müller.de"},
}

func TestIDNA(t *testing.T) {
	for _, tc := range idnaTestCases {
		if a, err := ToASCII(tc.unicode); err != nil {
			t.Errorf("ToASCII(%q): %v", tc.unicode, err)
		} else if a != tc.ascii {
			t.Errorf("ToASCII(%q): got %q, want %q", tc.unicode, a, tc.ascii)
		}

		if u, err := ToUnicode(tc.ascii); err != nil {
			t.Errorf("ToUnicode(%q): %v", tc.ascii, err)
		} else if u != tc.unicode {
			t.Errorf("ToUnicode(%q): got %q, want %q", tc.ascii, u, tc.unicode)
		}
	}
}

// TODO(nigeltao): test errors, once we've specified when ToASCII and ToUnicode
// return errors.
