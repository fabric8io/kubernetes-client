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

SCRIPT_ROOT=$(dirname ${BASH_SOURCE})/..

if [[ "$(protoc --version)" != "libprotoc 3.0."* ]]; then
  echo "Generating protobuf requires protoc 3.0.x. Please download and
install the platform appropriate Protobuf package for your OS:

  https://github.com/google/protobuf/releases

To skip protobuf generation, set \$PROTO_OPTIONAL."
fi

rm -rf go-to-protobuf
rm -rf protoc-gen-gogo
go build -o _output/bin/go-to-protobuf github.com/openshift/api/vendor/k8s.io/code-generator/cmd/go-to-protobuf
go build -o _output/bin/protoc-gen-gogo github.com/openshift/api/vendor/k8s.io/code-generator/cmd/go-to-protobuf/protoc-gen-gogo

PATH="$PATH:_output/bin" go-to-protobuf \
  --output-base="${GOPATH}/src" \
  --apimachinery-packages='-k8s.io/apimachinery/pkg/util/intstr,-k8s.io/apimachinery/pkg/api/resource,-k8s.io/apimachinery/pkg/runtime/schema,-k8s.io/apimachinery/pkg/runtime,-k8s.io/apimachinery/pkg/apis/meta/v1,-k8s.io/apimachinery/pkg/apis/meta/v1alpha1,-k8s.io/api/core/v1,-k8s.io/api/rbac/v1' \
  --go-header-file=${SCRIPT_ROOT}/hack/empty.txt \
  --proto-import=${SCRIPT_ROOT}/vendor/github.com/gogo/protobuf/protobuf \
  --proto-import=${SCRIPT_ROOT}/vendor \
  --packages="${API_PACKAGES}"
