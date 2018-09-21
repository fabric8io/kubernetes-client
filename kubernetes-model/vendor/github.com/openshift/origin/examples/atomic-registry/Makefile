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

TEST_IMAGE=atomic-registry-install
INSTALLHOST=127.0.0.1

all-systemd: pull-images build-systemd install-atomic install-systemd test-systemd
all-allinone: pull-images build-allinone install-atomic install-allinone test-allinone

pull-images:
	for IMAGE in openshift/origin openshift/origin-docker-registry cockpit/kubernetes ; do \
			docker pull $$IMAGE ; \
	done

build-systemd:
	docker build -t $(TEST_IMAGE) systemd/.

build-allinone:
	docker build -t $(TEST_IMAGE) allinone/.

install-atomic:
	dnf install -y atomic

install-systemd:
	atomic install $(TEST_IMAGE) $(INSTALLHOST)
	systemctl enable --now atomic-registry-master.service
	while ! /bin/curl -kfLs https://localhost:8443/healthz; do \
	    /bin/sleep 1; \
	    echo -n '.'; \
	done
	/var/run/setup-atomic-registry.sh

install-allinone:
	atomic install $(TEST_IMAGE) $(INSTALLHOST)
	atomic run $(TEST_IMAGE) $(INSTALLHOST)

test-systemd:
	bash test.sh atomic-registry-master 127.0.0.1

test-allinone:
	bash test.sh origin 127.0.0.1

clean:
	atomic uninstall $(TEST_IMAGE) --remove-data
	docker rm `docker ps -qa`
