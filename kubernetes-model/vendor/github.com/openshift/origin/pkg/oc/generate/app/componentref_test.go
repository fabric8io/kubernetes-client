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
package app

import (
	"testing"
)

func TestIsComponentReference(t *testing.T) {
	tests := map[string]struct {
		ref         string
		expectedErr string
	}{
		"empty string": {
			ref:         "",
			expectedErr: "empty string provided to component reference check",
		},
		"string with +": {
			ref: "foo+bar",
		},
		"image~code good": {
			ref: "foo~bar",
		},
		"image~code empty image name": {
			ref:         "~",
			expectedErr: "when using '[image]~[code]' form for \"~\", you must specify a image name",
		},
		"image~code empty seg 1 empty": {
			ref: "foo~",
		},
		"non image~code format": {
			ref: "foo",
		},
	}
	for name, test := range tests {
		err := IsComponentReference(test.ref)
		checkError(err, test.expectedErr, name, t)
	}
}
