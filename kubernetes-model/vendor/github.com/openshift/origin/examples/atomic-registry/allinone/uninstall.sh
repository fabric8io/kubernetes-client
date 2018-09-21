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


CMD="chroot /host docker exec -i origin"

# let's make sure we're logged in as admin/default
$CMD oc login -u system:admin
$CMD oc project default

SERVICES=(docker-registry registry-console)
for SERVICE in "${SERVICES[@]}"
do
  $CMD oc delete dc,service ${SERVICE} --grace-period=0
done

echo "Waiting for pods to terminate"

# poll for pods named "k8s", wait for them to die
until [[ $(chroot /host docker ps -f NAME=k8s --format '{{ .Names }}' | wc -l) == 0 ]]
do
  printf "."
  sleep 1
done

set -x
chroot /host docker stop origin
# remove all the containers that have started since origin
#docker rm $(docker ps --since=origin -qa)
# now remove origin
chroot /host docker rm origin

chroot /host find /var/lib/origin/volumes -type d -exec umount {} \; 2>/dev/null

echo "Removing configuration files..."
DIRS=(/etc/origin /var/lib/origin)
for DIR in "${DIRS[@]}"
do
  chroot /host rm -rf ${DIR}
done

set +x
IMAGES=(openshift/origin openshift/origin-docker-registry cockpit/kubernetes)

echo "Uninstallation complete."
echo "Stopped container and images have not been removed. To remove them manually run:"
echo "'sudo docker rm \$(sudo docker ps -qa)'"
echo "'sudo docker rmi ${IMAGES[*]}'"
