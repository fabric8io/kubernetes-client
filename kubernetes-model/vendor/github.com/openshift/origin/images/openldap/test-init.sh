#!/bin/bash
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

set -x 

# Wait for daemon
for ((i=30; i>0; i--))
do
    ping_result=`ldapsearch 2>&1 | grep "Can.t contact LDAP server"`
    if [ -z "$ping_result" ]
    then
        break
    fi
    sleep 1
done
if [ $i -eq 0 ]
then
    echo "slapd did not start correctly"
    exit 1
fi

# Wait for daemon to get configured
for ((i=30; i>0; i--))
do
    ping_result=`ldapsearch -x -b cn=Subschema -s base + 2>&1 | grep "inetOrgPerson"`
    if [ -n "$ping_result" ]
    then
        break
    fi
    sleep 1
done
if [ $i -eq 0 ]
then
    echo "slapd did not get initialized correctly"
    exit 1
fi

# Assumptions:
OPENLDAP_ROOT_DN="cn=Manager,dc=example,dc=com"
OPENLDAP_ROOT_PW="admin"

# Only do setup if it has not yet been done
if [ ! -f /etc/openldap/INITIALIZED ]
then
	# Add test users and groups to the server
	ldapadd -x -D $OPENLDAP_ROOT_DN -w $OPENLDAP_ROOT_PW -f /usr/local/etc/openldap/init.ldif

	touch /etc/openldap/INITIALIZED
fi