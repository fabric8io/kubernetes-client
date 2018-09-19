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
// Copyright 2012 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// +build !darwin,!dragonfly,!freebsd,!linux,!netbsd,!openbsd,!solaris,!windows

package ipv4

import (
	"net"

	"golang.org/x/net/bpf"
	"golang.org/x/net/internal/socket"
)

func (so *sockOpt) getMulticastInterface(c *socket.Conn) (*net.Interface, error) {
	return nil, errOpNoSupport
}

func (so *sockOpt) setMulticastInterface(c *socket.Conn, ifi *net.Interface) error {
	return errOpNoSupport
}

func (so *sockOpt) getICMPFilter(c *socket.Conn) (*ICMPFilter, error) {
	return nil, errOpNoSupport
}

func (so *sockOpt) setICMPFilter(c *socket.Conn, f *ICMPFilter) error {
	return errOpNoSupport
}

func (so *sockOpt) setGroup(c *socket.Conn, ifi *net.Interface, grp net.IP) error {
	return errOpNoSupport
}

func (so *sockOpt) setSourceGroup(c *socket.Conn, ifi *net.Interface, grp, src net.IP) error {
	return errOpNoSupport
}

func (so *sockOpt) setBPF(c *socket.Conn, f []bpf.RawInstruction) error {
	return errOpNoSupport
}
