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

// +build icu

package cases

// Ideally these functions would be defined in a test file, but go test doesn't
// allow CGO in tests. The build tag should ensure either way that these
// functions will not end up in the package.

// TODO: Ensure that the correct ICU version is set.

/*
#cgo LDFLAGS: -licui18n.57 -licuuc.57
#include <stdlib.h>
#include <unicode/ustring.h>
#include <unicode/utypes.h>
#include <unicode/localpointer.h>
#include <unicode/ucasemap.h>
*/
import "C"

import "unsafe"

func doICU(tag, caser, input string) string {
	err := C.UErrorCode(0)
	loc := C.CString(tag)
	cm := C.ucasemap_open(loc, C.uint32_t(0), &err)

	buf := make([]byte, len(input)*4)
	dst := (*C.char)(unsafe.Pointer(&buf[0]))
	src := C.CString(input)

	cn := C.int32_t(0)

	switch caser {
	case "fold":
		cn = C.ucasemap_utf8FoldCase(cm,
			dst, C.int32_t(len(buf)),
			src, C.int32_t(len(input)),
			&err)
	case "lower":
		cn = C.ucasemap_utf8ToLower(cm,
			dst, C.int32_t(len(buf)),
			src, C.int32_t(len(input)),
			&err)
	case "upper":
		cn = C.ucasemap_utf8ToUpper(cm,
			dst, C.int32_t(len(buf)),
			src, C.int32_t(len(input)),
			&err)
	case "title":
		cn = C.ucasemap_utf8ToTitle(cm,
			dst, C.int32_t(len(buf)),
			src, C.int32_t(len(input)),
			&err)
	}
	return string(buf[:cn])
}
