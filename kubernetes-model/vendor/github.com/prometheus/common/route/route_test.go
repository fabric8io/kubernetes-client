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
package route

import (
	"net/http"
	"net/http/httptest"
	"testing"
)

func TestRedirect(t *testing.T) {
	router := New().WithPrefix("/test/prefix")
	w := httptest.NewRecorder()
	r, err := http.NewRequest("GET", "http://localhost:9090/foo", nil)
	if err != nil {
		t.Fatalf("Error building test request: %s", err)
	}

	router.Redirect(w, r, "/some/endpoint", http.StatusFound)
	if w.Code != http.StatusFound {
		t.Fatalf("Unexpected redirect status code: got %d, want %d", w.Code, http.StatusFound)
	}

	want := "/test/prefix/some/endpoint"
	got := w.Header()["Location"][0]
	if want != got {
		t.Fatalf("Unexpected redirect location: got %s, want %s", got, want)
	}
}

func TestContext(t *testing.T) {
	router := New()
	router.Get("/test/:foo/", func(w http.ResponseWriter, r *http.Request) {
		want := "bar"
		got := Param(r.Context(), "foo")
		if want != got {
			t.Fatalf("Unexpected context value: want %q, got %q", want, got)
		}
	})

	r, err := http.NewRequest("GET", "http://localhost:9090/test/bar/", nil)
	if err != nil {
		t.Fatalf("Error building test request: %s", err)
	}
	router.ServeHTTP(nil, r)
}
