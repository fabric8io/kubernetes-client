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


. shared.sh

curl \
  -X DELETE \
  -H "$apiVersion" \
  -H "X-Broker-API-Originating-Identity: Kubernetes $(echo -ne "{\"username\": \"$requesterUsername\", \"groups\": [\"system:authenticated\"]}" | base64 -w 100)" \
  -v \
  $curlargs \
  $endpoint/v2/service_instances/$instanceUUID'?accepts_incomplete=true'
