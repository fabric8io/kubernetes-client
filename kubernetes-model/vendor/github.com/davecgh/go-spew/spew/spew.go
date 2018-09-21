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
package spew

import (
	"fmt"
	"io"
)

// Errorf is a wrapper for fmt.Errorf that treats each argument as if it were
// passed with a default Formatter interface returned by NewFormatter.  It
// returns the formatted string as a value that satisfies error.  See
// NewFormatter for formatting details.
//
// This function is shorthand for the following syntax:
//
//	fmt.Errorf(format, spew.NewFormatter(a), spew.NewFormatter(b))
func Errorf(format string, a ...interface{}) (err error) {
	return fmt.Errorf(format, convertArgs(a)...)
}

// Fprint is a wrapper for fmt.Fprint that treats each argument as if it were
// passed with a default Formatter interface returned by NewFormatter.  It
// returns the number of bytes written and any write error encountered.  See
// NewFormatter for formatting details.
//
// This function is shorthand for the following syntax:
//
//	fmt.Fprint(w, spew.NewFormatter(a), spew.NewFormatter(b))
func Fprint(w io.Writer, a ...interface{}) (n int, err error) {
	return fmt.Fprint(w, convertArgs(a)...)
}

// Fprintf is a wrapper for fmt.Fprintf that treats each argument as if it were
// passed with a default Formatter interface returned by NewFormatter.  It
// returns the number of bytes written and any write error encountered.  See
// NewFormatter for formatting details.
//
// This function is shorthand for the following syntax:
//
//	fmt.Fprintf(w, format, spew.NewFormatter(a), spew.NewFormatter(b))
func Fprintf(w io.Writer, format string, a ...interface{}) (n int, err error) {
	return fmt.Fprintf(w, format, convertArgs(a)...)
}

// Fprintln is a wrapper for fmt.Fprintln that treats each argument as if it
// passed with a default Formatter interface returned by NewFormatter.  See
// NewFormatter for formatting details.
//
// This function is shorthand for the following syntax:
//
//	fmt.Fprintln(w, spew.NewFormatter(a), spew.NewFormatter(b))
func Fprintln(w io.Writer, a ...interface{}) (n int, err error) {
	return fmt.Fprintln(w, convertArgs(a)...)
}

// Print is a wrapper for fmt.Print that treats each argument as if it were
// passed with a default Formatter interface returned by NewFormatter.  It
// returns the number of bytes written and any write error encountered.  See
// NewFormatter for formatting details.
//
// This function is shorthand for the following syntax:
//
//	fmt.Print(spew.NewFormatter(a), spew.NewFormatter(b))
func Print(a ...interface{}) (n int, err error) {
	return fmt.Print(convertArgs(a)...)
}

// Printf is a wrapper for fmt.Printf that treats each argument as if it were
// passed with a default Formatter interface returned by NewFormatter.  It
// returns the number of bytes written and any write error encountered.  See
// NewFormatter for formatting details.
//
// This function is shorthand for the following syntax:
//
//	fmt.Printf(format, spew.NewFormatter(a), spew.NewFormatter(b))
func Printf(format string, a ...interface{}) (n int, err error) {
	return fmt.Printf(format, convertArgs(a)...)
}

// Println is a wrapper for fmt.Println that treats each argument as if it were
// passed with a default Formatter interface returned by NewFormatter.  It
// returns the number of bytes written and any write error encountered.  See
// NewFormatter for formatting details.
//
// This function is shorthand for the following syntax:
//
//	fmt.Println(spew.NewFormatter(a), spew.NewFormatter(b))
func Println(a ...interface{}) (n int, err error) {
	return fmt.Println(convertArgs(a)...)
}

// Sprint is a wrapper for fmt.Sprint that treats each argument as if it were
// passed with a default Formatter interface returned by NewFormatter.  It
// returns the resulting string.  See NewFormatter for formatting details.
//
// This function is shorthand for the following syntax:
//
//	fmt.Sprint(spew.NewFormatter(a), spew.NewFormatter(b))
func Sprint(a ...interface{}) string {
	return fmt.Sprint(convertArgs(a)...)
}

// Sprintf is a wrapper for fmt.Sprintf that treats each argument as if it were
// passed with a default Formatter interface returned by NewFormatter.  It
// returns the resulting string.  See NewFormatter for formatting details.
//
// This function is shorthand for the following syntax:
//
//	fmt.Sprintf(format, spew.NewFormatter(a), spew.NewFormatter(b))
func Sprintf(format string, a ...interface{}) string {
	return fmt.Sprintf(format, convertArgs(a)...)
}

// Sprintln is a wrapper for fmt.Sprintln that treats each argument as if it
// were passed with a default Formatter interface returned by NewFormatter.  It
// returns the resulting string.  See NewFormatter for formatting details.
//
// This function is shorthand for the following syntax:
//
//	fmt.Sprintln(spew.NewFormatter(a), spew.NewFormatter(b))
func Sprintln(a ...interface{}) string {
	return fmt.Sprintln(convertArgs(a)...)
}

// convertArgs accepts a slice of arguments and returns a slice of the same
// length with each argument converted to a default spew Formatter interface.
func convertArgs(args []interface{}) (formatters []interface{}) {
	formatters = make([]interface{}, len(args))
	for index, arg := range args {
		formatters[index] = NewFormatter(arg)
	}
	return formatters
}
