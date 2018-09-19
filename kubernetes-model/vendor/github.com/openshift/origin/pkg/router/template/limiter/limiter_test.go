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
package limiter

import (
	"fmt"
	"sync"
	"testing"
	"time"
)

type handler struct {
	count int
	sync.Mutex
}

func (h *handler) handle() error {
	h.Lock()
	defer h.Unlock()
	h.count += 1
	return nil
}

func (h *handler) counter() int {
	h.Lock()
	defer h.Unlock()
	return h.count
}

func TestCoalescingSerializingRateLimiter(t *testing.T) {

	fmt.Println("start")

	tests := []struct {
		Name     string
		Interval time.Duration
		Times    int
	}{
		{
			Name:     "3PO",
			Interval: 3 * time.Second,
			Times:    10,
		},
		{
			Name:     "five-fer",
			Interval: 5 * time.Second,
			Times:    20,
		},
		{
			Name:     "longjob",
			Interval: 2 * time.Second,
			Times:    20,
		},
	}

	for _, tc := range tests {
		h := &handler{}
		rlf := NewCoalescingSerializingRateLimiter(tc.Interval, h.handle)

		for i := 0; i < tc.Times; i++ {
			fmt.Println("start")
			rlf.RegisterChange()
			fmt.Println("end")
		}

		select {
		case <-time.After(tc.Interval + 2*time.Second):
			fmt.Println("after")

			counter := h.counter()
			if tc.Interval > 0 && counter >= tc.Times/2 {
				t.Errorf("For coalesced calls, expected number of invocations to be at least half. Expected: < %v  Got: %v",
					tc.Times/2, counter)
			}
		}
	}
}
