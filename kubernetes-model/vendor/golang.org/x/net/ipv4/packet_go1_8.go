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

// +build !go1.9

package ipv4

import "net"

func (c *packetHandler) readFrom(b []byte) (h *Header, p []byte, cm *ControlMessage, err error) {
	c.rawOpt.RLock()
	oob := NewControlMessage(c.rawOpt.cflags)
	c.rawOpt.RUnlock()
	n, nn, _, src, err := c.ReadMsgIP(b, oob)
	if err != nil {
		return nil, nil, nil, err
	}
	var hs []byte
	if hs, p, err = slicePacket(b[:n]); err != nil {
		return nil, nil, nil, err
	}
	if h, err = ParseHeader(hs); err != nil {
		return nil, nil, nil, err
	}
	if nn > 0 {
		cm = new(ControlMessage)
		if err := cm.Parse(oob[:nn]); err != nil {
			return nil, nil, nil, err
		}
	}
	if src != nil && cm != nil {
		cm.Src = src.IP
	}
	return
}

func (c *packetHandler) writeTo(h *Header, p []byte, cm *ControlMessage) error {
	oob := cm.Marshal()
	wh, err := h.Marshal()
	if err != nil {
		return err
	}
	dst := new(net.IPAddr)
	if cm != nil {
		if ip := cm.Dst.To4(); ip != nil {
			dst.IP = ip
		}
	}
	if dst.IP == nil {
		dst.IP = h.Dst
	}
	wh = append(wh, p...)
	_, _, err = c.WriteMsgIP(wh, oob, dst)
	return err
}
