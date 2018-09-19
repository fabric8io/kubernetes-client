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

package icmp_test

import (
	"log"
	"net"
	"os"
	"runtime"

	"golang.org/x/net/icmp"
	"golang.org/x/net/ipv6"
)

func ExamplePacketConn_nonPrivilegedPing() {
	switch runtime.GOOS {
	case "darwin":
	case "linux":
		log.Println("you may need to adjust the net.ipv4.ping_group_range kernel state")
	default:
		log.Println("not supported on", runtime.GOOS)
		return
	}

	c, err := icmp.ListenPacket("udp6", "fe80::1%en0")
	if err != nil {
		log.Fatal(err)
	}
	defer c.Close()

	wm := icmp.Message{
		Type: ipv6.ICMPTypeEchoRequest, Code: 0,
		Body: &icmp.Echo{
			ID: os.Getpid() & 0xffff, Seq: 1,
			Data: []byte("HELLO-R-U-THERE"),
		},
	}
	wb, err := wm.Marshal(nil)
	if err != nil {
		log.Fatal(err)
	}
	if _, err := c.WriteTo(wb, &net.UDPAddr{IP: net.ParseIP("ff02::1"), Zone: "en0"}); err != nil {
		log.Fatal(err)
	}

	rb := make([]byte, 1500)
	n, peer, err := c.ReadFrom(rb)
	if err != nil {
		log.Fatal(err)
	}
	rm, err := icmp.ParseMessage(58, rb[:n])
	if err != nil {
		log.Fatal(err)
	}
	switch rm.Type {
	case ipv6.ICMPTypeEchoReply:
		log.Printf("got reflection from %v", peer)
	default:
		log.Printf("got %+v; want echo reply", rm)
	}
}
