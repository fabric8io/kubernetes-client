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
package issue260

import "time"

type Dropped struct {
	Name string
	Age  int32
}

func (d *Dropped) Drop() bool {
	return true
}

type DroppedWithoutGetters struct {
	Width             int64
	Height            int64
	Timestamp         time.Time  `protobuf:"bytes,3,opt,name=timestamp,stdtime" json:"timestamp"`
	NullableTimestamp *time.Time `protobuf:"bytes,4,opt,name=nullable_timestamp,json=nullableTimestamp,stdtime" json:"nullable_timestamp,omitempty"`
}
