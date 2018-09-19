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

# Clone from the Fedora 23 image
FROM fedora:23

# Install GSSAPI
RUN dnf install -y \
  apr-util-openssl \
  authconfig \
  httpd \
  krb5-libs \
  krb5-server \
  krb5-workstation \
  mod_auth_gssapi \
  mod_ssl \
  && dnf clean all

# Add conf files for Kerberos
ADD krb5.conf /etc/krb5.conf
ADD kdc.conf  /var/kerberos/krb5kdc/kdc.conf
ADD kadm5.acl /var/kerberos/krb5kdc/kadm5.acl

# Add conf file for Apache
ADD proxy.conf /etc/httpd/conf.d/proxy.conf

# Add health check file
ADD healthz /var/www/html/healthz

# 80  = http
# 443 = https
# 88  = kerberos
EXPOSE 80 443 88 88/udp

ADD configure.sh /usr/sbin/configure.sh
ENTRYPOINT /usr/sbin/configure.sh
