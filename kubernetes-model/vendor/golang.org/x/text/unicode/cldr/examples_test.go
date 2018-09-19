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
package cldr_test

import (
	"fmt"

	"golang.org/x/text/unicode/cldr"
)

func ExampleSlice() {
	var dr *cldr.CLDR // assume this is initialized

	x, _ := dr.LDML("en")
	cs := x.Collations.Collation
	// remove all but the default
	cldr.MakeSlice(&cs).Filter(func(e cldr.Elem) bool {
		return e.GetCommon().Type != x.Collations.Default()
	})
	for i, c := range cs {
		fmt.Println(i, c.Type)
	}
}
