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

os::golang::verify_go_version

bad_files=$(find_files | xargs gofmt -s -l)
if [[ -n "${bad_files}" ]]; then
	echo "!!! gofmt needs to be run on the following files: " >&2
	echo "${bad_files}"
	echo "Try running 'gofmt -s -d [path]'" >&2
	echo "Or autocorrect with 'hack/verify-gofmt.sh | xargs -n 1 gofmt -s -w'" >&2
	exit 1
fi
