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
package token

// StringSet is a useful type for looking up strings.
type stringSet map[string]struct{}

// NewStringSet creates a new StringSet with the given strings.
func newStringSet(keys ...string) stringSet {
	ss := make(stringSet, len(keys))
	ss.add(keys...)
	return ss
}

// Add inserts the given keys into this StringSet.
func (ss stringSet) add(keys ...string) {
	for _, key := range keys {
		ss[key] = struct{}{}
	}
}

// Contains returns whether the given key is in this StringSet.
func (ss stringSet) contains(key string) bool {
	_, ok := ss[key]
	return ok
}

// Keys returns a slice of all keys in this StringSet.
func (ss stringSet) keys() []string {
	keys := make([]string, 0, len(ss))

	for key := range ss {
		keys = append(keys, key)
	}

	return keys
}
