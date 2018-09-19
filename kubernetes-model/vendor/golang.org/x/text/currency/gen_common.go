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
// Copyright 2015 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// +build ignore

package main

import (
	"time"

	"golang.org/x/text/language"
)

// This file contains code common to gen.go and the package code.

const (
	cashShift = 3
	roundMask = 0x7

	nonTenderBit = 0x8000
)

// currencyInfo contains information about a currency.
// bits 0..2: index into roundings for standard rounding
// bits 3..5: index into roundings for cash rounding
type currencyInfo byte

// roundingType defines the scale (number of fractional decimals) and increments
// in terms of units of size 10^-scale. For example, for scale == 2 and
// increment == 1, the currency is rounded to units of 0.01.
type roundingType struct {
	scale, increment uint8
}

// roundings contains rounding data for currencies. This struct is
// created by hand as it is very unlikely to change much.
var roundings = [...]roundingType{
	{2, 1}, // default
	{0, 1},
	{1, 1},
	{3, 1},
	{4, 1},
	{2, 5}, // cash rounding alternative
}

// regionToCode returns a 16-bit region code. Only two-letter codes are
// supported. (Three-letter codes are not needed.)
func regionToCode(r language.Region) uint16 {
	if s := r.String(); len(s) == 2 {
		return uint16(s[0])<<8 | uint16(s[1])
	}
	return 0
}

func toDate(t time.Time) uint32 {
	y := t.Year()
	if y == 1 {
		return 0
	}
	date := uint32(y) << 4
	date |= uint32(t.Month())
	date <<= 5
	date |= uint32(t.Day())
	return date
}

func fromDate(date uint32) time.Time {
	return time.Date(int(date>>9), time.Month((date>>5)&0xf), int(date&0x1f), 0, 0, 0, 0, time.UTC)
}
