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
package log

import (
	"fmt"
	"io"
	"strings"

	ct "github.com/daviddengcn/go-colortext"
	"github.com/openshift/origin/pkg/cmd/util/term"
)

type textLogger struct {
	out         io.Writer
	ttyOutput   bool // usually want color; but do not output colors to non-tty
	lastNewline bool // keep track of newline separation
}

func newTextLogger(out io.Writer) *textLogger {
	logger := &textLogger{out: out, lastNewline: true}

	if term.IsTerminalWriter(out) {
		// only want color sequences to humans, not redirected output (logs, "less", etc.)
		logger.ttyOutput = true
	}
	return logger
}

func (t *textLogger) Write(entry Entry) {
	if t.ttyOutput {
		ct.ChangeColor(entry.Level.Color, entry.Level.Bright, ct.None, false)
	}
	text := strings.TrimSpace(entry.Message)
	if entry.Level.Level >= WarnLevel.Level {
		text = fmt.Sprintf("[%s from %s]\n", entry.ID, entry.Origin) + text
	}
	if strings.Contains(text, "\n") { // separate multiline comments with newlines
		if !t.lastNewline {
			fmt.Fprintln(t.out) // separate from previous one-line log msg
		}
		text = text + "\n"
		t.lastNewline = true
	} else {
		t.lastNewline = false
	}
	fmt.Fprintln(t.out, entry.Level.Prefix+strings.Replace(text, "\n", "\n       ", -1))
	if t.ttyOutput {
		ct.ResetColor()
	}
}
