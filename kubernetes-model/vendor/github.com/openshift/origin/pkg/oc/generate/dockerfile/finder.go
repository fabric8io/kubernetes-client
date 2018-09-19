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
package dockerfile

import (
	"os"
	"path/filepath"
	"strings"

	"github.com/openshift/origin/pkg/oc/generate"
)

type StatFunc func(path string) (os.FileInfo, error)

func (t StatFunc) Has(dir string) (string, bool, error) {
	path := filepath.Join(dir, "Dockerfile")
	_, err := t(path)
	if os.IsNotExist(err) {
		return "", false, nil
	}
	if err != nil {
		return "", false, err
	}
	return path, true, nil
}

func NewTester() generate.Tester {
	return StatFunc(os.Stat)
}

// Finder allows searching for Dockerfiles in a given directory
type Finder interface {
	Find(dir string) ([]string, error)
}

type finder struct {
	fsWalk func(dir string, fn filepath.WalkFunc) error
}

// NewFinder creates a new Dockerfile Finder
func NewFinder() Finder {
	return &finder{fsWalk: filepath.Walk}
}

// Find returns the relative paths of Dockerfiles in the given directory dir.
func (f *finder) Find(dir string) ([]string, error) {
	dockerfiles := []string{}
	err := f.fsWalk(dir, func(path string, info os.FileInfo, err error) error {
		if err != nil {
			return err
		}
		// Skip hidden directories.
		if info.IsDir() && strings.HasPrefix(info.Name(), ".") {
			return filepath.SkipDir
		}
		// Add relative path to Dockerfile.
		if isDockerfile(info) {
			relpath, err := filepath.Rel(dir, path)
			if err != nil {
				return err
			}
			dockerfiles = append(dockerfiles, relpath)
		}
		return nil
	})
	return dockerfiles, err
}

// isDockerfile returns true if info looks like a Dockerfile. It must be named
// "Dockerfile" and be either a regular file or a symlink.
func isDockerfile(info os.FileInfo) bool {
	return info.Name() == "Dockerfile" && (info.Mode().IsRegular() || info.Mode()&os.ModeSymlink != 0)
}
