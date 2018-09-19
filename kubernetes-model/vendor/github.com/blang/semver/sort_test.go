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
package semver

import (
	"reflect"
	"testing"
)

func TestSort(t *testing.T) {
	v100, _ := Parse("1.0.0")
	v010, _ := Parse("0.1.0")
	v001, _ := Parse("0.0.1")
	versions := []Version{v010, v100, v001}
	Sort(versions)

	correct := []Version{v001, v010, v100}
	if !reflect.DeepEqual(versions, correct) {
		t.Fatalf("Sort returned wrong order: %s", versions)
	}
}

func BenchmarkSort(b *testing.B) {
	v100, _ := Parse("1.0.0")
	v010, _ := Parse("0.1.0")
	v001, _ := Parse("0.0.1")
	b.ReportAllocs()
	b.ResetTimer()
	for n := 0; n < b.N; n++ {
		Sort([]Version{v010, v100, v001})
	}
}
