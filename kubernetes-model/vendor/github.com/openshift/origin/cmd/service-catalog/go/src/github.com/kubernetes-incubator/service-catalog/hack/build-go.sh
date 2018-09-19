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
STARTTIME=$(date +%s)
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

build_targets=("$@")
platform="$(os::build::host_platform)"

# Set build tags for these binaries
readonly OS_GOFLAGS_TAGS="include_gcs include_oss containers_image_openpgp"

# only works on Linux for now, all other platforms must build binaries themselves
if [[ -z "$@" ]]; then
  if [[ "${OS_RELEASE:-}" != "n" ]] && \
    os::build::detect_local_release_tars $(os::build::host_platform_friendly) >/dev/null; then
    echo "++ Using release artifacts from ${OS_RELEASE_COMMIT} for ${platform} instead of building"
    mkdir -p "${OS_OUTPUT_BINPATH}/${platform}"
    os::build::extract_tar "${OS_PRIMARY_RELEASE_TAR}" "${OS_OUTPUT_BINPATH}/${platform}"
    os::build::extract_tar "${OS_CLIENT_RELEASE_TAR}" "${OS_OUTPUT_BINPATH}/${platform}"
    os::build::extract_tar "${OS_IMAGE_RELEASE_TAR}" "${OS_OUTPUT_BINPATH}/${platform}"

    os::build::make_openshift_binary_symlinks

    ret=$?; ENDTIME=$(date +%s); echo "$0 took $(($ENDTIME - $STARTTIME)) seconds"; exit "$ret"
  fi

  build_targets=("${OS_CROSS_COMPILE_TARGETS[@]}")
  # Also build SDN components on Linux by default
  #if [[ "${platform}" == linux/* ]]; then
  #  build_targets=("${build_targets[@]}" "${OS_SDN_COMPILE_TARGETS_LINUX[@]}")
  #fi
fi


OS_BUILD_PLATFORMS=("${OS_BUILD_PLATFORMS[@]:-${platform}}")
os::build::build_binaries "${build_targets[@]}"
os::build::place_bins "${build_targets[@]}"
os::build::make_openshift_binary_symlinks

ret=$?; ENDTIME=$(date +%s); echo "$0 took $(($ENDTIME - $STARTTIME)) seconds"; exit "$ret"
