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
	"path/filepath"

	"github.com/golang/glog"
)

const GitConfigName = ".gitconfig"

// GitConfig implements SCMAuth interface for using a custom .gitconfig file
type GitConfig struct{}

// Setup adds the secret .gitconfig as an include to the .gitconfig file to be used in the build
func (_ GitConfig) Setup(baseDir string, context SCMAuthContext) error {
	glog.V(4).Infof("Adding user-provided gitconfig %s to build gitconfig", filepath.Join(baseDir, GitConfigName))
	return ensureGitConfigIncludes(filepath.Join(baseDir, GitConfigName), context)
}

// Name returns the name of this auth method.
func (_ GitConfig) Name() string {
	return GitConfigName
}

// Handles returns true if the secret file is a gitconfig
func (_ GitConfig) Handles(name string) bool {
	return name == GitConfigName
}
