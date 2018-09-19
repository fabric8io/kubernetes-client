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

// +build !go1.7

package nettest

import "testing"

func testConn(t *testing.T, mp MakePipe) {
	// Avoid using subtests on Go 1.6 and below.
	timeoutWrapper(t, mp, testBasicIO)
	timeoutWrapper(t, mp, testPingPong)
	timeoutWrapper(t, mp, testRacyRead)
	timeoutWrapper(t, mp, testRacyWrite)
	timeoutWrapper(t, mp, testReadTimeout)
	timeoutWrapper(t, mp, testWriteTimeout)
	timeoutWrapper(t, mp, testPastTimeout)
	timeoutWrapper(t, mp, testPresentTimeout)
	timeoutWrapper(t, mp, testFutureTimeout)
	timeoutWrapper(t, mp, testCloseTimeout)
	timeoutWrapper(t, mp, testConcurrentMethods)
}
