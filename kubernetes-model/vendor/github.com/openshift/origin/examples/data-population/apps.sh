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


source $(dirname "${BASH_SOURCE}")/common.sh

echo "Populating apps"

export KUBECONFIG=${OPENSHIFT_ADMIN_CONFIG}

gitrepos=(
  https://github.com/openshift/hello-world.git
)
sources=($(oc get istag -n openshift -o template --template='{{ range .items }}{{ .metadata.name }}{{ "\n" }}{{ end }}'))
num_sources=${#sources[@]}

for ((i=1; i <=$NUM_APPS; i++))
do
  number=$RANDOM
  let "number %= $NUM_PROJECTS"
  oc project ${PROJECT_NAME_PREFIX}${number}

  repo=""
  if [[ $RANDOM -gt 20000 ]]; then
    number=$RANDOM
    let "number %= ${#gitrepos[@]}"
    repo="~${gitrepos[$number]}"
  fi

  number=$RANDOM
  let "number %= $num_sources"
  oc new-app --name=app-${i} ${sources[$number]}${repo}
done

echo "Done"