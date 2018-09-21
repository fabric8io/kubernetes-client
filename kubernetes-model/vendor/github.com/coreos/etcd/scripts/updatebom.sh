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

if ! [[ "$0" =~ "scripts/updatebom.sh" ]]; then
	echo "must be run from repository root"
	exit 255
fi

echo "installing 'bill-of-materials.json'"
go get -v -u github.com/coreos/license-bill-of-materials

echo "setting up GOPATH"
rm -rf ./gopath
mkdir ./gopath
mv ./cmd/vendor ./gopath/src

echo "generating bill-of-materials.json"
GOPATH=`pwd`/gopath license-bill-of-materials \
    --override-file ./bill-of-materials.override.json \
    github.com/coreos/etcd github.com/coreos/etcd/etcdctl > bill-of-materials.json

echo "reverting GOPATH,vendor"
mv ./gopath/src ./cmd/vendor
rm -rf ./gopath

echo "generated bill-of-materials.json"

