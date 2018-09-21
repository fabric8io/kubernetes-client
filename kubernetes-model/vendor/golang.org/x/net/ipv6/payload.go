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

package ipv6

import (
	"net"

	"golang.org/x/net/internal/socket"
)

// BUG(mikio): On Windows, the ControlMessage for ReadFrom and WriteTo
// methods of PacketConn is not implemented.

// A payloadHandler represents the IPv6 datagram payload handler.
type payloadHandler struct {
	net.PacketConn
	*socket.Conn
	rawOpt
}

func (c *payloadHandler) ok() bool { return c != nil && c.PacketConn != nil && c.Conn != nil }
