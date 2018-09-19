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

// +build dragonfly freebsd netbsd

package route

func (w *wireFormat) parseInterfaceAnnounceMessage(_ RIBType, b []byte) (Message, error) {
	if len(b) < w.bodyOff {
		return nil, errMessageTooShort
	}
	l := int(nativeEndian.Uint16(b[:2]))
	if len(b) < l {
		return nil, errInvalidMessage
	}
	m := &InterfaceAnnounceMessage{
		Version: int(b[2]),
		Type:    int(b[3]),
		Index:   int(nativeEndian.Uint16(b[4:6])),
		What:    int(nativeEndian.Uint16(b[22:24])),
		raw:     b[:l],
	}
	for i := 0; i < 16; i++ {
		if b[6+i] != 0 {
			continue
		}
		m.Name = string(b[6 : 6+i])
		break
	}
	return m, nil
}
