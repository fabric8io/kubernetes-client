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
// Copyright 2017 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// +build go1.9

package http2

import (
	"context"
	"net/http"
	"reflect"
	"testing"
	"time"
)

func TestServerGracefulShutdown(t *testing.T) {
	var st *serverTester
	handlerDone := make(chan struct{})
	st = newServerTester(t, func(w http.ResponseWriter, r *http.Request) {
		defer close(handlerDone)
		go st.ts.Config.Shutdown(context.Background())

		ga := st.wantGoAway()
		if ga.ErrCode != ErrCodeNo {
			t.Errorf("GOAWAY error = %v; want ErrCodeNo", ga.ErrCode)
		}
		if ga.LastStreamID != 1 {
			t.Errorf("GOAWAY LastStreamID = %v; want 1", ga.LastStreamID)
		}

		w.Header().Set("x-foo", "bar")
	})
	defer st.Close()

	st.greet()
	st.bodylessReq1()

	select {
	case <-handlerDone:
	case <-time.After(5 * time.Second):
		t.Fatalf("server did not shutdown?")
	}
	hf := st.wantHeaders()
	goth := st.decodeHeader(hf.HeaderBlockFragment())
	wanth := [][2]string{
		{":status", "200"},
		{"x-foo", "bar"},
		{"content-type", "text/plain; charset=utf-8"},
		{"content-length", "0"},
	}
	if !reflect.DeepEqual(goth, wanth) {
		t.Errorf("Got headers %v; want %v", goth, wanth)
	}

	n, err := st.cc.Read([]byte{0})
	if n != 0 || err == nil {
		t.Errorf("Read = %v, %v; want 0, non-nil", n, err)
	}
}
