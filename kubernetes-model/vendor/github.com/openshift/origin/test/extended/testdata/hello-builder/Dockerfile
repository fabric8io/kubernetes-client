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

FROM openshift/origin-release:latest
LABEL io.openshift.s2i.scripts-url=image:///usr/libexec/s2i
ENV STI_SCRIPTS_PATH=/usr/libexec/s2i
COPY scripts $STI_SCRIPTS_PATH
RUN chown 1001 /openshifttmp
USER 1001 
