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
// Copyright 2014 Google Inc.  All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package uuid

import (
	"flag"
	"runtime"
	"testing"
	"time"
)

// This test is only run when --regressions is passed on the go test line.
var regressions = flag.Bool("regressions", false, "run uuid regression tests")

// TestClockSeqRace tests for a particular race condition of returning two
// identical Version1 UUIDs.  The duration of 1 minute was chosen as the race
// condition, before being fixed, nearly always occured in under 30 seconds.
func TestClockSeqRace(t *testing.T) {
	if !*regressions {
		t.Skip("skipping regression tests")
	}
	duration := time.Minute

	done := make(chan struct{})
	defer close(done)

	ch := make(chan UUID, 10000)
	ncpu := runtime.NumCPU()
	switch ncpu {
	case 0, 1:
		// We can't run the test effectively.
		t.Skip("skipping race test, only one CPU detected")
		return
	default:
		runtime.GOMAXPROCS(ncpu)
	}
	for i := 0; i < ncpu; i++ {
		go func() {
			for {
				select {
				case <-done:
					return
				case ch <- NewUUID():
				}
			}
		}()
	}

	uuids := make(map[string]bool)
	cnt := 0
	start := time.Now()
	for u := range ch {
		s := u.String()
		if uuids[s] {
			t.Errorf("duplicate uuid after %d in %v: %s", cnt, time.Since(start), s)
			return
		}
		uuids[s] = true
		if time.Since(start) > duration {
			return
		}
		cnt++
	}
}
