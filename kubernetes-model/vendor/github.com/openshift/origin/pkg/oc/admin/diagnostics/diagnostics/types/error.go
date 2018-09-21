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
package types

import (
	"fmt"
)

// DiagnosticError is an error created by the diagnostic framework and has a little
// more info than a regular error to make them easier to identify in the receiver.
type DiagnosticError struct {
	ID         string
	LogMessage string
	Cause      error
}

// Error() method means it conforms to the error interface.
func (e DiagnosticError) Error() string {
	if e.LogMessage != "" {
		return fmt.Sprintf("(%s) %s", e.ID, e.LogMessage)
	}
	if e.Cause != nil {
		return e.Cause.Error()
	}
	return e.ID
}

// Easily determine if an error is in fact a Diagnostic error
func IsDiagnosticError(e error) bool {
	_, ok := e.(DiagnosticError)
	return ok
}

// Is the error a diagnostics error that matches the given ID?
func MatchesDiagError(err error, id string) bool {
	if derr, ok := err.(DiagnosticError); ok && derr.ID == id {
		return true
	}
	return false
}
