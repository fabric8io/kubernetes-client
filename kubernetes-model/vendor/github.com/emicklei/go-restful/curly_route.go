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
package restful

// Copyright 2013 Ernest Micklei. All rights reserved.
// Use of this source code is governed by a license
// that can be found in the LICENSE file.

// curlyRoute exits for sorting Routes by the CurlyRouter based on number of parameters and number of static path elements.
type curlyRoute struct {
	route       Route
	paramCount  int
	staticCount int
}

type sortableCurlyRoutes []curlyRoute

func (s *sortableCurlyRoutes) add(route curlyRoute) {
	*s = append(*s, route)
}

func (s sortableCurlyRoutes) routes() (routes []Route) {
	for _, each := range s {
		routes = append(routes, each.route) // TODO change return type
	}
	return routes
}

func (s sortableCurlyRoutes) Len() int {
	return len(s)
}
func (s sortableCurlyRoutes) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}
func (s sortableCurlyRoutes) Less(i, j int) bool {
	ci := s[i]
	cj := s[j]

	// primary key
	if ci.staticCount < cj.staticCount {
		return true
	}
	if ci.staticCount > cj.staticCount {
		return false
	}
	// secundary key
	if ci.paramCount < cj.paramCount {
		return true
	}
	if ci.paramCount > cj.paramCount {
		return false
	}
	return ci.route.Path < cj.route.Path
}
