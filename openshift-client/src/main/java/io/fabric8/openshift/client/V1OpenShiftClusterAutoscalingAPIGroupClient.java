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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscaler;
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscalerList;
import io.fabric8.openshift.client.dsl.V1ClusterAutoscalingAPIGroupDSL;
import io.fabric8.openshift.client.dsl.internal.autoscaling.ClusterAutoscalerOperationsImpl;
import okhttp3.OkHttpClient;

public class V1OpenShiftClusterAutoscalingAPIGroupClient extends BaseClient implements V1ClusterAutoscalingAPIGroupDSL {
  public V1OpenShiftClusterAutoscalingAPIGroupClient() {
    super();
  }

  public V1OpenShiftClusterAutoscalingAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public NonNamespaceOperation<ClusterAutoscaler, ClusterAutoscalerList, Resource<ClusterAutoscaler>> clusterAutoscalers() {
    return new ClusterAutoscalerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
