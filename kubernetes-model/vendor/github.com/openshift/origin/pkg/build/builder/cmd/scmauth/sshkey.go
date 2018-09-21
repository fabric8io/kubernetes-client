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
	"io/ioutil"
	"path/filepath"

	"github.com/golang/glog"
)

const SSHPrivateKeyMethodName = "ssh-privatekey"

// SSHPrivateKey implements SCMAuth interface for using SSH private keys.
type SSHPrivateKey struct{}

// Setup creates a wrapper script for SSH command to be able to use the provided
// SSH key while accessing private repository.
func (_ SSHPrivateKey) Setup(baseDir string, context SCMAuthContext) error {
	script, err := ioutil.TempFile("", "gitssh")
	if err != nil {
		return err
	}
	defer script.Close()
	if err := script.Chmod(0711); err != nil {
		return err
	}
	content := "#!/bin/sh\nssh -i " +
		filepath.Join(baseDir, SSHPrivateKeyMethodName) +
		" -o StrictHostKeyChecking=false \"$@\"\n"

	glog.V(5).Infof("Adding Private SSH Auth:\n%s\n", content)

	if _, err := script.WriteString(content); err != nil {
		return err
	}
	// set environment variable to tell git to use the SSH wrapper
	if err := context.Set("GIT_SSH", script.Name()); err != nil {
		return err
	}
	return nil
}

// Name returns the name of this auth method.
func (_ SSHPrivateKey) Name() string {
	return SSHPrivateKeyMethodName
}

// Handles returns true if the file is an SSH private key
func (_ SSHPrivateKey) Handles(name string) bool {
	return name == SSHPrivateKeyMethodName
}
