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
package graphview

import (
	"sort"

	"k8s.io/apimachinery/pkg/util/sets"
)

type IntSet map[int]sets.Empty

// NewIntSet creates a IntSet from a list of values.
func NewIntSet(items ...int) IntSet {
	ss := IntSet{}
	ss.Insert(items...)
	return ss
}

// Insert adds items to the set.
func (s IntSet) Insert(items ...int) {
	for _, item := range items {
		s[item] = sets.Empty{}
	}
}

// Delete removes all items from the set.
func (s IntSet) Delete(items ...int) {
	for _, item := range items {
		delete(s, item)
	}
}

// Has returns true iff item is contained in the set.
func (s IntSet) Has(item int) bool {
	_, contained := s[item]
	return contained
}

// List returns the contents as a sorted string slice.
func (s IntSet) List() []int {
	res := make([]int, 0, len(s))
	for key := range s {
		res = append(res, key)
	}
	sort.IntSlice(res).Sort()
	return res
}
