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
package clientcmd

import (
	"net/http"
	"net/http/httptest"
	"testing"
)

func TestIsCertificateAuthorityUnknown(t *testing.T) {
	server := httptest.NewTLSServer(http.HandlerFunc(func(http.ResponseWriter, *http.Request) {}))
	defer server.Close()

	req, _ := http.NewRequest("GET", server.URL, nil)
	_, err := http.DefaultClient.Do(req)
	if err == nil {
		t.Fatalf("Expected TLS error")
	}
	if !IsCertificateAuthorityUnknown(err) {
		t.Fatalf("Expected IsCertificateAuthorityUnknown error, error message was %q", err.Error())
	}
}
