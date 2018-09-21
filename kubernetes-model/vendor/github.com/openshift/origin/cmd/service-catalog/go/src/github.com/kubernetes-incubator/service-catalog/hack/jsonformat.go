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
package main

import (
	"encoding/json"
	"log"
)

import "io/ioutil"
import "os"

func main() {
	if len(os.Args) != 2 {
		log.Fatal("Usage: jsonformat.go <filename>")
	}

	byt, err := ioutil.ReadFile(os.Args[1])
	if err != nil {
		log.Fatalf("ERROR: Unable to read file: %v\n", os.Args[1])
	}

	var dat map[string]interface{}

	if err := json.Unmarshal(byt, &dat); err != nil {
		log.Fatalf("ERROR: Invalid JSON file  '%v': %v\n", os.Args[1], err)
	}

	if output, err := json.MarshalIndent(dat, "", "  "); err != nil {
		log.Fatalf("ERROR: Unable to indent JSON file: %v\n", os.Args[1])
	} else {
		os.Stdout.Write(append(output, '\n'))
	}
}
