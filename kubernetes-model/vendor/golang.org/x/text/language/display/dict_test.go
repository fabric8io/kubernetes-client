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

package display

import (
	"fmt"
	"testing"

	"golang.org/x/text/internal/testtext"
)

func TestLinking(t *testing.T) {
	base := getSize(t, `display.Tags(language.English).Name(language.English)`)
	compact := getSize(t, `display.English.Languages().Name(language.English)`)

	if d := base - compact; d < 1.5*1024*1024 {
		t.Errorf("size(base)-size(compact) was %d; want > 1.5MB", base, compact)
	}
}

func getSize(t *testing.T, main string) int {
	size, err := testtext.CodeSize(fmt.Sprintf(body, main))
	if err != nil {
		t.Skipf("skipping link size test; binary size could not be determined: %v", err)
	}
	return size
}

const body = `package main
import (
	"golang.org/x/text/language"
	"golang.org/x/text/language/display"
)
func main() {
	%s
}
`
