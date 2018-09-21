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
// Copyright 2016 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package currency_test

import (
	"fmt"
	"time"

	"golang.org/x/text/currency"
)

func ExampleQuery() {
	t1799, _ := time.Parse("2006-01-02", "1799-01-01")
	for it := currency.Query(currency.Date(t1799)); it.Next(); {
		from := ""
		if t, ok := it.From(); ok {
			from = t.Format("2006-01-01")
		}
		fmt.Printf("%v is used in %v since: %v\n", it.Unit(), it.Region(), from)
	}
	// Output:
	// GBP is used in GB since: 1694-07-07
	// GIP is used in GI since: 1713-01-01
	// USD is used in US since: 1792-01-01
}
