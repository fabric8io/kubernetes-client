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

package icmp

import (
	"net"

	"golang.org/x/net/internal/iana"
)

const ipv6PseudoHeaderLen = 2*net.IPv6len + 8

// IPv6PseudoHeader returns an IPv6 pseudo header for checksum
// calculation.
func IPv6PseudoHeader(src, dst net.IP) []byte {
	b := make([]byte, ipv6PseudoHeaderLen)
	copy(b, src.To16())
	copy(b[net.IPv6len:], dst.To16())
	b[len(b)-1] = byte(iana.ProtocolIPv6ICMP)
	return b
}
