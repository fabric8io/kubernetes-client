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
package cmd

import (
	"bytes"
	"encoding/xml"
	"fmt"
	"io"

	"github.com/openshift/origin/tools/junitreport/pkg/api"
)

// Summarize reads the input into a TestSuites structure and summarizes the tests contained within,
// bringing attention to tests that did not succeed.
func Summarize(input io.Reader) (string, error) {
	var testSuites api.TestSuites
	if err := xml.NewDecoder(input).Decode(&testSuites); err != nil {
		return "", err
	}

	var summary bytes.Buffer
	var numTests, numFailed, numSkipped uint
	var duration float64
	for _, testSuite := range testSuites.Suites {
		numTests += testSuite.NumTests
		numFailed += testSuite.NumFailed
		numSkipped += testSuite.NumSkipped
		duration += testSuite.Duration
	}

	verb := "were"
	if numSkipped == 1 {
		verb = "was"
	}
	summary.WriteString(fmt.Sprintf("Of %d tests executed in %.3fs, %d succeeded, %d failed, and %d %s skipped.\n\n", numTests, duration, (numTests - numFailed - numSkipped), numFailed, numSkipped, verb))

	for _, testSuite := range testSuites.Suites {
		summarizeTests(testSuite, &summary)
	}

	return summary.String(), nil
}

func summarizeTests(testSuite *api.TestSuite, summary *bytes.Buffer) {
	for _, testCase := range testSuite.TestCases {
		if testCase.FailureOutput != nil {
			summary.WriteString(fmt.Sprintf("In suite %q, test case %q failed:\n%s\n\n", testSuite.Name, testCase.Name, testCase.FailureOutput.Output))
		}
		if testCase.SkipMessage != nil {
			summary.WriteString(fmt.Sprintf("In suite %q, test case %q was skipped:\n%s\n\n", testSuite.Name, testCase.Name, testCase.SkipMessage.Message))
		}
	}

	for _, childSuite := range testSuite.Children {
		summarizeTests(childSuite, summary)
	}
}
