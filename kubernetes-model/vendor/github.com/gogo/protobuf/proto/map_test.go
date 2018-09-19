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
package proto_test

import (
	"fmt"
	"testing"

	"github.com/gogo/protobuf/proto"
	ppb "github.com/gogo/protobuf/proto/proto3_proto"
)

func marshalled() []byte {
	m := &ppb.IntMaps{}
	for i := 0; i < 1000; i++ {
		m.Maps = append(m.Maps, &ppb.IntMap{
			Rtt: map[int32]int32{1: 2},
		})
	}
	b, err := proto.Marshal(m)
	if err != nil {
		panic(fmt.Sprintf("Can't marshal %+v: %v", m, err))
	}
	return b
}

func BenchmarkConcurrentMapUnmarshal(b *testing.B) {
	in := marshalled()
	b.RunParallel(func(pb *testing.PB) {
		for pb.Next() {
			var out ppb.IntMaps
			if err := proto.Unmarshal(in, &out); err != nil {
				b.Errorf("Can't unmarshal ppb.IntMaps: %v", err)
			}
		}
	})
}

func BenchmarkSequentialMapUnmarshal(b *testing.B) {
	in := marshalled()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		var out ppb.IntMaps
		if err := proto.Unmarshal(in, &out); err != nil {
			b.Errorf("Can't unmarshal ppb.IntMaps: %v", err)
		}
	}
}
