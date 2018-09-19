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
// Copyright 2012 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package icmp

// A MessageBody represents an ICMP message body.
type MessageBody interface {
	// Len returns the length of ICMP message body.
	// Proto must be either the ICMPv4 or ICMPv6 protocol number.
	Len(proto int) int

	// Marshal returns the binary encoding of ICMP message body.
	// Proto must be either the ICMPv4 or ICMPv6 protocol number.
	Marshal(proto int) ([]byte, error)
}

// A DefaultMessageBody represents the default message body.
type DefaultMessageBody struct {
	Data []byte // data
}

// Len implements the Len method of MessageBody interface.
func (p *DefaultMessageBody) Len(proto int) int {
	if p == nil {
		return 0
	}
	return len(p.Data)
}

// Marshal implements the Marshal method of MessageBody interface.
func (p *DefaultMessageBody) Marshal(proto int) ([]byte, error) {
	return p.Data, nil
}

// parseDefaultMessageBody parses b as an ICMP message body.
func parseDefaultMessageBody(proto int, b []byte) (MessageBody, error) {
	p := &DefaultMessageBody{Data: make([]byte, len(b))}
	copy(p.Data, b)
	return p, nil
}
