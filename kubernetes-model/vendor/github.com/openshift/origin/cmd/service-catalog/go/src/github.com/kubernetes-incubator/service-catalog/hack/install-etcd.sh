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

source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

etcd_version=$(go run ${OS_ROOT}/tools/godepversion/godepversion.go ${OS_ROOT}/Godeps/Godeps.json github.com/coreos/etcd/etcdserver)

mkdir -p "${OS_ROOT}/_output/tools"
cd "${OS_ROOT}/_output/tools"

if [ ! -d etcd ]; then
  mkdir -p etcd
  pushd etcd >/dev/null

  curl -s -L https://github.com/coreos/etcd/tarball/${etcd_version} | \
    tar xz --strip-components 1 --no-same-owner 2>/dev/null

  if [ "$?" != "0" ]; then
    echo "Failed to download coreos/etcd."
    exit 1
  fi
else
  pushd etcd >/dev/null
fi

# setup a private GOPATH so the build can succeed
export GOPATH="${PWD}/gopath"
./build

echo
echo Installed coreos/etcd ${etcd_version} into:
echo export PATH=${PWD}/bin:\$PATH

popd >/dev/null
exit 0
