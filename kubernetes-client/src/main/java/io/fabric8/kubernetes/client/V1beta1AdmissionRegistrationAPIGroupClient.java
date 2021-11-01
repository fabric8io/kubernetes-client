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

import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfigurationList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfigurationList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.http.HttpClient;

public class V1beta1AdmissionRegistrationAPIGroupClient extends BaseClient implements V1beta1AdmissionRegistrationAPIGroupDSL {
  public V1beta1AdmissionRegistrationAPIGroupClient() {
    super();
  }

  public V1beta1AdmissionRegistrationAPIGroupClient(HttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<ValidatingWebhookConfiguration, ValidatingWebhookConfigurationList, Resource<ValidatingWebhookConfiguration>> validatingWebhookConfigurations() {
    return Handlers.getOperation(ValidatingWebhookConfiguration.class, ValidatingWebhookConfigurationList.class, httpClient, getConfiguration());
  }

  @Override
  public NonNamespaceOperation<MutatingWebhookConfiguration, MutatingWebhookConfigurationList, Resource<MutatingWebhookConfiguration>> mutatingWebhookConfigurations() {
    return Handlers.getOperation(MutatingWebhookConfiguration.class, MutatingWebhookConfigurationList.class, httpClient, getConfiguration());
  }
}
