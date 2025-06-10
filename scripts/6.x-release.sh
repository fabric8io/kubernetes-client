#!/bin/zsh
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

# Run with: PASSPHRASE=your_passphrase ./scripts/6.x-release.sh

trap 'exit' ERR

if ! java -version 2>&1 | grep -q 'version "1.8.'; then
  echo "Java 8 is required. Please set JAVA_HOME to a Java 8 installation."
  exit 1
fi

# Java 8 artifacts
mvn -Prelease -Dgpg.passphrase=${PASSPHRASE} -DskipTests                        \
    clean install gpg:sign

OLD_JAVA_HOME="$JAVA_HOME"
export JAVA_HOME="/home/user/00-MN/bin/jdk-11.0.14.1+1"
export PATH="$JAVA_HOME/bin:$PATH"

if ! java -version 2>&1 | grep -q 'version "11'; then
  echo "Java 11 is required. Please set JAVA_HOME to a Java 11 installation."
  exit 1
fi

# Java 11 artifacts
mvn -Prelease -Dgpg.passphrase=${PASSPHRASE} -DskipTests                        \
    -pl "httpclient-jdk"                                                        \
    -pl "httpclient-jetty"                                                      \
    -pl "junit/kube-api-test"                                                   \
    -pl "junit/kube-api-test/core"                                              \
    -pl "junit/kube-api-test/client-inject"                                     \
    install gpg:sign

mvn -Prelease -DskipTests sundr:generate-bom
mvn -Dgpg.passphrase=${PASSPHRASE} -DskipTests                                  \
    -f "target/classes/kubernetes-client-bom/pom.xml"                           \
    gpg:sign
mvn -Dgpg.passphrase=${PASSPHRASE} -DskipTests                                  \
    -f "target/classes/kubernetes-client-bom-with-deps/pom.xml"                 \
    gpg:sign
