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
package purell

import (
	"fmt"
	"net/url"
)

func ExampleNormalizeURLString() {
	if normalized, err := NormalizeURLString("hTTp://someWEBsite.com:80/Amazing%3f/url/",
		FlagLowercaseScheme|FlagLowercaseHost|FlagUppercaseEscapes); err != nil {
		panic(err)
	} else {
		fmt.Print(normalized)
	}
	// Output: http://somewebsite.com:80/Amazing%3F/url/
}

func ExampleMustNormalizeURLString() {
	normalized := MustNormalizeURLString("hTTpS://someWEBsite.com:443/Amazing%fa/url/",
		FlagsUnsafeGreedy)
	fmt.Print(normalized)

	// Output: http://somewebsite.com/Amazing%FA/url
}

func ExampleNormalizeURL() {
	if u, err := url.Parse("Http://SomeUrl.com:8080/a/b/.././c///g?c=3&a=1&b=9&c=0#target"); err != nil {
		panic(err)
	} else {
		normalized := NormalizeURL(u, FlagsUsuallySafeGreedy|FlagRemoveDuplicateSlashes|FlagRemoveFragment)
		fmt.Print(normalized)
	}

	// Output: http://someurl.com:8080/a/c/g?c=3&a=1&b=9&c=0
}
