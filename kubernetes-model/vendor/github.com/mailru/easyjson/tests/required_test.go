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
package tests

import (
	"fmt"
	"testing"
)

func TestRequiredField(t *testing.T) {
	cases := []struct{ json, errorMessage string }{
		{`{"first_name":"Foo", "last_name": "Bar"}`, ""},
		{`{"last_name":"Bar"}`, "key 'first_name' is required"},
		{"{}", "key 'first_name' is required"},
	}

	for _, tc := range cases {
		var v RequiredOptionalStruct
		err := v.UnmarshalJSON([]byte(tc.json))
		if tc.errorMessage == "" {
			if err != nil {
				t.Errorf("%s. UnmarshalJSON didn`t expect error: %v", tc.json, err)
			}
		} else {
			if fmt.Sprintf("%v", err) != tc.errorMessage {
				t.Errorf("%s. UnmarshalJSON expected error: %v. got: %v", tc.json, tc.errorMessage, err)
			}
		}
	}
}
