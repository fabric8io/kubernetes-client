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
package io.fabric8.openshift.client.dsl.internal.config;

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;

import okhttp3.OkHttpClient;

import io.fabric8.openshift.api.model.DNS;
import io.fabric8.openshift.api.model.DNSBuilder;
import io.fabric8.openshift.api.model.DNSList;

public class DNSOperationsImpl extends OpenShiftOperation<DNS, DNSList, Resource<DNS>> {

  public DNSOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config).withPropagationPolicy(DEFAULT_PROPAGATION_POLICY));
  }

  public DNSOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("config.openshift.io")
      .withApiGroupVersion("v1")
      .withPlural("dnses"));
    this.type = DNS.class;
    this.listType = DNSList.class;
  }

  @Override
  public DNSOperationsImpl newInstance(OperationContext context) {
    return new DNSOperationsImpl(context);
  }

  @Override
  public DNS edit(Visitor... visitors) {
    return patch(new DNSBuilder(getMandatory()).accept(visitors).build());
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
