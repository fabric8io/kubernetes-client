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
// Copyright 2015 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package testtext

import (
	"bytes"
	"fmt"
	"io/ioutil"
	"os"
	"os/exec"
	"path/filepath"
	"runtime"
)

// CodeSize builds the given code sample and returns the binary size or en error
// if an error occurred. The code sample typically will look like this:
//     package main
//     import "golang.org/x/text/somepackage"
//     func main() {
//         somepackage.Func() // reference Func to cause it to be linked in.
//     }
// See dict_test.go in the display package for an example.
func CodeSize(s string) (int, error) {
	// Write the file.
	tmpdir, err := ioutil.TempDir(os.TempDir(), "testtext")
	if err != nil {
		return 0, fmt.Errorf("testtext: failed to create tmpdir: %v", err)
	}
	defer os.RemoveAll(tmpdir)
	filename := filepath.Join(tmpdir, "main.go")
	if err := ioutil.WriteFile(filename, []byte(s), 0644); err != nil {
		return 0, fmt.Errorf("testtext: failed to write main.go: %v", err)
	}

	// Build the binary.
	w := &bytes.Buffer{}
	cmd := exec.Command(filepath.Join(runtime.GOROOT(), "bin", "go"), "build", "-o", "main")
	cmd.Dir = tmpdir
	cmd.Stderr = w
	cmd.Stdout = w
	if err := cmd.Run(); err != nil {
		return 0, fmt.Errorf("testtext: failed to execute command: %v\nmain.go:\n%vErrors:%s", err, s, w)
	}

	// Determine the size.
	fi, err := os.Stat(filepath.Join(tmpdir, "main"))
	if err != nil {
		return 0, fmt.Errorf("testtext: failed to get file info: %v", err)
	}
	return int(fi.Size()), nil
}
