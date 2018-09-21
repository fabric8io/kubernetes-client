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

# Templates

# Populates the "openshift" namespace with set of templates

set -o nounset
set -o pipefail

source $(dirname "${BASH_SOURCE}")/common.sh

echo "Populating templates"

export KUBECONFIG=${OPENSHIFT_ADMIN_CONFIG}

OS_ROOT=$(dirname "${BASH_SOURCE}")/../..
EXAMPLES_ROOT=${OS_ROOT}/examples

TEMPLATES="$EXAMPLES_ROOT/db-templates
$EXAMPLES_ROOT/sample-app/application-template-*
$EXAMPLES_ROOT/image-streams/image-streams-centos*"

for f in $TEMPLATES
do
  oc create -f $f --namespace=openshift
done

echo "Done"