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
package app

import (
	"os"
)

// isFile returns true if the passed-in argument is a file in the filesystem
func isFile(name string) (bool, error) {
	info, err := os.Stat(name)
	return err == nil && !info.IsDir(), err
}

// IsDirectory returns true if the passed-in argument is a directory in the filesystem
func IsDirectory(name string) (bool, error) {
	info, err := os.Stat(name)
	return err == nil && info.IsDir(), err
}
