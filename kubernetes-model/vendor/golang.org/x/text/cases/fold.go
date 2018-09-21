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

package cases

import "golang.org/x/text/transform"

type caseFolder struct{ transform.NopResetter }

// caseFolder implements the Transformer interface for doing case folding.
func (t *caseFolder) Transform(dst, src []byte, atEOF bool) (nDst, nSrc int, err error) {
	c := context{dst: dst, src: src, atEOF: atEOF}
	for c.next() {
		foldFull(&c)
		c.checkpoint()
	}
	return c.ret()
}

func (t *caseFolder) Span(src []byte, atEOF bool) (n int, err error) {
	c := context{src: src, atEOF: atEOF}
	for c.next() && isFoldFull(&c) {
		c.checkpoint()
	}
	return c.retSpan()
}

func makeFold(o options) transform.SpanningTransformer {
	// TODO: Special case folding, through option Language, Special/Turkic, or
	// both.
	// TODO: Implement Compact options.
	return &caseFolder{}
}
