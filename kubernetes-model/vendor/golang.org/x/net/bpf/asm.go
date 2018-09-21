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

package bpf

import "fmt"

// Assemble converts insts into raw instructions suitable for loading
// into a BPF virtual machine.
//
// Currently, no optimization is attempted, the assembled program flow
// is exactly as provided.
func Assemble(insts []Instruction) ([]RawInstruction, error) {
	ret := make([]RawInstruction, len(insts))
	var err error
	for i, inst := range insts {
		ret[i], err = inst.Assemble()
		if err != nil {
			return nil, fmt.Errorf("assembling instruction %d: %s", i+1, err)
		}
	}
	return ret, nil
}

// Disassemble attempts to parse raw back into
// Instructions. Unrecognized RawInstructions are assumed to be an
// extension not implemented by this package, and are passed through
// unchanged to the output. The allDecoded value reports whether insts
// contains no RawInstructions.
func Disassemble(raw []RawInstruction) (insts []Instruction, allDecoded bool) {
	insts = make([]Instruction, len(raw))
	allDecoded = true
	for i, r := range raw {
		insts[i] = r.Disassemble()
		if _, ok := insts[i].(RawInstruction); ok {
			allDecoded = false
		}
	}
	return insts, allDecoded
}
