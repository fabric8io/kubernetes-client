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


IMAGES=(openshift/origin openshift/origin-docker-registry cockpit/kubernetes)

for IMAGE in "${IMAGES[@]}"
do
  chroot /host docker pull $IMAGE
done

INSTALL_HOST=${1:-`hostname`}
echo "Installing using hostname ${INSTALL_HOST}"

# write out configuration
openshift start --write-config /etc/origin/ \
  --etcd-dir /var/lib/origin/etcd \
  --volume-dir /var/lib/origin/volumes \
  --public-master ${INSTALL_HOST} \
  --hostname ${INSTALL_HOST}

echo "Copy files to host"

set -x
mv /host/etc/origin/node-* /host/etc/origin/node

mkdir -p /host/etc/origin/registry/bin
mkdir -p /host/etc/origin/master/site
cp /container/bin/* /host/etc/origin/registry/bin/.
cp /container/etc/origin/registry-console-template.yaml /host/etc/origin/registry/.
cp /container/etc/origin/registry-login-template.html /host/etc/origin/master/site/.
# Create registry UI service certificates -- TODO: use this cert
cat /etc/origin/master/master.server.crt /etc/origin/master/master.server.key > /etc/origin/registry/master.server.cert

set +x
PORT_RANGE="80-32767"
echo "Updating servicesNodePortRange to ${PORT_RANGE}..."
sed -i "s/  servicesNodePortRange:.*$/  servicesNodePortRange: ${PORT_RANGE}/" /etc/origin/master/master-config.yaml
echo "Updating login template"
sed -i "s/  templates: null$/  templates:\n    login: site\/registry-login-template.html/" /etc/origin/master/master-config.yaml

echo "Optionally edit configuration file /etc/origin/master/master-config.yaml,"
echo "add certificates to /etc/origin/master,"
echo "then run 'atomic run projectatomic/atomic-registry-quickstart'"
