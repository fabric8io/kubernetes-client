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
package errors

import (
	"fmt"
	"io"
)

type hasCause interface {
	Cause() error
}

type hasDetails interface {
	Details() string
}

type hasSolution interface {
	Solution() string
}

func PrintError(err error, out io.Writer) {
	fmt.Fprintf(out, "%v\n", err)
	if d, ok := err.(hasDetails); ok && len(d.Details()) > 0 {
		fmt.Fprintf(out, "%s\n", d.Details())
	}
	if c, ok := err.(hasCause); ok && c.Cause() != nil {
		fmt.Fprintf(out, "%v\n", c.Cause())
	}
	if s, ok := err.(hasSolution); ok && len(s.Solution()) > 0 {
		fmt.Fprintf(out, "%s", s.Solution())
	}
}
