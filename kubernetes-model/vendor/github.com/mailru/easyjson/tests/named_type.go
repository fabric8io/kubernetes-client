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

//easyjson:json
type NamedType struct {
	Inner struct {
		// easyjson is mistakenly naming the type of this field 'tests.MyString' in the generated output
		// something about a named type inside an anonmymous type is triggering this bug
		Field  MyString `tag:"value"`
		Field2 int      "tag:\"value with ` in it\""
	}
}

type MyString string

var namedTypeValue NamedType

func init() {
	namedTypeValue.Inner.Field = "test"
	namedTypeValue.Inner.Field2 = 123
}

var namedTypeValueString = `{"Inner":{"Field":"test","Field2":123}}`
