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
package recycle

import (
	"fmt"
	"io/ioutil"
	"os"
	"path"
	"path/filepath"
	"testing"
)

var testFilenames = []string{
	string([]byte{3}), // Ctrl+C
	string([]byte{4}), // Ctrl+D

	`white space`,
	`new
line`,

	`*`,
	`~`,
	`\`,
	`\\`,

	` && touch and-escape`,
	` || touch or-escape`,
	` ; touch semi-escape`,
	` " touch quote-escape`,
	` ' touch apos-escape`,
	` }"; touch brace-escape`,

	`env x='() { :;}; echo vulnerable'`, // shellshock

	`$USER`,

	`...`,
	`.file`,

	`中文`,                   // utf-8
	`κόσμε`,                // utf-8
	`Iñtërnâtiônàlizætiøn`, // utf-8
}

func prepareTestDir(root string, filenames []string) error {
	for _, dir := range filenames {
		dirpath := path.Join(root, dir)
		if err := os.Mkdir(dirpath, os.FileMode(0755)); err != nil {
			return fmt.Errorf("Error writing dir %s\n%v", dirpath, err)
		}

		for _, file := range filenames {
			filepath := path.Join(dirpath, file)
			if err := ioutil.WriteFile(filepath, []byte(filepath), os.FileMode(0755)); err != nil {
				return fmt.Errorf("Error writing file %s\n%v", filepath, err)
			}

			if _, err := os.Stat(filepath); err != nil {
				return fmt.Errorf("Error verifying file %s\n%v", filepath, err)
			}
		}
	}
	return nil
}

func TestRecycle(t *testing.T) {
	root, err := ioutil.TempDir("", "recycler-test-")
	if err != nil {
		t.Fatal(err)
	}
	defer func() {
		if err := os.RemoveAll(root); err != nil {
			t.Fatal(err)
		}
	}()

	prepareTestDir(root, testFilenames)

	err = Recycle(root)
	if err != nil {
		t.Error(err)
	}

	remaining := []string{}
	err = filepath.Walk(root, func(path string, info os.FileInfo, err error) error {
		remaining = append(remaining, path)
		return err
	})
	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}
	if len(remaining) != 1 || remaining[0] != root {
		t.Errorf("Unexpected files left after recycling: %#v", remaining)
	}
}

func TestCheckEmpty(t *testing.T) {
	tests := []struct {
		name          string
		filenames     []string
		expectedError bool
	}{
		{
			name:          "EmptyDir",
			expectedError: false,
		},
		{
			name:          "File",
			filenames:     []string{"file"},
			expectedError: true,
		},
		{
			name:          "HiddenFile",
			filenames:     []string{".file"},
			expectedError: true,
		},
		{
			name:          "TestFilenames",
			filenames:     testFilenames,
			expectedError: true,
		},
	}
	for _, test := range tests {
		root, err := ioutil.TempDir("", "recycler-test-")
		if err != nil {
			t.Fatal(err)
		}
		defer func() {
			if err := os.RemoveAll(root); err != nil {
				t.Fatal(err)
			}
		}()

		if err := prepareTestDir(root, test.filenames); err != nil {
			t.Errorf("Failed to prepare files for test %q: %v", test.name, err)
			continue
		}

		err = CheckEmpty(root)
		if test.expectedError && err == nil {
			t.Errorf("Test %q expected an error and did not get any", test.name)
		}
		if !test.expectedError && err != nil {
			t.Errorf("Test %q: unexpected error: %v", test.name, err)
		}
	}
}
