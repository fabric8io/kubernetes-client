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


set -x

project="fabric8io/kubernetes-client"
use_git_tag_next_version="true"
artifact_id_to_watch_in_central="kubernetes-client"

git config --global user.email fabric8cd@gmail.com
git config --global user.name fabric8-cd

#git clone https://github.com/fabric8io/cico-bash-library.git

#source cico-bash-library/utils.sh
source utils.sh

# stage
output=$(stage_project)
echo $output

# promote
release_sonatype_repo
wait_until_artifacts_are_synced_in_central

# update downstream dependencies
#downstream_repos=("fabric8io/kubernetes-client")
#property_name="kubernetes.model.version"
#update_downstream_dependencies $downstream_repos $property_name "3.0.4"
