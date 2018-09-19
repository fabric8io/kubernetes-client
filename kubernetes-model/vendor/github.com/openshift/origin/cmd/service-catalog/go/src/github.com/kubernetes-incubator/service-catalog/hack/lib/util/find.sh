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


# This script contains helper functions for finding components
# in the Origin repository or on the host machine running scripts.

# os::util::find::system_binary determines the absolute path to a
# system binary, if it exists.
#
# Globals:
#  None
# Arguments:
#  - 1: binary name
# Returns:
#  - location of the binary
function os::util::find::system_binary() {
	local binary_name="$1"

	command -v "${binary_name}"
}
readonly -f os::util::find::system_binary

# os::util::find::built_binary determines the absolute path to a
# built binary for the current platform, if it exists.
#
# Globals:
#  - OS_OUTPUT_BINPATH
# Arguments:
#  - 1: binary name
# Returns:
#  - location of the binary
function os::util::find::built_binary() {
	local binary_name="$1"

	local binary_path; binary_path="${OS_OUTPUT_BINPATH}/$( os::build::host_platform )/${binary_name}"
	# we need to check that the path leads to a file
	# as directories also have the executable bit set
	if [[ -f "${binary_path}" && -x "${binary_path}" ]]; then
		echo "${binary_path}"
		return 0
	else
		return 1
	fi
}
readonly -f os::util::find::built_binary

# os::util::find::gopath_binary determines the absolute path to a
# binary installed through the go toolchain, if it exists.
#
# Globals:
#  - GOPATH
# Arguments:
#  - 1: binary name
# Returns:
#  - location of the binary
function os::util::find::gopath_binary() {
	local binary_name="$1"

	local old_ifs="${IFS}"
	IFS=":"
	for part in ${GOPATH}; do
		local binary_path="${part}/bin/${binary_name}"
		# we need to check that the path leads to a file
		# as directories also have the executable bit set
		if [[ -f "${binary_path}" && -x "${binary_path}" ]]; then
			echo "${binary_path}"
			IFS="${old_ifs}"
			return 0
		fi
	done
	IFS="${old_ifs}"
	return 1
}
readonly -f os::util::find::gopath_binary