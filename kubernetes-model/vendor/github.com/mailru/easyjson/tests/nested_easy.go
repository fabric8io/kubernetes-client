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
package tests

import (
	"github.com/mailru/easyjson"
	"github.com/mailru/easyjson/jwriter"
)

//easyjson:json
type NestedInterfaces struct {
	Value interface{}
	Slice []interface{}
	Map   map[string]interface{}
}

type NestedEasyMarshaler struct {
	EasilyMarshaled bool
}

var _ easyjson.Marshaler = &NestedEasyMarshaler{}

func (i *NestedEasyMarshaler) MarshalEasyJSON(w *jwriter.Writer) {
	// We use this method only to indicate that easyjson.Marshaler
	// interface was really used while encoding.
	i.EasilyMarshaled = true
}