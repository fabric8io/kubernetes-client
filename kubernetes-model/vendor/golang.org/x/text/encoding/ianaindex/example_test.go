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

package ianaindex_test

import (
	"fmt"

	"golang.org/x/text/encoding/charmap"
	"golang.org/x/text/encoding/ianaindex"
)

func ExampleIndex() {
	fmt.Println(ianaindex.MIME.Name(charmap.ISO8859_7))
	fmt.Println(ianaindex.IANA.Name(charmap.ISO8859_7))
	fmt.Println(ianaindex.MIB.Name(charmap.ISO8859_7))

	e, _ := ianaindex.IANA.Encoding("cp437")
	fmt.Println(ianaindex.IANA.Name(e))

	// Output:
	// ISO-8859-7 <nil>
	// ISO_8859-7:1987 <nil>
	// ISOLatinGreek <nil>
	// IBM437 <nil>
}
