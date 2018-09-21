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
// Copyright 2011 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package proxy

import (
	"errors"
	"net"
	"reflect"
	"testing"
)

type recordingProxy struct {
	addrs []string
}

func (r *recordingProxy) Dial(network, addr string) (net.Conn, error) {
	r.addrs = append(r.addrs, addr)
	return nil, errors.New("recordingProxy")
}

func TestPerHost(t *testing.T) {
	var def, bypass recordingProxy
	perHost := NewPerHost(&def, &bypass)
	perHost.AddFromString("localhost,*.zone,127.0.0.1,10.0.0.1/8,1000::/16")

	expectedDef := []string{
		"example.com:123",
		"1.2.3.4:123",
		"[1001::]:123",
	}
	expectedBypass := []string{
		"localhost:123",
		"zone:123",
		"foo.zone:123",
		"127.0.0.1:123",
		"10.1.2.3:123",
		"[1000::]:123",
	}

	for _, addr := range expectedDef {
		perHost.Dial("tcp", addr)
	}
	for _, addr := range expectedBypass {
		perHost.Dial("tcp", addr)
	}

	if !reflect.DeepEqual(expectedDef, def.addrs) {
		t.Errorf("Hosts which went to the default proxy didn't match. Got %v, want %v", def.addrs, expectedDef)
	}
	if !reflect.DeepEqual(expectedBypass, bypass.addrs) {
		t.Errorf("Hosts which went to the bypass proxy didn't match. Got %v, want %v", bypass.addrs, expectedBypass)
	}
}
