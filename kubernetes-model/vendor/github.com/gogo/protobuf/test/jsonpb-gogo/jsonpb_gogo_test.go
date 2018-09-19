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
package jsonpb_gogo

import (
	"testing"

	"github.com/gogo/protobuf/jsonpb"
)

// customFieldMessage implements protobuf.Message but is not a normal generated message type.
type customFieldMessage struct {
	someField string //this is not a proto field
}

func (m *customFieldMessage) Reset() {
	m.someField = "hello"
}

func (m *customFieldMessage) String() string {
	return m.someField
}

func (m *customFieldMessage) ProtoMessage() {
}

func TestUnmarshalWithJSONPBUnmarshaler(t *testing.T) {
	rawJson := `{}`
	marshaler := &jsonpb.Marshaler{}
	msg := &customFieldMessage{someField: "Ignore me"}
	str, err := marshaler.MarshalToString(msg)
	if err != nil {
		t.Errorf("an unexpected error occurred when marshaling message: %v", err)
	}
	if str != rawJson {
		t.Errorf("marshaled JSON was incorrect: got %s, wanted %s", str, rawJson)
	}
}
