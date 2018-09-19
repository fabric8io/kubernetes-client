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

#
# This library holds golang related utility functions.

# os::golang::verify_go_version ensures the go tool exists and is a viable version.
function os::golang::verify_go_version() {
	os::util::ensure::system_binary_exists 'go'

	local go_version
	go_version=($(go version))
	if [[ "${go_version[2]}" < "${OS_REQUIRED_GO_VERSION}" ]]; then
		os::log::info "Detected go version: ${go_version[*]}."
		if [[ -z "${PERMISSIVE_GO:-}" ]]; then
			os::log::fatal "Please install Go version ${OS_REQUIRED_GO_VERSION} or use PERMISSIVE_GO=y to bypass this check."
		else
			os::log::warning "Detected golang version doesn't match required Go version."
			os::log::warning "This version mismatch could lead to differences in execution between this run and the CI systems."
			return 0
		fi
	fi
}
readonly -f os::golang::verify_go_version

# os::golang::verify_glide_version ensures the glide is at the required level
function os::golang::verify_glide_version() {
	os::util::ensure::system_binary_exists 'glide'

	local glide_version
	glide_version=($(glide --version))
	if ! echo "${glide_version[2]#v}" | awk -F. -v min=$OS_GLIDE_MINOR_VERSION '{ exit $2 < min }'; then
		os::log::info "Detected glide version: ${glide_version[*]}."
		os::log::fatal "Please install Glide version ${OS_REQUIRED_GLIDE_VERSION} or newer."
	fi

}
readonly -f os::golang::verify_glide_version
