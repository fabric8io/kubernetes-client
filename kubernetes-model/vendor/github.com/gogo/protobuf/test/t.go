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
package test

import (
	"encoding/json"
	"strings"

	"github.com/gogo/protobuf/proto"
)

type T struct {
	Data string
}

func (gt *T) protoType() *ProtoType {
	return &ProtoType{
		Field2: &gt.Data,
	}
}

func (gt T) Equal(other T) bool {
	return gt.protoType().Equal(other.protoType())
}

func (gt *T) Size() int {
	proto := &ProtoType{
		Field2: &gt.Data,
	}
	return proto.Size()
}

func NewPopulatedT(r randyThetest) *T {
	data := NewPopulatedProtoType(r, false).Field2
	gt := &T{}
	if data != nil {
		gt.Data = *data
	}
	return gt
}

func (r T) Marshal() ([]byte, error) {
	return proto.Marshal(r.protoType())
}

func (r *T) Unmarshal(data []byte) error {
	pr := &ProtoType{}
	err := proto.Unmarshal(data, pr)
	if err != nil {
		return err
	}

	if pr.Field2 != nil {
		r.Data = *pr.Field2
	}
	return nil
}

func (gt T) MarshalJSON() ([]byte, error) {
	return json.Marshal(gt.Data)
}

func (gt *T) UnmarshalJSON(data []byte) error {
	var s string
	err := json.Unmarshal(data, &s)
	if err != nil {
		return err
	}
	*gt = T{Data: s}
	return nil
}

func (gt T) Compare(other T) int {
	return strings.Compare(gt.Data, other.Data)
}
