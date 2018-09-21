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
// Copyright 2014 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// +build darwin freebsd linux solaris

package ipv4

import (
	"net"
	"unsafe"

	"golang.org/x/net/internal/socket"
)

var freebsd32o64 bool

func (so *sockOpt) setGroupReq(c *socket.Conn, ifi *net.Interface, grp net.IP) error {
	var gr groupReq
	if ifi != nil {
		gr.Interface = uint32(ifi.Index)
	}
	gr.setGroup(grp)
	var b []byte
	if freebsd32o64 {
		var d [sizeofGroupReq + 4]byte
		s := (*[sizeofGroupReq]byte)(unsafe.Pointer(&gr))
		copy(d[:4], s[:4])
		copy(d[8:], s[4:])
		b = d[:]
	} else {
		b = (*[sizeofGroupReq]byte)(unsafe.Pointer(&gr))[:sizeofGroupReq]
	}
	return so.Set(c, b)
}

func (so *sockOpt) setGroupSourceReq(c *socket.Conn, ifi *net.Interface, grp, src net.IP) error {
	var gsr groupSourceReq
	if ifi != nil {
		gsr.Interface = uint32(ifi.Index)
	}
	gsr.setSourceGroup(grp, src)
	var b []byte
	if freebsd32o64 {
		var d [sizeofGroupSourceReq + 4]byte
		s := (*[sizeofGroupSourceReq]byte)(unsafe.Pointer(&gsr))
		copy(d[:4], s[:4])
		copy(d[8:], s[4:])
		b = d[:]
	} else {
		b = (*[sizeofGroupSourceReq]byte)(unsafe.Pointer(&gsr))[:sizeofGroupSourceReq]
	}
	return so.Set(c, b)
}
