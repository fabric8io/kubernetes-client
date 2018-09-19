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

package icmp

import (
	"encoding/binary"
	"golang.org/x/net/internal/iana"
)

// A ParamProb represents an ICMP parameter problem message body.
type ParamProb struct {
	Pointer    uintptr     // offset within the data where the error was detected
	Data       []byte      // data, known as original datagram field
	Extensions []Extension // extensions
}

// Len implements the Len method of MessageBody interface.
func (p *ParamProb) Len(proto int) int {
	if p == nil {
		return 0
	}
	l, _ := multipartMessageBodyDataLen(proto, p.Data, p.Extensions)
	return 4 + l
}

// Marshal implements the Marshal method of MessageBody interface.
func (p *ParamProb) Marshal(proto int) ([]byte, error) {
	if proto == iana.ProtocolIPv6ICMP {
		b := make([]byte, p.Len(proto))
		binary.BigEndian.PutUint32(b[:4], uint32(p.Pointer))
		copy(b[4:], p.Data)
		return b, nil
	}
	b, err := marshalMultipartMessageBody(proto, p.Data, p.Extensions)
	if err != nil {
		return nil, err
	}
	b[0] = byte(p.Pointer)
	return b, nil
}

// parseParamProb parses b as an ICMP parameter problem message body.
func parseParamProb(proto int, b []byte) (MessageBody, error) {
	if len(b) < 4 {
		return nil, errMessageTooShort
	}
	p := &ParamProb{}
	if proto == iana.ProtocolIPv6ICMP {
		p.Pointer = uintptr(binary.BigEndian.Uint32(b[:4]))
		p.Data = make([]byte, len(b)-4)
		copy(p.Data, b[4:])
		return p, nil
	}
	p.Pointer = uintptr(b[0])
	var err error
	p.Data, p.Extensions, err = parseMultipartMessageBody(proto, b)
	if err != nil {
		return nil, err
	}
	return p, nil
}
