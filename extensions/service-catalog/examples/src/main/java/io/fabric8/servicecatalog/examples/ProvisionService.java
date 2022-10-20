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

package io.fabric8.servicecatalog.examples;

import io.fabric8.servicecatalog.api.model.ServiceInstance;
import io.fabric8.servicecatalog.api.model.ServiceInstanceBuilder;
import io.fabric8.servicecatalog.client.ServiceCatalogClient;

public class ProvisionService {

  public static void main(String[] args) {
    ServiceCatalogClient client = ClientFactory.newClient(args);
    System.out.println("Provisioning a service");
    ServiceInstance instance = client.serviceInstances().inNamespace("iocanel").create(new ServiceInstanceBuilder()
        .withNewMetadata()
        .withName("myserivce")
        .endMetadata()
        .withNewSpec()
        .withClusterServiceClassExternalName("jenkins-ephemeral")
        .withClusterServicePlanExternalName("default")
        .endSpec()
        .build());
    System.out.println("Done");
  }
}
