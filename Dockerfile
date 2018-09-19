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

FROM centos:7

RUN yum update -y && \
  yum install -y centos-release-scl && \
  yum install -y docker sclo-git212-git unzip java-1.8.0-openjdk-devel java-1.8.0-openjdk-devel.i686 which && \
  yum clean all

# Enable packages installed from SCL
#
# This approach is a hack, but is the only option that worked well with bash and
# sh in both interactive and non interactive modes.
#
# 1. Standard `scl enable`, `scl_source` etc wont work because each `RUN`
# statement spawns a new subshell and the changes in ENV is not persistent.
#
# 2. Sourcing files is hard because there is no file that is read by bash and sh
# in both interactive and non interactive modes.
#
# 3. Setting $ENV and $BASH_ENV to a file that executes commands from 1 didn't
# work with non interactive shells even though the docs says it will.
#
# If you would like to change this, you can test it with following commands
#
# `docker run <image> sh -c 'git --version'`
# `docker run <image> bash -c 'git --version'`
# `docker run <image> sh -ic 'git --version'`
# `docker run <image> bash -c 'git --version'`

ENV PATH=/opt/rh/sclo-git212/root/bin:$PATH

RUN curl --retry 999 --retry-max-time 0  -sSL https://bintray.com/artifact/download/fabric8io/helm-ci/helm-v0.1.0%2B825f5ef-linux-amd64.zip > helm.zip && \
  unzip helm.zip && \
  rm -f helm.zip && \
  mv helm /usr/bin/

ARG PUBRING \
  SEC_JENKINS \
  SECRING \
  TRUSTDB \
  GPG_PASSPHRASE \
  SONATYPE_USERNAME \
  SONATYPE_PASSWORD

# put gpg keys in gpg home directory
ENV GPG_HOME $HOME/.gnupg \
  GPG_PASSPHRASE $GPG_PASSPRHASE
RUN base64 --decode $PUBRING > pubring.gpg \
  base64 --decode $SEC_JENKINS > sec_jenkins.gpg \
  base64 --decode $SECRING > secring.gpg \
  base64 --decode $TRUSTDB > trustdb.gpg

# Maven
RUN curl -L http://mirrors.ukfast.co.uk/sites/ftp.apache.org/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz | tar -C /opt -xzv

ENV M2_HOME /opt/apache-maven-3.3.9
ENV maven.home $M2_HOME
ENV M2 $M2_HOME/bin
ENV PATH $M2:$PATH
RUN mkdir --parents --mode 777 /root/.mvnrepository

RUN curl https://raw.githubusercontent.com/fabric8io/cico-bash-library/master/settings.xml > $M2_HOME/settings.xml

# Set JDK to be 32bit
#COPY set_java $M2
#RUN $M2/set_java && rm $M2/set_java
#RUN java -version

# hub
RUN curl -L https://github.com/github/hub/releases/download/v2.2.3/hub-linux-amd64-2.2.3.tgz | tar xzv && \
  mv hub-linux-amd64-2.2.3/bin/hub /usr/bin/ && \
  rm -rf hub-linux-amd64-2.2.3

# exposecontroller
ENV EXPOSECONTROLLER_VERSION 2.3.27
RUN curl -L https://github.com/fabric8io/exposecontroller/releases/download/v$EXPOSECONTROLLER_VERSION/exposecontroller-linux-amd64 > exposecontroller && \
  chmod +x exposecontroller && \
  mv exposecontroller /usr/bin/

# updatebot
ENV UPDATEBOT_VERSION 1.0.5
RUN curl -L http://central.maven.org/maven2/io/fabric8/updatebot/updatebot/$UPDATEBOT_VERSION/updatebot-$UPDATEBOT_VERSION.jar -o /usr/bin/updatebot && chmod +x /usr/bin/updatebot

ENV FABRIC8_USER_NAME=fabric8
RUN useradd --user-group --create-home --shell /bin/false ${FABRIC8_USER_NAME}
ENV HOME=/home/${FABRIC8_USER_NAME}
ENV WORKSPACE=$HOME/workspace
RUN mkdir $WORKSPACE
COPY . $WORKSPACE
WORKDIR $WORKSPACE/ 