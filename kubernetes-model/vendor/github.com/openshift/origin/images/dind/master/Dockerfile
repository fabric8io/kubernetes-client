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
# This image is for the master of an openshift dind dev cluster.
#
# The standard name for this image is openshift/dind-master
#

FROM openshift/dind-node

# Disable iptables on the master since it will prevent access to the
# openshift api from outside the master.
RUN systemctl disable iptables.service

COPY openshift-generate-master-config.sh /usr/local/bin/

COPY openshift-disable-master-node.sh /usr/local/bin/
COPY openshift-disable-master-node.service /etc/systemd/system/
RUN systemctl enable openshift-disable-master-node.service

COPY openshift-get-hosts.sh /usr/local/bin/
COPY openshift-add-to-hosts.sh /usr/local/bin/
COPY openshift-remove-from-hosts.sh /usr/local/bin/
COPY openshift-sync-etc-hosts.service /etc/systemd/system/
RUN systemctl enable openshift-sync-etc-hosts.service

COPY openshift-master.service /etc/systemd/system/
RUN systemctl enable openshift-master.service

RUN mkdir -p /etc/systemd/system/openshift-node.service.d
COPY master-node.conf /etc/systemd/system/openshift-node.service.d/

COPY ovn-kubernetes-master-setup.service /etc/systemd/system/
COPY ovn-kubernetes-master-setup.sh /usr/local/bin/
RUN systemctl enable ovn-kubernetes-master-setup.service

COPY ovn-kubernetes-master.service /etc/systemd/system/
COPY ovn-kubernetes-master.sh /usr/local/bin/
RUN systemctl enable ovn-kubernetes-master.service

