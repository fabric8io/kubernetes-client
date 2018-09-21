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
// +build unsafe

// Copyright (c) 2012-2015 Ugorji Nwoke. All rights reserved.
// Use of this source code is governed by a MIT license found in the LICENSE file.

package codec

import (
	"unsafe"
)

// This file has unsafe variants of some helper methods.

type unsafeString struct {
	Data uintptr
	Len  int
}

type unsafeSlice struct {
	Data uintptr
	Len  int
	Cap  int
}

// stringView returns a view of the []byte as a string.
// In unsafe mode, it doesn't incur allocation and copying caused by conversion.
// In regular safe mode, it is an allocation and copy.
func stringView(v []byte) string {
	if len(v) == 0 {
		return ""
	}

	bx := (*unsafeSlice)(unsafe.Pointer(&v))
	sx := unsafeString{bx.Data, bx.Len}
	return *(*string)(unsafe.Pointer(&sx))
}

// bytesView returns a view of the string as a []byte.
// In unsafe mode, it doesn't incur allocation and copying caused by conversion.
// In regular safe mode, it is an allocation and copy.
func bytesView(v string) []byte {
	if len(v) == 0 {
		return zeroByteSlice
	}

	sx := (*unsafeString)(unsafe.Pointer(&v))
	bx := unsafeSlice{sx.Data, sx.Len, sx.Len}
	return *(*[]byte)(unsafe.Pointer(&bx))
}
