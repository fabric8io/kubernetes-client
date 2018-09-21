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

package route

import (
	"testing"
	"unsafe"
)

func TestFetchAndParseRIBOnFreeBSD(t *testing.T) {
	for _, typ := range []RIBType{sysNET_RT_IFMALIST} {
		var lastErr error
		var ms []Message
		for _, af := range []int{sysAF_UNSPEC, sysAF_INET, sysAF_INET6} {
			rs, err := fetchAndParseRIB(af, typ)
			if err != nil {
				lastErr = err
				continue
			}
			ms = append(ms, rs...)
		}
		if len(ms) == 0 && lastErr != nil {
			t.Error(typ, lastErr)
			continue
		}
		ss, err := msgs(ms).validate()
		if err != nil {
			t.Error(typ, err)
			continue
		}
		for _, s := range ss {
			t.Log(s)
		}
	}
}

func TestFetchAndParseRIBOnFreeBSD10AndAbove(t *testing.T) {
	if _, err := FetchRIB(sysAF_UNSPEC, sysNET_RT_IFLISTL, 0); err != nil {
		t.Skip("NET_RT_IFLISTL not supported")
	}
	var p uintptr
	if kernelAlign != int(unsafe.Sizeof(p)) {
		t.Skip("NET_RT_IFLIST vs. NET_RT_IFLISTL doesn't work for 386 emulation on amd64")
	}

	var tests = [2]struct {
		typ  RIBType
		b    []byte
		msgs []Message
		ss   []string
	}{
		{typ: sysNET_RT_IFLIST},
		{typ: sysNET_RT_IFLISTL},
	}
	for i := range tests {
		var lastErr error
		for _, af := range []int{sysAF_UNSPEC, sysAF_INET, sysAF_INET6} {
			rs, err := fetchAndParseRIB(af, tests[i].typ)
			if err != nil {
				lastErr = err
				continue
			}
			tests[i].msgs = append(tests[i].msgs, rs...)
		}
		if len(tests[i].msgs) == 0 && lastErr != nil {
			t.Error(tests[i].typ, lastErr)
			continue
		}
		tests[i].ss, lastErr = msgs(tests[i].msgs).validate()
		if lastErr != nil {
			t.Error(tests[i].typ, lastErr)
			continue
		}
		for _, s := range tests[i].ss {
			t.Log(s)
		}
	}
	for i := len(tests) - 1; i > 0; i-- {
		if len(tests[i].ss) != len(tests[i-1].ss) {
			t.Errorf("got %v; want %v", tests[i].ss, tests[i-1].ss)
			continue
		}
		for j, s1 := range tests[i].ss {
			s0 := tests[i-1].ss[j]
			if s1 != s0 {
				t.Errorf("got %s; want %s", s1, s0)
			}
		}
	}
}
