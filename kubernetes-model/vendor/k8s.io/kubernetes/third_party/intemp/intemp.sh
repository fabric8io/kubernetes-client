#!/usr/bin/env bash
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


# Runs the supplied bash command string in a temporary workspace directory.
# Usage: intemp.sh [-t prefix] <command>
# Requires: mktemp

set -o errexit
set -o nounset
set -o pipefail

opt_flag=${1:-}
[ -z "${opt_flag}" ] && echo "No command supplied" >&2 && exit 1

if [ "${opt_flag}" == "-t" ]; then
  shift
  prefix=${1:-}
  [ -z "${prefix}" ] && echo "No prefix supplied" >&2 && exit 1
  shift
else
  prefix='temp'
fi

cmd="$1"
[ -z "${cmd}" ] && echo "No command supplied" >&2 && exit 1

workspace=$(mktemp -d "${TMPDIR:-/tmp}/${prefix}.XXXXXX")
echo "Workspace created: ${workspace}" 1>&2

cleanup() {
  local -r workspace="$1"
  rm -rf "${workspace}"
  echo "Workspace deleted: ${workspace}" 1>&2
}
trap "cleanup '${workspace}'" EXIT

pushd "${workspace}" > /dev/null
bash -ceu "${cmd}"
popd > /dev/null

trap - EXIT
cleanup "${workspace}"
