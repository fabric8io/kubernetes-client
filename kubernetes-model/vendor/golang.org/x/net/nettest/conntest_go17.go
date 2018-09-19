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

// +build go1.7

package nettest

import "testing"

func testConn(t *testing.T, mp MakePipe) {
	// Use subtests on Go 1.7 and above since it is better organized.
	t.Run("BasicIO", func(t *testing.T) { timeoutWrapper(t, mp, testBasicIO) })
	t.Run("PingPong", func(t *testing.T) { timeoutWrapper(t, mp, testPingPong) })
	t.Run("RacyRead", func(t *testing.T) { timeoutWrapper(t, mp, testRacyRead) })
	t.Run("RacyWrite", func(t *testing.T) { timeoutWrapper(t, mp, testRacyWrite) })
	t.Run("ReadTimeout", func(t *testing.T) { timeoutWrapper(t, mp, testReadTimeout) })
	t.Run("WriteTimeout", func(t *testing.T) { timeoutWrapper(t, mp, testWriteTimeout) })
	t.Run("PastTimeout", func(t *testing.T) { timeoutWrapper(t, mp, testPastTimeout) })
	t.Run("PresentTimeout", func(t *testing.T) { timeoutWrapper(t, mp, testPresentTimeout) })
	t.Run("FutureTimeout", func(t *testing.T) { timeoutWrapper(t, mp, testFutureTimeout) })
	t.Run("CloseTimeout", func(t *testing.T) { timeoutWrapper(t, mp, testCloseTimeout) })
	t.Run("ConcurrentMethods", func(t *testing.T) { timeoutWrapper(t, mp, testConcurrentMethods) })
}
