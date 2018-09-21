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
package quantile

import (
	"testing"
)

func BenchmarkInsertTargeted(b *testing.B) {
	b.ReportAllocs()

	s := NewTargeted(Targets)
	b.ResetTimer()
	for i := float64(0); i < float64(b.N); i++ {
		s.Insert(i)
	}
}

func BenchmarkInsertTargetedSmallEpsilon(b *testing.B) {
	s := NewTargeted(TargetsSmallEpsilon)
	b.ResetTimer()
	for i := float64(0); i < float64(b.N); i++ {
		s.Insert(i)
	}
}

func BenchmarkInsertBiased(b *testing.B) {
	s := NewLowBiased(0.01)
	b.ResetTimer()
	for i := float64(0); i < float64(b.N); i++ {
		s.Insert(i)
	}
}

func BenchmarkInsertBiasedSmallEpsilon(b *testing.B) {
	s := NewLowBiased(0.0001)
	b.ResetTimer()
	for i := float64(0); i < float64(b.N); i++ {
		s.Insert(i)
	}
}

func BenchmarkQuery(b *testing.B) {
	s := NewTargeted(Targets)
	for i := float64(0); i < 1e6; i++ {
		s.Insert(i)
	}
	b.ResetTimer()
	n := float64(b.N)
	for i := float64(0); i < n; i++ {
		s.Query(i / n)
	}
}

func BenchmarkQuerySmallEpsilon(b *testing.B) {
	s := NewTargeted(TargetsSmallEpsilon)
	for i := float64(0); i < 1e6; i++ {
		s.Insert(i)
	}
	b.ResetTimer()
	n := float64(b.N)
	for i := float64(0); i < n; i++ {
		s.Query(i / n)
	}
}
