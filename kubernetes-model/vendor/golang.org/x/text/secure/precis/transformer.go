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

package precis

import "golang.org/x/text/transform"

// Transformer implements the transform.Transformer interface.
type Transformer struct {
	t transform.Transformer
}

// Reset implements the transform.Transformer interface.
func (t Transformer) Reset() { t.t.Reset() }

// Transform implements the transform.Transformer interface.
func (t Transformer) Transform(dst, src []byte, atEOF bool) (nDst, nSrc int, err error) {
	return t.t.Transform(dst, src, atEOF)
}

// Bytes returns a new byte slice with the result of applying t to b.
func (t Transformer) Bytes(b []byte) []byte {
	b, _, _ = transform.Bytes(t, b)
	return b
}

// String returns a string with the result of applying t to s.
func (t Transformer) String(s string) string {
	s, _, _ = transform.String(t, s)
	return s
}
