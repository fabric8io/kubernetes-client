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

import "time"

// SetDuration sets the runtime duration of the test case
func (t *TestCase) SetDuration(duration string) error {
	parsedDuration, err := time.ParseDuration(duration)
	if err != nil {
		return err
	}

	// we round to the millisecond on duration
	t.Duration = float64(int(parsedDuration.Seconds()*1000)) / 1000
	return nil
}

// MarkSkipped marks the test as skipped with the given message
func (t *TestCase) MarkSkipped(message string) {
	t.SkipMessage = &SkipMessage{
		Message: message,
	}
}

// MarkFailed marks the test as failed with the given message and output
func (t *TestCase) MarkFailed(message, output string) {
	t.FailureOutput = &FailureOutput{
		Message: message,
		Output:  output,
	}
}
