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


# This script extracts a valid release tar into _output/releases. It requires hack/build-release.sh
# to have been executed
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

# Copy the release archives release back to the local _output/local/bin/... directories.
# NOTE: On Mac and Windows you must pass WARN=1 in order to extract the output.
os::build::detect_local_release_tars $(os::build::host_platform_friendly)

mkdir -p "${OS_OUTPUT_BINPATH}/$(os::build::host_platform)"
os::build::extract_tar "${OS_PRIMARY_RELEASE_TAR}" "${OS_OUTPUT_BINPATH}/$(os::build::host_platform)"
os::build::extract_tar "${OS_CLIENT_RELEASE_TAR}" "${OS_OUTPUT_BINPATH}/$(os::build::host_platform)"
os::build::extract_tar "${OS_IMAGE_RELEASE_TAR}" "${OS_OUTPUT_BINPATH}/$(os::build::host_platform)"

os::build::make_openshift_binary_symlinks
