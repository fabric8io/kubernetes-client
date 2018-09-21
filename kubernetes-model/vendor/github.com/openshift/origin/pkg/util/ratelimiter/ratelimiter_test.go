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
package ratelimiter

import (
	"sync"
	"testing"
	"time"
)

type handler struct {
	_counter int
	sync.Mutex
}

func (h *handler) handle() error {
	h.Lock()
	defer h.Unlock()
	h._counter += 1
	return nil
}

func (h *handler) counter() int {
	h.Lock()
	defer h.Unlock()
	return h._counter
}

func TestRateLimitedFunction(t *testing.T) {
	tests := []struct {
		Name     string
		Interval int
		Times    int
	}{
		{
			Name:     "unrated",
			Interval: 0,
			Times:    5,
		},
		{
			Name:     "3PO",
			Interval: 3,
			Times:    10,
		},
		{
			Name:     "five-fer",
			Interval: 5,
			Times:    20,
		},
	}

	keyFunc := func(_ interface{}) (string, error) {
		return "ratelimitertest", nil
	}

	for _, tc := range tests {
		h := &handler{}
		quit := make(chan struct{})
		rlf := NewRateLimitedFunction(keyFunc, tc.Interval, h.handle)
		rlf.RunUntil(quit)

		for i := 0; i < tc.Times; i++ {
			go func(rlf *RateLimitedFunction, idx, interval int) {
				if interval > 0 {
					rlf.Invoke(rlf)
				} else {
					rlf.Invoke(idx)
				}
			}(rlf, i, tc.Interval)
		}

		select {
		case <-time.After(time.Duration(tc.Interval+2) * time.Second):
			close(quit)
			counter := h.counter()
			if tc.Interval > 0 && counter >= tc.Times/2 {
				t.Errorf("For coalesced calls, expected number of invocations to be atleast half. Expected: < %v  Got: %v",
					tc.Times/2, counter)
			}
		}
	}
}
