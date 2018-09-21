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
package version

import (
	"fmt"
	"io"
	"os"
)

// FprintVersion outputs the version string to the writer, in the following
// format, followed by a newline:
//
// 	<cmd> <project> <version>
//
// For example, a binary "registry" built from github.com/docker/distribution
// with version "v2.0" would print the following:
//
// 	registry github.com/docker/distribution v2.0
//
func FprintVersion(w io.Writer) {
	fmt.Fprintln(w, os.Args[0], Package, Version)
}

// PrintVersion outputs the version information, from Fprint, to stdout.
func PrintVersion() {
	FprintVersion(os.Stdout)
}
