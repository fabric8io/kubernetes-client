/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.client.dsl.CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1CertificatesAPIGroupDSL;

public class CertificatesAPIGroupClient extends BaseClient implements CertificatesAPIGroupDSL {

  public CertificatesAPIGroupClient() {
    super();
  }

  public CertificatesAPIGroupClient(ClientState clientState) {
    super(clientState);
  }

  @Override
  public V1CertificatesAPIGroupDSL v1() {
    return adapt(V1CertificatesAPIGroupClient.class);
  }

  @Override
  public V1beta1CertificatesAPIGroupDSL v1beta1() {
    return adapt(V1beta1CertificatesAPIGroupClient.class);
  }
}
