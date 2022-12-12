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

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ExtensionRootClientAdapter;
import io.fabric8.kubernetes.client.extension.SupportTestingClient;
import io.fabric8.volcano.client.dsl.V1beta1APIGroupDSL;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import io.fabric8.volcano.scheduling.v1beta1.Queue;
import io.fabric8.volcano.scheduling.v1beta1.QueueList;

public class DefaultVolcanoClient extends ExtensionRootClientAdapter<DefaultVolcanoClient>
    implements NamespacedVolcanoClient, SupportTestingClient {

  public DefaultVolcanoClient() {
    super();
  }

  public DefaultVolcanoClient(Config configuration) {
    super(configuration);
  }

  public DefaultVolcanoClient(Client client) {
    super(client);
  }

  @Override
  protected DefaultVolcanoClient newInstance(Client client) {
    return new DefaultVolcanoClient(client);
  }

  @Override
  public FunctionCallable<NamespacedVolcanoClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public MixedOperation<PodGroup, PodGroupList, Resource<PodGroup>> podGroups() {
    // By default, client.podGroups() use v1beta1 version,
    return resources(PodGroup.class, PodGroupList.class);
  }

  @Override
  public MixedOperation<Queue, QueueList, Resource<Queue>> queues() {
    // By default, client.podGroups() use v1beta1 version,
    return resources(Queue.class, QueueList.class);
  }

  @Override
  public V1beta1APIGroupDSL v1beta1() {
    // User can specify client.v1beta1().podGroups() to use v1beta1 API
    return adapt(V1beta1APIGroupClient.class);
  }

  @Override
  public boolean isSupported() {
    return getClient().hasApiGroup(VolcanoExtensionAdapter.API_GROUP, false);
  }
}
