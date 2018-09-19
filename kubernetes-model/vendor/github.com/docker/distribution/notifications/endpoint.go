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
package notifications

import (
	"net/http"
	"time"
)

// EndpointConfig covers the optional configuration parameters for an active
// endpoint.
type EndpointConfig struct {
	Headers           http.Header
	Timeout           time.Duration
	Threshold         int
	Backoff           time.Duration
	IgnoredMediaTypes []string
	Transport         *http.Transport `json:"-"`
}

// defaults set any zero-valued fields to a reasonable default.
func (ec *EndpointConfig) defaults() {
	if ec.Timeout <= 0 {
		ec.Timeout = time.Second
	}

	if ec.Threshold <= 0 {
		ec.Threshold = 10
	}

	if ec.Backoff <= 0 {
		ec.Backoff = time.Second
	}

	if ec.Transport == nil {
		ec.Transport = http.DefaultTransport.(*http.Transport)
	}
}

// Endpoint is a reliable, queued, thread-safe sink that notify external http
// services when events are written. Writes are non-blocking and always
// succeed for callers but events may be queued internally.
type Endpoint struct {
	Sink
	url  string
	name string

	EndpointConfig

	metrics *safeMetrics
}

// NewEndpoint returns a running endpoint, ready to receive events.
func NewEndpoint(name, url string, config EndpointConfig) *Endpoint {
	var endpoint Endpoint
	endpoint.name = name
	endpoint.url = url
	endpoint.EndpointConfig = config
	endpoint.defaults()
	endpoint.metrics = newSafeMetrics()

	// Configures the inmemory queue, retry, http pipeline.
	endpoint.Sink = newHTTPSink(
		endpoint.url, endpoint.Timeout, endpoint.Headers,
		endpoint.Transport, endpoint.metrics.httpStatusListener())
	endpoint.Sink = newRetryingSink(endpoint.Sink, endpoint.Threshold, endpoint.Backoff)
	endpoint.Sink = newEventQueue(endpoint.Sink, endpoint.metrics.eventQueueListener())
	endpoint.Sink = newIgnoredMediaTypesSink(endpoint.Sink, config.IgnoredMediaTypes)

	register(&endpoint)
	return &endpoint
}

// Name returns the name of the endpoint, generally used for debugging.
func (e *Endpoint) Name() string {
	return e.name
}

// URL returns the url of the endpoint.
func (e *Endpoint) URL() string {
	return e.url
}

// ReadMetrics populates em with metrics from the endpoint.
func (e *Endpoint) ReadMetrics(em *EndpointMetrics) {
	e.metrics.Lock()
	defer e.metrics.Unlock()

	*em = e.metrics.EndpointMetrics
	// Map still need to copied in a threadsafe manner.
	em.Statuses = make(map[string]int)
	for k, v := range e.metrics.Statuses {
		em.Statuses[k] = v
	}
}
