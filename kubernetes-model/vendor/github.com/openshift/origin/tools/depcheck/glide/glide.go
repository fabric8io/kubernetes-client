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
package glide

import (
	"time"

	yaml "gopkg.in/yaml.v2"
)

type LockFile struct {
	Hash    string    `yaml:"hash"`
	Updated time.Time `yaml:"updated"`

	Imports []*LockFileImport `yaml:"imports"`
}

func (l *LockFile) Decode(b []byte) error {
	return yaml.Unmarshal(b, l)
}

type YamlFile struct {
	Package     string             `yaml:"package"`
	ExcludeDirs []string           `yaml:"excludeDirs"`
	Imports     YamlFileImportList `yaml:"import"`
}

func (y *YamlFile) Encode() ([]byte, error) {
	return yaml.Marshal(y)
}

func (y *YamlFile) Decode(b []byte) error {
	return yaml.Unmarshal(b, y)
}

type LockFileImport struct {
	Name    string `yaml:"name"`
	Repo    string `yaml:"repo,omitempty"`
	Version string `yaml:"version"`
}

type YamlFileImport struct {
	Package string `yaml:"package"`
	Repo    string `yaml:"repo,omitempty"`
	Version string `yaml:"version"`
}

type YamlFileImportList []*YamlFileImport

func (l *YamlFileImportList) Encode() ([]byte, error) {
	return yaml.Marshal(l)
}
