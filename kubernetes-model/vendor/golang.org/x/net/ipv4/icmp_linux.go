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

package ipv4

func (f *icmpFilter) accept(typ ICMPType) {
	f.Data &^= 1 << (uint32(typ) & 31)
}

func (f *icmpFilter) block(typ ICMPType) {
	f.Data |= 1 << (uint32(typ) & 31)
}

func (f *icmpFilter) setAll(block bool) {
	if block {
		f.Data = 1<<32 - 1
	} else {
		f.Data = 0
	}
}

func (f *icmpFilter) willBlock(typ ICMPType) bool {
	return f.Data&(1<<(uint32(typ)&31)) != 0
}
