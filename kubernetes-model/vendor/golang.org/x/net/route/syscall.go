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

// +build darwin dragonfly freebsd netbsd openbsd

package route

import (
	"syscall"
	"unsafe"
)

var zero uintptr

func sysctl(mib []int32, old *byte, oldlen *uintptr, new *byte, newlen uintptr) error {
	var p unsafe.Pointer
	if len(mib) > 0 {
		p = unsafe.Pointer(&mib[0])
	} else {
		p = unsafe.Pointer(&zero)
	}
	_, _, errno := syscall.Syscall6(syscall.SYS___SYSCTL, uintptr(p), uintptr(len(mib)), uintptr(unsafe.Pointer(old)), uintptr(unsafe.Pointer(oldlen)), uintptr(unsafe.Pointer(new)), uintptr(newlen))
	if errno != 0 {
		return error(errno)
	}
	return nil
}
