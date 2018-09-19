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

// +build ignore

package main

import "unicode/utf8"

// A system identifies a CLDR numbering system.
type system byte

type systemData struct {
	id        system
	digitSize byte              // number of UTF-8 bytes per digit
	zero      [utf8.UTFMax]byte // UTF-8 sequence of zero digit.
}

// A SymbolType identifies a symbol of a specific kind.
type SymbolType int

const (
	SymDecimal SymbolType = iota
	SymGroup
	SymList
	SymPercentSign
	SymPlusSign
	SymMinusSign
	SymExponential
	SymSuperscriptingExponent
	SymPerMille
	SymInfinity
	SymNan
	SymTimeSeparator

	NumSymbolTypes
)

type altSymData struct {
	compactTag uint16
	system     system
	symIndex   byte
}
