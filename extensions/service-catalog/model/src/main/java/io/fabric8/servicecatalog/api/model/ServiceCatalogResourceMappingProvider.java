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
package io.fabric8.servicecatalog.api.model;

import io.fabric8.kubernetes.api.KubernetesResourceMappingProvider;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.servicecatalog.api.model.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceCatalogResourceMappingProvider implements KubernetesResourceMappingProvider {

  public final Map<String, Class<? extends KubernetesResource>> mappings = new HashMap<>();

  public ServiceCatalogResourceMappingProvider() {
    mappings.put("servicecatalog.k8s.io/v1beta1#ClusterServiceBroker", ClusterServiceBroker.class);
    mappings.put("servicecatalog.k8s.io/v1beta1#ClusterServiceClass", ClusterServiceClass.class);
    mappings.put("servicecatalog.k8s.io/v1beta1#ClusterServicePlan", ClusterServicePlan.class);
    mappings.put("servicecatalog.k8s.io/v1beta1#ServiceBroker", ServiceBroker.class);
    mappings.put("servicecatalog.k8s.io/v1beta1#ServiceBinding", ServiceBinding.class);
    mappings.put("servicecatalog.k8s.io/v1beta1#ServiceInstance", ServiceInstance.class);
    mappings.put("servicecatalog.k8s.io/v1beta1#ServiceClass", ServiceClass.class);
    mappings.put("servicecatalog.k8s.io/v1beta1#ServicePlan", ServicePlan.class);
  }

  public Map<String, Class<? extends KubernetesResource>> getMappings() {
    return mappings;
  }
}
