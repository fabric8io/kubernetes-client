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

import "fmt"

// NewSuiteOutOfBoundsError returns a new SuiteOutOfBounds error for the given suite name
func NewSuiteOutOfBoundsError(name string) error {
	return &suiteOutOfBoundsError{
		suiteName: name,
	}
}

// suiteOutOfBoundsError describes the failure to place a test suite into a test suite tree because the suite
// in question is not a child of any suite in the tree
type suiteOutOfBoundsError struct {
	suiteName string
}

func (e *suiteOutOfBoundsError) Error() string {
	return fmt.Sprintf("the test suite %q could not be placed under any existing roots in the tree", e.suiteName)
}

// IsSuiteOutOfBoundsError determines if the given error was raised because a suite could not be placed
// in the test suite tree
func IsSuiteOutOfBoundsError(err error) bool {
	if err == nil {
		return false
	}

	_, ok := err.(*suiteOutOfBoundsError)
	return ok
}
