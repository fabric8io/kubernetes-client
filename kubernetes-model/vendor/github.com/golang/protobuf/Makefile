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


all:	install

install:
	go install ./proto ./jsonpb ./ptypes
	go install ./protoc-gen-go

test:
	go test ./proto ./jsonpb ./ptypes
	make -C protoc-gen-go/testdata test

clean:
	go clean ./...

nuke:
	go clean -i ./...

regenerate:
	make -C protoc-gen-go/descriptor regenerate
	make -C protoc-gen-go/plugin regenerate
	make -C protoc-gen-go/testdata regenerate
	make -C proto/testdata regenerate
	make -C jsonpb/jsonpb_test_proto regenerate
	make -C _conformance regenerate
