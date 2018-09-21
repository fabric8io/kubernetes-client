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

package bidirule

import (
	"testing"

	"golang.org/x/text/internal/testtext"
)

var benchData = []struct{ name, data string }{
	{"ascii", "Scheveningen"},
	{"arabic", "دبي"},
	{"hangul", "다음과"},
}

func doBench(b *testing.B, fn func(b *testing.B, data string)) {
	for _, d := range benchData {
		testtext.Bench(b, d.name, func(b *testing.B) { fn(b, d.data) })
	}
}

func BenchmarkSpan(b *testing.B) {
	r := New()
	doBench(b, func(b *testing.B, str string) {
		b.SetBytes(int64(len(str)))
		data := []byte(str)
		for i := 0; i < b.N; i++ {
			r.Reset()
			r.Span(data, true)
		}
	})
}

func BenchmarkDirectionASCII(b *testing.B) {
	doBench(b, func(b *testing.B, str string) {
		b.SetBytes(int64(len(str)))
		data := []byte(str)
		for i := 0; i < b.N; i++ {
			Direction(data)
		}
	})
}

func BenchmarkDirectionStringASCII(b *testing.B) {
	doBench(b, func(b *testing.B, str string) {
		b.SetBytes(int64(len(str)))
		for i := 0; i < b.N; i++ {
			DirectionString(str)
		}
	})
}
