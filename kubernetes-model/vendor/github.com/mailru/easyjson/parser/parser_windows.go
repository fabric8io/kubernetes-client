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
package parser

import (
	"fmt"
	"os"
	"path"
	"strings"
)

func normalizePath(path string) string {
	return strings.Replace(path, "\\", "/", -1)
}

func getPkgPath(fname string, isDir bool) (string, error) {
	if !path.IsAbs(fname) {
		pwd, err := os.Getwd()
		if err != nil {
			return "", err
		}
		fname = path.Join(pwd, fname)
	}

	fname = normalizePath(fname)

	for _, p := range strings.Split(os.Getenv("GOPATH"), ";") {
		prefix := path.Join(normalizePath(p), "src") + "/"
		if rel := strings.TrimPrefix(fname, prefix); rel != fname {
			if !isDir {
				return path.Dir(rel), nil
			} else {
				return path.Clean(rel), nil
			}
		}
	}

	return "", fmt.Errorf("file '%v' is not in GOPATH", fname)
}
