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


# Usage:
#
# To only verify that there are no errors in JSON files, run:
# $ ./hack/verify-jsonformat.sh
#
# Additionally, to verify also the formatting of JSON file, run:
# $ ./hack/verify-jsonformat.sh --format
#
# In case there is a formatting error, you can use this command to fix it
# automatically:
# $ ./hack/verify-jsonformat.sh --format --fix
#
source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

json_files=$(find {api,examples,docs,images,plugins,test} -name "*.json")
tmp_dir=$(mktemp -d)
found=0

set +e

format="${1:-""}"
fix="${2:-""}"

for f in $json_files; do
  tmp_file="${tmp_dir}$(basename $f)"
  go run ./hack/jsonformat.go ${f} > ${tmp_file}
  result=$?
  if [ "${format}" == "--format" ]; then
    if ! diff --brief ${f} ${tmp_file} > /dev/null; then
      if [ "$result" == "0" -a "${fix}" == "--fix" ]; then
        echo "Fixing JSON formatting for '${f}'"
        cp ${tmp_file} ${f}
      else
        echo "JSON formatting problem: '${f}'"
        found=1
      fi
      continue
    fi
  fi
  [ "$result" != "0" ] && found=1
done

rm -rf ${tmp_dir}

if [ "$found" == "1" ]; then
  echo -e "\nThere are problems with some JSON files, to verify them you can run:"
  echo -e "$ go run ./hack/jsonformat.go <filename>\n"
  exit
fi
