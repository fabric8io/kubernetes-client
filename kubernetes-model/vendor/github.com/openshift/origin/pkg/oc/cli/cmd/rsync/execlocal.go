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
package rsync

import (
	"io"
	"os/exec"
	"strings"

	"github.com/golang/glog"
)

// localExecutor will execute commands on the local machine
type localExecutor struct{}

// ensure localExecutor implements the executor interface
var _ executor = &localExecutor{}

// Execute will run a command locally
func (*localExecutor) Execute(command []string, in io.Reader, out, errOut io.Writer) error {
	glog.V(3).Infof("Local executor running command: %s", strings.Join(command, " "))
	cmd := exec.Command(command[0], command[1:]...)
	cmd.Stdout = out
	cmd.Stderr = errOut
	cmd.Stdin = in
	err := cmd.Run()
	if err != nil {
		glog.V(4).Infof("Error from local command execution: %v", err)
	}
	return err
}

// newLocalExecutor instantiates a local executor
func newLocalExecutor() executor {
	return &localExecutor{}
}
