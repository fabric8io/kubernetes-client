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
package buffer

import (
	"bytes"
	"testing"
)

func TestAppendByte(t *testing.T) {
	var b Buffer
	var want []byte

	for i := 0; i < 1000; i++ {
		b.AppendByte(1)
		b.AppendByte(2)
		want = append(want, 1, 2)
	}

	got := b.BuildBytes()
	if !bytes.Equal(got, want) {
		t.Errorf("BuildBytes() = %v; want %v", got, want)
	}
}

func TestAppendBytes(t *testing.T) {
	var b Buffer
	var want []byte

	for i := 0; i < 1000; i++ {
		b.AppendBytes([]byte{1, 2})
		want = append(want, 1, 2)
	}

	got := b.BuildBytes()
	if !bytes.Equal(got, want) {
		t.Errorf("BuildBytes() = %v; want %v", got, want)
	}
}

func TestAppendString(t *testing.T) {
	var b Buffer
	var want []byte

	s := "test"
	for i := 0; i < 1000; i++ {
		b.AppendBytes([]byte(s))
		want = append(want, s...)
	}

	got := b.BuildBytes()
	if !bytes.Equal(got, want) {
		t.Errorf("BuildBytes() = %v; want %v", got, want)
	}
}

func TestDumpTo(t *testing.T) {
	var b Buffer
	var want []byte

	s := "test"
	for i := 0; i < 1000; i++ {
		b.AppendBytes([]byte(s))
		want = append(want, s...)
	}

	out := &bytes.Buffer{}
	n, err := b.DumpTo(out)
	if err != nil {
		t.Errorf("DumpTo() error: %v", err)
	}

	got := out.Bytes()
	if !bytes.Equal(got, want) {
		t.Errorf("DumpTo(): got %v; want %v", got, want)
	}

	if n != len(want) {
		t.Errorf("DumpTo() = %v; want %v", n, len(want))
	}
}

func TestReadCloser(t *testing.T) {
	var b Buffer
	var want []byte

	s := "test"
	for i := 0; i < 1000; i++ {
		b.AppendBytes([]byte(s))
		want = append(want, s...)
	}

	out := &bytes.Buffer{}
	rc := b.ReadCloser()
	n, err := out.ReadFrom(rc)
	if err != nil {
		t.Errorf("ReadCloser() error: %v", err)
	}
	rc.Close() // Will always return nil

	got := out.Bytes()
	if !bytes.Equal(got, want) {
		t.Errorf("DumpTo(): got %v; want %v", got, want)
	}

	if n != int64(len(want)) {
		t.Errorf("DumpTo() = %v; want %v", n, len(want))
	}
}
