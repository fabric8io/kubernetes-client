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

# Not stored here, but plugin.proto is in https://github.com/google/protobuf/
# at src/google/protobuf/compiler/plugin.proto
# Also we need to fix an import.
regenerate:
	echo WARNING! THIS RULE IS PROBABLY NOT RIGHT FOR YOUR INSTALLATION
	protoc --go_out=Mgoogle/protobuf/descriptor.proto=github.com/golang/protobuf/protoc-gen-go/descriptor:. \
		-I$(HOME)/src/protobuf/src $(HOME)/src/protobuf/src/google/protobuf/compiler/plugin.proto && \
		mv google/protobuf/compiler/plugin.pb.go $(GOPATH)/src/github.com/golang/protobuf/protoc-gen-go/plugin

restore:
	cp plugin.pb.golden plugin.pb.go

preserve:
	cp plugin.pb.go plugin.pb.golden
