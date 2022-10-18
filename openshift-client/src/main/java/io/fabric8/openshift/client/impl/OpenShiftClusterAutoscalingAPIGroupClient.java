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
package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.openshift.client.dsl.OpenShiftClusterAutoscalingAPIGroupDSL;
import io.fabric8.openshift.client.dsl.V1ClusterAutoscalingAPIGroupDSL;
import io.fabric8.openshift.client.dsl.V1beta1ClusterAutoscalingAPIGroupDSL;

public class OpenShiftClusterAutoscalingAPIGroupClient extends ClientAdapter<OpenShiftClusterAutoscalingAPIGroupClient>
    implements OpenShiftClusterAutoscalingAPIGroupDSL {

  @Override
  public V1ClusterAutoscalingAPIGroupDSL v1() {
    return adapt(V1OpenShiftClusterAutoscalingAPIGroupClient.class);
  }

  @Override
  public V1beta1ClusterAutoscalingAPIGroupDSL v1beta1() {
    return adapt(V1beta1OpenShiftClusterAutoscalingAPIGroupClient.class);
  }

  @Override
  public OpenShiftClusterAutoscalingAPIGroupClient newInstance() {
    return new OpenShiftClusterAutoscalingAPIGroupClient();
  }
}
