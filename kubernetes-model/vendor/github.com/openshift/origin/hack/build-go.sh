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


# This script sets up a go workspace locally and builds all go components.
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

function cleanup() {
	return_code=$?
	os::util::describe_return_code "${return_code}"
	exit "${return_code}"
}
trap "cleanup" EXIT

platform="$(os::build::host_platform)"

build_targets=("$@")
if [[ -z "$@" ]]; then
	build_targets=("${OS_CROSS_COMPILE_TARGETS[@]}")
  # Also build SDN components on Linux by default
  if [[ "${platform}" == linux/* ]]; then
    build_targets=("${build_targets[@]}" "${OS_SDN_COMPILE_TARGETS_LINUX[@]}")
  fi
fi

OS_BUILD_PLATFORMS=("${OS_BUILD_PLATFORMS[@]:-${platform}}")
os::build::build_binaries "${build_targets[@]}"
os::build::place_bins "${build_targets[@]}"
os::build::make_openshift_binary_symlinks
