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

os::build::setup_env

os::util::ensure::built_binary_exists 'genopenapi'

ORIGIN_PREFIX="${OS_GO_PACKAGE}/"

INPUT_DIRS=(
  # kube apis
  $(
    grep --color=never -rl '+k8s:openapi-gen=' vendor/k8s.io/kubernetes | \
    xargs -n1 dirname | \
    sed "s,^vendor/,," | \
    sort -u | \
    sed '/^k8s\.io\/kubernetes$/d' | \
    sed '/^k8s\.io\/kubernetes\/staging$/d' | \
    sed 's,k8s\.io/kubernetes/staging/src/,,'
  )

  # origin apis
  $(
    grep --color=never -rl '+k8s:openapi-gen=' pkg | \
    xargs -n1 dirname | \
    sed "s,^,${ORIGIN_PREFIX}," | \
    sort -u
  )
)

INPUT_DIRS=$(IFS=,; echo "${INPUT_DIRS[*]}")

genopenapi \
  --logtostderr \
  --output-base="${GOPATH}/src" \
  --input-dirs "${INPUT_DIRS}" \
  --output-package "${ORIGIN_PREFIX}pkg/openapi" \
  "$@"
