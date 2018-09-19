#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

regenerate:
	protoc --go_out=Mgoogle/protobuf/any.proto=github.com/golang/protobuf/ptypes/any,Mgoogle/protobuf/duration.proto=github.com/golang/protobuf/ptypes/duration,Mgoogle/protobuf/struct.proto=github.com/golang/protobuf/ptypes/struct,Mgoogle/protobuf/timestamp.proto=github.com/golang/protobuf/ptypes/timestamp,Mgoogle/protobuf/wrappers.proto=github.com/golang/protobuf/ptypes/wrappers,Mgoogle/protobuf/field_mask.proto=google.golang.org/genproto/protobuf:. conformance_proto/conformance.proto
