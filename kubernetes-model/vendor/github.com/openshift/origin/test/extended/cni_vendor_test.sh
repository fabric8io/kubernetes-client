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


source "$(dirname "${BASH_SOURCE}")/../../hack/lib/init.sh"

# Set this to false if the plugin does not implement NetworkPolicy
export NETWORKING_E2E_NETWORKPOLICY="${NETWORKING_E2E_NETWORKPOLICY:-true}"

# Set this to true if the plugin implements isolation in the same manner as
# redhat/openshift-ovs-multitenant
export NETWORKING_E2E_ISOLATION="${NETWORKING_E2E_ISOLATION:-false}"

export NETWORKING_E2E_FOCUS="${NETWORKING_E2E_FOCUS:-\[Area:Networking\]}"
export NETWORKING_E2E_EXTERNAL=1

# Checking for a given kubeconfig
os::log::info "Starting 'networking' extended tests for cni plugin"
if [[ -n "${OPENSHIFT_TEST_KUBECONFIG:-}" ]]; then
  # Run tests against an existing cluster
  "${OS_ROOT}/test/extended/networking.sh" $@
else
  os::log::error "Please set env OPENSHIFT_TEST_KUBECONFIG to run the tests against an existing cluster"
  exit 1
fi
