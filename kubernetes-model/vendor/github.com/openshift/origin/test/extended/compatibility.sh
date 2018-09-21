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
# Runs extended compatibility tests with a previous version
source "$(dirname "${BASH_SOURCE}")/../../hack/lib/init.sh"
source "${OS_ROOT}/test/extended/setup.sh"

# Previous version to test against
PREVIOUS_VERSION="v1.3.0"

export API_SERVER_VERSION="${RUN_PREVIOUS_API:+${PREVIOUS_VERSION}}"
export CONTROLLER_VERSION="${RUN_PREVIOUS_CONTROLLER:+${PREVIOUS_VERSION}}"

# For now, compatibility tests will not require a node
# so tests can execute quicker
export SKIP_NODE=1

os::test::extended::setup
os::test::extended::focus "$@"


os::log::info "Running compatibility tests"
FOCUS="\[Compatibility\]" SKIP="${SKIP_TESTS:-}" TEST_REPORT_FILE_NAME=compatibility os::test::extended::run -- -test.timeout 2h
