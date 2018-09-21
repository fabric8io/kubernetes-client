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


set -o nounset
set -o pipefail

OS_ROOT=$(dirname "${BASH_SOURCE}")/../../..
source "${OS_ROOT}/hack/util.sh"
cd "${OS_ROOT}"

function cleanup()
{
	out=$?
	cleanup_openshift
	echo "[INFO] Exiting"
	exit $out
}

trap "exit" INT TERM
trap "cleanup" EXIT

TMPDIR="${TMPDIR:-"/tmp"}"
BASETMPDIR="${TMPDIR}/openshift-extended-tests/config-compatibility"

# run the end-to-end using the old config from each release
V1_TMPDIR=${BASETMPDIR}/v1.0.0
sudo rm -rf "${V1_TMPDIR}"
mkdir -p "${V1_TMPDIR}"
set -e
BASETMPDIR=${V1_TMPDIR} test/old-start-configs/v1.0.0/test-end-to-end.sh
