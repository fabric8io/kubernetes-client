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

// +build !go1.7

package testtext

import "testing"

func Run(t *testing.T, name string, fn func(t *testing.T)) bool {
	t.Logf("Running %s...", name)
	fn(t)
	return t.Failed()
}

// Bench runs the given benchmark function. This pre-1.7 implementation renders
// the measurement useless, but allows the code to be compiled at least.
func Bench(b *testing.B, name string, fn func(b *testing.B)) bool {
	b.Logf("Running %s...", name)
	fn(b)
	return b.Failed()
}
