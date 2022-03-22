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
package io.fabric8.openclustermanagement.client;

import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta1.ObservabilityAddon;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta1.ObservabilityAddonList;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2.MultiClusterObservability;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2.MultiClusterObservabilityList;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementObservabilityAPIGroupDSL;

public class OpenClusterManagementObservabilityAPIGroupClient extends
    ClientAdapter<OpenClusterManagementObservabilityAPIGroupClient> implements OpenClusterManagementObservabilityAPIGroupDSL {

  @Override
  public OpenClusterManagementObservabilityAPIGroupClient newInstance() {
    return new OpenClusterManagementObservabilityAPIGroupClient();
  }

  @Override
  public NonNamespaceOperation<MultiClusterObservability, MultiClusterObservabilityList, Resource<MultiClusterObservability>> multiClusterObservailities() {
    return resources(MultiClusterObservability.class, MultiClusterObservabilityList.class);
  }

  @Override
  public MixedOperation<ObservabilityAddon, ObservabilityAddonList, Resource<ObservabilityAddon>> observabilityAddons() {
    return resources(ObservabilityAddon.class, ObservabilityAddonList.class);
  }
}
