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
package topk

import (
	"fmt"
	"math/rand"
	"sort"
	"testing"
)

func TestTopK(t *testing.T) {
	stream := New(10)
	ss := []*Stream{New(10), New(10), New(10)}
	m := make(map[string]int)
	for _, s := range ss {
		for i := 0; i < 1e6; i++ {
			v := fmt.Sprintf("%x", int8(rand.ExpFloat64()))
			s.Insert(v)
			m[v]++
		}
		stream.Merge(s.Query())
	}

	var sm Samples
	for x, s := range m {
		sm = append(sm, &Element{x, s})
	}
	sort.Sort(sort.Reverse(sm))

	g := stream.Query()
	if len(g) != 10 {
		t.Fatalf("got %d, want 10", len(g))
	}
	for i, e := range g {
		if sm[i].Value != e.Value {
			t.Errorf("at %d: want %q, got %q", i, sm[i].Value, e.Value)
		}
	}
}

func TestQuery(t *testing.T) {
	queryTests := []struct {
		value string
		expected int
	}{
		{"a", 1},
		{"b", 2},
		{"c", 2},
	}

	stream := New(2)
	for _, tt := range queryTests {
		stream.Insert(tt.value)
		if n := len(stream.Query()); n != tt.expected {
			t.Errorf("want %d, got %d", tt.expected, n)
		}
	}
}
