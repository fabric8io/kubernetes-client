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

FROM openshift/openldap-2441-centos7:latest

# OpenLDAP server image for OpenShift Origin testing based on OpenLDAP 2.4.41
#
# Volumes:
# * /var/lib/openldap/data - Datastore for OpenLDAP
# * /etc/openldap/slapd.d  - Config directory for slapd
# Environment:
# * $OPENLDAP_DEBUG_LEVEL (Optional) - OpenLDAP debugging level, defaults to 256

MAINTAINER Steve Kuznetsov <skuznets@redhat.com>

# Add LDAP test data and script
COPY *init.sh /usr/local/bin/
COPY contrib/init.ldif /usr/local/etc/openldap/

# Set OpenLDAP data and config directories in a data volume
VOLUME ["/var/lib/ldap", "/etc/openldap"]

# Expose default ports for ldap and ldaps
EXPOSE 389 636

CMD ["/usr/local/bin/init.sh"]
