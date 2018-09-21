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
// Copyright 2010 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package html

import (
	"testing"
	"unicode/utf8"
)

func TestEntityLength(t *testing.T) {
	// We verify that the length of UTF-8 encoding of each value is <= 1 + len(key).
	// The +1 comes from the leading "&". This property implies that the length of
	// unescaped text is <= the length of escaped text.
	for k, v := range entity {
		if 1+len(k) < utf8.RuneLen(v) {
			t.Error("escaped entity &" + k + " is shorter than its UTF-8 encoding " + string(v))
		}
		if len(k) > longestEntityWithoutSemicolon && k[len(k)-1] != ';' {
			t.Errorf("entity name %s is %d characters, but longestEntityWithoutSemicolon=%d", k, len(k), longestEntityWithoutSemicolon)
		}
	}
	for k, v := range entity2 {
		if 1+len(k) < utf8.RuneLen(v[0])+utf8.RuneLen(v[1]) {
			t.Error("escaped entity &" + k + " is shorter than its UTF-8 encoding " + string(v[0]) + string(v[1]))
		}
	}
}
