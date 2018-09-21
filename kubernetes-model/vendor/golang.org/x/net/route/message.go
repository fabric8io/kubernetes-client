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

package route

// A Message represents a routing message.
type Message interface {
	// Sys returns operating system-specific information.
	Sys() []Sys
}

// A Sys reprensents operating system-specific information.
type Sys interface {
	// SysType returns a type of operating system-specific
	// information.
	SysType() SysType
}

// A SysType represents a type of operating system-specific
// information.
type SysType int

const (
	SysMetrics SysType = iota
	SysStats
)

// ParseRIB parses b as a routing information base and returns a list
// of routing messages.
func ParseRIB(typ RIBType, b []byte) ([]Message, error) {
	if !typ.parseable() {
		return nil, errUnsupportedMessage
	}
	var msgs []Message
	nmsgs, nskips := 0, 0
	for len(b) > 4 {
		nmsgs++
		l := int(nativeEndian.Uint16(b[:2]))
		if l == 0 {
			return nil, errInvalidMessage
		}
		if len(b) < l {
			return nil, errMessageTooShort
		}
		if b[2] != sysRTM_VERSION {
			b = b[l:]
			continue
		}
		if w, ok := wireFormats[int(b[3])]; !ok {
			nskips++
		} else {
			m, err := w.parse(typ, b)
			if err != nil {
				return nil, err
			}
			if m == nil {
				nskips++
			} else {
				msgs = append(msgs, m)
			}
		}
		b = b[l:]
	}
	// We failed to parse any of the messages - version mismatch?
	if nmsgs != len(msgs)+nskips {
		return nil, errMessageMismatch
	}
	return msgs, nil
}
