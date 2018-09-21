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
)

func TestGitConfigHandles(t *testing.T) {
	caCert := &GitConfig{}
	if !caCert.Handles(".gitconfig") {
		t.Errorf("should handle .gitconfig")
	}
	if caCert.Handles("username") {
		t.Errorf("should not handle username")
	}
	if caCert.Handles("gitconfig") {
		t.Errorf("should not handle gitconfig")
	}
}

func TestGitConfigSetup(t *testing.T) {
	context := NewDefaultSCMContext()
	gitConfig := &GitConfig{}
	secretDir := secretDir(t, ".gitconfig")
	defer os.RemoveAll(secretDir)

	err := gitConfig.Setup(secretDir, context)
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}
	config, _ := context.Get("GIT_CONFIG")
	defer cleanupConfig(config)
	validateConfig(t, config, "test")
}
