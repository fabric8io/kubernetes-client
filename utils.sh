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


function get_project_version() {
    project_version=$(mvn -q \
    -Dexec.executable="echo" \
    -Dexec.args='${project.version}' \
    --non-recursive \
    org.codehaus.mojo:exec-maven-plugin:1.3.1:exec)
    echo $project_version
}

function setup_git_ssh() {
    git config --global user.email fabric8cd@gmail.com
    git config --global user.name fabric8-cd
}

function push_tag() {
    release_version=$1
    git tag -fa v${release_version} -m 'Release version ${release_version}'
    git push origin v${release_version}
}

function setup_workspace_for_release() {
    git tag -d $(git tag)
    git fetch --tags
    if [ ! -z $use_git_tag_next_version ]; then
        new_version=$(get_new_ver_from_tag)
        echo "New release version $new_version"
        mvn -B -U versions:set -DnewVersion=${new_version} $mvnExtraArgs
        git commit -a -m "release ${new_version}"
        push_tag $new_version
    else
        mvn -B build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} $mvnExtraArgs
    fi
    git checkout -b release-v${new_version}
    echo "$new_version"

}

function semver_parse_into() {
    local RE='[^0-9]*\([0-9]*\)[.]\([0-9]*\)[.]\([0-9]*\)\([0-9A-Za-z-]*\)'
    #MAJOR
    eval $2=`echo $1 | sed -e "s#$RE#\1\#"`
    #MINOR
    eval $3=`echo $1 | sed -e "s#$RE#\2\#"`
    #PATCH
    eval $4=`echo $1 | sed -e "s#$RE#\3\#"`
    #SPECIAL
    eval $5=`echo $1 | sed -e "s#$RE#\4\#"`
}

function get_new_ver_from_tag() {
    version='1.0.0'

    # Set known prerelease prefixes, needed for the proper sort order in the next command
    git config versionsort.prereleaseSuffix -RC
    git config versionsort.prereleaseSuffix -M

    # if the repo has no tags this command will fail
    git tag --sort version:refname | tail -1 > version.tmp
    tag=$(cat version.tmp)
    if [ ! -z "$tag" ]; then
        local MAJOR=0
        local MINOR=0
        local PATCH=0
        local SPECIAL=""
        semver_parse_into $tag MAJOR MINOR PATCH SPECIAL
        MAJOR_VERSION=$MAJOR
        MINOR_VERSION=$MINOR
        PATCH_VERSION=$(($PATCH + 1))
        echo "$MAJOR_VERSION.$MINOR_VERSION.$PATCH_VERSION"
    else
        echo $version
    fi

}

# check the logic of this for getting repo_id
function get_repo_ids() {
  find target/  -maxdepth 1 -name "*.properties" > target/repos.txt
  filename=$(cat target/repos.txt)
  repo_id=$filename
  #repo_id=$(cat $filename)
  echo repo_id
  exit 0
}

# check this
function stage_sonatype_repo() {
    mvn clean -B
    mvn -V -B -e -U install org.sonatype.plugins:nexus-staging-maven-plugin:1.6.7:deploy -P release -DnexusUrl=https://oss.sonatype.org -DserverId=oss-sonatype-staging
    get_repo_ids
}

function stage_project() {
    setup_git_ssh
    if [ -z $GH_USER ]; then
        GH_USER=fabric8cd
        echo $GH_USER
    fi
    git remote set-url origin https://${GH_USER}:${GH_TOKEN}@github.com/${project}.git
    current_project_version=$(get_project_version)
    #version=$(setup_workspace_for_release)
    version=4.0.7
    mvn versions:set -DnewVersion=$version
    cd kubernetes-model/
    mvn versions:set -DnewVersion=$version
    cd -
    repo_ids=$(stage_sonatype_repo)
    echo "$project,$version,$repo_ids"
}

# check how to handle if there is a failure in the release
function release_sonatype_repo() {
    repo_id=$1
    mvn -B org.sonatype.plugins:nexus-staging-maven-plugin:1.6.5:rc-release -DserverId=oss-sonatype-staging -DnexusUrl=https://oss.sonatype.org -DstagingRepositoryId=${repo_id} -Ddescription=\"Next release is ready\" -DstagingProgressTimeoutMinutes=60
}

function wait_until_artifacts_are_synced_in_central() {
    version=$1
    NEXT_WAIT_TIME=0
    until [ $(is_artifact_available_in_repo $version) == "success" ] || [ $NEXT_WAIT_TIME -eq 10 ]; do
        echo "File yet not present in maven central"
        sleep $(( NEXT_WAIT_TIME++ ))
    done
}

