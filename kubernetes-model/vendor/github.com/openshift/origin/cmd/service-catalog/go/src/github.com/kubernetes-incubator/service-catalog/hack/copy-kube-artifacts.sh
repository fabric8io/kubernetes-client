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


# this will allow matching files also in subdirs with **/*.json pattern
shopt -s globstar

source "$(dirname "${BASH_SOURCE}")/lib/init.sh"

KUBE_ROOT=${1:-""}
KUBE_GODEP_ROOT="${OS_ROOT}/vendor/k8s.io/kubernetes"

if [ -z "$KUBE_ROOT" ]; then
  echo "usage: copy-kube-artifacts.sh <kubernetes root dir>"
  exit 255
fi

# Copy special files.
rsync -av \
  --exclude='BUILD' \
  --include-from=- \
  --include='*/' \
  --exclude='*' \
  --prune-empty-dirs \
  $KUBE_ROOT/ $KUBE_GODEP_ROOT <<EOF
/api/swagger-spec/*.json
/examples/***
/test/e2e/***
/test/fixtures/***
/test/integration/***
/third_party/protobuf/***
/README.md
EOF

rsync -av \
  --exclude='BUILD' \
  --exclude='OWNERS' \
  --exclude='*.go' \
  --include-from=- \
  --include='*/' \
  --exclude='*' \
  --prune-empty-dirs \
  $KUBE_ROOT/ $KUBE_GODEP_ROOT <<EOF
/pkg/***
/plugin/***
/staging/***
EOF
