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


# Install intemp from the internet
# Usage: install.sh [version]
# Alt Usage: curl -o- https://raw.githubusercontent.com/karlkfi/intemp/master/install.sh | bash
# Requires: curl

set -o errexit
set -o nounset
set -o pipefail

prefix="/usr/local/bin"

version=${1:-}
if [ -z "${version}" ]; then
  version=$(curl -s https://api.github.com/repos/karlkfi/intemp/releases/latest | grep 'tag_name' | cut -d\" -f4)
fi

echo "Installing intemp ${version} -> ${prefix}/intemp.sh"
curl -o- "https://raw.githubusercontent.com/karlkfi/intemp/${version}/intemp.sh" > "${prefix}/intemp.sh"
chmod a+x "${prefix}/intemp.sh"
