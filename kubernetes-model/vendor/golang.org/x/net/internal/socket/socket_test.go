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

// +build darwin dragonfly freebsd linux netbsd openbsd solaris windows

package socket_test

import (
	"net"
	"runtime"
	"syscall"
	"testing"

	"golang.org/x/net/internal/nettest"
	"golang.org/x/net/internal/socket"
)

func TestSocket(t *testing.T) {
	t.Run("Option", func(t *testing.T) {
		testSocketOption(t, &socket.Option{Level: syscall.SOL_SOCKET, Name: syscall.SO_RCVBUF, Len: 4})
	})
}

func testSocketOption(t *testing.T, so *socket.Option) {
	c, err := nettest.NewLocalPacketListener("udp")
	if err != nil {
		t.Skipf("not supported on %s/%s: %v", runtime.GOOS, runtime.GOARCH, err)
	}
	defer c.Close()
	cc, err := socket.NewConn(c.(net.Conn))
	if err != nil {
		t.Fatal(err)
	}
	const N = 2048
	if err := so.SetInt(cc, N); err != nil {
		t.Fatal(err)
	}
	n, err := so.GetInt(cc)
	if err != nil {
		t.Fatal(err)
	}
	if n < N {
		t.Fatalf("got %d; want greater than or equal to %d", n, N)
	}
}
