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

#
# Runs the conformance extended tests for OpenShift
source "$(dirname "${BASH_SOURCE}")/../../hack/lib/init.sh"
source "${OS_ROOT}/test/extended/setup.sh"

os::test::extended::setup
os::test::extended::focus "$@"

exitstatus=0

# run parallel tests
os::log::info "Running parallel tests N=${PARALLEL_NODES:-<default>}"
TEST_PARALLEL="${PARALLEL_NODES:-5}" TEST_REPORT_FILE_NAME=conformance_parallel os::test::extended::run -- -suite "parallel.conformance.openshift.io" -test.timeout 6h ${TEST_EXTENDED_ARGS-} || exitstatus=$?

# run tests in serial
os::log::info "Running serial tests"
TEST_REPORT_FILE_NAME=conformance_serial os::test::extended::run -- -suite "serial.conformance.openshift.io" -test.timeout 2h ${TEST_EXTENDED_ARGS-} || exitstatus=$?

exit $exitstatus
