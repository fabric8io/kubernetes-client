#!/bin/bash

set -x

project="fabric8io/kubernetes-client"
use_git_tag_next_version="true"
artifact_id_to_watch_in_central="kubernetes-client"

git config --global user.email fabric8cd@gmail.com
git config --global user.name fabric8-cd

git clone https://github.com/fabric8io/cico-bash-library.git

source cico-bash-library/utils.sh

# stage
output=$(stage_project)
echo $output

# promote
#release_sonatype_repo
#wait_until_artifacts_are_synced_in_central

# update downstream dependencies
#downstream_repos=("fabric8io/kubernetes-client")
#property_name="kubernetes.model.version"
#update_downstream_dependencies $downstream_repos $property_name "3.0.4"