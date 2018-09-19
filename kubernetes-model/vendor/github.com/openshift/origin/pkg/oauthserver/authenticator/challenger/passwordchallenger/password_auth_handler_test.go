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
package passwordchallenger

import (
	"fmt"
	"net/http"
	"strings"
	"testing"
)

func TestAuthChallengeNeeded(t *testing.T) {
	realm := "testing-realm"
	expectedChallenge := fmt.Sprintf(`Basic realm="%s"`, realm)

	handler := NewBasicAuthChallenger(realm)

	req, _ := http.NewRequest("GET", "", nil)
	req.Header.Set(CSRFTokenHeader, "1")
	header, err := handler.AuthenticationChallenge(req)
	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}
	if warning := header.Get("Warning"); warning != "" {
		t.Errorf("Unexpected warning %v", warning)
	}
	if challenge := header.Get("WWW-Authenticate"); challenge != expectedChallenge {
		t.Errorf("Expected %v, got %v", expectedChallenge, challenge)
	}

}

func TestAuthChallengeWithoutCSRF(t *testing.T) {
	realm := "testing-realm"
	expectedWarning := CSRFTokenHeader

	handler := NewBasicAuthChallenger(realm)

	req, _ := http.NewRequest("GET", "", nil)
	header, err := handler.AuthenticationChallenge(req)
	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}
	if warning := header.Get("Warning"); !strings.Contains(warning, expectedWarning) {
		t.Errorf("Expected warning containing %s, got %s", expectedWarning, warning)
	}
	if challenge := header.Get("WWW-Authenticate"); challenge != "" {
		t.Errorf("Unexpected challenge %v", challenge)
	}

}
