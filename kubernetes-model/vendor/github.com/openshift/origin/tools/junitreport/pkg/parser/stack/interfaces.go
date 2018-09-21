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
package stack

import "github.com/openshift/origin/tools/junitreport/pkg/api"

// TestDataParser knows how to take raw test data and extract the useful information from it
type TestDataParser interface {
	// MarksBeginning determines if the line marks the beginning of a test case
	MarksBeginning(line string) bool

	// ExtractName extracts the name of the test case from test output lines
	ExtractName(line string) (name string, succeeded bool)

	// ExtractResult extracts the test result from a test output line
	ExtractResult(line string) (result api.TestResult, succeeded bool)

	// ExtractDuration extracts the test duration from a test output line
	ExtractDuration(line string) (duration string, succeeded bool)

	// ExtractMessage extracts a message (e.g. for signalling why a failure or skip occurred) from a test output line
	ExtractMessage(line string) (message string, succeeded bool)

	// MarksCompletion determines if the line marks the completion of a test case
	MarksCompletion(line string) bool
}

// TestSuiteDataParser knows how to take raw test suite data and extract the useful information from it
type TestSuiteDataParser interface {
	// MarksBeginning determines if the line marks the beginning of a test suite
	MarksBeginning(line string) bool

	// ExtractName extracts the name of the test suite from a test output line
	ExtractName(line string) (name string, succeeded bool)

	// ExtractProperties extracts any metadata properties of the test suite from a test output line
	ExtractProperties(line string) (properties map[string]string, succeeded bool)

	// MarksCompletion determines if the line marks the completion of a test suite
	MarksCompletion(line string) bool
}
