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
package term

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strings"

	"github.com/docker/docker/pkg/term"
	"github.com/golang/glog"
)

// PromptForString takes an io.Reader and prompts for user input if it's a terminal, returning the result.
func PromptForString(r io.Reader, w io.Writer, format string, a ...interface{}) string {
	if w == nil {
		w = os.Stdout
	}

	fmt.Fprintf(w, format, a...)
	return readInput(r)
}

// PromptForPasswordString prompts for user input by disabling echo in terminal, useful for password prompt.
func PromptForPasswordString(r io.Reader, w io.Writer, format string, a ...interface{}) string {
	if w == nil {
		w = os.Stdout
	}

	if file, ok := r.(*os.File); ok {
		inFd := file.Fd()

		if term.IsTerminal(inFd) {
			oldState, err := term.SaveState(inFd)
			if err != nil {
				glog.V(3).Infof("Unable to save terminal state")
				return PromptForString(r, w, format, a...)
			}

			fmt.Fprintf(w, format, a...)

			term.DisableEcho(inFd, oldState)

			input := readInput(r)

			defer term.RestoreTerminal(inFd, oldState)

			fmt.Fprintf(w, "\n")

			return input
		}
		glog.V(3).Infof("Stdin is not a terminal")
		return PromptForString(r, w, format, a...)
	}
	return PromptForString(r, w, format, a...)
}

// PromptForBool prompts for user input of a boolean value. The accepted values are:
//   yes, y, true, 	t, 1 (not case sensitive)
//   no, 	n, false, f, 0 (not case sensitive)
// A valid answer is mandatory so it will keep asking until an answer is provided.
func PromptForBool(r io.Reader, w io.Writer, format string, a ...interface{}) bool {
	if w == nil {
		w = os.Stdout
	}

	str := PromptForString(r, w, format, a...)
	switch strings.ToLower(str) {
	case "1", "t", "true", "y", "yes":
		return true
	case "0", "f", "false", "n", "no":
		return false
	}
	fmt.Println("Please enter 'yes' or 'no'.")
	return PromptForBool(r, w, format, a...)
}

// PromptForStringWithDefault prompts for user input but take a default in case nothing is provided.
func PromptForStringWithDefault(r io.Reader, w io.Writer, def string, format string, a ...interface{}) string {
	if w == nil {
		w = os.Stdout
	}

	s := PromptForString(r, w, format, a...)
	if len(s) == 0 {
		return def
	}
	return s
}

func readInput(r io.Reader) string {
	if _, isTerminal := term.GetFdInfo(r); isTerminal {
		return readInputFromTerminal(r)
	}
	return readInputFromReader(r)
}

func readInputFromTerminal(r io.Reader) string {
	reader := bufio.NewReader(r)
	result, _ := reader.ReadString('\n')
	return strings.TrimRight(result, "\r\n")
}

func readInputFromReader(r io.Reader) string {
	var result string
	fmt.Fscan(r, &result)
	return result
}

// IsTerminalReader returns whether the passed io.Reader is a terminal or not
func IsTerminalReader(r io.Reader) bool {
	file, ok := r.(*os.File)
	return ok && term.IsTerminal(file.Fd())
}

// IsTerminalWriter returns whether the passed io.Writer is a terminal or not
func IsTerminalWriter(w io.Writer) bool {
	file, ok := w.(*os.File)
	return ok && term.IsTerminal(file.Fd())
}
