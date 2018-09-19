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
package scmauth

import (
	"os"
	"testing"

	"github.com/openshift/source-to-image/pkg/scm/git"
)

func TestCACertHandles(t *testing.T) {
	caCert := &CACert{}
	if !caCert.Handles("ca.crt") {
		t.Errorf("should handle ca.crt")
	}
	if caCert.Handles("username") {
		t.Errorf("should not handle username")
	}
}

func TestCACertSetup(t *testing.T) {
	context := NewDefaultSCMContext()
	caCert := &CACert{
		SourceURL: *git.MustParse("https://my.host/git/repo"),
	}
	secretDir := secretDir(t, "ca.crt")
	defer os.RemoveAll(secretDir)

	err := caCert.Setup(secretDir, context)
	gitConfig, _ := context.Get("GIT_CONFIG")
	defer cleanupConfig(gitConfig)
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	validateConfig(t, gitConfig, "sslCAInfo")
}

func TestCACertSetupNoSSL(t *testing.T) {
	context := NewDefaultSCMContext()
	caCert := &CACert{
		SourceURL: *git.MustParse("http://my.host/git/repo"),
	}
	secretDir := secretDir(t, "ca.crt")
	defer os.RemoveAll(secretDir)

	err := caCert.Setup(secretDir, context)
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	_, gitConfigPresent := context.Get("GIT_CONFIG")
	if gitConfigPresent {
		t.Fatalf("git config not expected")
	}
}
