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
// This file is included to the build if any of the buildtags below
// are defined. Refer to README notes for more details.

//+build easyjson_nounsafe appengine

package jlexer

// bytesToStr creates a string normally from []byte
//
// Note that this method is roughly 1.5x slower than using the 'unsafe' method.
func bytesToStr(data []byte) string {
	return string(data)
}
