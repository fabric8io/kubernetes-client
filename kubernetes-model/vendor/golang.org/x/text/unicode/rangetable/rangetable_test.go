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
package rangetable

import (
	"reflect"
	"testing"
	"unicode"
)

var (
	empty = &unicode.RangeTable{}
	many  = &unicode.RangeTable{
		R16:         []unicode.Range16{{0, 0xffff, 5}},
		R32:         []unicode.Range32{{0x10004, 0x10009, 5}},
		LatinOffset: 0,
	}
)

func TestVisit(t *testing.T) {
	Visit(empty, func(got rune) {
		t.Error("call from empty RangeTable")
	})

	var want rune
	Visit(many, func(got rune) {
		if got != want {
			t.Errorf("got %U; want %U", got, want)
		}
		want += 5
	})
	if want -= 5; want != 0x10009 {
		t.Errorf("last run was %U; want U+10009", want)
	}
}

func TestNew(t *testing.T) {
	for i, rt := range []*unicode.RangeTable{
		empty,
		unicode.Co,
		unicode.Letter,
		unicode.ASCII_Hex_Digit,
		many,
		maxRuneTable,
	} {
		var got, want []rune
		Visit(rt, func(r rune) {
			want = append(want, r)
		})
		Visit(New(want...), func(r rune) {
			got = append(got, r)
		})
		if !reflect.DeepEqual(got, want) {
			t.Errorf("%d:\ngot  %v;\nwant %v", i, got, want)
		}
	}
}
