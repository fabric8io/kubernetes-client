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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;

import okhttp3.OkHttpClient;

import io.fabric8.kubernetes.api.model.admissionregistration.DoneableValidatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.ValidatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.ValidatingWebhookConfigurationList;
import io.fabric8.kubernetes.api.model.admissionregistration.DoneableValidatingWebhookConfiguration;

import java.util.Map;
import java.util.TreeMap;


public class ValidatingWebhookConfigurationOperationsImpl extends HasMetadataOperation<ValidatingWebhookConfiguration, ValidatingWebhookConfigurationList, DoneableValidatingWebhookConfiguration, Resource<ValidatingWebhookConfiguration, DoneableValidatingWebhookConfiguration>> {

  public ValidatingWebhookConfigurationOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public ValidatingWebhookConfigurationOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("admissionregistration.k8s.io")
      .withApiGroupVersion("v1beta1")
      .withPlural("validatingwebhookconfigurations"));
    this.type = ValidatingWebhookConfiguration.class;
    this.listType = ValidatingWebhookConfigurationList.class;
    this.doneableType = DoneableValidatingWebhookConfiguration.class;
  }
  @Override
  public ValidatingWebhookConfigurationOperationsImpl newInstance(OperationContext context) {
    return new ValidatingWebhookConfigurationOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}

