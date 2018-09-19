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

//go:generate go run gen.go gen_bits.go

// Package runenames provides rune names from the Unicode Character Database.
// For example, the name for '\u0100' is "LATIN CAPITAL LETTER A WITH MACRON".
//
// See http://www.unicode.org/Public/UCD/latest/ucd/UnicodeData.txt
package runenames

import (
	"sort"
)

// Name returns the name for r.
func Name(r rune) string {
	i := sort.Search(len(table0), func(j int) bool {
		e := table0[j]
		rOffset := rune(e >> shiftRuneOffset)
		return r < rOffset
	})
	if i == 0 {
		return ""
	}

	e := table0[i-1]
	rOffset := rune(e >> shiftRuneOffset)
	rLength := rune(e>>shiftRuneLength) & maskRuneLength
	if r >= rOffset+rLength {
		return ""
	}

	if (e>>shiftDirect)&maskDirect != 0 {
		o := int(e>>shiftDataOffset) & maskDataOffset
		n := int(e>>shiftDataLength) & maskDataLength
		return data[o : o+n]
	}

	base := uint32(e>>shiftDataBase) & maskDataBase
	base <<= dataBaseUnit
	j := rune(e>>shiftTable1Offset) & maskTable1Offset
	j += r - rOffset
	d0 := base + uint32(table1[j-1]) // dataOffset
	d1 := base + uint32(table1[j-0]) // dataOffset + dataLength
	return data[d0:d1]
}
