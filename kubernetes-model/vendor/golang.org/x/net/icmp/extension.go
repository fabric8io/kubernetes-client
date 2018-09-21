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

package icmp

import "encoding/binary"

// An Extension represents an ICMP extension.
type Extension interface {
	// Len returns the length of ICMP extension.
	// Proto must be either the ICMPv4 or ICMPv6 protocol number.
	Len(proto int) int

	// Marshal returns the binary encoding of ICMP extension.
	// Proto must be either the ICMPv4 or ICMPv6 protocol number.
	Marshal(proto int) ([]byte, error)
}

const extensionVersion = 2

func validExtensionHeader(b []byte) bool {
	v := int(b[0]&0xf0) >> 4
	s := binary.BigEndian.Uint16(b[2:4])
	if s != 0 {
		s = checksum(b)
	}
	if v != extensionVersion || s != 0 {
		return false
	}
	return true
}

// parseExtensions parses b as a list of ICMP extensions.
// The length attribute l must be the length attribute field in
// received icmp messages.
//
// It will return a list of ICMP extensions and an adjusted length
// attribute that represents the length of the padded original
// datagram field. Otherwise, it returns an error.
func parseExtensions(b []byte, l int) ([]Extension, int, error) {
	// Still a lot of non-RFC 4884 compliant implementations are
	// out there. Set the length attribute l to 128 when it looks
	// inappropriate for backwards compatibility.
	//
	// A minimal extension at least requires 8 octets; 4 octets
	// for an extension header, and 4 octets for a single object
	// header.
	//
	// See RFC 4884 for further information.
	if 128 > l || l+8 > len(b) {
		l = 128
	}
	if l+8 > len(b) {
		return nil, -1, errNoExtension
	}
	if !validExtensionHeader(b[l:]) {
		if l == 128 {
			return nil, -1, errNoExtension
		}
		l = 128
		if !validExtensionHeader(b[l:]) {
			return nil, -1, errNoExtension
		}
	}
	var exts []Extension
	for b = b[l+4:]; len(b) >= 4; {
		ol := int(binary.BigEndian.Uint16(b[:2]))
		if 4 > ol || ol > len(b) {
			break
		}
		switch b[2] {
		case classMPLSLabelStack:
			ext, err := parseMPLSLabelStack(b[:ol])
			if err != nil {
				return nil, -1, err
			}
			exts = append(exts, ext)
		case classInterfaceInfo:
			ext, err := parseInterfaceInfo(b[:ol])
			if err != nil {
				return nil, -1, err
			}
			exts = append(exts, ext)
		}
		b = b[ol:]
	}
	return exts, l, nil
}
