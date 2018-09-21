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

package internal

import (
	"testing"

	"golang.org/x/text/language"
)

func TestParents(t *testing.T) {
	testCases := []struct {
		tag, parent string
	}{
		{"af", "und"},
		{"en", "und"},
		{"en-001", "en"},
		{"en-AU", "en-001"},
		{"en-US", "en"},
		{"en-US-u-va-posix", "en-US"},
		{"ca-ES-valencia", "ca-ES"},
	}
	for _, tc := range testCases {
		tag, ok := language.CompactIndex(language.MustParse(tc.tag))
		if !ok {
			t.Fatalf("Could not get index of flag %s", tc.tag)
		}
		want, ok := language.CompactIndex(language.MustParse(tc.parent))
		if !ok {
			t.Fatalf("Could not get index of parent %s of tag %s", tc.parent, tc.tag)
		}
		if got := int(Parent[tag]); got != want {
			t.Errorf("Parent[%s] = %d; want %d (%s)", tc.tag, got, want, tc.parent)
		}
	}
}
