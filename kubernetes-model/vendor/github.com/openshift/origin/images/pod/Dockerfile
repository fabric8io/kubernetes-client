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
# This is the official OpenShift Origin pod infrastructure image. It will stay running
# until terminated by a signal and is the heart of each running pod. It holds on to
# the network and IPC namespaces as containers come and go during the lifetime of the
# pod.
#
# The standard name for this image is openshift/origin-pod
#
FROM openshift/origin-source

RUN INSTALL_PKGS="origin-pod" && \
    yum --enablerepo=origin-local-release install -y ${INSTALL_PKGS} && \
    rpm -V ${INSTALL_PKGS} && \
    yum clean all

LABEL io.k8s.display-name="OpenShift Origin Pod Infrastructure" \
      io.k8s.description="This is a component of OpenShift Origin and holds on to the shared Linux namespaces within a Pod." \
      io.openshift.tags="openshift,pod"

USER 1001
ENTRYPOINT ["/usr/bin/pod"]
