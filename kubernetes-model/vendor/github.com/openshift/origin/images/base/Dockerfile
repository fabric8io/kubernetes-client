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

#
# This is the base image from which all OpenShift Origin images inherit. Only packages
# common to all downstream images should be here.
#
# The standard name for this image is openshift/origin-base
#
FROM openshift/origin-source

COPY *.repo /etc/yum.repos.d/
RUN INSTALL_PKGS=" \
      which git tar wget hostname sysvinit-tools util-linux bsdtar \
      socat ethtool device-mapper iptables tree findutils nmap-ncat e2fsprogs \
      xfsprogs lsof device-mapper-persistent-data ceph-common \
      " && \
    yum install -y centos-release-ceph-luminous && \
    rpm -V centos-release-ceph-luminous && \
    yum install -y ${INSTALL_PKGS} && \
    rpm -V ${INSTALL_PKGS} && \
    yum clean all && \
    mkdir -p /var/lib/origin

LABEL io.k8s.display-name="OpenShift Origin CentOS 7 Base" \
      io.k8s.description="This is the base image from which all OpenShift Origin images inherit." \
      io.openshift.tags="openshift,base"
