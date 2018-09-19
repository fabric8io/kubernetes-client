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
package ldaputil

import (
	"testing"

	"gopkg.in/ldap.v2"
)

func TestGetAttributeValue(t *testing.T) {

	testcases := map[string]struct {
		Entry         *ldap.Entry
		Attributes    []string
		ExpectedValue string
	}{
		"empty": {
			Attributes:    []string{},
			Entry:         &ldap.Entry{DN: "", Attributes: []*ldap.EntryAttribute{}},
			ExpectedValue: "",
		},

		"dn": {
			Attributes:    []string{"dn"},
			Entry:         &ldap.Entry{DN: "foo", Attributes: []*ldap.EntryAttribute{}},
			ExpectedValue: "foo",
		},
		"DN": {
			Attributes:    []string{"DN"},
			Entry:         &ldap.Entry{DN: "foo", Attributes: []*ldap.EntryAttribute{}},
			ExpectedValue: "foo",
		},

		"missing": {
			Attributes:    []string{"foo", "bar", "baz"},
			Entry:         &ldap.Entry{DN: "", Attributes: []*ldap.EntryAttribute{}},
			ExpectedValue: "",
		},

		"present": {
			Attributes: []string{"foo"},
			Entry: &ldap.Entry{DN: "", Attributes: []*ldap.EntryAttribute{
				{Name: "foo", Values: []string{"fooValue"}},
			}},
			ExpectedValue: "fooValue",
		},
		"first of multi-value attribute": {
			Attributes: []string{"foo"},
			Entry: &ldap.Entry{DN: "", Attributes: []*ldap.EntryAttribute{
				{Name: "foo", Values: []string{"fooValue", "fooValue2"}},
			}},
			ExpectedValue: "fooValue",
		},
		"first present attribute": {
			Attributes: []string{"foo", "bar", "baz"},
			Entry: &ldap.Entry{DN: "", Attributes: []*ldap.EntryAttribute{
				{Name: "foo", Values: []string{""}},
				{Name: "bar", Values: []string{"barValue"}},
				{Name: "baz", Values: []string{"bazValue"}},
			}},
			ExpectedValue: "barValue",
		},
	}

	for k, tc := range testcases {
		v := GetAttributeValue(tc.Entry, tc.Attributes)
		if v != tc.ExpectedValue {
			t.Errorf("%s: Expected %q, got %q", k, tc.ExpectedValue, v)
		}
	}

}
