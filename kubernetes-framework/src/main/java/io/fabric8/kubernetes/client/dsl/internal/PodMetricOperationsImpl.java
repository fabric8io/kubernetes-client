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

import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.PodMetricOperation;

import java.util.Map;

public class PodMetricOperationsImpl extends MetricOperationsImpl<PodMetrics, PodMetricsList> implements PodMetricOperation {

  public PodMetricOperationsImpl(Client client) {
    // default to any namespace
    this(HasMetadataOperationsImpl.defaultContext(client).withNamespace(null));
  }

  public PodMetricOperationsImpl(OperationContext context) {
    super(context.withPlural("pods"), PodMetrics.class, PodMetricsList.class);
  }

  @Override
  public PodMetrics metrics(String namespace, String podName) {
    return inNamespace(namespace).withName(podName).metric();
  }

  @Override
  public PodMetricsList metrics(String namespace) {
    return inNamespace(namespace).metrics();
  }

  @Override
  public PodMetricOperationsImpl inNamespace(String namespace) {
    return new PodMetricOperationsImpl(context.withNamespace(namespace));
  }

  @Override
  public PodMetricOperation withName(String name) {
    return new PodMetricOperationsImpl(context.withName(name));
  }

  @Override
  public PodMetricOperation withLabels(Map<String, String> labels) {
    return new PodMetricOperationsImpl(context.withLabels(labels));
  }
}
