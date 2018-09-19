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
// Copyright 2013 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package colltab // import "golang.org/x/text/internal/colltab"

// A Weighter can be used as a source for Collator and Searcher.
type Weighter interface {
	// Start finds the start of the segment that includes position p.
	Start(p int, b []byte) int

	// StartString finds the start of the segment that includes position p.
	StartString(p int, s string) int

	// AppendNext appends Elems to buf corresponding to the longest match
	// of a single character or contraction from the start of s.
	// It returns the new buf and the number of bytes consumed.
	AppendNext(buf []Elem, s []byte) (ce []Elem, n int)

	// AppendNextString appends Elems to buf corresponding to the longest match
	// of a single character or contraction from the start of s.
	// It returns the new buf and the number of bytes consumed.
	AppendNextString(buf []Elem, s string) (ce []Elem, n int)

	// Domain returns a slice of all single characters and contractions for which
	// collation elements are defined in this table.
	Domain() []string

	// Top returns the highest variable primary value.
	Top() uint32
}
