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

// +build darwin dragonfly freebsd linux netbsd openbsd solaris

package ipv6

import "golang.org/x/net/internal/socket"

func setControlMessage(c *socket.Conn, opt *rawOpt, cf ControlFlags, on bool) error {
	opt.Lock()
	defer opt.Unlock()
	if so, ok := sockOpts[ssoReceiveTrafficClass]; ok && cf&FlagTrafficClass != 0 {
		if err := so.SetInt(c, boolint(on)); err != nil {
			return err
		}
		if on {
			opt.set(FlagTrafficClass)
		} else {
			opt.clear(FlagTrafficClass)
		}
	}
	if so, ok := sockOpts[ssoReceiveHopLimit]; ok && cf&FlagHopLimit != 0 {
		if err := so.SetInt(c, boolint(on)); err != nil {
			return err
		}
		if on {
			opt.set(FlagHopLimit)
		} else {
			opt.clear(FlagHopLimit)
		}
	}
	if so, ok := sockOpts[ssoReceivePacketInfo]; ok && cf&flagPacketInfo != 0 {
		if err := so.SetInt(c, boolint(on)); err != nil {
			return err
		}
		if on {
			opt.set(cf & flagPacketInfo)
		} else {
			opt.clear(cf & flagPacketInfo)
		}
	}
	if so, ok := sockOpts[ssoReceivePathMTU]; ok && cf&FlagPathMTU != 0 {
		if err := so.SetInt(c, boolint(on)); err != nil {
			return err
		}
		if on {
			opt.set(FlagPathMTU)
		} else {
			opt.clear(FlagPathMTU)
		}
	}
	return nil
}
