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

set -euo

OS_ROOT=$(
  unset CDPATH
  origin_root=$(dirname "${BASH_SOURCE}")/../..
  cd "${origin_root}"
  pwd
)
USERNAME=vagrant

yum install -y deltarpm
yum update -y
yum install -y docker-io go git bash-completion

# It should be safe to bypass security to access docker in a dev
# environment.  This also allows bash completion, which doesn't work
# when invoking a target command via sudo.
if ! getent group docker > /dev/null; then
  groupadd docker
fi
usermod -a -G docker "${USERNAME}"

systemctl enable docker
systemctl start docker

# Docker-in-docker is not compatible with SELinux enforcement
setenforce 0 || true

# Add a convenience symlink to the gopath repo
ln -sf "${OS_ROOT}" /

function set_env {
  USER_DIR="${1}"
  # Prefer bashrc to bash_profile since bash_profile is only loaded on
  # login and bashrc is loaded by bash_profile anyway.
  TARGET="${USER_DIR}/.bashrc"
  OUTPUT_PATH="${OS_ROOT}/_output/local"
  if [[ -z "$(grep ${OUTPUT_PATH} ${TARGET})" ]]; then
    echo "export GOPATH=${OUTPUT_PATH}/go" >> ${TARGET}
    # Binpath for origin binaries
    echo "export PATH=${OUTPUT_PATH}/bin/linux/amd64:\$PATH" >> ${TARGET}
    # Binpath for go-getted binaries
    echo "export PATH=${OUTPUT_PATH}/go/bin:\$PATH" >> ${TARGET}
    echo "cd ${OS_ROOT}" >> ${TARGET}
  else
    echo "path variables for ${USER_DIR} already configured"
  fi
}

set_env "/home/${USERNAME}"
set_env /root
