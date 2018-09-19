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

FROM dmcgowan/token-server@sha256:5a6f76d3086cdf63249c77b521108387b49d85a30c5e1c4fe82fdf5ae3b76ba7

WORKDIR /

COPY ./.htpasswd /.htpasswd
COPY ./certs/auth.localregistry.cert /tls.cert
COPY ./certs/auth.localregistry.key /tls.key
COPY ./certs/signing.key /sign.key
