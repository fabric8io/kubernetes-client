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

// +build darwin dragonfly freebsd netbsd openbsd

package socket

import "unsafe"

func (h *msghdr) pack(vs []iovec, bs [][]byte, oob []byte, sa []byte) {
	for i := range vs {
		vs[i].set(bs[i])
	}
	h.setIov(vs)
	if len(oob) > 0 {
		h.Control = (*byte)(unsafe.Pointer(&oob[0]))
		h.Controllen = uint32(len(oob))
	}
	if sa != nil {
		h.Name = (*byte)(unsafe.Pointer(&sa[0]))
		h.Namelen = uint32(len(sa))
	}
}

func (h *msghdr) name() []byte {
	if h.Name != nil && h.Namelen > 0 {
		return (*[sizeofSockaddrInet6]byte)(unsafe.Pointer(h.Name))[:h.Namelen]
	}
	return nil
}

func (h *msghdr) controllen() int {
	return int(h.Controllen)
}

func (h *msghdr) flags() int {
	return int(h.Flags)
}
