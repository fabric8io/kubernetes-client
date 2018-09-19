#!/bin/bash -e
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


readonly GLIDE_MINOR_VERSION="13"
readonly REQUIRED_GLIDE_VERSION="0.$GLIDE_MINOR_VERSION"

function verify_glide_version() {
	if ! command -v glide &> /dev/null; then
		echo "[FATAL] Glide was not found in \$PATH. Please install version ${REQUIRED_GLIDE_VERSION} or newer."
		exit 1
	fi

	local glide_version
	glide_version=($(glide --version))
	if ! echo "${glide_version[2]#v}" | awk -F. -v min=$GLIDE_MINOR_VERSION '{ exit $2 < min }'; then
		echo "Detected glide version: ${glide_version[*]}."
		echo "Please install Glide version ${REQUIRED_GLIDE_VERSION} or newer."
		exit 1
	fi
}

verify_glide_version

glide update --strip-vendor

find vendor/ -name *.proto | xargs sed -i '/k8s.io\/apiextensions-apiserver\/pkg\/apis\/apiextensions\/v1beta1\/generated.proto/d'
