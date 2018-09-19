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
package imported

import (
	"encoding/json"

	"github.com/gogo/protobuf/proto"
)

type B struct {
	A
}

func (b B) Equal(other B) bool {
	return b.A.Equal(other.A)
}

func (b B) Size() int {
	return b.A.Size()
}

func NewPopulatedB(r randyA) *B {
	a := NewPopulatedA(r, false)
	if a == nil {
		return nil
	}
	return &B{*a}
}

func (b B) Marshal() ([]byte, error) {
	return proto.Marshal(&b.A)
}

func (b *B) Unmarshal(data []byte) error {
	a := &A{}
	err := proto.Unmarshal(data, a)
	if err != nil {
		return err
	}
	b.A = *a
	return nil
}

func (b B) MarshalJSON() ([]byte, error) {
	return json.Marshal(b.A)
}

func (b *B) UnmarshalJSON(data []byte) error {
	a := &A{}
	err := json.Unmarshal(data, a)
	if err != nil {
		return err
	}
	*b = B{A: *a}
	return nil
}
