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
package glide

import (
	"fmt"
)

// MissingImports receives a LockFile and a YamlFile and returns a slice of
// imports not contained in the YamlFile. Dependencies with a non-empty "repo" field
// are skipped, as they are assumed to contain forked dependencies.
func MissingImports(lockfile *LockFile, yamlfile *YamlFile) (YamlFileImportList, []string, error) {
	if lockfile == nil || yamlfile == nil {
		return nil, []string{}, fmt.Errorf("both a lockfile and a yamlfile are required")
	}

	warnings := []string{}
	newImports := []*YamlFileImport{}

	for _, lockDep := range lockfile.Imports {
		if len(lockDep.Repo) > 0 {
			warnings = append(warnings, fmt.Sprintf("info: skipping package with \"repo\" field: %s", lockDep.Name))
			continue
		}

		yamlDepExists := false
		for _, yamlDep := range yamlfile.Imports {
			if yamlDep.Package == lockDep.Name {
				yamlDepExists = true
				break
			}
		}
		if yamlDepExists {
			continue
		}

		newImports = append(newImports, &YamlFileImport{
			Package: lockDep.Name,
			Version: lockDep.Version,
		})
	}

	return newImports, warnings, nil
}
