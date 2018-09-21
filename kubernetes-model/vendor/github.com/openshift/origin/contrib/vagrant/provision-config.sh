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
source ${OS_ROOT}/contrib/vagrant/provision-util.sh

# Passed as arguments to provisioning script
MASTER_IP=${1:-""}
NODE_COUNT=${2:-${OPENSHIFT_NUM_MINIONS:-2}}
NODE_IPS=${3:-""}
INSTANCE_PREFIX=${4:-${OPENSHIFT_INSTANCE_PREFIX:-openshift}}

# Set defaults for optional arguments
FIXUP_NET_UDEV=false
NETWORK_PLUGIN=${OPENSHIFT_NETWORK_PLUGIN:-""}
NODE_INDEX=0
CONFIG_ROOT=${OS_ROOT}
SKIP_BUILD=${OPENSHIFT_SKIP_BUILD:-false}

# Parse optional arguments
# Skip the positional arguments
OPTIND=5
while getopts ":i:n:c:fs" opt; do
  case $opt in
    f)
      FIXUP_NET_UDEV=true
      ;;
    i)
      NODE_INDEX=${OPTARG}
      ;;
    n)
      NETWORK_PLUGIN=${OPTARG}
      ;;
    c)
      CONFIG_ROOT=${OPTARG}
      ;;
    s)
      SKIP_BUILD=true
      ;;
    \?)
      echo "Invalid option: -${OPTARG}" >&2
      exit 1
      ;;
    :)
      echo "Option -${OPTARG} requires an argument." >&2
      exit 1
      ;;
  esac
done

LOG_LEVEL=${OPENSHIFT_LOG_LEVEL:-5}

NODE_IPS=(${NODE_IPS//,/ })
if [[ "${CONFIG_ROOT}" = "/" ]]; then
  CONFIG_ROOT=""
fi

NETWORK_PLUGIN="$(os::provision::get-network-plugin "${NETWORK_PLUGIN}" \
  "${DIND_MANAGEMENT_SCRIPT:-false}")"
if [[ "${NETWORK_PLUGIN}" =~ redhat/ ]]; then
  SDN_NODE="true"
else
  SDN_NODE="false"
fi

MASTER_NAME="${INSTANCE_PREFIX}-master"
NODE_PREFIX="${INSTANCE_PREFIX}-node-"
NODE_NAMES=( $(eval echo ${NODE_PREFIX}{1..${NODE_COUNT}}) )
SDN_NODE_NAME="${INSTANCE_PREFIX}-master-sdn"
