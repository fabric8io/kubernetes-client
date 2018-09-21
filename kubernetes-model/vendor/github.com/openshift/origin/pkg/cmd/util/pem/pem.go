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
package pem

import (
	"bytes"
	"encoding/pem"
	"io/ioutil"
	"os"
	"path/filepath"
)

func BlockFromFile(path string, blockType string) (*pem.Block, bool, error) {
	data, err := ioutil.ReadFile(path)
	if err != nil {
		return nil, false, err
	}
	block, ok := BlockFromBytes(data, blockType)
	return block, ok, nil
}

func BlockFromBytes(data []byte, blockType string) (*pem.Block, bool) {
	for {
		block, remaining := pem.Decode(data)
		if block == nil {
			return nil, false
		}
		if block.Type == blockType {
			return block, true
		}
		data = remaining
	}
}

func BlockToFile(path string, block *pem.Block, mode os.FileMode) error {
	b, err := BlockToBytes(block)
	if err != nil {
		return err
	}
	if err := os.MkdirAll(filepath.Dir(path), os.FileMode(0755)); err != nil {
		return err
	}
	return ioutil.WriteFile(path, b, mode)
}

func BlockToBytes(block *pem.Block) ([]byte, error) {
	b := bytes.Buffer{}
	if err := pem.Encode(&b, block); err != nil {
		return nil, err
	}
	return b.Bytes(), nil
}