function is_artifact_available_in_repo() {
    repo="http://central.maven.org/maven2"
    group_id="io/fabric8"
    artifact_id="$artifact_id_to_watch_in_central"
    version=$1
    ext="jar"

    url="${repo}/${group_id}/${artifact_id}/${version}/${artifact_id}-${version}.${ext}"
    if curl --output /dev/null --silent --head --fail "$url"; then
      echo "success"
    else
      echo "failure"
    fi
}

function update_downstream_dependencies() {
    # array of projects projects=("fabric8io/kubernetes-client" "fabric8io/kubernetes-model")
    projects=$1
    property_name=$2
    version=$3
    if [ -z $GH_USER ]; then
        GH_USER=fabric8cd
        echo $GH_USER
    fi
    for project in ${projects[@]}; do
        repo=$(echo "$project" | cut -d "/" -f2)
        rm -rf ${repo}
        git clone https://github.com/${project}.git
        pushd $repo
        git remote set-url origin https://${GH_USER}:${GH_TOKEN}@github.com/${project}.git
        uid=$(uuidgen)
        git checkout -b versionUpdate${uid}
        # read pom.xml file
        pom_file='pom.xml'
        cat $pom_file
        update_version $pom_file $property_name $version
        commit_message="Update pom property ${propertyName} to ${version}"
        git add $pom_file
        output=$(git commit -m "${commit_message}")
        if [[ $output = *"nothing to commit"* ]]; then
            echo "There was no version update hence no change, skip commit"
        else
            echo "Version updated pushing changes"
            git push origin versionUpdate${uid}
            body="{
                        \"title\": \"${commit_message}\",
                        \"head\": \"versionUpdate${uid}\",
                        \"base\": \"master\"
                        }"
            pr_id=$(create_pull_request "${project}" "${body}")
            wait_until_success "${pr_id}" "${project}"
            merge_pr "${pr_id}" "${project}"
        fi

        popd

    done

}

function update_version() {
    # eg: sed -i -e 's/<kubernetes.model.version>3.0.2<\/kubernetes.model.version>/
    #                <kubernetes.model.version>3.0.3<\/kubernetes.model.version>/g' pom.xml
    # updating the latest version in dependent projects pom.xml
    # params: pom_file, property_name - property to be updated in pom.xml, version is the latest version
    pom_file=$1
    property_name=$2
    version=$3
    previous_version=$(mvn -q -Dexec.executable="echo" \
                      -Dexec.args='${'${property_name}'}' \
                      --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec)
    original_string="<$property_name>$previous_version<\/$property_name>"
    replace_string="<$property_name>$version<\/$property_name>"
    sed -i -e "s/$original_string/$replace_string/g" $pom_file
    cat $pom_file
}

function create_pull_request() {
    project=$1
    body=$2
    api_url="https://api.github.com/repos/${project}/pulls"
    pr_id=$(curl --silent -X POST -H "Authorization: Bearer $GH_TOKEN" -d "${body}" "${api_url}" \
            | sed -n 's/.*"number": \(.*\),/\1/p' )
    echo "$pr_id"
}

function merge_pr() {
    # Merge PR
    pr_id=$1
    project=$2
    api_url="https://api.github.com/repos/${project}/pulls/${pr_id}/merge"
    echo "Merging PR ${pr_id}"
    curl --silent -X PUT -H "Authorization: Bearer $GH_TOKEN" "${api_url}"
}

function wait_until_success {
    pr_id=$1
    project=$2
    ref=$( curl --silent -X GET https://api.github.com/repos/"${project}"/pulls/"${pr_id}" \
           | sed -n 's/.*"ref": "\(.*\)",/\1/p' | head -1) # Extract "ref" value from the response
    status="NA"
    NEXT_WAIT_TIME=0
    # Max wait 720 seconds
    until [ "$status" == "success" ] || [ $NEXT_WAIT_TIME -eq 7 ]; do
        status=$( curl --silent -X GET https://api.github.com/repos/"${project}"/commits/"${ref}"/status \
                  | sed -n 's/.*"state": "\(.*\)",/\1/p')  # Extract "state" value from the response
        echo "Pull Request status: ${status}.  Waiting to merge..."
        sleep $(( NEXT_WAIT_TIME++ ))
    done
}
