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

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.volcano.client.dsl.V1beta1APIGroupDSL;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import io.fabric8.volcano.scheduling.v1beta1.Queue;
import io.fabric8.volcano.scheduling.v1beta1.QueueList;
import okhttp3.OkHttpClient;

public class V1beta1APIGroupClient  extends BaseClient implements V1beta1APIGroupDSL {

  public V1beta1APIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<PodGroup, PodGroupList, Resource<PodGroup>> PodGroups() {
    return Handlers.getOperation(PodGroup.class, PodGroupList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Queue, QueueList, Resource<Queue>> Queues() {
    return Handlers.getOperation(Queue.class, QueueList.class, this.getHttpClient(), this.getConfiguration());
  }
}
