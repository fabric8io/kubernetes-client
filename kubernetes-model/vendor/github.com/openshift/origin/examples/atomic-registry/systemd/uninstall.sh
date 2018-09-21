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


REMOVE_DATA=false
if [[ $1 == "--remove-data" ]] ; then
  REMOVE_DATA=true
fi

SERVICES=(atomic-registry-master.service atomic-registry-console.service atomic-registry.service)
for SVC in "${SERVICES[@]}"
do
  set -x
  chroot /host systemctl stop ${SVC}
  chroot /host systemctl disable ${SVC}
  set +x
done

CONFDIRS=(/etc/atomic-registry
      /etc/sysconfig/atomic-registry-master
      /etc/systemd/system/atomic-registry-master.service
      /etc/sysconfig/atomic-registry
      /etc/systemd/system/atomic-registry.service
      /etc/sysconfig/atomic-registry-console
      /etc/systemd/system/atomic-registry-console.service
      /usr/bin/setup-atomic-registry.sh)

DATADIRS=(/var/lib/atomic-registry)

echo "Removing configuration files..."
for CONFDIR in "${CONFDIRS[@]}"
do
  set -x
  chroot /host rm -rf ${CONFDIR}
  set +x
done

chroot /host systemctl daemon-reload

if [ $REMOVE_DATA == "true" ] ; then
  echo "Removing data..."
  for DATADIR in "${DATADIRS[@]}"
  do
    set -x
    chroot /host rm -rf ${DATADIR}
    set +x
  done
fi

IMAGES=(openshift/origin openshift/origin-docker-registry cockpit/kubernetes)

echo "Uninstallation complete."
echo "Images have not been removed. To remove them manually run:"
echo "sudo docker rmi ${IMAGES[*]}"
