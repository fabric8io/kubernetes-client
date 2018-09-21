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

package ipv4

import "golang.org/x/net/internal/socket"

// Sticky socket options
const (
	ssoTOS                = iota // header field for unicast packet
	ssoTTL                       // header field for unicast packet
	ssoMulticastTTL              // header field for multicast packet
	ssoMulticastInterface        // outbound interface for multicast packet
	ssoMulticastLoopback         // loopback for multicast packet
	ssoReceiveTTL                // header field on received packet
	ssoReceiveDst                // header field on received packet
	ssoReceiveInterface          // inbound interface on received packet
	ssoPacketInfo                // incbound or outbound packet path
	ssoHeaderPrepend             // ipv4 header prepend
	ssoStripHeader               // strip ipv4 header
	ssoICMPFilter                // icmp filter
	ssoJoinGroup                 // any-source multicast
	ssoLeaveGroup                // any-source multicast
	ssoJoinSourceGroup           // source-specific multicast
	ssoLeaveSourceGroup          // source-specific multicast
	ssoBlockSourceGroup          // any-source or source-specific multicast
	ssoUnblockSourceGroup        // any-source or source-specific multicast
	ssoAttachFilter              // attach BPF for filtering inbound traffic
)

// Sticky socket option value types
const (
	ssoTypeIPMreq = iota + 1
	ssoTypeIPMreqn
	ssoTypeGroupReq
	ssoTypeGroupSourceReq
)

// A sockOpt represents a binding for sticky socket option.
type sockOpt struct {
	socket.Option
	typ int // hint for option value type; optional
}
