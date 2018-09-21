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

function ovn-kubernetes-master() {
  local config_dir=$1
  local kube_config="${config_dir}/admin.kubeconfig"

  token=$(cat ${config_dir}/ovn.token)

  local master_config="${config_dir}/master-config.yaml"
  cluster_cidr=$(python -c "import yaml; stream = file('${master_config}', 'r'); y = yaml.load(stream); print y['networkConfig']['clusterNetworkCIDR']")
  apiserver=$(oc --config="${kube_config}" config view -o custom-columns=server:clusters[0].cluster.server | grep http)
  ovn_master_ip=$(echo -n ${apiserver} | cut -d "/" -f 3 | cut -d ":" -f 1)

  echo "Enabling and start ovn-kubernetes master services"
  /usr/local/bin/ovnkube \
	--apiserver "${apiserver}" \
	--ca-cert "${config_dir}/ca.crt" \
	--token "${token}" \
	--cluster-subnet "${cluster_cidr}" \
	--ovn-north-db "tcp://${ovn_master_ip}:6641" \
	--ovn-south-db "tcp://${ovn_master_ip}:6642" \
	--init-master `hostname` \
	--net-controller
}

if [[ -n "${OPENSHIFT_OVN_KUBERNETES}" ]]; then
  ovn-kubernetes-master /data/openshift.local.config/master
fi
