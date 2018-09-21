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


# This script builds and pushes a release to DockerHub.
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

tag="${OS_TAG:-}"
if [[ -z "${tag}" ]]; then
  if [[ "$( git tag --points-at HEAD | wc -l )" -ne 1 ]]; then
    echo "error: Specify OS_TAG or ensure the current git HEAD is tagged."
    exit 1
  fi
  tag="$( git tag --points-at HEAD )"
fi

# release_component is the standard release pattern for subcomponents
function release_component() {
  local STARTTIME=$(date +%s)
  echo "--- $1 $2 ---"
  mkdir -p "_output/components"
  (
    pushd _output/components/
    git clone --recursive "$2" "$1"
    pushd "$1"
    git checkout "${tag}"
    OS_TAG="${tag}" hack/release.sh
  )
  local ENDTIME=$(date +%s); echo "--- $1 took $(($ENDTIME - $STARTTIME)) seconds ---"
  rm -rf "_output/components/$1"
}

release_component logging https://github.com/openshift/origin-aggregated-logging
release_component metrics https://github.com/openshift/origin-metrics
release_component origin https://github.com/openshift/origin