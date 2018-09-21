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
CODEGEN_PKG=${CODEGEN_PKG:-$(cd ${SCRIPT_ROOT}; ls -d -1 ./vendor/k8s.io/code-generator 2>/dev/null || echo ../../../k8s.io/code-generator)}

verify="${VERIFY:-}"

${CODEGEN_PKG}/generate-groups.sh "deepcopy" \
  github.com/openshift/api/generated \
  github.com/openshift/api \
  "apps:v1 authorization:v1 build:v1 image:v1,docker10,dockerpre012 network:v1 oauth:v1 project:v1 quota:v1 route:v1 security:v1 template:v1 user:v1 webconsole:v1" \
  --go-header-file ${SCRIPT_ROOT}/hack/empty.txt \
  ${verify}
