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
package io.fabric8.verticalpodautoscaler.client;

import io.fabric8.verticalpodautoscaler.client.dsl.V1APIGroupDSL;
import io.fabric8.kubernetes.client.*;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import okhttp3.OkHttpClient;

public class DefaultVerticalPodAutoscalerClient extends BaseClient implements NamespacedVerticalPodAutoscalerClient {

  public DefaultVerticalPodAutoscalerClient() {
    super();
  }

  public DefaultVerticalPodAutoscalerClient(Config configuration) {
    super(configuration);
  }

  public DefaultVerticalPodAutoscalerClient(OkHttpClient httpClient, Config configuration) {
    super(httpClient, configuration);
  }

  @Override
  public NamespacedVerticalPodAutoscalerClient inAnyNamespace() {
    return inNamespace(null);
  }

  @Override
  public NamespacedVerticalPodAutoscalerClient inNamespace(String namespace) {
    Config updated = new ConfigBuilder(getConfiguration())
      .withNamespace(namespace)
      .build();

    return new DefaultVerticalPodAutoscalerClient(getHttpClient(), updated);
  }

  @Override
  public FunctionCallable<NamespacedVerticalPodAutoscalerClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public V1APIGroupDSL v1() { return adapt(V1APIGroupClient.class); }

}
