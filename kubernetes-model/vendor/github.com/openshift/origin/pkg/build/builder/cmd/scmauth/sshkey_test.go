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

func TestSSHPrivateKeyHandles(t *testing.T) {
	sshKey := &SSHPrivateKey{}
	if !sshKey.Handles("ssh-privatekey") {
		t.Errorf("should handle ssh-privatekey")
	}
	if sshKey.Handles("ca.crt") {
		t.Errorf("should not handle ca.crt")
	}
}

func TestSSHPrivateKeySetup(t *testing.T) {
	context := NewDefaultSCMContext()
	sshKey := &SSHPrivateKey{}
	secretDir := secretDir(t, "ssh-privatekey")
	defer os.RemoveAll(secretDir)

	err := sshKey.Setup(secretDir, context)
	if err != nil {
		t.Errorf("unexpected error %v", err)
	}
	_, isSet := context.Get("GIT_SSH")
	if !isSet {
		t.Errorf("GIT_SSH is not set")
	}
}
