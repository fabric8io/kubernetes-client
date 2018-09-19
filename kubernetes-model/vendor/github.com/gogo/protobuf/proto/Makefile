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

install:
	go install

test: install generate-test-pbs
	go test


generate-test-pbs:
	make install
	make -C testdata
	protoc-min-version --version="3.0.0" --proto_path=.:../../../../:../protobuf --gogo_out=Mtestdata/test.proto=github.com/gogo/protobuf/proto/testdata,Mgoogle/protobuf/any.proto=github.com/gogo/protobuf/types:. proto3_proto/proto3.proto
	make
