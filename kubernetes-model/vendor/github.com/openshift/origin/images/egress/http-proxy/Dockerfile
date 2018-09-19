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
# This is the egress router HTTP proxy for OpenShift Origin
#
# The standard name for this image is openshift/origin-egress-http-proxy

FROM openshift/origin-base

RUN INSTALL_PKGS="squid" && \
    yum install -y $INSTALL_PKGS && \
    rpm -V $INSTALL_PKGS && \
    yum clean all && \
    rmdir /var/log/squid /var/spool/squid && \
    rm -f /etc/squid/squid.conf

ADD egress-http-proxy.sh /bin/egress-http-proxy.sh

ENTRYPOINT /bin/egress-http-proxy.sh
