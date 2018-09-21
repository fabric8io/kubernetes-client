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

echo "===== Verifying Generated Bindata ====="

TMP_GENERATED_BOOTSTRAP_DIR="_output/verify-bindata"

echo "Generating bindata..."
if ! output=`OUTPUT_ROOT=${TMP_GENERATED_BOOTSTRAP_DIR} ${OS_ROOT}/hack/update-generated-bindata.sh 2>&1`
then
	echo "FAILURE: Generation of fresh bindata failed:"
	echo "$output"
  exit 1
fi

echo "Diffing current bootstrap bindata against freshly generated bindata"
ret=0
diff -Naup "${OS_ROOT}/pkg/bootstrap/bindata.go" "${TMP_GENERATED_BOOTSTRAP_DIR}/pkg/bootstrap/bindata.go" || ret=$?
if [[ $ret -eq 0 ]]
then
  echo "SUCCESS: Generated bootstrap bindata up to date."
else
  rm -rf "${TMP_GENERATED_BOOTSTRAP_DIR}"
  echo "FAILURE: Generated bootstrap bindata out of date. Please run hack/update-generated-bindata.sh"
  exit 1
fi

echo "Diffing current test/extended bindata against freshly generated bindata"
ret=0
diff -Naup "${OS_ROOT}/test/extended/testdata/bindata.go" "${TMP_GENERATED_BOOTSTRAP_DIR}/test/extended/testdata/bindata.go" || ret=$?
rm -rf "${TMP_GENERATED_BOOTSTRAP_DIR}"
if [[ $ret -eq 0 ]]
then
  echo "SUCCESS: Generated test/extended bindata up to date."
else
  rm -rf "${TMP_GENERATED_BOOTSTRAP_DIR}"
  echo "FAILURE: Generated test/extended bindata out of date. Please run hack/update-generated-bindata.sh"
  exit 1
fi

rm -rf "${TMP_GENERATED_BOOTSTRAP_DIR}"
