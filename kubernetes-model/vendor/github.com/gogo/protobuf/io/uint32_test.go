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
package io_test

import (
	"encoding/binary"
	"io/ioutil"
	"math/rand"
	"testing"
	"time"

	"github.com/gogo/protobuf/test"
	example "github.com/gogo/protobuf/test/example"

	"github.com/gogo/protobuf/io"
)

func BenchmarkUint32DelimWriterMarshaller(b *testing.B) {
	w := io.NewUint32DelimitedWriter(ioutil.Discard, binary.BigEndian)
	r := rand.New(rand.NewSource(time.Now().UnixNano()))
	msg := example.NewPopulatedA(r, true)

	for i := 0; i < b.N; i++ {
		if err := w.WriteMsg(msg); err != nil {
			b.Fatal(err)
		}
	}
}

func BenchmarkUint32DelimWriterFallback(b *testing.B) {
	w := io.NewUint32DelimitedWriter(ioutil.Discard, binary.BigEndian)
	r := rand.New(rand.NewSource(time.Now().UnixNano()))
	msg := test.NewPopulatedNinOptNative(r, true)

	for i := 0; i < b.N; i++ {
		if err := w.WriteMsg(msg); err != nil {
			b.Fatal(err)
		}
	}
}
