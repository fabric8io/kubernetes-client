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
	utilruntime "k8s.io/apimachinery/pkg/util/runtime"
	utilwait "k8s.io/apimachinery/pkg/util/wait"
	kcache "k8s.io/client-go/tools/cache"
	"k8s.io/client-go/util/flowcontrol"
)

// HandlerFunc defines function signature for a RateLimitedFunction.
type HandlerFunc func() error

// RateLimitedFunction is a rate limited function controlling how often the function/handler is invoked.
type RateLimitedFunction struct {
	// Handler is the function to rate limit calls to.
	Handler HandlerFunc

	// Internal queue of requests to be processed.
	queue kcache.Queue

	// Rate limiting configuration.
	flowcontrol.RateLimiter
}

// NewRateLimitedFunction creates a new rate limited function.
func NewRateLimitedFunction(keyFunc kcache.KeyFunc, interval int, handlerFunc HandlerFunc) *RateLimitedFunction {
	fifo := kcache.NewFIFO(keyFunc)

	qps := float32(1000.0) // Call rate per second (SLA).
	if interval > 0 {
		qps = float32(1.0 / float32(interval))
	}

	limiter := flowcontrol.NewTokenBucketRateLimiter(qps, 1)

	return &RateLimitedFunction{handlerFunc, fifo, limiter}
}

// RunUntil begins processes the resources from queue asynchronously until
// stopCh is closed.
func (rlf *RateLimitedFunction) RunUntil(stopCh <-chan struct{}) {
	go utilwait.Until(rlf.pop, 0, stopCh)
}

// handleOne processes a request in the queue invoking the rate limited
// function.
func (rlf *RateLimitedFunction) pop() {
	rlf.RateLimiter.Accept()
	if _, err := rlf.queue.Pop(func(_ interface{}) error {
		return rlf.Handler()
	}); err != nil {
		utilruntime.HandleError(err)
	}
}

// Invoke adds a request if its not already present and returns immediately
// unless the rate limited function is actually running, in which case it will
// block until the current run completes
func (rlf *RateLimitedFunction) Invoke(resource interface{}) {
	rlf.queue.AddIfNotPresent(resource)
}
