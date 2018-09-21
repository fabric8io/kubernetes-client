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

package socket

import (
	"syscall"
	"unsafe"
)

const (
	sysRECVMMSG = 0x1db
	sysSENDMMSG = 0x1dc
)

func recvmmsg(s uintptr, hs []mmsghdr, flags int) (int, error) {
	n, _, errno := syscall.Syscall6(sysRECVMMSG, s, uintptr(unsafe.Pointer(&hs[0])), uintptr(len(hs)), uintptr(flags), 0, 0)
	return int(n), errnoErr(errno)
}

func sendmmsg(s uintptr, hs []mmsghdr, flags int) (int, error) {
	n, _, errno := syscall.Syscall6(sysSENDMMSG, s, uintptr(unsafe.Pointer(&hs[0])), uintptr(len(hs)), uintptr(flags), 0, 0)
	return int(n), errnoErr(errno)
}
