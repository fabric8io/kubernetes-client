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

package nettest

import (
	"fmt"
	"runtime"
	"syscall"
)

func maxOpenFiles() int {
	return 4 * defaultMaxOpenFiles /* actually it's 16581375 */
}

func supportsRawIPSocket() (string, bool) {
	// From http://msdn.microsoft.com/en-us/library/windows/desktop/ms740548.aspx:
	// Note: To use a socket of type SOCK_RAW requires administrative privileges.
	// Users running Winsock applications that use raw sockets must be a member of
	// the Administrators group on the local computer, otherwise raw socket calls
	// will fail with an error code of WSAEACCES. On Windows Vista and later, access
	// for raw sockets is enforced at socket creation. In earlier versions of Windows,
	// access for raw sockets is enforced during other socket operations.
	s, err := syscall.Socket(syscall.AF_INET, syscall.SOCK_RAW, 0)
	if err == syscall.WSAEACCES {
		return fmt.Sprintf("no access to raw socket allowed on %s", runtime.GOOS), false
	}
	if err != nil {
		return err.Error(), false
	}
	syscall.Closesocket(s)
	return "", true
}

func supportsIPv6MulticastDeliveryOnLoopback() bool {
	return true
}

func causesIPv6Crash() bool {
	return false
}
