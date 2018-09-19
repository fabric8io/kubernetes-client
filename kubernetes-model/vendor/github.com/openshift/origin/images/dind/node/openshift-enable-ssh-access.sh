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

PUBLIC_KEY="/data/id_rsa.pub"

if os::util::is-master; then
  # Generate the keypair
  ssh-keygen -N '' -q -f /root/.ssh/id_rsa
  cp /root/.ssh/id_rsa.pub "${PUBLIC_KEY}"
else
  # Wait for the master to generate the keypair
  CONDITION="test -f ${PUBLIC_KEY}"
  os::util::wait-for-condition "public key to be generated" "${CONDITION}"
fi

mkdir -p /root/.ssh
chmod 700 /root/.ssh
cp "${PUBLIC_KEY}" /root/.ssh/authorized_keys
chmod 600 /root/.ssh/authorized_keys
