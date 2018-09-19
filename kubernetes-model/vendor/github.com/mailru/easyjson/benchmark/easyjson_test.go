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
// +build use_easyjson

package benchmark

import (
	"testing"

	"github.com/mailru/easyjson"
	"github.com/mailru/easyjson/jwriter"
)

func BenchmarkEJ_Unmarshal_M(b *testing.B) {
	b.SetBytes(int64(len(largeStructText)))
	for i := 0; i < b.N; i++ {
		var s LargeStruct
		err := s.UnmarshalJSON(largeStructText)
		if err != nil {
			b.Error(err)
		}
	}
}

func BenchmarkEJ_Unmarshal_S(b *testing.B) {
	b.SetBytes(int64(len(smallStructText)))

	for i := 0; i < b.N; i++ {
		var s Entities
		err := s.UnmarshalJSON(smallStructText)
		if err != nil {
			b.Error(err)
		}
	}
}

func BenchmarkEJ_Marshal_M(b *testing.B) {
	var l int64
	for i := 0; i < b.N; i++ {
		data, err := easyjson.Marshal(&largeStructData)
		if err != nil {
			b.Error(err)
		}
		l = int64(len(data))
	}
	b.SetBytes(l)
}

func BenchmarkEJ_Marshal_L(b *testing.B) {
	var l int64
	for i := 0; i < b.N; i++ {
		data, err := easyjson.Marshal(&xlStructData)
		if err != nil {
			b.Error(err)
		}
		l = int64(len(data))
	}
	b.SetBytes(l)
}

func BenchmarkEJ_Marshal_L_ToWriter(b *testing.B) {
	var l int64
	out := &DummyWriter{}
	for i := 0; i < b.N; i++ {
		w := jwriter.Writer{}
		xlStructData.MarshalEasyJSON(&w)
		if w.Error != nil {
			b.Error(w.Error)
		}

		l = int64(w.Size())
		w.DumpTo(out)
	}
	b.SetBytes(l)

}
func BenchmarkEJ_Marshal_M_Parallel(b *testing.B) {
	b.SetBytes(int64(len(largeStructText)))

	b.RunParallel(func(pb *testing.PB) {
		for pb.Next() {
			_, err := largeStructData.MarshalJSON()
			if err != nil {
				b.Error(err)
			}
		}
	})
}

func BenchmarkEJ_Marshal_M_ToWriter(b *testing.B) {
	var l int64
	out := &DummyWriter{}
	for i := 0; i < b.N; i++ {
		w := jwriter.Writer{}
		largeStructData.MarshalEasyJSON(&w)
		if w.Error != nil {
			b.Error(w.Error)
		}

		l = int64(w.Size())
		w.DumpTo(out)
	}
	b.SetBytes(l)

}
func BenchmarkEJ_Marshal_M_ToWriter_Parallel(b *testing.B) {
	out := &DummyWriter{}

	b.RunParallel(func(pb *testing.PB) {
		var l int64
		for pb.Next() {
			w := jwriter.Writer{}
			largeStructData.MarshalEasyJSON(&w)
			if w.Error != nil {
				b.Error(w.Error)
			}

			l = int64(w.Size())
			w.DumpTo(out)
		}
		if l > 0 {
			b.SetBytes(l)
		}
	})

}

func BenchmarkEJ_Marshal_L_Parallel(b *testing.B) {
	var l int64
	b.RunParallel(func(pb *testing.PB) {
		for pb.Next() {
			data, err := xlStructData.MarshalJSON()
			if err != nil {
				b.Error(err)
			}
			l = int64(len(data))
		}
	})
	b.SetBytes(l)
}

func BenchmarkEJ_Marshal_L_ToWriter_Parallel(b *testing.B) {
	out := &DummyWriter{}
	b.RunParallel(func(pb *testing.PB) {
		var l int64
		for pb.Next() {
			w := jwriter.Writer{}

			xlStructData.MarshalEasyJSON(&w)
			if w.Error != nil {
				b.Error(w.Error)
			}
			l = int64(w.Size())
			w.DumpTo(out)
		}
		if l > 0 {
			b.SetBytes(l)
		}
	})
}

func BenchmarkEJ_Marshal_S(b *testing.B) {
	var l int64
	for i := 0; i < b.N; i++ {
		data, err := smallStructData.MarshalJSON()
		if err != nil {
			b.Error(err)
		}
		l = int64(len(data))
	}
	b.SetBytes(l)
}

func BenchmarkEJ_Marshal_S_Parallel(b *testing.B) {
	var l int64
	b.RunParallel(func(pb *testing.PB) {
		for pb.Next() {
			data, err := smallStructData.MarshalJSON()
			if err != nil {
				b.Error(err)
			}
			l = int64(len(data))
		}
	})
	b.SetBytes(l)
}
