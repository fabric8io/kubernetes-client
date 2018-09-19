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
package prefixwriter

import (
	"bytes"
	"io"
)

// prefixWriter is a writer that prefixes every line it writes with a prefix
type prefixWriter struct {
	// prefix is the prefix for every line
	prefix string
	// atStart is true if the writer is positioned at the start of a line
	atStart bool
	// writer is the actual internal writer
	writer io.Writer
}

// New creates a writer that prepends a prefix to every line it writes
func New(prefix string, w io.Writer) io.Writer {
	return &prefixWriter{
		writer:  w,
		atStart: true,
		prefix:  prefix,
	}
}

func (w *prefixWriter) Write(p []byte) (n int, err error) {
	segments := bytes.Split(p, []byte("\n"))
	for i, s := range segments {
		if len(s) > 0 {
			if w.atStart {
				// write the prefix if at start of a line
				_, err = w.writer.Write([]byte(w.prefix))
				if err != nil {
					return
				}
			}
			_, err = w.writer.Write(s)
			if err != nil {
				return
			}
			w.atStart = false
		} else {
			// If segment is empty, we're at start of a line
			w.atStart = true
		}

		if i < (len(segments) - 1) {
			// If not at the end of the segments, write a newline
			_, err = w.writer.Write([]byte("\n"))
			if err != nil {
				return
			}
			w.atStart = true
		}
	}
	n = len(p)
	return
}
