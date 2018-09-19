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

FROM openshift/jenkins-1-centos
MAINTAINER fabric8.io (http://fabric8.io/)

WORKDIR ~

# Install package dependencies as root
USER root

RUN yum install -y bzr mercurial

# Go
RUN wget -q https://storage.googleapis.com/golang/go1.4.linux-amd64.tar.gz && \
    tar -C /usr/local -xzf go1.4.linux-amd64.tar.gz

# Maven
RUN wget -q http://mirrors.ukfast.co.uk/sites/ftp.apache.org/maven/maven-3/3.2.5/binaries/apache-maven-3.2.5-bin.tar.gz && \
	tar -C /opt -zxvf apache-maven-3.2.5-bin.tar.gz

RUN rm -rf apache-maven-3.2.5-bin.tar.gz && \
	rm -rf go1.4.linux-amd64.tar.gz

RUN mkdir -p /var/jenkins_home/.m2 && \
	touch /var/jenkins_home/.m2/.keep

RUN mkdir /go && \
	chown jenkins:jenkins /go

# Java JDK
RUN wget -q --no-cookies --no-check-certificate --header "Cookie: oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u5-b13/jdk-8u5-linux-x64.rpm" -O jdk-8-linux-x64.rpm && \
	yum -y install jdk-8-linux-x64.rpm && \
	rm -rf jdk-8-linux-x64.rpm

RUN alternatives --install /usr/bin/java jar /usr/java/latest/bin/java 200000 && \
	alternatives --install /usr/bin/javaws javaws /usr/java/latest/bin/javaws 200000 && \
	alternatives --install /usr/bin/javac javac /usr/java/latest/bin/javac 200000

# Switch to jenkibs user to set env vars and configure Jenkins
USER jenkins

ENV PATH $PATH:/usr/local/go/bin
ENV GOROOT /usr/local/go
ENV GOPATH /go
ENV PATH $PATH:$GOPATH/bin

ENV M2_HOME /opt/apache-maven-3.2.5
ENV M2 $M2_HOME/bin
ENV PATH $M2:$PATH

ENV JAVA_HOME /usr/java/latest

RUN go get github.com/tools/godep && \
	cd $GOPATH/src/github.com/tools/godep && go install

# configure Jenkins
ADD http://updates.jenkins-ci.org/latest/ghprb.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/ssh-credentials.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/git-client.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/scm-api.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/credentials.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/commit-message-trigger-plugin.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/ruby-runtime.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/git.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/ssh-agent.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/github-api.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/github.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/ircbot.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/instant-messaging.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/jquery.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/parameterized-trigger.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/dashboard-view.hpi $JENKINS_HOME/plugins/
ADD http://updates.jenkins-ci.org/latest/build-pipeline-plugin.hpi $JENKINS_HOME/plugins/

ADD config.xml $JENKINS_HOME/
ADD origin-schema-generator-config.xml $JENKINS_HOME/jobs/origin-schema-generator/config.xml
ADD fabric8-jenkins-IT-config.xml $JENKINS_HOME/jobs/fabric8-jenkins-IT/config.xml
#ADD fabric8-console-IT-config.xml $JENKINS_HOME/jobs/fabric8-console-IT/config.xml
#ADD fabric8-cadvisor-IT-config.xml $JENKINS_HOME/jobs/fabric8-cadvisor-IT/config.xml

ADD hudson.plugins.ircbot.IrcPublisher.xml $JENKINS_HOME/

USER root
RUN chown -R jenkins:jenkins /var/jenkins_home
USER jenkins
