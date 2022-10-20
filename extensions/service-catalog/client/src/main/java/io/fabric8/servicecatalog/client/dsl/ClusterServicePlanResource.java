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
package io.fabric8.servicecatalog.client.dsl;

import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.servicecatalog.api.model.*;

public interface ClusterServicePlanResource extends Resource<ClusterServicePlan> {

  /**
   * Instantiate the {@link ClusterServicePlan}.
   * 
   * @param args The instance name, or the namespace and instance name (var-arg).
   * @return The {@link ServiceInstance}.
   */
  ServiceInstance instantiate(String... args);

  /**
   * Instantiate the {@link ClusterServicePlan} and returns the {@link ServiceInstanceResource}.
   * 
   * @param args The instance name, or the namespace and instance name (var-arg).
   * @return The {@link ServiceInstanceResource}.
   */
  ServiceInstanceResource instantiateAnd(String... args);
}
