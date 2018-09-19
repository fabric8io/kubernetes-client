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

source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

echo "===== Verifying Generated Completions ====="

platform="$(os::build::host_platform)"
if [[ "${platform}" != "linux/amd64" ]]; then
  os::log::warning "Completions cannot be verified on non-Linux systems (${platform})"
  exit 0
fi

COMPLETION_ROOT_REL="contrib/completions"
COMPLETION_ROOT="${OS_ROOT}/${COMPLETION_ROOT_REL}"
TMP_COMPLETION_ROOT_REL="_output/verify-generated-completions/"
TMP_COMPLETION_ROOT="${OS_ROOT}/${TMP_COMPLETION_ROOT_REL}/${COMPLETION_ROOT_REL}"

echo "Generating fresh completions..."
if ! output=`${OS_ROOT}/hack/update-generated-completions.sh ${TMP_COMPLETION_ROOT_REL} 2>&1`
then
	echo "FAILURE: Generation of fresh spec failed:"
	echo "$output"
	exit 1
fi


echo "Diffing current completions against freshly generated completions..."
ret=0
diff -Naupr "${COMPLETION_ROOT}" "${TMP_COMPLETION_ROOT}" || ret=$?
rm -rf "${TMP_COMPLETION_ROOT}"
if [[ $ret -eq 0 ]]
then
  echo "SUCCESS: Generated completions up to date."
else
  echo "FAILURE: Generated completions out of date. Please run hack/update-generated-completions.sh"
  exit 1
fi
