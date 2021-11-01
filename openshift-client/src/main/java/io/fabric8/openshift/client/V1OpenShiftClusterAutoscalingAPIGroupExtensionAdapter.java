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

import io.fabric8.kubernetes.client.APIGroupExtensionAdapter;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.http.HttpClient;

public class V1OpenShiftClusterAutoscalingAPIGroupExtensionAdapter extends APIGroupExtensionAdapter<V1OpenShiftClusterAutoscalingAPIGroupClient> {
  @Override
  protected String getAPIGroupName() {
    return "clusterautoscaling.openshift.io/v1";
  }

  @Override
  public Class<V1OpenShiftClusterAutoscalingAPIGroupClient> getExtensionType() {
    return V1OpenShiftClusterAutoscalingAPIGroupClient.class;
  }

  @Override
  protected V1OpenShiftClusterAutoscalingAPIGroupClient newInstance(Client client) {
    return new V1OpenShiftClusterAutoscalingAPIGroupClient(client.adapt(HttpClient.class), client.getConfiguration());
  }
}
