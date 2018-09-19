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
# This is an openvswitch image meant to enable OpenShift OVS based SDN
#
# The standard name for this image is openshift/openvswitch
#
FROM openshift/node

COPY scripts/* /usr/local/bin/
RUN INSTALL_PKGS="openvswitch" && \
    yum install -y ${INSTALL_PKGS} && \
    rpm -V ${INSTALL_PKGS} && \
    yum clean all

LABEL io.openshift.tags="openshift,openvswitch" \
      io.k8s.display-name="OpenShift Origin OpenVSwitch Daemon" \
      io.k8s.description="This is a component of OpenShift Origin and runs an OpenVSwitch daemon process."

VOLUME /etc/openswitch
ENV HOME /root

# files required to run as a system container
COPY system-container/system-container-wrapper.sh /usr/local/bin/
COPY system-container/config.json.template system-container/service.template system-container/tmpfiles.template system-container/manifest.json /exports/

ENTRYPOINT ["/usr/local/bin/ovs-run.sh"]
