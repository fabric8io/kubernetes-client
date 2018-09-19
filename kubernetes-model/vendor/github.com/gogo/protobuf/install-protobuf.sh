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


set -ex

die() {
    echo "$@" >&2
    exit 1
}

case "$PROTOBUF_VERSION" in
2*)
    basename=protobuf-$PROTOBUF_VERSION
    ;;
3*)
    basename=protobuf-cpp-$PROTOBUF_VERSION
    ;;
*)
    die "unknown protobuf version: $PROTOBUF_VERSION"
    ;;
esac

cd /home/travis

wget https://github.com/google/protobuf/releases/download/v$PROTOBUF_VERSION/$basename.tar.gz
tar xzf $basename.tar.gz

cd protobuf-$PROTOBUF_VERSION

./configure --prefix=/home/travis && make -j2 && make install
