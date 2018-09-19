#!/bin/bash -e
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

#
# This script fetches and rebuilds the "well-known types" protocol buffers.
# To run this you will need protoc and goprotobuf installed;
# see https://github.com/golang/protobuf for instructions.
# You also need Go and Git installed.

PKG=github.com/golang/protobuf/ptypes
UPSTREAM=https://github.com/google/protobuf
UPSTREAM_SUBDIR=src/google/protobuf
PROTO_FILES='
  any.proto
  duration.proto
  empty.proto
  struct.proto
  timestamp.proto
  wrappers.proto
'

function die() {
  echo 1>&2 $*
  exit 1
}

# Sanity check that the right tools are accessible.
for tool in go git protoc protoc-gen-go; do
  q=$(which $tool) || die "didn't find $tool"
  echo 1>&2 "$tool: $q"
done

tmpdir=$(mktemp -d -t regen-wkt.XXXXXX)
trap 'rm -rf $tmpdir' EXIT

echo -n 1>&2 "finding package dir... "
pkgdir=$(go list -f '{{.Dir}}' $PKG)
echo 1>&2 $pkgdir
base=$(echo $pkgdir | sed "s,/$PKG\$,,")
echo 1>&2 "base: $base"
cd $base

echo 1>&2 "fetching latest protos... "
git clone -q $UPSTREAM $tmpdir
# Pass 1: build mapping from upstream filename to our filename.
declare -A filename_map
for f in $(cd $PKG && find * -name '*.proto'); do
  echo -n 1>&2 "looking for latest version of $f... "
  up=$(cd $tmpdir/$UPSTREAM_SUBDIR && find * -name $(basename $f) | grep -v /testdata/)
  echo 1>&2 $up
  if [ $(echo $up | wc -w) != "1" ]; then
    die "not exactly one match"
  fi
  filename_map[$up]=$f
done
# Pass 2: copy files
for up in "${!filename_map[@]}"; do
  f=${filename_map[$up]}
  shortname=$(basename $f | sed 's,\.proto$,,')
  cp $tmpdir/$UPSTREAM_SUBDIR/$up $PKG/$f
done

# Run protoc once per package.
for dir in $(find $PKG -name '*.proto' | xargs dirname | sort | uniq); do
  echo 1>&2 "* $dir"
  protoc --go_out=. $dir/*.proto
done
echo 1>&2 "All OK"
