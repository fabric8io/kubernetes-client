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
package storage

import (
	"expvar"
	"sync/atomic"

	"github.com/docker/distribution/registry/storage/cache"
)

type blobStatCollector struct {
	metrics cache.Metrics
}

func (bsc *blobStatCollector) Hit() {
	atomic.AddUint64(&bsc.metrics.Requests, 1)
	atomic.AddUint64(&bsc.metrics.Hits, 1)
}

func (bsc *blobStatCollector) Miss() {
	atomic.AddUint64(&bsc.metrics.Requests, 1)
	atomic.AddUint64(&bsc.metrics.Misses, 1)
}

func (bsc *blobStatCollector) Metrics() cache.Metrics {
	return bsc.metrics
}

// blobStatterCacheMetrics keeps track of cache metrics for blob descriptor
// cache requests. Note this is kept globally and made available via expvar.
// For more detailed metrics, its recommend to instrument a particular cache
// implementation.
var blobStatterCacheMetrics cache.MetricsTracker = &blobStatCollector{}

func init() {
	registry := expvar.Get("registry")
	if registry == nil {
		registry = expvar.NewMap("registry")
	}

	cache := registry.(*expvar.Map).Get("cache")
	if cache == nil {
		cache = &expvar.Map{}
		cache.(*expvar.Map).Init()
		registry.(*expvar.Map).Set("cache", cache)
	}

	storage := cache.(*expvar.Map).Get("storage")
	if storage == nil {
		storage = &expvar.Map{}
		storage.(*expvar.Map).Init()
		cache.(*expvar.Map).Set("storage", storage)
	}

	storage.(*expvar.Map).Set("blobdescriptor", expvar.Func(func() interface{} {
		// no need for synchronous access: the increments are atomic and
		// during reading, we don't care if the data is up to date. The
		// numbers will always *eventually* be reported correctly.
		return blobStatterCacheMetrics
	}))
}
