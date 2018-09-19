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
// Copyright 2014 Canonical Ltd.
// Licensed under the LGPLv3 with static-linking exception.
// See LICENCE file for details.

package ratelimit

import "io"

type reader struct {
	r      io.Reader
	bucket *Bucket
}

// Reader returns a reader that is rate limited by
// the given token bucket. Each token in the bucket
// represents one byte.
func Reader(r io.Reader, bucket *Bucket) io.Reader {
	return &reader{
		r:      r,
		bucket: bucket,
	}
}

func (r *reader) Read(buf []byte) (int, error) {
	n, err := r.r.Read(buf)
	if n <= 0 {
		return n, err
	}
	r.bucket.Wait(int64(n))
	return n, err
}

type writer struct {
	w      io.Writer
	bucket *Bucket
}

// Writer returns a reader that is rate limited by
// the given token bucket. Each token in the bucket
// represents one byte.
func Writer(w io.Writer, bucket *Bucket) io.Writer {
	return &writer{
		w:      w,
		bucket: bucket,
	}
}

func (w *writer) Write(buf []byte) (int, error) {
	w.bucket.Wait(int64(len(buf)))
	return w.w.Write(buf)
}
