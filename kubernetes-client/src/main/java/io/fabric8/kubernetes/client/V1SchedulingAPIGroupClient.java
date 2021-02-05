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

import io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClass;
import io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClassList;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.V1SchedulingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.internal.scheduling.v1.PriorityClassOperationsImpl;
import okhttp3.OkHttpClient;

public class V1SchedulingAPIGroupClient extends BaseClient implements V1SchedulingAPIGroupDSL {

  public V1SchedulingAPIGroupClient() {
    super();
  }

  public V1SchedulingAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  public NonNamespaceOperation<PriorityClass, PriorityClassList, Resource<PriorityClass>> priorityClasses() {
    return new PriorityClassOperationsImpl(httpClient, getConfiguration());
  }
}
