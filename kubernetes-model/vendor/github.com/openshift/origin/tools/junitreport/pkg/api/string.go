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
package api

import "fmt"

// This file implements Stringer for the API types for ease of debugging

func (t *TestSuites) String() string {
	return fmt.Sprintf("Test Suites with suites: %s.", t.Suites)
}

func (t *TestSuite) String() string {
	childDescriptions := []string{}
	for _, child := range t.Children {
		childDescriptions = append(childDescriptions, child.String())
	}
	return fmt.Sprintf("Test Suite %q with properties: %s, %d test cases, of which %d failed and %d were skipped: %s, and children: %s.", t.Name, t.Properties, t.NumTests, t.NumFailed, t.NumSkipped, t.TestCases, childDescriptions)
}

func (t *TestCase) String() string {
	var result, message, output string
	result = "passed"
	if t.SkipMessage != nil {
		result = "skipped"
		message = t.SkipMessage.Message
	}
	if t.FailureOutput != nil {
		result = "failed"
		message = t.FailureOutput.Message
		output = t.FailureOutput.Output
	}

	return fmt.Sprintf("Test Case %q %s after %f seconds with message %q and output %q.", t.Name, result, t.Duration, message, output)
}

func (p *TestSuiteProperty) String() string {
	return fmt.Sprintf("%q=%q", p.Name, p.Value)
}
