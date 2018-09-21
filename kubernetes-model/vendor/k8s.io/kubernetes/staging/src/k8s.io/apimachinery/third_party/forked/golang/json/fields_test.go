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
package json

import (
	"reflect"
	"testing"
)

func TestLookupPtrToStruct(t *testing.T) {
	type Elem struct {
		Key   string
		Value string
	}
	type Outer struct {
		Inner []Elem `json:"inner" patchStrategy:"merge" patchMergeKey:"key"`
	}
	outer := &Outer{}
	elemType, patchStrategies, patchMergeKey, err := LookupPatchMetadataForStruct(reflect.TypeOf(outer), "inner")
	if err != nil {
		t.Fatal(err)
	}
	if elemType != reflect.TypeOf([]Elem{}) {
		t.Errorf("elemType = %v, want: %v", elemType, reflect.TypeOf([]Elem{}))
	}
	if !reflect.DeepEqual(patchStrategies, []string{"merge"}) {
		t.Errorf("patchStrategies = %v, want: %v", patchStrategies, []string{"merge"})
	}
	if patchMergeKey != "key" {
		t.Errorf("patchMergeKey = %v, want: %v", patchMergeKey, "key")
	}
}
