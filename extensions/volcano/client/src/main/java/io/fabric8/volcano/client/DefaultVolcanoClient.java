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
package io.fabric8.volcano.client;

import io.fabric8.kubernetes.client.*;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.volcano.client.dsl.V1beta1APIGroupDSL;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import io.fabric8.volcano.scheduling.v1beta1.Queue;
import io.fabric8.volcano.scheduling.v1beta1.QueueList;
import okhttp3.OkHttpClient;

public class DefaultVolcanoClient extends BaseClient implements NamespacedVolcanoClient {

  public DefaultVolcanoClient() {
    super();
  }

  public DefaultVolcanoClient(Config configuration) {
    super(configuration);
  }

  public DefaultVolcanoClient(OkHttpClient httpClient, Config configuration) {
    super(httpClient, configuration);
  }

  @Override
  public NamespacedVolcanoClient inAnyNamespace() {
    return inNamespace(null);
  }

  @Override
  public NamespacedVolcanoClient inNamespace(String namespace) {
    Config updated = new ConfigBuilder(getConfiguration())
      .withNamespace(namespace)
      .build();
    return new DefaultVolcanoClient(getHttpClient(), updated);
  }

  @Override
  public FunctionCallable<NamespacedVolcanoClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public MixedOperation<PodGroup, PodGroupList, Resource<PodGroup>> PodGroups() {
    // By default, client.PodGroups() use v1beta1 version,
    return Handlers.getOperation(PodGroup.class, PodGroupList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Queue, QueueList, Resource<Queue>> Queues() {
    // By default, client.PodGroups() use v1beta1 version,
    return Handlers.getOperation(Queue.class, QueueList.class, this.getHttpClient(), this.getConfiguration());
  }


  @Override
  public V1beta1APIGroupDSL v1beta1() {
    // User can specify client.v1beta1().PodGroups() to use v1beta1 API
    return adapt(V1beta1APIGroupClient.class);
  }
}
