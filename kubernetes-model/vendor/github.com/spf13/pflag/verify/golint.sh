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


ROOT=$(dirname "${BASH_SOURCE}")/..
GOLINT=${GOLINT:-"golint"}

pushd "${ROOT}" > /dev/null
  bad_files=$($GOLINT -min_confidence=0.9 ./...)
  if [[ -n "${bad_files}" ]]; then
    echo "!!! '$GOLINT' problems: "
    echo "${bad_files}"
    exit 1
  fi
popd > /dev/null

# ex: ts=2 sw=2 et filetype=sh
