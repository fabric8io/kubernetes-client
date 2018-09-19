#!/bin/bash
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

source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

if [[ "${PROTO_OPTIONAL:-}" == "1" ]]; then
  os::log::warning "Skipping protobuf generation as \$PROTO_OPTIONAL is set."
  exit 0
fi

os::util::ensure::system_binary_exists 'protoc'
if [[ "$(protoc --version)" != "libprotoc 3.0."* ]]; then
  os::log::fatal "Generating protobuf requires protoc 3.0.x. Please download and
install the platform appropriate Protobuf package for your OS:

  https://github.com/google/protobuf/releases

To skip protobuf generation, set \$PROTO_OPTIONAL."
fi

os::util::ensure::gopath_binary_exists 'goimports'
os::build::setup_env

os::util::ensure::built_binary_exists 'genprotobuf'
os::util::ensure::built_binary_exists 'protoc-gen-gogo' vendor/k8s.io/kubernetes/cmd/libs/go2idl/go-to-protobuf/protoc-gen-gogo

genprotobuf --output-base="${GOPATH}/src" "$@"
