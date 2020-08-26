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

trap 'exit' ERR

START_LINK=10
BASEDIR=$(dirname "$BASH_SOURCE")

function help() {
 cat <<-END
Utility script for CHANGELOG.md

Available functions:
  - extract: Extracts the changelog for a given version
      Usage: ./changelog.sh extract semVer
      Example: ./changelog.sh extract 4.9.0
  - extractWithLinks: Extracts the changelog for a given version and appends links to the referenced issues
      Usage: ./changelog.sh extractWithLinks semVer [startLinkNumber]
      Example: ./changelog.sh extractWithLinks 4.9.0 1
  - emailTemplate: Prepares an e-mail for the release announcement
      Usage: ./changelog.sh emailTemplate semVer
      Example: ./changelog.sh emailTemplate 4.9.0
END
}

function checkInput() {
  if [ "$#" -lt 1 ]; then
    help
    exit 1;
  fi
  dotCount=$(echo "$1" | tr -d -c '.' | wc -c)
  if [ "$dotCount" -ne 2 ]; then
      echo "Provided version has an invalid format, should be semver compliant (e.g. 1.3.37)"
      exit 1;
  fi
}

function extractChangelogPortion() {
  sed -e "/^### ""$1""/,/^### /!d" "$BASEDIR/../CHANGELOG.md"
}

function removeLastLine() {
  echo "$1" | sed '$d'
}

function replaceBullets() {
  echo -e "$1" | sed -e "s/^*/-/"
}

function addLinks() {
  lines=""
  links=""
  currentLink="$START_LINK"
  if [ -n "$2" ]; then currentLink="$2" ; fi
  while read -r line; do
    issueNumber=$(echo "$line" | sed -En 's/.*?#([0-9]+).*/\1/p')
    if [ -z "$issueNumber" ]; then
      lines+="$line\n";
    else
      lines+="$line [$currentLink]\n"
      links+="[$currentLink] https://github.com/fabric8io/kubernetes-client/issues/$issueNumber\n"
      currentLink=$((currentLink + 1));
    fi
  done < <(echo "$1")
  echo -e "$lines\n$links";
}

function extract() {
  checkInput "$@"
  changelog=$1
  changelog=$(extractChangelogPortion "$changelog")
  changelog=$(removeLastLine "$changelog")
  changelog=$(replaceBullets "$changelog")
  echo "$changelog"
}

function extractWithLinks() {
  changelog=$(extract "$@")
  changelog=$(addLinks "$changelog" "$2")
  echo "$changelog";
}

function emailTemplate() {
  checkInput "$@"
  changelog=$(extract "$@")
  changelogWithLinks=$(addLinks "$changelog" 2)
  numberedChangelog=$(echo -e "$changelogWithLinks" | sed '/^$/d' | sed '/^#/d' | sed -E '/^\[[0-9]+\]/d')
  changelogLinks=$(echo -e "$changelogWithLinks" | sed '/^$/d' | sed '/^#/d' | sed -E '/^\[[0-9]+\]/!d')
  changelogLinksCount=$(echo -e "$changelogLinks" | wc -l)
  githubLinkId="["$((changelogLinksCount + 2))"]"
  gitterLinkId="["$((changelogLinksCount + 3))"]"
  lines="Release announcement for Fabric8-Kubernetes-Client $1\n\n"
  lines+="Hi All,\n\n"
  lines+="We are pleased to announce Fabric8 Kubernetes Client $1 was just released. You can find the release at Maven Central [1].\n\n"
  lines+="These are the features and fixes included in $1:\n"
  lines+="$numberedChangelog\n\n"
  lines+="Your feedback is highly appreciated, you can provide it replying to the mailing list or through the usual channels. $githubLinkId $gitterLinkId\n\n"
  lines+="[1] https://repo1.maven.org/maven2/io/fabric8/kubernetes-client/$1/\n"
  lines+="$changelogLinks\n"
  lines+="$githubLinkId https://github.com/fabric8io/kubernetes-client\n"
  lines+="$gitterLinkId https://gitter.im/fabric8io/kubernetes-client\n"
  echo -e "$lines"
}

if declare -f "$1" > /dev/null ; then
  "$@"
elif [ -z "$1" ]; then
  echo "Please specify a function name" >&2
else
  echo "'$1' is not a known function name" >&2
  exit 1
fi
