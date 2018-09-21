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

// Package format contains types for defining language-specific formatting of
// values.
//
// This package is internal now, but will eventually be exposed after the API
// settles.
package format // import "golang.org/x/text/internal/format"

import (
	"fmt"

	"golang.org/x/text/language"
)

// State represents the printer state passed to custom formatters. It provides
// access to the fmt.State interface and the sentence and language-related
// context.
type State interface {
	fmt.State

	// Language reports the requested language in which to render a message.
	Language() language.Tag

	// TODO: more info:
	// - sentence context
	// - user preferences, like measurement systems
	// - options
}

// A Statement is a Var or an Expression.
type Statement interface {
	statement()
}

// A String a literal string format.
type String string

func (String) statement() {}

// TODO: Select, Var, Case, StatementSequence
