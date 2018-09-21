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
package restful

// Copyright 2015 Ernest Micklei. All rights reserved.
// Use of this source code is governed by a license
// that can be found in the LICENSE file.

import (
	"compress/gzip"
	"compress/zlib"
)

// BoundedCachedCompressors is a CompressorProvider that uses a cache with a fixed amount
// of writers and readers (resources).
// If a new resource is acquired and all are in use, it will return a new unmanaged resource.
type BoundedCachedCompressors struct {
	gzipWriters     chan *gzip.Writer
	gzipReaders     chan *gzip.Reader
	zlibWriters     chan *zlib.Writer
	writersCapacity int
	readersCapacity int
}

// NewBoundedCachedCompressors returns a new, with filled cache,  BoundedCachedCompressors.
func NewBoundedCachedCompressors(writersCapacity, readersCapacity int) *BoundedCachedCompressors {
	b := &BoundedCachedCompressors{
		gzipWriters:     make(chan *gzip.Writer, writersCapacity),
		gzipReaders:     make(chan *gzip.Reader, readersCapacity),
		zlibWriters:     make(chan *zlib.Writer, writersCapacity),
		writersCapacity: writersCapacity,
		readersCapacity: readersCapacity,
	}
	for ix := 0; ix < writersCapacity; ix++ {
		b.gzipWriters <- newGzipWriter()
		b.zlibWriters <- newZlibWriter()
	}
	for ix := 0; ix < readersCapacity; ix++ {
		b.gzipReaders <- newGzipReader()
	}
	return b
}

// AcquireGzipWriter returns an resettable *gzip.Writer. Needs to be released.
func (b *BoundedCachedCompressors) AcquireGzipWriter() *gzip.Writer {
	var writer *gzip.Writer
	select {
	case writer, _ = <-b.gzipWriters:
	default:
		// return a new unmanaged one
		writer = newGzipWriter()
	}
	return writer
}

// ReleaseGzipWriter accepts a writer (does not have to be one that was cached)
// only when the cache has room for it. It will ignore it otherwise.
func (b *BoundedCachedCompressors) ReleaseGzipWriter(w *gzip.Writer) {
	// forget the unmanaged ones
	if len(b.gzipWriters) < b.writersCapacity {
		b.gzipWriters <- w
	}
}

// AcquireGzipReader returns a *gzip.Reader. Needs to be released.
func (b *BoundedCachedCompressors) AcquireGzipReader() *gzip.Reader {
	var reader *gzip.Reader
	select {
	case reader, _ = <-b.gzipReaders:
	default:
		// return a new unmanaged one
		reader = newGzipReader()
	}
	return reader
}

// ReleaseGzipReader accepts a reader (does not have to be one that was cached)
// only when the cache has room for it. It will ignore it otherwise.
func (b *BoundedCachedCompressors) ReleaseGzipReader(r *gzip.Reader) {
	// forget the unmanaged ones
	if len(b.gzipReaders) < b.readersCapacity {
		b.gzipReaders <- r
	}
}

// AcquireZlibWriter returns an resettable *zlib.Writer. Needs to be released.
func (b *BoundedCachedCompressors) AcquireZlibWriter() *zlib.Writer {
	var writer *zlib.Writer
	select {
	case writer, _ = <-b.zlibWriters:
	default:
		// return a new unmanaged one
		writer = newZlibWriter()
	}
	return writer
}

// ReleaseZlibWriter accepts a writer (does not have to be one that was cached)
// only when the cache has room for it. It will ignore it otherwise.
func (b *BoundedCachedCompressors) ReleaseZlibWriter(w *zlib.Writer) {
	// forget the unmanaged ones
	if len(b.zlibWriters) < b.writersCapacity {
		b.zlibWriters <- w
	}
}
