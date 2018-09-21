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

// Note: this file is identical to the file text/collate/index.go. Both files
// will be removed when the new colltab package is finished and in use.

package search

import "golang.org/x/text/internal/colltab"

const blockSize = 64

func getTable(t tableIndex) *colltab.Table {
	return &colltab.Table{
		Index: colltab.Trie{
			Index0:  mainLookup[:][blockSize*t.lookupOffset:],
			Values0: mainValues[:][blockSize*t.valuesOffset:],
			Index:   mainLookup[:],
			Values:  mainValues[:],
		},
		ExpandElem:     mainExpandElem[:],
		ContractTries:  colltab.ContractTrieSet(mainCTEntries[:]),
		ContractElem:   mainContractElem[:],
		MaxContractLen: 18,
		VariableTop:    varTop,
	}
}

// tableIndex holds information for constructing a table
// for a certain locale based on the main table.
type tableIndex struct {
	lookupOffset uint32
	valuesOffset uint32
}
