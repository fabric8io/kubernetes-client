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
package util

import (
	"testing"
)

func TestRejectNonAbsolutePathsThatRequireBacksteps(t *testing.T) {
	path := "../foo"
	paths := []*string{}
	paths = append(paths, &path)

	expectedError := "../foo requires backsteps and is not absolute"

	if err := RelativizePathWithNoBacksteps(paths, "."); err == nil || expectedError != err.Error() {
		t.Errorf("expected %v, got %v", expectedError, err)
	}
}

func TestAcceptAbsolutePath(t *testing.T) {
	path := "/foo"
	paths := []*string{}
	paths = append(paths, &path)

	if err := RelativizePathWithNoBacksteps(paths, "/home/deads"); err != nil {
		t.Errorf("unexpected error: %v", err)
	}
}
