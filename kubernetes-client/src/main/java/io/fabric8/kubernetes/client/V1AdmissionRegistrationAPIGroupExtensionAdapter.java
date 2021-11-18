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

public class V1AdmissionRegistrationAPIGroupExtensionAdapter extends APIGroupExtensionAdapter<V1AdmissionRegistrationAPIGroupClient> {
  @Override
  protected String getAPIGroupName() {
    return "admissionregistration/v1";
  }

  @Override
  public Class<V1AdmissionRegistrationAPIGroupClient> getExtensionType() {
    return V1AdmissionRegistrationAPIGroupClient.class;
  }

  @Override
  protected V1AdmissionRegistrationAPIGroupClient newInstance(Client client) {
    return new V1AdmissionRegistrationAPIGroupClient(client);
  }
}
