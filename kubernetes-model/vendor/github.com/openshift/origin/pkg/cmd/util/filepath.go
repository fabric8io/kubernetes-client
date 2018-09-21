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
package util

import (
	"fmt"
	"os"
	"path/filepath"
	"strings"
)

func MakeAbs(path, base string) (string, error) {
	if filepath.IsAbs(path) {
		return path, nil
	}
	if len(base) == 0 {
		cwd, err := os.Getwd()
		if err != nil {
			return "", err
		}
		base = cwd
	}
	return filepath.Join(base, path), nil
}

// ResolvePaths updates the given refs to be absolute paths, relative to the given base directory
func ResolvePaths(refs []*string, base string) error {
	for _, ref := range refs {
		// Don't resolve empty paths
		if len(*ref) > 0 {
			// Don't resolve absolute paths
			if !filepath.IsAbs(*ref) {
				*ref = filepath.Join(base, *ref)
			}
		}
	}
	return nil
}

func MakeRelative(path, base string) (string, error) {
	if len(path) > 0 {
		rel, err := filepath.Rel(base, path)
		if err != nil {
			return path, err
		}
		return rel, nil
	}
	return path, nil
}

// RelativizePathWithNoBacksteps updates the given refs to be relative paths, relative to the given base directory as long as they do not require backsteps.
// Any path requiring a backstep is left as-is as long it is absolute.  Any non-absolute path that can't be relativized produces an error
func RelativizePathWithNoBacksteps(refs []*string, base string) error {
	for _, ref := range refs {
		// Don't relativize empty paths
		if len(*ref) > 0 {
			rel, err := MakeRelative(*ref, base)
			if err != nil {
				return err
			}

			// if we have a backstep, don't mess with the path
			if strings.HasPrefix(rel, "../") {
				if filepath.IsAbs(*ref) {
					continue
				}

				return fmt.Errorf("%v requires backsteps and is not absolute", *ref)
			}

			*ref = rel
		}
	}
	return nil
}
