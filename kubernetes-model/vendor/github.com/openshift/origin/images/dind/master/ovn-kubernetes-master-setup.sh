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
source /data/dind-env

function is-api-running() {
  local config=$1

  /usr/local/bin/oc --config="${kube_config}" get --raw /healthz/ready &> /dev/null
}

function ovn-kubernetes-master-setup() {
  local config_dir=$1
  local kube_config="${config_dir}/admin.kubeconfig"

  local msg="apiserver to become alive"
  os::util::wait-for-condition "${msg}" "is-api-running ${kube_config}"

  systemctl enable ovn-northd
  systemctl start ovn-northd

  ln -sf /data/ovnkube /usr/local/bin/
  ln -sf /data/ovn-kube-util /usr/local/bin/
  ln -sf /data/ovn-k8s-cni-overlay /usr/local/bin/
  ln -sf /data/ovn-k8s-gateway-helper /usr/local/bin/
  ln -sf /data/ovn-k8s-overlay /usr/local/bin
  ln -sf /data/ovn-k8s-util /usr/local/bin/
  ln -sf /data/ovn-k8s-watcher /usr/local/bin/
  mkdir -p /usr/lib/python2.7/site-packages
  ln -sf /data/ovn_k8s /usr/lib/python2.7/site-packages/

  # Create the service account for OVN stuff
  if ! /usr/local/bin/oc --config="${kube_config}" get serviceaccount ovn >/dev/null 2>&1; then
    /usr/local/bin/oc --config="${kube_config}" create serviceaccount ovn
    /usr/local/bin/oc adm --config="${kube_config}" policy add-cluster-role-to-user cluster-admin -z ovn
    # rhbz#1383707: need to add ovn SA to anyuid SCC to allow pod annotation updates
    /usr/local/bin/oc adm --config="${kube_config}" policy add-scc-to-user anyuid -z ovn
  fi

  /usr/local/bin/oc --config="${kube_config}" sa get-token ovn > ${config_dir}/ovn.token
}

if [[ -n "${OPENSHIFT_OVN_KUBERNETES}" ]]; then
  ovn-kubernetes-master-setup /data/openshift.local.config/master
fi
