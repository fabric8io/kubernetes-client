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
package example

/* Used to generate output for testing

import (
	"fmt"
	"testing"
)

func TestSubTestWithFailures(t *testing.T) {
	t.Run("subtest-pass-1", func(t *testing.T) {})
	t.Run("subtest-pass-2", func(t *testing.T) {})
	t.Run("subtest-fail-1", func(t *testing.T) { fmt.Printf("text line\n"); t.Logf("log line"); t.Errorf("failed") })
}

func TestSubTestWithFirstFailures(t *testing.T) {
	t.Run("subtest-fail-1", func(t *testing.T) { fmt.Printf("text line\n"); t.Logf("log line"); t.Errorf("failed") })
	t.Run("subtest-pass-1", func(t *testing.T) {})
	t.Run("subtest-pass-2", func(t *testing.T) {})
}

func TestSubTestWithSubTestFailures(t *testing.T) {
	t.Run("subtest-pass-1", func(t *testing.T) {})
	t.Run("subtest-pass-2", func(t *testing.T) {})
	t.Run("subtest-fail-1", func(t *testing.T) {
		fmt.Printf("text line\n")
		t.Logf("log line before")
		t.Run("sub-subtest-pass-1", func(t *testing.T) {})
		t.Run("sub-subtest-pass-2", func(t *testing.T) {})
		t.Run("sub-subtest-fail-1", func(t *testing.T) { fmt.Printf("text line\n"); t.Logf("log line"); t.Errorf("failed") })
		t.Logf("log line after")
	})
}

func TestSubTestWithMiddleFailures(t *testing.T) {
	t.Run("subtest-pass-1", func(t *testing.T) {})
	t.Run("subtest-fail-1", func(t *testing.T) { fmt.Printf("text line\n"); t.Logf("log line"); t.Errorf("failed") })
	t.Run("subtest-pass-2", func(t *testing.T) {})
}
*/
