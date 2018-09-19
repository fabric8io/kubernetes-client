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
package oauthserver

import (
	"io/ioutil"
	"os"
	"reflect"
	"testing"

	_ "github.com/openshift/origin/pkg/api/install"
	"github.com/openshift/origin/pkg/cmd/server/apis/config"
	"github.com/openshift/origin/pkg/cmd/server/apis/config/latest"
)

func TestGetDefaultSessionSecrets(t *testing.T) {
	secrets, err := getSessionSecrets("")
	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}
	if len(secrets) != 2 {
		t.Errorf("Unexpected 2 secrets, got: %#v", secrets)
	}
}

func TestGetMissingSessionSecretsFile(t *testing.T) {
	_, err := getSessionSecrets("missing")
	if err == nil {
		t.Errorf("Expected error, got none")
	}
}

func TestGetInvalidSessionSecretsFile(t *testing.T) {
	tmpfile, err := ioutil.TempFile("", "invalid.yaml")
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	defer os.Remove(tmpfile.Name())

	ioutil.WriteFile(tmpfile.Name(), []byte("invalid content"), os.FileMode(0600))

	_, err = getSessionSecrets(tmpfile.Name())
	if err == nil {
		t.Errorf("Expected error, got none")
	}
}

func TestGetEmptySessionSecretsFile(t *testing.T) {
	tmpfile, err := ioutil.TempFile("", "empty.yaml")
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	defer os.Remove(tmpfile.Name())

	secrets := &config.SessionSecrets{
		Secrets: []config.SessionSecret{},
	}

	yaml, err := latest.WriteYAML(secrets)
	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}
	ioutil.WriteFile(tmpfile.Name(), []byte(yaml), os.FileMode(0600))

	_, err = getSessionSecrets(tmpfile.Name())
	if err == nil {
		t.Errorf("Expected error, got none")
	}
}

func TestGetValidSessionSecretsFile(t *testing.T) {
	tmpfile, err := ioutil.TempFile("", "valid.yaml")
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	defer os.Remove(tmpfile.Name())

	secrets := &config.SessionSecrets{
		Secrets: []config.SessionSecret{
			{Authentication: "a1", Encryption: "e1"},
			{Authentication: "a2", Encryption: "e2"},
		},
	}
	expectedSecrets := []string{"a1", "e1", "a2", "e2"}

	yaml, err := latest.WriteYAML(secrets)
	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}
	ioutil.WriteFile(tmpfile.Name(), []byte(yaml), os.FileMode(0600))

	readSecrets, err := getSessionSecrets(tmpfile.Name())
	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}
	if !reflect.DeepEqual(readSecrets, expectedSecrets) {
		t.Errorf("Unexpected %v, got %v", expectedSecrets, readSecrets)
	}
}
