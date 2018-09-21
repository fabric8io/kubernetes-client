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
package easyjson

import (
	"github.com/mailru/easyjson/jlexer"
	"github.com/mailru/easyjson/jwriter"
)

// RawMessage is a raw piece of JSON (number, string, bool, object, array or
// null) that is extracted without parsing and output as is during marshaling.
type RawMessage []byte

// MarshalEasyJSON does JSON marshaling using easyjson interface.
func (v *RawMessage) MarshalEasyJSON(w *jwriter.Writer) {
	if len(*v) == 0 {
		w.RawString("null")
	} else {
		w.Raw(*v, nil)
	}
}

// UnmarshalEasyJSON does JSON unmarshaling using easyjson interface.
func (v *RawMessage) UnmarshalEasyJSON(l *jlexer.Lexer) {
	*v = RawMessage(l.Raw())
}

// UnmarshalJSON implements encoding/json.Unmarshaler interface.
func (v *RawMessage) UnmarshalJSON(data []byte) error {
	*v = data
	return nil
}

var nullBytes = []byte("null")

// MarshalJSON implements encoding/json.Marshaler interface.
func (v RawMessage) MarshalJSON() ([]byte, error) {
	if len(v) == 0 {
		return nullBytes, nil
	}
	return v, nil
}

// IsDefined is required for integration with omitempty easyjson logic.
func (v *RawMessage) IsDefined() bool {
	return len(*v) > 0
}
