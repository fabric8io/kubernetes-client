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


# Configuration script for data population

# The server to login to when provisioning users
export OPENSHIFT_SERVER="${OPENSHIFT_SERVER:-https://10.0.2.15:8443}"

# The admin user to populate
export OPENSHIFT_ADMIN_CONFIG="${OPENSHIFT_ADMIN_CONFIG:-./openshift.local.config/master/admin.kubeconfig}"

# The ca cert to present when provisioning users
export OPENSHIFT_CA_CERT="${OPENSHIFT_CA_CERT:-./openshift.local.config/master/ca.crt}"

# The number of users that are in the system
export NUM_USERS="${NUM_USERS:-10}"

# The number of applications to create across all projcets
export NUM_APPS="${NUM_APPS:-100}"

# The user name prefix
export USER_NAME_PREFIX=hal-

# The number of projects that are in the system
export NUM_PROJECTS="${NUM_PROJECTS:-3}"

# The project name prefix
export PROJECT_NAME_PREFIX=project-

# How many concurrent CLI requests to make
export MAX_PROCS=4
