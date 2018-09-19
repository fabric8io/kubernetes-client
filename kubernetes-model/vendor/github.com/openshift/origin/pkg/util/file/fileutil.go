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
package file

import (
	"bufio"
	"io/ioutil"
	"os"
)

// ReadLines reads the content of the given file into a string slice
func ReadLines(fileName string) ([]string, error) {
	file, err := os.Open(fileName)
	if err != nil {
		return nil, err
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	var lines []string
	for scanner.Scan() {
		lines = append(lines, scanner.Text())
	}
	return lines, scanner.Err()
}

// LoadData reads the specified file and returns it as a bytes slice.
func LoadData(file string) ([]byte, error) {
	if len(file) == 0 {
		return []byte{}, nil
	}

	bytes, err := ioutil.ReadFile(file)
	if err != nil {
		return []byte{}, err
	}

	return bytes, nil
}
