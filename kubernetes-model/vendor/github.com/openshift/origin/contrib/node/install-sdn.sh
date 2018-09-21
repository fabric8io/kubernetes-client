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


os::provision::install-sdn() {
  local deployed_root=$1
  local binaries_path=$2
  local target=${3:-}
  local target_usrdir="${target}/usr"
  local target_bindir="${target_usrdir}/bin"
  local target_confdir="${target}/etc/cni/net.d"
  local target_cnidir="${target}/opt/cni/bin"

  mkdir -p -m u+rwx,g+rwx,o+rx "${target_usrdir}"
  mkdir -p -m u+rwx,g+rwx,o+rx "${target_bindir}"
  mkdir -p -m u+rwx,g+rwx,o+rx "${target_confdir}"
  mkdir -p -m u+rwx,g+rwx,o+rx "${target_cnidir}"

  install -m u+rwx,g+rwx,o+rx "${binaries_path}/sdn-cni-plugin" "${target_cnidir}/openshift-sdn"
  install -m u+rwx,g+rwx,o+rx "${binaries_path}/host-local" "${target_cnidir}"
  install -m u+rwx,g+rwx,o+rx "${binaries_path}/loopback" "${target_cnidir}"

  # Assume an empty/default target is an indication of deploying in an
  # environment where openvswitch should be started by us
  if [[ -z "${target}" ]]; then
    systemctl enable openvswitch
    systemctl start openvswitch
  fi
}
