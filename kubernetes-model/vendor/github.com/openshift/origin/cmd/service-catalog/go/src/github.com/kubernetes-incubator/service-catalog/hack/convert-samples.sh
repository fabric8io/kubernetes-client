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

os::util::ensure::built_binary_exists 'origin-version-change'
IGNORE_FILES={$IGNORE_FILES:-"examples/sample-app/github-webhook-example.json"}

sample_files=$(find {api,examples,docs,images,plugins,test} -name "*.json" -o -name "*.yaml")
ignore_arr=(${IGNORE_FILES//,/ })

for f in $sample_files; do
  if [[ $ignore_arr =~ $f ]]; then
    echo "-> Skipping '$f'"
  else
    echo "-> Processing '$f' ..."
    origin-version-change -r "$f"
  fi
done
