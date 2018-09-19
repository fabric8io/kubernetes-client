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

# Should set OPENSHIFT_NETWORK_PLUGIN
source /data/dind-env

function ensure-master-config() {
  local config_path="/data/openshift.local.config"
  local master_path="${config_path}/master"
  local config_file="${master_path}/master-config.yaml"

  if [[ -f "${config_file}" ]]; then
    # Config has already been generated
    return
  fi

  local name
  name="$(hostname)"

  local ip_addr1
  ip_addr1="$(ip addr | grep inet | grep eth0 | awk '{print $2}' | sed -e 's+/.*++')"

  local ip_addr2
  ip_addr2="$(ip addr | grep inet | (grep eth1 || true) | awk '{print $2}' | sed -e 's+/.*++')"

  local ip_addrs
  local serving_ip_addr
  if [[ -n "${ip_addr2}" ]]; then
    ip_addrs="${ip_addr1},${ip_addr2}"
    serving_ip_addr="${ip_addr2}"
  else
    ip_addrs="${ip_addr1}"
    serving_ip_addr="${ip_addr1}"
  fi

  /usr/local/bin/oc adm ca create-master-certs \
    --overwrite=false \
    --cert-dir="${master_path}" \
    --master="https://${serving_ip_addr}:8443" \
    --hostnames="${ip_addrs},${name}"

  /usr/local/bin/openshift start master --write-config="${master_path}" \
    --master="https://${serving_ip_addr}:8443" \
    --network-plugin="${OPENSHIFT_NETWORK_PLUGIN}" \
    ${OPENSHIFT_ADDITIONAL_ARGS}

  # ensure the configuration can be used outside of the container
  chmod -R ga+rX "${master_path}"
  chmod ga+w "${master_path}/admin.kubeconfig"
}

ensure-master-config
