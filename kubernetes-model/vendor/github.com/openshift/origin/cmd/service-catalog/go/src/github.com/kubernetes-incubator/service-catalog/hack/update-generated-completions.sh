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


# This script sets up a go workspace locally and generates shell auto-completion scripts.

source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

platform="$(os::build::host_platform)"
if [[ "${platform}" != "linux/amd64" ]]; then
  os::log::warning "Generating completions on ${platform} may not be identical to running on linux/amd64 due to conditional compilation."
fi

OUTPUT_REL_DIR=${1:-""}
OUTPUT_DIR_ROOT="${OS_ROOT}/${OUTPUT_REL_DIR}/contrib/completions"

mkdir -p "${OUTPUT_DIR_ROOT}/bash" || echo $? > /dev/null
mkdir -p "${OUTPUT_DIR_ROOT}/zsh" || echo $? > /dev/null

os::build::gen-completions "${OUTPUT_DIR_ROOT}/bash" "bash"
os::build::gen-completions "${OUTPUT_DIR_ROOT}/zsh" "zsh"