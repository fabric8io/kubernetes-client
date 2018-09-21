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
	"fmt"
	"os"
	"os/exec"
	"runtime"
	"strings"
	"syscall"
)

var baseCommand = "oc"

func main() {
	if runtime.GOOS == "windows" {
		baseCommand = strings.ToLower(baseCommand) + ".exe"
	}

	path, err := exec.LookPath(baseCommand)
	if err != nil {
		fmt.Fprintf(os.Stderr, "%v\n", err)
		os.Exit(1)
	}

	fmt.Fprintf(os.Stderr, "DEPRECATED: The 'oadm' command is deprecated, please use '%s adm' instead.\n", baseCommand)

	admCmd := ""

	// 1. there is no `oc adm version` command,special-case it here.
	// 2. oadm with no args should run oc adm and print out the default usage msg.
	if (len(os.Args) > 1 && os.Args[1] != "version") || len(os.Args) == 1 {
		admCmd = "adm"
	}

	if err := syscall.Exec(path, append([]string{baseCommand, admCmd}, os.Args[1:]...), os.Environ()); err != nil {
		fmt.Fprintf(os.Stderr, "%v\n", err)
		os.Exit(1)
	}
}
