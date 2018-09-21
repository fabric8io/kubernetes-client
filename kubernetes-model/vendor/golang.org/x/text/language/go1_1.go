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
// Copyright 2013 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// +build !go1.2

package language

import "sort"

func sortStable(s sort.Interface) {
	ss := stableSort{
		s:   s,
		pos: make([]int, s.Len()),
	}
	for i := range ss.pos {
		ss.pos[i] = i
	}
	sort.Sort(&ss)
}

type stableSort struct {
	s   sort.Interface
	pos []int
}

func (s *stableSort) Len() int {
	return len(s.pos)
}

func (s *stableSort) Less(i, j int) bool {
	return s.s.Less(i, j) || !s.s.Less(j, i) && s.pos[i] < s.pos[j]
}

func (s *stableSort) Swap(i, j int) {
	s.s.Swap(i, j)
	s.pos[i], s.pos[j] = s.pos[j], s.pos[i]
}
