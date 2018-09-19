#!/usr/bin/env bash
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


set -e

ARCH=$1

if [ -z "$1" ]; then
    echo "Usage: ${0} [amd64 or darwin], defaulting to 'amd64'" >> /dev/stderr
    ARCH=amd64
fi

MARKER_URL=https://storage.googleapis.com/etcd/test-binaries/marker-v0.4.0-x86_64-unknown-linux-gnu
if [ ${ARCH} == "darwin" ]; then
    MARKER_URL=https://storage.googleapis.com/etcd/test-binaries/marker-v0.4.0-x86_64-apple-darwin
fi

echo "Installing marker"
curl -L ${MARKER_URL} -o ${GOPATH}/bin/marker
chmod 755 ${GOPATH}/bin/marker

${GOPATH}/bin/marker --version
