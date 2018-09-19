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

// +build go1.9
// +build darwin dragonfly freebsd linux netbsd openbsd solaris windows

package socket

import (
	"os"
	"syscall"
)

func (c *Conn) recvMsg(m *Message, flags int) error {
	var h msghdr
	vs := make([]iovec, len(m.Buffers))
	var sa []byte
	if c.network != "tcp" {
		sa = make([]byte, sizeofSockaddrInet6)
	}
	h.pack(vs, m.Buffers, m.OOB, sa)
	var operr error
	var n int
	fn := func(s uintptr) bool {
		n, operr = recvmsg(s, &h, flags)
		if operr == syscall.EAGAIN {
			return false
		}
		return true
	}
	if err := c.c.Read(fn); err != nil {
		return err
	}
	if operr != nil {
		return os.NewSyscallError("recvmsg", operr)
	}
	if c.network != "tcp" {
		var err error
		m.Addr, err = parseInetAddr(sa[:], c.network)
		if err != nil {
			return err
		}
	}
	m.N = n
	m.NN = h.controllen()
	m.Flags = h.flags()
	return nil
}

func (c *Conn) sendMsg(m *Message, flags int) error {
	var h msghdr
	vs := make([]iovec, len(m.Buffers))
	var sa []byte
	if m.Addr != nil {
		sa = marshalInetAddr(m.Addr)
	}
	h.pack(vs, m.Buffers, m.OOB, sa)
	var operr error
	var n int
	fn := func(s uintptr) bool {
		n, operr = sendmsg(s, &h, flags)
		if operr == syscall.EAGAIN {
			return false
		}
		return true
	}
	if err := c.c.Write(fn); err != nil {
		return err
	}
	if operr != nil {
		return os.NewSyscallError("sendmsg", operr)
	}
	m.N = n
	m.NN = len(m.OOB)
	return nil
}
