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
	"fmt"

	"github.com/openshift/origin/pkg/oc/util/prefixwriter"
)

// execError is an error that occurred executing a local command
type execError struct {
	cmd    []string
	cause  error
	stdOut []byte
	errOut []byte
}

func newExecError(cmd []string, cause error, stdOut, errOut []byte) error {
	return &execError{
		cmd:    cmd,
		cause:  cause,
		stdOut: stdOut,
		errOut: errOut,
	}
}

func (e *execError) Error() string {
	return fmt.Sprintf("exec error: %v", e.cause)
}

func (e *execError) Cause() error {
	return e.cause
}

func (e *execError) Details() string {
	out := &bytes.Buffer{}
	fmt.Fprintf(out, "Command: %v\n", e.cmd)
	if len(e.stdOut) > 0 {
		fmt.Fprintf(out, "Standard output:\n")
		w := prefixwriter.New("  ", out)
		w.Write(bytes.TrimSpace(e.stdOut))
		fmt.Fprintf(out, "\n")
	}
	if len(e.errOut) > 0 {
		fmt.Fprintf(out, "Error output:\n")
		w := prefixwriter.New("  ", out)
		w.Write(bytes.TrimSpace(e.errOut))
		fmt.Fprintf(out, "\n")
	}
	return out.String()
}
