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

plugin="$(oc get clusternetwork default --template='{{.pluginName}}')"
if [[ "${plugin}" != "redhat/openshift-ovs-multitenant" ]]; then
   echo "Migration script must be run after switching back to multitenant plugin"
   exit 1
fi

declare -A ids
for ns in $(oc get namespaces --output=jsonpath="{range .items[*]}{.metadata.name}:{.metadata.labels['pod\\.network\\.openshift\\.io/legacy-netid']} {end}"); do
    name="${ns%:*}"
    id="${ns#*:}"
    if [[ -n "${id}" ]]; then
	ids["${id}"]+=" ${name}"
    fi
done

for id in ${!ids[@]}; do
    if [[ "${id}" == 0 ]]; then
	echo "Making global:${ids[${id}]}"
	oc adm pod-network make-projects-global ${ids["${id}"]}
    else
	echo "Joining projects:${ids[${id}]}"
	oc adm pod-network join-projects --to ${ids["${id}"]}
    fi
done
