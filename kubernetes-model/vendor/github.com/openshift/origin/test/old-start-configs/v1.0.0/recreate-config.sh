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


# when the certificates expire a year from now, run this to regenerate the config

DIRNAME=`dirname $0`
ABSOLUTE_DIRNAME=`readlink -f ${DIRNAME}`
CONFIG_DIR=${ABSOLUTE_DIRNAME}/config

rm -rf ${CONFIG_DIR}
mkdir ${CONFIG_DIR}

docker run -t -i --rm -u `id -u` -v ${CONFIG_DIR}:/tmp/cfg openshift/origin:v1.0.0 start master --write-config=/tmp/cfg/openshift.local.config/master --listen=https://0.0.0.0:8443 --master=https://172.17.42.1:8443 --public-master=https://172.17.42.1:8443 --nodes=127.0.0.1

docker run -t -i --rm -u `id -u` -v ${CONFIG_DIR}:/tmp/cfg -w /tmp/cfg openshift/origin:v1.0.0 admin create-node-config --node-dir=/tmp/cfg/openshift.local.config/node-127.0.0.1 --listen=https://0.0.0.0:10250 --hostnames=127.0.0.1,localhost --node=127.0.0.1 --dns-ip=127.0.0.1

