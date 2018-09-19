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


# This script runs all of the test written for our Bash libraries.
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

function cleanup() {
    return_code=$?
	os::test::junit::generate_report
	os::util::describe_return_code "${return_code}"
    exit "${return_code}"
}
trap "cleanup" EXIT

library_tests="$( find 'hack/test-lib/' -type f -executable )"
for test in ${library_tests}; do
	# run each library test found in a subshell so that we can isolate them
	( ${test} )
	echo "$(basename "${test//.sh}"): ok"
done