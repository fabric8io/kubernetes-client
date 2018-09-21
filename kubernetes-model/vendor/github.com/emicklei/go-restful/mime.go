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

import (
	"strconv"
	"strings"
)

type mime struct {
	media   string
	quality float64
}

// insertMime adds a mime to a list and keeps it sorted by quality.
func insertMime(l []mime, e mime) []mime {
	for i, each := range l {
		// if current mime has lower quality then insert before
		if e.quality > each.quality {
			left := append([]mime{}, l[0:i]...)
			return append(append(left, e), l[i:]...)
		}
	}
	return append(l, e)
}

// sortedMimes returns a list of mime sorted (desc) by its specified quality.
func sortedMimes(accept string) (sorted []mime) {
	for _, each := range strings.Split(accept, ",") {
		typeAndQuality := strings.Split(strings.Trim(each, " "), ";")
		if len(typeAndQuality) == 1 {
			sorted = insertMime(sorted, mime{typeAndQuality[0], 1.0})
		} else {
			// take factor
			parts := strings.Split(typeAndQuality[1], "=")
			if len(parts) == 2 {
				f, err := strconv.ParseFloat(parts[1], 64)
				if err != nil {
					traceLogger.Printf("unable to parse quality in %s, %v", each, err)
				} else {
					sorted = insertMime(sorted, mime{typeAndQuality[0], f})
				}
			}
		}
	}
	return
}
