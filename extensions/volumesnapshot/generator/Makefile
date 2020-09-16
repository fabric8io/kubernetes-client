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

SHELL := /bin/bash

all: build

build: gobuild
	pushd ../model && \
	mvn clean install -o && \
  popd

gobuild:
	go mod vendor
	CGO_ENABLED=0 GO111MODULE=on GO15VENDOREXPERIMENT=1 go run -mod=vendor -a ./cmd/generate/generate.go > ../model/src/main/resources/schema/volumesnapshot-schema.json
