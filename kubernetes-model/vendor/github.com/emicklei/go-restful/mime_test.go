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
	"fmt"
	"testing"
)

// go test -v -test.run TestSortMimes ...restful
func TestSortMimes(t *testing.T) {
	accept := "text/html; q=0.8, text/plain, image/gif,  */*; q=0.01, image/jpeg"
	result := sortedMimes(accept)
	got := fmt.Sprintf("%v", result)
	want := "[{text/plain 1} {image/gif 1} {image/jpeg 1} {text/html 0.8} {*/* 0.01}]"
	if got != want {
		t.Errorf("bad sort order of mime types:%s", got)
	}
}
