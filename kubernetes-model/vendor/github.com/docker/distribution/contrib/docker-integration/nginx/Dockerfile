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

FROM nginx:1.9

COPY nginx.conf /etc/nginx/nginx.conf
COPY registry.conf /etc/nginx/conf.d/registry.conf
COPY docker-registry-v2.conf /etc/nginx/docker-registry-v2.conf
COPY registry-noauth.conf /etc/nginx/registry-noauth.conf
COPY registry-basic.conf /etc/nginx/registry-basic.conf
COPY test.passwd /etc/nginx/test.passwd
COPY ssl /etc/nginx/ssl
COPY v1 /var/www/html/v1
