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

package catmsg

// This file implements varint encoding analogous to the one in encoding/binary.
// We need a string version of this function, so we add that here and then add
// the rest for consistency.

import "errors"

var (
	errIllegalVarint  = errors.New("catmsg: illegal varint")
	errVarintTooLarge = errors.New("catmsg: varint too large for uint64")
)

const maxVarintBytes = 10 // maximum length of a varint

// encodeUint encodes x as a variable-sized integer into buf and returns the
// number of bytes written. buf must be at least maxVarintBytes long
func encodeUint(buf []byte, x uint64) (n int) {
	for ; x > 127; n++ {
		buf[n] = 0x80 | uint8(x&0x7F)
		x >>= 7
	}
	buf[n] = uint8(x)
	n++
	return n
}

func decodeUintString(s string) (x uint64, size int, err error) {
	i := 0
	for shift := uint(0); shift < 64; shift += 7 {
		if i >= len(s) {
			return 0, i, errIllegalVarint
		}
		b := uint64(s[i])
		i++
		x |= (b & 0x7F) << shift
		if b&0x80 == 0 {
			return x, i, nil
		}
	}
	return 0, i, errVarintTooLarge
}

func decodeUint(b []byte) (x uint64, size int, err error) {
	i := 0
	for shift := uint(0); shift < 64; shift += 7 {
		if i >= len(b) {
			return 0, i, errIllegalVarint
		}
		c := uint64(b[i])
		i++
		x |= (c & 0x7F) << shift
		if c&0x80 == 0 {
			return x, i, nil
		}
	}
	return 0, i, errVarintTooLarge
}
