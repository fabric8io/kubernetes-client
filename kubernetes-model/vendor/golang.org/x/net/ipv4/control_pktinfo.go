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

// +build darwin linux solaris

package ipv4

import (
	"net"
	"unsafe"

	"golang.org/x/net/internal/iana"
	"golang.org/x/net/internal/socket"
)

func marshalPacketInfo(b []byte, cm *ControlMessage) []byte {
	m := socket.ControlMessage(b)
	m.MarshalHeader(iana.ProtocolIP, sysIP_PKTINFO, sizeofInetPktinfo)
	if cm != nil {
		pi := (*inetPktinfo)(unsafe.Pointer(&m.Data(sizeofInetPktinfo)[0]))
		if ip := cm.Src.To4(); ip != nil {
			copy(pi.Spec_dst[:], ip)
		}
		if cm.IfIndex > 0 {
			pi.setIfindex(cm.IfIndex)
		}
	}
	return m.Next(sizeofInetPktinfo)
}

func parsePacketInfo(cm *ControlMessage, b []byte) {
	pi := (*inetPktinfo)(unsafe.Pointer(&b[0]))
	cm.IfIndex = int(pi.Ifindex)
	if len(cm.Dst) < net.IPv4len {
		cm.Dst = make(net.IP, net.IPv4len)
	}
	copy(cm.Dst, pi.Addr[:])
}
