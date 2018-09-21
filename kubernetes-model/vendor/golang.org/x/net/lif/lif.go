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

// +build solaris

// Package lif provides basic functions for the manipulation of
// logical network interfaces and interface addresses on Solaris.
//
// The package supports Solaris 11 or above.
package lif

import "syscall"

type endpoint struct {
	af int
	s  uintptr
}

func (ep *endpoint) close() error {
	return syscall.Close(int(ep.s))
}

func newEndpoints(af int) ([]endpoint, error) {
	var lastErr error
	var eps []endpoint
	afs := []int{sysAF_INET, sysAF_INET6}
	if af != sysAF_UNSPEC {
		afs = []int{af}
	}
	for _, af := range afs {
		s, err := syscall.Socket(af, sysSOCK_DGRAM, 0)
		if err != nil {
			lastErr = err
			continue
		}
		eps = append(eps, endpoint{af: af, s: uintptr(s)})
	}
	if len(eps) == 0 {
		return nil, lastErr
	}
	return eps, nil
}
