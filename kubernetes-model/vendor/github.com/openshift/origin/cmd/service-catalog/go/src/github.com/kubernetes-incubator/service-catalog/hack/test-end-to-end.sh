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


# This script tests the high level end-to-end functionality demonstrated
# as part of the examples/sample-app
STARTTIME=$(date +%s)
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

readonly JQSETPULLPOLICY='(.items[] | select(.kind == "DeploymentConfig") | .spec.template.spec.containers[0].imagePullPolicy) |= "IfNotPresent"'

if [[ "${TEST_END_TO_END:-}" != "direct" ]]; then
	if os::util::ensure::system_binary_exists 'docker'; then
		echo "++ Docker is installed, running hack/test-end-to-end-docker.sh instead."
		"${OS_ROOT}/hack/test-end-to-end-docker.sh"
		exit $?
	fi
	echo "++ Docker is not installed, running end-to-end against local binaries"
fi

os::util::ensure::iptables_privileges_exist

os::log::info "Starting end-to-end test"

function cleanup()
{
	out=$?
	echo
	if [ $out -ne 0 ]; then
		echo "[FAIL] !!!!! Test Failed !!!!"
	else
		os::log::info "Test Succeeded"
	fi
	echo

	cleanup_openshift
	os::test::junit::generate_oscmd_report
	os::log::info "Exiting"
	ENDTIME=$(date +%s); echo "$0 took $(($ENDTIME - $STARTTIME)) seconds"
	exit $out
}

trap "exit" INT TERM
trap "cleanup" EXIT


# Start All-in-one server and wait for health
os::util::environment::use_sudo
os::cleanup::tmpdir
os::util::environment::setup_all_server_vars

# Allow setting $JUNIT_REPORT to toggle output behavior
if [[ -n "${JUNIT_REPORT:-}" ]]; then
	export JUNIT_REPORT_OUTPUT="${LOG_DIR}/raw_test_output.log"
fi

os::log::system::start

os::start::configure_server
os::start::server

# set our default KUBECONFIG location
export KUBECONFIG="${ADMIN_KUBECONFIG}"

os::test::junit::declare_suite_start "end-to-end/startup"
if [[ -n "${USE_IMAGES:-}" ]]; then
    os::cmd::expect_success "oc adm registry --dry-run -o json --images='$USE_IMAGES' | jq '$JQSETPULLPOLICY' | oc create -f -"
else
    os::cmd::expect_success "oc adm registry"
fi
os::cmd::expect_success 'oc adm policy add-scc-to-user hostnetwork -z router'
os::cmd::expect_success 'oc adm router'
os::test::junit::declare_suite_end

${OS_ROOT}/test/end-to-end/core.sh
