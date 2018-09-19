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
// Copyright 2015 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// +build !go1.7

package ctxhttp // import "golang.org/x/net/context/ctxhttp"

import (
	"io"
	"net/http"
	"net/url"
	"strings"

	"golang.org/x/net/context"
)

func nop() {}

var (
	testHookContextDoneBeforeHeaders = nop
	testHookDoReturned               = nop
	testHookDidBodyClose             = nop
)

// Do sends an HTTP request with the provided http.Client and returns an HTTP response.
// If the client is nil, http.DefaultClient is used.
// If the context is canceled or times out, ctx.Err() will be returned.
func Do(ctx context.Context, client *http.Client, req *http.Request) (*http.Response, error) {
	if client == nil {
		client = http.DefaultClient
	}

	// TODO(djd): Respect any existing value of req.Cancel.
	cancel := make(chan struct{})
	req.Cancel = cancel

	type responseAndError struct {
		resp *http.Response
		err  error
	}
	result := make(chan responseAndError, 1)

	// Make local copies of test hooks closed over by goroutines below.
	// Prevents data races in tests.
	testHookDoReturned := testHookDoReturned
	testHookDidBodyClose := testHookDidBodyClose

	go func() {
		resp, err := client.Do(req)
		testHookDoReturned()
		result <- responseAndError{resp, err}
	}()

	var resp *http.Response

	select {
	case <-ctx.Done():
		testHookContextDoneBeforeHeaders()
		close(cancel)
		// Clean up after the goroutine calling client.Do:
		go func() {
			if r := <-result; r.resp != nil {
				testHookDidBodyClose()
				r.resp.Body.Close()
			}
		}()
		return nil, ctx.Err()
	case r := <-result:
		var err error
		resp, err = r.resp, r.err
		if err != nil {
			return resp, err
		}
	}

	c := make(chan struct{})
	go func() {
		select {
		case <-ctx.Done():
			close(cancel)
		case <-c:
			// The response's Body is closed.
		}
	}()
	resp.Body = &notifyingReader{resp.Body, c}

	return resp, nil
}

// Get issues a GET request via the Do function.
func Get(ctx context.Context, client *http.Client, url string) (*http.Response, error) {
	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return nil, err
	}
	return Do(ctx, client, req)
}

// Head issues a HEAD request via the Do function.
func Head(ctx context.Context, client *http.Client, url string) (*http.Response, error) {
	req, err := http.NewRequest("HEAD", url, nil)
	if err != nil {
		return nil, err
	}
	return Do(ctx, client, req)
}

// Post issues a POST request via the Do function.
func Post(ctx context.Context, client *http.Client, url string, bodyType string, body io.Reader) (*http.Response, error) {
	req, err := http.NewRequest("POST", url, body)
	if err != nil {
		return nil, err
	}
	req.Header.Set("Content-Type", bodyType)
	return Do(ctx, client, req)
}

// PostForm issues a POST request via the Do function.
func PostForm(ctx context.Context, client *http.Client, url string, data url.Values) (*http.Response, error) {
	return Post(ctx, client, url, "application/x-www-form-urlencoded", strings.NewReader(data.Encode()))
}

// notifyingReader is an io.ReadCloser that closes the notify channel after
// Close is called or a Read fails on the underlying ReadCloser.
type notifyingReader struct {
	io.ReadCloser
	notify chan<- struct{}
}

func (r *notifyingReader) Read(p []byte) (int, error) {
	n, err := r.ReadCloser.Read(p)
	if err != nil && r.notify != nil {
		close(r.notify)
		r.notify = nil
	}
	return n, err
}

func (r *notifyingReader) Close() error {
	err := r.ReadCloser.Close()
	if r.notify != nil {
		close(r.notify)
		r.notify = nil
	}
	return err
}
