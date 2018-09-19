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

// +build nacl plan9

package icmp

// ListenPacket listens for incoming ICMP packets addressed to
// address. See net.Dial for the syntax of address.
//
// For non-privileged datagram-oriented ICMP endpoints, network must
// be "udp4" or "udp6". The endpoint allows to read, write a few
// limited ICMP messages such as echo request and echo reply.
// Currently only Darwin and Linux support this.
//
// Examples:
//	ListenPacket("udp4", "192.168.0.1")
//	ListenPacket("udp4", "0.0.0.0")
//	ListenPacket("udp6", "fe80::1%en0")
//	ListenPacket("udp6", "::")
//
// For privileged raw ICMP endpoints, network must be "ip4" or "ip6"
// followed by a colon and an ICMP protocol number or name.
//
// Examples:
//	ListenPacket("ip4:icmp", "192.168.0.1")
//	ListenPacket("ip4:1", "0.0.0.0")
//	ListenPacket("ip6:ipv6-icmp", "fe80::1%en0")
//	ListenPacket("ip6:58", "::")
func ListenPacket(network, address string) (*PacketConn, error) {
	return nil, errOpNoSupport
}
