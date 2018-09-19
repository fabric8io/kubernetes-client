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

package bpf_test

import (
	"testing"

	"golang.org/x/net/bpf"
)

func TestVMRetA(t *testing.T) {
	vm, done, err := testVM(t, []bpf.Instruction{
		bpf.LoadAbsolute{
			Off:  8,
			Size: 1,
		},
		bpf.RetA{},
	})
	if err != nil {
		t.Fatalf("failed to load BPF program: %v", err)
	}
	defer done()

	out, err := vm.Run([]byte{
		0xff, 0xff, 0xff, 0xff,
		0xff, 0xff, 0xff, 0xff,
		9,
	})
	if err != nil {
		t.Fatalf("unexpected error while running program: %v", err)
	}
	if want, got := 1, out; want != got {
		t.Fatalf("unexpected number of output bytes:\n- want: %d\n-  got: %d",
			want, got)
	}
}

func TestVMRetALargerThanInput(t *testing.T) {
	vm, done, err := testVM(t, []bpf.Instruction{
		bpf.LoadAbsolute{
			Off:  8,
			Size: 2,
		},
		bpf.RetA{},
	})
	if err != nil {
		t.Fatalf("failed to load BPF program: %v", err)
	}
	defer done()

	out, err := vm.Run([]byte{
		0xff, 0xff, 0xff, 0xff,
		0xff, 0xff, 0xff, 0xff,
		0, 255,
	})
	if err != nil {
		t.Fatalf("unexpected error while running program: %v", err)
	}
	if want, got := 2, out; want != got {
		t.Fatalf("unexpected number of output bytes:\n- want: %d\n-  got: %d",
			want, got)
	}
}

func TestVMRetConstant(t *testing.T) {
	vm, done, err := testVM(t, []bpf.Instruction{
		bpf.RetConstant{
			Val: 9,
		},
	})
	if err != nil {
		t.Fatalf("failed to load BPF program: %v", err)
	}
	defer done()

	out, err := vm.Run([]byte{
		0xff, 0xff, 0xff, 0xff,
		0xff, 0xff, 0xff, 0xff,
		0, 1,
	})
	if err != nil {
		t.Fatalf("unexpected error while running program: %v", err)
	}
	if want, got := 1, out; want != got {
		t.Fatalf("unexpected number of output bytes:\n- want: %d\n-  got: %d",
			want, got)
	}
}

func TestVMRetConstantLargerThanInput(t *testing.T) {
	vm, done, err := testVM(t, []bpf.Instruction{
		bpf.RetConstant{
			Val: 16,
		},
	})
	if err != nil {
		t.Fatalf("failed to load BPF program: %v", err)
	}
	defer done()

	out, err := vm.Run([]byte{
		0xff, 0xff, 0xff, 0xff,
		0xff, 0xff, 0xff, 0xff,
		0, 1,
	})
	if err != nil {
		t.Fatalf("unexpected error while running program: %v", err)
	}
	if want, got := 2, out; want != got {
		t.Fatalf("unexpected number of output bytes:\n- want: %d\n-  got: %d",
			want, got)
	}
}
