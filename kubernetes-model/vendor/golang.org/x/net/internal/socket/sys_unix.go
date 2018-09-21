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
// Copyright 2017 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// +build darwin dragonfly freebsd linux,!s390x,!386 netbsd openbsd

package socket

import (
	"syscall"
	"unsafe"
)

func getsockopt(s uintptr, level, name int, b []byte) (int, error) {
	l := uint32(len(b))
	_, _, errno := syscall.Syscall6(syscall.SYS_GETSOCKOPT, s, uintptr(level), uintptr(name), uintptr(unsafe.Pointer(&b[0])), uintptr(unsafe.Pointer(&l)), 0)
	return int(l), errnoErr(errno)
}

func setsockopt(s uintptr, level, name int, b []byte) error {
	_, _, errno := syscall.Syscall6(syscall.SYS_SETSOCKOPT, s, uintptr(level), uintptr(name), uintptr(unsafe.Pointer(&b[0])), uintptr(len(b)), 0)
	return errnoErr(errno)
}

func recvmsg(s uintptr, h *msghdr, flags int) (int, error) {
	n, _, errno := syscall.Syscall(syscall.SYS_RECVMSG, s, uintptr(unsafe.Pointer(h)), uintptr(flags))
	return int(n), errnoErr(errno)
}

func sendmsg(s uintptr, h *msghdr, flags int) (int, error) {
	n, _, errno := syscall.Syscall(syscall.SYS_SENDMSG, s, uintptr(unsafe.Pointer(h)), uintptr(flags))
	return int(n), errnoErr(errno)
}
