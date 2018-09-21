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

FROM gssapiproxy/ubuntu-gssapi-kerberos

ENV CLIENT CLIENT_HAS_LIBS_IS_CONFIGURED

RUN sed -i.bak1 -e "s/\[realms\]/\[realms\]\n${REALM} = {\n kdc = ${HOST}\n admin_server = ${HOST}\n default_domain = ${HOST}\n}/" /etc/krb5.conf && \
    sed -i.bak2 -e "s/\[domain_realm\]/\[domain_realm\]\n.${HOST} = ${REALM}\n${HOST} = ${REALM}/" /etc/krb5.conf && \
    sed -i.bak3 -e "s!default_realm = !default_realm = ${REALM}\ndefault_ccache_name = DIR:/tmp/krb5cc_%{uid}\n#!" /etc/krb5.conf
