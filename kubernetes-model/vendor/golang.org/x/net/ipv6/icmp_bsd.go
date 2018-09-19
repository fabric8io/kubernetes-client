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

// +build darwin dragonfly freebsd netbsd openbsd

package ipv6

func (f *icmpv6Filter) accept(typ ICMPType) {
	f.Filt[typ>>5] |= 1 << (uint32(typ) & 31)
}

func (f *icmpv6Filter) block(typ ICMPType) {
	f.Filt[typ>>5] &^= 1 << (uint32(typ) & 31)
}

func (f *icmpv6Filter) setAll(block bool) {
	for i := range f.Filt {
		if block {
			f.Filt[i] = 0
		} else {
			f.Filt[i] = 1<<32 - 1
		}
	}
}

func (f *icmpv6Filter) willBlock(typ ICMPType) bool {
	return f.Filt[typ>>5]&(1<<(uint32(typ)&31)) == 0
}
