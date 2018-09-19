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


set -o errexit
set -o nounset
set -o pipefail

cd "${OS_ROOT}"
source hack/lib/init.sh

export TEST_NAME="test-extended/gssapiproxy-tests/$(uname -n)-${CLIENT}-${SERVER}"
os::util::environment::setup_time_vars
os::cleanup::tmpdir
export JUNIT_REPORT_OUTPUT="${LOG_DIR}/raw_test_output.log"

# use a subshell and `if` statement to prevent `exit` calls from killing this script
if ! ( './gssapi-tests.sh' ) 2>&1; then
    return_code=$?
fi

cat "${JUNIT_REPORT_OUTPUT}" 1>&2
exit "${return_code:-0}"
