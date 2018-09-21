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
// Copyright 2015 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

//go:generate go run gen.go

// Package internal contains non-exported functionality that are used by
// packages in the text repository.
package internal // import "golang.org/x/text/internal"

import (
	"sort"

	"golang.org/x/text/language"
)

// SortTags sorts tags in place.
func SortTags(tags []language.Tag) {
	sort.Sort(sorter(tags))
}

type sorter []language.Tag

func (s sorter) Len() int {
	return len(s)
}

func (s sorter) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func (s sorter) Less(i, j int) bool {
	return s[i].String() < s[j].String()
}

// UniqueTags sorts and filters duplicate tags in place and returns a slice with
// only unique tags.
func UniqueTags(tags []language.Tag) []language.Tag {
	if len(tags) <= 1 {
		return tags
	}
	SortTags(tags)
	k := 0
	for i := 1; i < len(tags); i++ {
		if tags[k].String() < tags[i].String() {
			k++
			tags[k] = tags[i]
		}
	}
	return tags[:k+1]
}
