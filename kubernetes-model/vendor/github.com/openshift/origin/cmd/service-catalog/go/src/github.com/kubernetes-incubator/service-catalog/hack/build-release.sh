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


# This script generates release zips into _output/releases. It requires the openshift/origin-release
# image to be built prior to executing this command via hack/build-base-images.sh.

# NOTE:   only committed code is built.
STARTTIME=$(date +%s)
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

export OS_BUILD_ENV_FROM_ARCHIVE=y
export OS_BUILD_ENV_PRESERVE=_output/local

context="${OS_ROOT}/_output/buildenv-context"

# Clean existing output.
rm -rf "${OS_LOCAL_RELEASEPATH}"
rm -rf "${context}"
mkdir -p "${context}"
mkdir -p "${OS_OUTPUT}"

container="$( os::build::environment::create /bin/sh -c "OS_ONLY_BUILD_PLATFORMS=${OS_ONLY_BUILD_PLATFORMS-} make build-cross" )"
trap "os::build::environment::cleanup ${container}" EXIT

# Perform the build and release in Docker.
(
  OS_GIT_TREE_STATE=clean # set this because we will be pulling from git archive
  os::build::get_version_vars
  echo "++ Building release ${OS_GIT_VERSION}"
)
os::build::environment::withsource "${container}" "${OS_GIT_COMMIT:-HEAD}"
echo "${OS_GIT_COMMIT}" > "${OS_LOCAL_RELEASEPATH}/.commit"

ret=$?; ENDTIME=$(date +%s); echo "$0 took $(($ENDTIME - $STARTTIME)) seconds"; exit "$ret"
