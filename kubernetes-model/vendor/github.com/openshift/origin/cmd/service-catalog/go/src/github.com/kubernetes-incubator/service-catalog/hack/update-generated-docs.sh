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


# This script sets up a go workspace locally and generates the documents and manuals.

source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

OUTPUT_DIR_REL=${1:-""}
OUTPUT_DIR="${OS_ROOT}/${OUTPUT_DIR_REL}/docs/generated"
MAN_OUTPUT_DIR="${OS_ROOT}/${OUTPUT_DIR_REL}/docs/man/man1"

# Generate fresh docs
os::util::gen-docs ${1:-""}

# Replace with placeholder docs
os::util::set-docs-placeholder "${OUTPUT_DIR}"
os::util::set-man-placeholder "${MAN_OUTPUT_DIR}"
