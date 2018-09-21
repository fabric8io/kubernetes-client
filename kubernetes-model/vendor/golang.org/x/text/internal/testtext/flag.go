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

package testtext

import (
	"flag"
	"testing"

	"golang.org/x/text/internal/gen"
)

var long = flag.Bool("long", false,
	"run tests that require fetching data online")

// SkipIfNotLong returns whether long tests should be performed.
func SkipIfNotLong(t *testing.T) {
	if testing.Short() || !(gen.IsLocal() || *long) {
		t.Skip("skipping test to prevent downloading; to run use -long or use -local or UNICODE_DIR to specify a local source")
	}
}
