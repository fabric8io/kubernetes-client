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


source $(dirname $0)/provision-config.sh

# Provided index is 1-based, array is 0 based
NODE_NAME=${NODE_NAMES[${NODE_INDEX}-1]}

os::provision::base-provision "${OS_ROOT}"

# Waiting for node config to exist before deploying allows vm
# provisioning to safely execute in parallel.
if ! os::provision::in-container; then
  os::provision::wait-for-node-config "${CONFIG_ROOT}" "${NODE_NAME}"
fi

# Copy configuration to local storage because each node's openshift
# service uses the configuration path as a working directory and it is
# not desirable for nodes to share a working directory.
DEPLOYED_CONFIG_ROOT="/"
os::provision::copy-config "${CONFIG_ROOT}"

# Binaries are expected to have been built by the time node
# configuration is available.
os::provision::base-install "${OS_ROOT}" "${DEPLOYED_CONFIG_ROOT}"

echo "Launching openshift daemon"
os::provision::start-node-service "${DEPLOYED_CONFIG_ROOT}" "${NODE_NAME}"
