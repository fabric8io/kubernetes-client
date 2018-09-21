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
// Copyright 2013 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// +build !go1.9
// +build !nacl,!plan9,!windows

package ipv6

import "net"

func (c *payloadHandler) readFrom(b []byte) (n int, cm *ControlMessage, src net.Addr, err error) {
	c.rawOpt.RLock()
	oob := NewControlMessage(c.rawOpt.cflags)
	c.rawOpt.RUnlock()
	var nn int
	switch c := c.PacketConn.(type) {
	case *net.UDPConn:
		if n, nn, _, src, err = c.ReadMsgUDP(b, oob); err != nil {
			return 0, nil, nil, err
		}
	case *net.IPConn:
		if n, nn, _, src, err = c.ReadMsgIP(b, oob); err != nil {
			return 0, nil, nil, err
		}
	default:
		return 0, nil, nil, &net.OpError{Op: "read", Net: c.LocalAddr().Network(), Source: c.LocalAddr(), Err: errInvalidConnType}
	}
	if nn > 0 {
		cm = new(ControlMessage)
		if err = cm.Parse(oob[:nn]); err != nil {
			return 0, nil, nil, &net.OpError{Op: "read", Net: c.PacketConn.LocalAddr().Network(), Source: c.PacketConn.LocalAddr(), Err: err}
		}
	}
	if cm != nil {
		cm.Src = netAddrToIP16(src)
	}
	return
}

func (c *payloadHandler) writeTo(b []byte, cm *ControlMessage, dst net.Addr) (n int, err error) {
	oob := cm.Marshal()
	if dst == nil {
		return 0, &net.OpError{Op: "write", Net: c.PacketConn.LocalAddr().Network(), Source: c.PacketConn.LocalAddr(), Err: errMissingAddress}
	}
	switch c := c.PacketConn.(type) {
	case *net.UDPConn:
		n, _, err = c.WriteMsgUDP(b, oob, dst.(*net.UDPAddr))
	case *net.IPConn:
		n, _, err = c.WriteMsgIP(b, oob, dst.(*net.IPAddr))
	default:
		return 0, &net.OpError{Op: "write", Net: c.LocalAddr().Network(), Source: c.LocalAddr(), Addr: opAddr(dst), Err: errInvalidConnType}
	}
	return
}
