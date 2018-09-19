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

// +build solaris

package lif

import (
	"syscall"
	"unsafe"
)

//go:cgo_import_dynamic libc_ioctl ioctl "libc.so"

//go:linkname procIoctl libc_ioctl

var procIoctl uintptr

func sysvicall6(trap, nargs, a1, a2, a3, a4, a5, a6 uintptr) (uintptr, uintptr, syscall.Errno)

func ioctl(s, ioc uintptr, arg unsafe.Pointer) error {
	_, _, errno := sysvicall6(uintptr(unsafe.Pointer(&procIoctl)), 3, s, ioc, uintptr(arg), 0, 0, 0)
	if errno != 0 {
		return error(errno)
	}
	return nil
}
