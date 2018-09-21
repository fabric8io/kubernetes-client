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
// +build go1.2

package inf

import (
	"encoding"
	"encoding/json"
	"testing"
)

var _ encoding.TextMarshaler = new(Dec)
var _ encoding.TextUnmarshaler = new(Dec)

type Obj struct {
	Val *Dec
}

func TestDecJsonMarshalUnmarshal(t *testing.T) {
	o := Obj{Val: NewDec(123, 2)}
	js, err := json.Marshal(o)
	if err != nil {
		t.Fatalf("json.Marshal(%v): got %v, want ok", o, err)
	}
	o2 := &Obj{}
	err = json.Unmarshal(js, o2)
	if err != nil {
		t.Fatalf("json.Unmarshal(%#q): got %v, want ok", js, err)
	}
	if o.Val.Scale() != o2.Val.Scale() ||
		o.Val.UnscaledBig().Cmp(o2.Val.UnscaledBig()) != 0 {
		t.Fatalf("json.Unmarshal(json.Marshal(%v)): want %v, got %v", o, o, o2)
	}
}
