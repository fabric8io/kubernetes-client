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
package registryclient

import (
	"net/url"
	"testing"
)

func TestBasicCredentials(t *testing.T) {
	creds := NewBasicCredentials()
	creds.Add(&url.URL{Host: "localhost"}, "test", "other")
	if u, p := creds.Basic(&url.URL{Host: "test"}); u != "" || p != "" {
		t.Fatalf("unexpected response: %s %s", u, p)
	}
	if u, p := creds.Basic(&url.URL{Host: "localhost"}); u != "test" || p != "other" {
		t.Fatalf("unexpected response: %s %s", u, p)
	}
	if u, p := creds.Basic(&url.URL{Host: "localhost", Path: "/foo"}); u != "test" || p != "other" {
		t.Fatalf("unexpected response: %s %s", u, p)
	}
}
