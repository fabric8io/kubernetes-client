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

// +build !linux,!netbsd

package socket

import "net"

type mmsghdr struct{}

type mmsghdrs []mmsghdr

func (hs mmsghdrs) pack(ms []Message, parseFn func([]byte, string) (net.Addr, error), marshalFn func(net.Addr) []byte) error {
	return nil
}

func (hs mmsghdrs) unpack(ms []Message, parseFn func([]byte, string) (net.Addr, error), hint string) error {
	return nil
}
