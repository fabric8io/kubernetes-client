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
package api

import (
	"net/http"
	"net/http/httptest"
	"testing"

	"github.com/docker/distribution/health"
)

// TestGETDownHandlerDoesNotChangeStatus ensures that calling the endpoint
// /debug/health/down with METHOD GET returns a 404
func TestGETDownHandlerDoesNotChangeStatus(t *testing.T) {
	recorder := httptest.NewRecorder()

	req, err := http.NewRequest("GET", "https://fakeurl.com/debug/health/down", nil)
	if err != nil {
		t.Errorf("Failed to create request.")
	}

	DownHandler(recorder, req)

	if recorder.Code != 404 {
		t.Errorf("Did not get a 404.")
	}
}

// TestGETUpHandlerDoesNotChangeStatus ensures that calling the endpoint
// /debug/health/down with METHOD GET returns a 404
func TestGETUpHandlerDoesNotChangeStatus(t *testing.T) {
	recorder := httptest.NewRecorder()

	req, err := http.NewRequest("GET", "https://fakeurl.com/debug/health/up", nil)
	if err != nil {
		t.Errorf("Failed to create request.")
	}

	DownHandler(recorder, req)

	if recorder.Code != 404 {
		t.Errorf("Did not get a 404.")
	}
}

// TestPOSTDownHandlerChangeStatus ensures the endpoint /debug/health/down changes
// the status code of the response to 503
// This test is order dependent, and should come before TestPOSTUpHandlerChangeStatus
func TestPOSTDownHandlerChangeStatus(t *testing.T) {
	recorder := httptest.NewRecorder()

	req, err := http.NewRequest("POST", "https://fakeurl.com/debug/health/down", nil)
	if err != nil {
		t.Errorf("Failed to create request.")
	}

	DownHandler(recorder, req)

	if recorder.Code != 200 {
		t.Errorf("Did not get a 200.")
	}

	if len(health.CheckStatus()) != 1 {
		t.Errorf("DownHandler didn't add an error check.")
	}
}

// TestPOSTUpHandlerChangeStatus ensures the endpoint /debug/health/up changes
// the status code of the response to 200
func TestPOSTUpHandlerChangeStatus(t *testing.T) {
	recorder := httptest.NewRecorder()

	req, err := http.NewRequest("POST", "https://fakeurl.com/debug/health/up", nil)
	if err != nil {
		t.Errorf("Failed to create request.")
	}

	UpHandler(recorder, req)

	if recorder.Code != 200 {
		t.Errorf("Did not get a 200.")
	}

	if len(health.CheckStatus()) != 0 {
		t.Errorf("UpHandler didn't remove the error check.")
	}
}
