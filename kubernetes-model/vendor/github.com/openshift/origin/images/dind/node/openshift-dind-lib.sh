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

#
# This library holds utility functions used by dind deployment and images.  Since
# it is intended to be distributed standalone in dind images, it cannot depend
# on any functions outside of this file.

# os::util::wait-for-condition blocks until the provided condition becomes true
#
# Globals:
#  None
# Arguments:
#  - 1: message indicating what conditions is being waited for (e.g. 'config to be written')
#  - 2: a string representing an eval'able condition.  When eval'd it should not output
#       anything to stdout or stderr.
#  - 3: optional timeout in seconds.  If not provided, waits forever.
# Returns:
#  1 if the condition is not met before the timeout
function os::util::wait-for-condition() {
  local msg=$1
  # condition should be a string that can be eval'd.
  local condition=$2
  local timeout=${3:-}

  local start_msg="Waiting for ${msg}"
  local error_msg="[ERROR] Timeout waiting for ${msg}"

  local counter=0
  while ! ${condition} >& /dev/null; do
    if [[ "${counter}" = "0" ]]; then
      echo "${start_msg}"
    fi

    if [[ -z "${timeout}" || "${counter}" -lt "${timeout}" ]]; then
      counter=$((counter + 1))
      if [[ -n "${timeout}" ]]; then
        echo -n '.'
      fi
      sleep 1
    else
      echo -e "\n${error_msg}"
      return 1
    fi
  done

  if [[ "${counter}" != "0" && -n "${timeout}" ]]; then
    echo -e '\nDone'
  fi
}
readonly -f os::util::wait-for-condition

# os::util::is-master indicates whether the host is configured to be an OpenShift master
#
# Globals:
#  None
# Arguments:
#  None
# Returns:
#  1 if host is a master, 0 otherwise
function os::util::is-master() {
   test -f "/etc/systemd/system/openshift-master.service"
}
readonly -f os::util::is-master
