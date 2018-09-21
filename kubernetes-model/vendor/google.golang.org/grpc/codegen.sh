#!/usr/bin/env bash
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


# This script serves as an example to demonstrate how to generate the gRPC-Go
# interface and the related messages from .proto file.
#
# It assumes the installation of i) Google proto buffer compiler at
# https://github.com/google/protobuf (after v2.6.1) and ii) the Go codegen
# plugin at https://github.com/golang/protobuf (after 2015-02-20). If you have
# not, please install them first.
#
# We recommend running this script at $GOPATH/src.
#
# If this is not what you need, feel free to make your own scripts. Again, this
# script is for demonstration purpose.
#
proto=$1
protoc --go_out=plugins=grpc:. $proto
