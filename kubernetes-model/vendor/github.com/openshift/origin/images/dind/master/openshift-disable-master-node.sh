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


set -o errexit
set -o nounset
set -o pipefail

source /usr/local/bin/openshift-dind-lib.sh

function is-node-registered() {
  local config=$1
  local node_name=$2

  /usr/local/bin/oc --config="${config}" get nodes "${node_name}" &> /dev/null
}

function disable-node() {
  local config=$1
  local node_name=$2

  local msg="${node_name} to register with the master"
  local condition="is-node-registered ${config} ${node_name}"
  os::util::wait-for-condition "${msg}" "${condition}"

  echo "Disabling scheduling for node ${node_name}"
  /usr/local/bin/oc adm --config="${config}" manage-node "${node_name}" --schedulable=false > /dev/null
}

disable-node /data/openshift.local.config/master/admin.kubeconfig "$(hostname)-node"
