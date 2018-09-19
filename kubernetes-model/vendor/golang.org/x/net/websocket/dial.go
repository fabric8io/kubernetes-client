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
// Copyright 2015 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package websocket

import (
	"crypto/tls"
	"net"
)

func dialWithDialer(dialer *net.Dialer, config *Config) (conn net.Conn, err error) {
	switch config.Location.Scheme {
	case "ws":
		conn, err = dialer.Dial("tcp", parseAuthority(config.Location))

	case "wss":
		conn, err = tls.DialWithDialer(dialer, "tcp", parseAuthority(config.Location), config.TlsConfig)

	default:
		err = ErrBadScheme
	}
	return
}
