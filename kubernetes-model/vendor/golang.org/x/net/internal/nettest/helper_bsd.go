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
// Copyright 2016 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// +build darwin dragonfly freebsd netbsd openbsd

package nettest

import (
	"runtime"
	"strconv"
	"strings"
	"syscall"
)

var darwinVersion int

func init() {
	if runtime.GOOS == "darwin" {
		// See http://support.apple.com/kb/HT1633.
		s, err := syscall.Sysctl("kern.osrelease")
		if err != nil {
			return
		}
		ss := strings.Split(s, ".")
		if len(ss) == 0 {
			return
		}
		darwinVersion, _ = strconv.Atoi(ss[0])
	}
}

func supportsIPv6MulticastDeliveryOnLoopback() bool {
	switch runtime.GOOS {
	case "freebsd":
		// See http://www.freebsd.org/cgi/query-pr.cgi?pr=180065.
		// Even after the fix, it looks like the latest
		// kernels don't deliver link-local scoped multicast
		// packets correctly.
		return false
	case "darwin":
		return !causesIPv6Crash()
	default:
		return true
	}
}

func causesIPv6Crash() bool {
	// We see some kernel crash when running IPv6 with IP-level
	// options on Darwin kernel version 12 or below.
	// See golang.org/issues/17015.
	return darwinVersion < 13
}
