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
	"bytes"
	"fmt"
	"io/ioutil"
	"os"
)

func main() {
	args := os.Args
	if len(args) != 4 {
		fmt.Println("gogoreplace wants three arguments")
		fmt.Println("	gogoreplace oldsubstring newsubstring filename")
		os.Exit(1)
	}
	data, err := ioutil.ReadFile(args[3])
	if err != nil {
		panic(err)
	}
	data = bytes.Replace(data, []byte(args[1]), []byte(args[2]), -1)
	if err := ioutil.WriteFile(args[3], data, 0666); err != nil {
		panic(err)
	}
}
