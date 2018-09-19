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
package basicauthpassword

import (
	"encoding/json"
	"fmt"
	"testing"
)

func TestUnmarshal(t *testing.T) {
	expectedSubject := "12345"
	expectedName := "My Name"
	expectedEmail := "mylogin@example.com"
	expectedPreferredUsername := "myusername"

	// These keys are the published interface for the basicauthpassword IDP
	// The keys for this test should not be changed unless all corresponding docs are also updated
	data := fmt.Sprintf(`
	{
		"sub":"%s",
		"name": "%s",
		"email": "%s",
		"preferred_username": "%s",
		"additional_field": "should be ignored"
	}`, expectedSubject, expectedName, expectedEmail, expectedPreferredUsername)

	user := &RemoteUserData{}
	err := json.Unmarshal([]byte(data), user)
	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}

	if user.Subject != expectedSubject {
		t.Errorf("Expected %s, got %s", expectedSubject, user.Subject)
	}
	if user.Name != expectedName {
		t.Errorf("Expected %s, got %s", expectedName, user.Name)
	}
	if user.Email != expectedEmail {
		t.Errorf("Expected %s, got %s", expectedEmail, user.Email)
	}
	if user.PreferredUsername != expectedPreferredUsername {
		t.Errorf("Expected %s, got %s", expectedPreferredUsername, user.PreferredUsername)
	}

}
