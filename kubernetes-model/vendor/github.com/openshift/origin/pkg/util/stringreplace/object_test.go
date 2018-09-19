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
package stringreplace

import (
	"fmt"
	"reflect"
	"testing"
)

type sampleInnerStruct struct {
	Name   string
	Number int
	List   []string
	Map    map[string]string
}

type sampleStruct struct {
	Name         string
	Inner        sampleInnerStruct
	Ptr          *sampleInnerStruct
	MapInMap     map[string]map[string]string
	ArrayInArray [][]string
	Array        []string
	ArrayInMap   map[string][]interface{}
}

func TestVisitObjectStringsOnStruct(t *testing.T) {
	samples := [][]sampleStruct{
		{{}, {}},
		{{Name: "Foo"}, {Name: "sample-Foo"}},
		{{Ptr: nil}, {Ptr: nil}},
		{{Ptr: &sampleInnerStruct{Name: "foo"}}, {Ptr: &sampleInnerStruct{Name: "sample-foo"}}},
		{{Inner: sampleInnerStruct{Name: "foo"}}, {Inner: sampleInnerStruct{Name: "sample-foo"}}},
		{{Array: []string{"foo", "bar"}}, {Array: []string{"sample-foo", "sample-bar"}}},
		{
			{
				MapInMap: map[string]map[string]string{
					"foo": {"bar": "test"},
				},
			},
			{
				MapInMap: map[string]map[string]string{
					"sample-foo": {"sample-bar": "sample-test"},
				},
			},
		},
		{
			{ArrayInArray: [][]string{{"foo", "bar"}}},
			{ArrayInArray: [][]string{{"sample-foo", "sample-bar"}}},
		},
		{
			{ArrayInMap: map[string][]interface{}{"key": {"foo", "bar"}}},
			{ArrayInMap: map[string][]interface{}{"sample-key": {"sample-foo", "sample-bar"}}},
		},
	}
	for i := range samples {
		VisitObjectStrings(&samples[i][0], func(in string) (string, bool) {
			if len(in) == 0 {
				return in, true
			}
			return fmt.Sprintf("sample-%s", in), true
		})
		if !reflect.DeepEqual(samples[i][0], samples[i][1]) {
			t.Errorf("[%d] Got:\n%#v\nExpected:\n%#v", i, samples[i][0], samples[i][1])
		}
	}
}

func TestVisitObjectStringsOnMap(t *testing.T) {
	samples := [][]map[string]string{
		{
			{"foo": "bar"},
			{"sample-foo": "sample-bar"},
		},
		{
			{"empty": ""},
			{"sample-empty": "sample-"},
		},
		{
			{"": "invalid"},
			{"sample-": "sample-invalid"},
		},
	}

	for i := range samples {
		VisitObjectStrings(&samples[i][0], func(in string) (string, bool) {
			return fmt.Sprintf("sample-%s", in), true
		})
		if !reflect.DeepEqual(samples[i][0], samples[i][1]) {
			t.Errorf("Got %#v, expected %#v", samples[i][0], samples[i][1])
		}
	}
}

func TestVisitObjectStringsOnArray(t *testing.T) {
	samples := [][][]string{
		{
			{"foo", "bar"},
			{"sample-foo", "sample-bar"},
		},
	}

	for i := range samples {
		VisitObjectStrings(&samples[i][0], func(in string) (string, bool) {
			return fmt.Sprintf("sample-%s", in), true
		})
		if !reflect.DeepEqual(samples[i][0], samples[i][1]) {
			t.Errorf("Got %#v, expected %#v", samples[i][0], samples[i][1])
		}
	}
}
