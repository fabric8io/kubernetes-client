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

# This is the cluster capacity tool.
#
# The standard name for this image is openshift/origin-cluster-capacity
#
FROM openshift/origin-source

RUN INSTALL_PKGS="origin-cluster-capacity" && \
    yum --enablerepo=origin-local-release install -y ${INSTALL_PKGS} && \
    rpm -V ${INSTALL_PKGS} && \
    yum clean all

LABEL io.k8s.display-name="OpenShift Origin Cluster Capacity" \
      io.k8s.description="This is a component of OpenShift Origin and runs cluster capacity analysis tool."

CMD ["/usr/bin/cluster-capacity --help"]
