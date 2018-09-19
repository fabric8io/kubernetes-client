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
package top

import (
	"bytes"
	"fmt"
	"io"
	"strings"
	"text/tabwriter"
)

type Info interface {
	PrintLine(out io.Writer)
}

func Print(out io.Writer, headers []string, infos []Info) {
	s := tabbedString(func(out *tabwriter.Writer) {
		printHeader(out, headers)
		for _, info := range infos {
			info.PrintLine(out)
			fmt.Fprintf(out, "\n")
		}
	})
	fmt.Fprintf(out, "%s", s)
}

func printHeader(out io.Writer, columns []string) {
	for _, col := range columns {
		printValue(out, col)
	}
	fmt.Fprintf(out, "\n")
}

func printArray(out io.Writer, values []string) {
	if len(values) == 0 {
		printValue(out, "<none>")
	} else {
		printValue(out, strings.Join(values, ", "))
	}
}

func printValue(out io.Writer, value interface{}) {
	fmt.Fprintf(out, "%v\t", value)
}

func printBool(out io.Writer, value bool) {
	if value {
		printValue(out, "yes")
	} else {
		printValue(out, "no")
	}
}

func tabbedString(f func(*tabwriter.Writer)) string {
	out := new(tabwriter.Writer)
	buf := &bytes.Buffer{}
	out.Init(buf, 0, 8, 1, ' ', 0)
	f(out)
	out.Flush()
	str := string(buf.String())
	return str
}
