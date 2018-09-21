#!/bin/sh
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


cd $(dirname $0)

REPO_ROOT=$(git rev-parse --show-toplevel)
RESOLVE_REPO_ROOT_STATUS=$?
if [ "$RESOLVE_REPO_ROOT_STATUS" -ne "0" ]; then
	echo -e "Unable to resolve repository root. Error:\n$REPO_ROOT" > /dev/stderr
	exit $RESOLVE_REPO_ROOT_STATUS
fi

set -e
set -x

# Just in case the directory doesn't exist
mkdir -p $REPO_ROOT/.git/hooks

ln -f -s $(pwd)/pre-commit $REPO_ROOT/.git/hooks/pre-commit