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

package runes_test

import (
	"fmt"
	"unicode"

	"golang.org/x/text/runes"
	"golang.org/x/text/transform"
	"golang.org/x/text/unicode/norm"
	"golang.org/x/text/width"
)

func ExampleRemove() {
	t := transform.Chain(norm.NFD, runes.Remove(runes.In(unicode.Mn)), norm.NFC)
	s, _, _ := transform.String(t, "résumé")
	fmt.Println(s)

	// Output:
	// resume
}

func ExampleMap() {
	replaceHyphens := runes.Map(func(r rune) rune {
		if unicode.Is(unicode.Hyphen, r) {
			return '|'
		}
		return r
	})
	s, _, _ := transform.String(replaceHyphens, "a-b‐c⸗d﹣e")
	fmt.Println(s)

	// Output:
	// a|b|c|d|e
}

func ExampleIn() {
	// Convert Latin characters to their canonical form, while keeping other
	// width distinctions.
	t := runes.If(runes.In(unicode.Latin), width.Fold, nil)
	s, _, _ := transform.String(t, "ｱﾙｱﾉﾘｳ tech / アルアノリウ ｔｅｃｈ")
	fmt.Println(s)

	// Output:
	// ｱﾙｱﾉﾘｳ tech / アルアノリウ tech
}

func ExampleIf() {
	// Widen everything but ASCII.
	isASCII := func(r rune) bool { return r <= unicode.MaxASCII }
	t := runes.If(runes.Predicate(isASCII), nil, width.Widen)
	s, _, _ := transform.String(t, "ｱﾙｱﾉﾘｳ tech / 中國 / 5₩")
	fmt.Println(s)

	// Output:
	// アルアノリウ tech / 中國 / 5￦
}
