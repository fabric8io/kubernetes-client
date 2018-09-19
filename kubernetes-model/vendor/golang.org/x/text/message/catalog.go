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

package message

// TODO: some types in this file will need to be made public at some time.
// Documentation and method names will reflect this by using the exported name.

import (
	"golang.org/x/text/language"
	"golang.org/x/text/message/catalog"
)

// DefaultCatalog is used by SetString.
var DefaultCatalog *catalog.Catalog = defaultCatalog

var defaultCatalog = catalog.New()

// SetString calls SetString on the initial default Catalog.
func SetString(tag language.Tag, key string, msg string) error {
	return defaultCatalog.SetString(tag, key, msg)
}

// Set calls Set on the initial default Catalog.
func Set(tag language.Tag, key string, msg ...catalog.Message) error {
	return defaultCatalog.Set(tag, key, msg...)
}
