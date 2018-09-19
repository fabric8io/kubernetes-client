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
# This is the official OpenShift Origin image. It has as its entrypoint the OpenShift
# all-in-one binary.
#
# While this image can be used for a simple node it does not support OVS based
# SDN or storage plugins required for EBS, GCE, Gluster, Ceph, or iSCSI volume
# management. For those features please use 'openshift/node'
#
# The standard name for this image is openshift/origin
#
FROM openshift/origin-base

COPY system-container/system-container-wrapper.sh /usr/local/bin/
COPY system-container/config.json.template system-container/manifest.json system-container/service.template system-container/tmpfiles.template /exports/
RUN INSTALL_PKGS="origin" && \
    yum --enablerepo=origin-local-release install -y ${INSTALL_PKGS} && \
    rpm -V ${INSTALL_PKGS} && \
    yum clean all && \
    setcap 'cap_net_bind_service=ep' /usr/bin/openshift

LABEL io.k8s.display-name="OpenShift Origin Application Platform" \
      io.k8s.description="OpenShift Origin is a platform for developing, building, and deploying containerized applications." \
      io.openshift.tags="openshift,core"

ENV HOME=/root \
    OPENSHIFT_CONTAINERIZED=true \
    KUBECONFIG=/var/lib/origin/openshift.local.config/master/admin.kubeconfig

WORKDIR /var/lib/origin
EXPOSE 8443 53

ENTRYPOINT ["/usr/bin/openshift"]
