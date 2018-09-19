#!/bin/bash -e
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
# This is a wrapper for the etcd that serves as 'discovery' server and manager
# for the cluster configuration

address=$(getent ahosts ${HOSTNAME} | grep RAW | cut -d ' ' -f 1)

exec /usr/local/bin/etcd \
  --advertise-client-urls http://${address}:2379 \
  --listen-client-urls http://${address}:2379 \
  --data-dir /var/lib/etcd \
  --name discovery
