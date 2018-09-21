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

// CompressorProvider describes a component that can provider compressors for the std methods.
type CompressorProvider interface {
	// Returns a *gzip.Writer which needs to be released later.
	// Before using it, call Reset().
	AcquireGzipWriter() *gzip.Writer

	// Releases an aqcuired *gzip.Writer.
	ReleaseGzipWriter(w *gzip.Writer)

	// Returns a *gzip.Reader which needs to be released later.
	AcquireGzipReader() *gzip.Reader

	// Releases an aqcuired *gzip.Reader.
	ReleaseGzipReader(w *gzip.Reader)

	// Returns a *zlib.Writer which needs to be released later.
	// Before using it, call Reset().
	AcquireZlibWriter() *zlib.Writer

	// Releases an aqcuired *zlib.Writer.
	ReleaseZlibWriter(w *zlib.Writer)
}

// DefaultCompressorProvider is the actual provider of compressors (zlib or gzip).
var currentCompressorProvider CompressorProvider

func init() {
	currentCompressorProvider = NewSyncPoolCompessors()
}

// CurrentCompressorProvider returns the current CompressorProvider.
// It is initialized using a SyncPoolCompessors.
func CurrentCompressorProvider() CompressorProvider {
	return currentCompressorProvider
}

// CompressorProvider sets the actual provider of compressors (zlib or gzip).
func SetCompressorProvider(p CompressorProvider) {
	if p == nil {
		panic("cannot set compressor provider to nil")
	}
	currentCompressorProvider = p
}
