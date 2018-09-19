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
// Copyright 2016 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package runenames

import (
	"strings"
	"testing"
	"unicode"

	"golang.org/x/text/internal/gen"
	"golang.org/x/text/internal/testtext"
	"golang.org/x/text/internal/ucd"
)

func TestName(t *testing.T) {
	testtext.SkipIfNotLong(t)

	wants := make([]string, 1+unicode.MaxRune)
	ucd.Parse(gen.OpenUCDFile("UnicodeData.txt"), func(p *ucd.Parser) {
		r, s := p.Rune(0), p.String(ucd.Name)
		if s == "" {
			return
		}
		if s[0] == '<' {
			const first = ", First>"
			if i := strings.Index(s, first); i >= 0 {
				s = s[:i] + ">"
			}
		}
		wants[r] = s
	})

	nErrors := 0
	for r, want := range wants {
		got := Name(rune(r))
		if got != want {
			t.Errorf("r=%#08x: got %q, want %q", r, got, want)
			nErrors++
			if nErrors == 100 {
				t.Fatal("too many errors")
			}
		}
	}
}
