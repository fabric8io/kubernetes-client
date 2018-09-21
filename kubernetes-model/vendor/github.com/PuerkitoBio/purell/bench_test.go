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
	"testing"
)

var (
	safeUrl        = "HttPS://..iaMHost..Test:443/paTh^A%ef//./%41PaTH/..//?"
	usuallySafeUrl = "HttPS://..iaMHost..Test:443/paTh^A%ef//./%41PaTH/../final/"
	unsafeUrl      = "HttPS://..www.iaMHost..Test:443/paTh^A%ef//./%41PaTH/../final/index.html?t=val1&a=val4&z=val5&a=val1#fragment"
	allDWORDUrl    = "HttPS://1113982867:/paTh^A%ef//./%41PaTH/../final/index.html?t=val1&a=val4&z=val5&a=val1#fragment"
	allOctalUrl    = "HttPS://0102.0146.07.0223:/paTh^A%ef//./%41PaTH/../final/index.html?t=val1&a=val4&z=val5&a=val1#fragment"
	allHexUrl      = "HttPS://0x42660793:/paTh^A%ef//./%41PaTH/../final/index.html?t=val1&a=val4&z=val5&a=val1#fragment"
	allCombinedUrl = "HttPS://..0x42660793.:/paTh^A%ef//./%41PaTH/../final/index.html?t=val1&a=val4&z=val5&a=val1#fragment"
)

func BenchmarkSafe(b *testing.B) {
	for i := 0; i < b.N; i++ {
		NormalizeURLString(safeUrl, FlagsSafe)
	}
}

func BenchmarkUsuallySafe(b *testing.B) {
	for i := 0; i < b.N; i++ {
		NormalizeURLString(usuallySafeUrl, FlagsUsuallySafeGreedy)
	}
}

func BenchmarkUnsafe(b *testing.B) {
	for i := 0; i < b.N; i++ {
		NormalizeURLString(unsafeUrl, FlagsUnsafeGreedy)
	}
}

func BenchmarkAllDWORD(b *testing.B) {
	for i := 0; i < b.N; i++ {
		NormalizeURLString(allDWORDUrl, FlagsAllGreedy)
	}
}

func BenchmarkAllOctal(b *testing.B) {
	for i := 0; i < b.N; i++ {
		NormalizeURLString(allOctalUrl, FlagsAllGreedy)
	}
}

func BenchmarkAllHex(b *testing.B) {
	for i := 0; i < b.N; i++ {
		NormalizeURLString(allHexUrl, FlagsAllGreedy)
	}
}

func BenchmarkAllCombined(b *testing.B) {
	for i := 0; i < b.N; i++ {
		NormalizeURLString(allCombinedUrl, FlagsAllGreedy)
	}
}
