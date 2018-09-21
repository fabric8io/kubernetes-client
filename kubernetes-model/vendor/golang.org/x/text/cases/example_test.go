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

package cases_test

import (
	"fmt"

	"golang.org/x/text/cases"
	"golang.org/x/text/language"
)

func Example() {
	src := []string{
		"hello world!",
		"i with dot",
		"'n ijsberg",
		"here comes O'Brian",
	}
	for _, c := range []cases.Caser{
		cases.Lower(language.Und),
		cases.Upper(language.Turkish),
		cases.Title(language.Dutch),
		cases.Title(language.Und, cases.NoLower),
	} {
		fmt.Println()
		for _, s := range src {
			fmt.Println(c.String(s))
		}
	}

	// Output:
	// hello world!
	// i with dot
	// 'n ijsberg
	// here comes o'brian
	//
	// HELLO WORLD!
	// İ WİTH DOT
	// 'N İJSBERG
	// HERE COMES O'BRİAN
	//
	// Hello World!
	// I With Dot
	// 'n IJsberg
	// Here Comes O'brian
	//
	// Hello World!
	// I With Dot
	// 'N Ijsberg
	// Here Comes O'Brian
}
