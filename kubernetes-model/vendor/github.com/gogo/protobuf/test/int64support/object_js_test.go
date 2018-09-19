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
package int64support

import (
	"encoding/json"
	"testing"
)

func TestMarshaler(t *testing.T) {
	n := int64(1)
	b, err := json.Marshal(&Object{&n})
	if err != nil {
		t.Fatal(err)
	}
	const expected = "{\"optional_number\":1}"
	if string(b) != expected {
		t.Fatalf("expected '%s' instead of '%s'", expected, string(b))
	}

	b, err = json.Marshal(new(Object))
	if err != nil {
		t.Fatal(err)
	}
	const expected2 = "{}"
	if string(b) != expected2 {
		t.Fatalf("expected '%s' instead of '%s'", expected2, string(b))
	}
}

func TestUnmarshaler(t *testing.T) {
	o := new(Object)
	err := json.Unmarshal(([]byte)("{\"optional_number\": 1}"), o)
	if err != nil {
		t.Fatal(err)
	}
	if n := o.GetOptionalNumber(); n != 1 {
		t.Fatalf("expected 1 instead of %d", n)
	}

	o = new(Object)
	err = json.Unmarshal(([]byte)("{}"), o)
	if err != nil {
		t.Fatal(err)
	}
	if o.OptionalNumber != nil {
		t.Fatalf("expected nil OptionalNumber instead of %d", *o.OptionalNumber)
	}
}
