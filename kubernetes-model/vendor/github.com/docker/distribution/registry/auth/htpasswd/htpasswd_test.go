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
package htpasswd

import (
	"fmt"
	"reflect"
	"strings"
	"testing"
)

func TestParseHTPasswd(t *testing.T) {

	for _, tc := range []struct {
		desc    string
		input   string
		err     error
		entries map[string][]byte
	}{
		{
			desc: "basic example",
			input: `
# This is a comment in a basic example.
bilbo:{SHA}5siv5c0SHx681xU6GiSx9ZQryqs=
frodo:$2y$05$926C3y10Quzn/LnqQH86VOEVh/18T6RnLaS.khre96jLNL/7e.K5W
MiShil:$2y$05$0oHgwMehvoe8iAWS8I.7l.KoECXrwVaC16RPfaSCU5eVTFrATuMI2
DeokMan:공주님
`,
			entries: map[string][]byte{
				"bilbo":   []byte("{SHA}5siv5c0SHx681xU6GiSx9ZQryqs="),
				"frodo":   []byte("$2y$05$926C3y10Quzn/LnqQH86VOEVh/18T6RnLaS.khre96jLNL/7e.K5W"),
				"MiShil":  []byte("$2y$05$0oHgwMehvoe8iAWS8I.7l.KoECXrwVaC16RPfaSCU5eVTFrATuMI2"),
				"DeokMan": []byte("공주님"),
			},
		},
		{
			desc: "ensures comments are filtered",
			input: `
# asdf:asdf
`,
		},
		{
			desc: "ensure midline hash is not comment",
			input: `
asdf:as#df
`,
			entries: map[string][]byte{
				"asdf": []byte("as#df"),
			},
		},
		{
			desc: "ensure midline hash is not comment",
			input: `
# A valid comment
valid:entry
asdf
`,
			err: fmt.Errorf(`htpasswd: invalid entry at line 4: "asdf"`),
		},
	} {

		entries, err := parseHTPasswd(strings.NewReader(tc.input))
		if err != tc.err {
			if tc.err == nil {
				t.Fatalf("%s: unexpected error: %v", tc.desc, err)
			} else {
				if err.Error() != tc.err.Error() { // use string equality here.
					t.Fatalf("%s: expected error not returned: %v != %v", tc.desc, err, tc.err)
				}
			}
		}

		if tc.err != nil {
			continue // don't test output
		}

		// allow empty and nil to be equal
		if tc.entries == nil {
			tc.entries = map[string][]byte{}
		}

		if !reflect.DeepEqual(entries, tc.entries) {
			t.Fatalf("%s: entries not parsed correctly: %v != %v", tc.desc, entries, tc.entries)
		}
	}

}
