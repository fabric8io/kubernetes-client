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
package links

import "regexp"

// Matches URL+rel links defined by https://tools.ietf.org/html/rfc5988
// Examples header values:
//   <http://www.example.com/foo?page=3>; rel="next"
//   <http://www.example.com/foo?page=3>; rel="next", <http://www.example.com/foo?page=1>; rel="prev"
var linkRegex = regexp.MustCompile(`\<(.+?)\>\s*;\s*rel="(.+?)"(?:\s*,\s*)?`)

// ParseLinks extracts link relations from the given header value.
func ParseLinks(header string) map[string]string {
	links := map[string]string{}
	if len(header) == 0 {
		return links
	}

	matches := linkRegex.FindAllStringSubmatch(header, -1)
	for _, match := range matches {
		url := match[1]
		rel := match[2]
		links[rel] = url
	}
	return links
}
