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
package localcmd

import (
	"bytes"
	"io"
	"io/ioutil"
	"os/exec"

	"github.com/golang/glog"
)

// LocalCmd is a helper to execute commands locally
type LocalCmd struct {
	cmd  string
	args []string
	env  []string
}

// New creates a LocalCmd helper
func New(command string) *LocalCmd {
	return &LocalCmd{
		cmd: command,
	}
}

// Args adds arguments to the command
func (c *LocalCmd) Args(args ...string) *LocalCmd {
	c.args = args
	return c
}

// Env adds environment to the command
func (c *LocalCmd) Env(env ...string) *LocalCmd {
	c.env = env
	return c
}

// Run executes the command and returns an error if one occurs
func (c *LocalCmd) Run() error {
	return runCmd(c.cmd, c.args, c.env, ioutil.Discard, ioutil.Discard)
}

// CombinedOutput executes the command and returns combined stdout and stderr from the command
func (c *LocalCmd) CombinedOutput() (string, error) {
	outBuf := &bytes.Buffer{}
	err := runCmd(c.cmd, c.args, c.env, outBuf, outBuf)
	return outBuf.String(), err
}

// Output executes the command and returns separate stdout and stderr from the command
func (c *LocalCmd) Output() (string, string, error) {
	outBuf, errBuf := &bytes.Buffer{}, &bytes.Buffer{}
	err := runCmd(c.cmd, c.args, c.env, outBuf, errBuf)
	return outBuf.String(), errBuf.String(), err
}

func runCmd(cmd string, args []string, env []string, stdOut, errOut io.Writer) error {
	glog.V(5).Infof("Executing local command:")
	glog.V(5).Infof("  %s", cmd)
	for _, a := range args {
		glog.V(5).Infof("  %s", a)
	}
	if len(env) > 0 {
		glog.V(5).Infof("Environment:")
		for _, e := range env {
			glog.V(5).Infof("  %s", e)
		}
	}
	c := exec.Command(cmd, args...)
	outLog := &bytes.Buffer{}
	errLog := &bytes.Buffer{}
	c.Stdout = io.MultiWriter(stdOut, outLog)
	c.Stderr = io.MultiWriter(errOut, errLog)
	c.Env = env
	err := c.Run()
	if glog.V(5) {
		if err != nil {
			glog.Infof("Error from execution: %v", err)
		}
		if outLog.Len() > 0 {
			glog.Infof("Stdout:\n%s", outLog.String())
		}
		if errLog.Len() > 0 {
			glog.Infof("Errout:\n%s", errLog.String())
		}
	}
	if err != nil {
		return newExecError(append([]string{cmd}, args...), err, outLog.Bytes(), errLog.Bytes())
	}
	return nil
}
