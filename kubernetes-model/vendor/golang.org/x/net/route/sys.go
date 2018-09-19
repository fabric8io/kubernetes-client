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

import "unsafe"

var (
	nativeEndian binaryByteOrder
	kernelAlign  int
	wireFormats  map[int]*wireFormat
)

func init() {
	i := uint32(1)
	b := (*[4]byte)(unsafe.Pointer(&i))
	if b[0] == 1 {
		nativeEndian = littleEndian
	} else {
		nativeEndian = bigEndian
	}
	kernelAlign, wireFormats = probeRoutingStack()
}

func roundup(l int) int {
	if l == 0 {
		return kernelAlign
	}
	return (l + kernelAlign - 1) & ^(kernelAlign - 1)
}

type wireFormat struct {
	extOff  int // offset of header extension
	bodyOff int // offset of message body
	parse   func(RIBType, []byte) (Message, error)
}
