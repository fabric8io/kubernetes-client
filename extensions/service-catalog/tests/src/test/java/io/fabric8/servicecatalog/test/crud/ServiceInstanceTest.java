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
package io.fabric8.servicecatalog.test.crud;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.servicecatalog.api.model.ServiceInstance;
import io.fabric8.servicecatalog.api.model.ServiceInstanceBuilder;
import io.fabric8.servicecatalog.api.model.ServiceInstanceList;
import io.fabric8.servicecatalog.client.ServiceCatalogClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient(crud = true)
class ServiceInstanceTest {

  ServiceCatalogClient client;

  @Test
  void testCrud() {

    ServiceInstance instance1 = new ServiceInstanceBuilder()
        .withNewMetadata()
        .withName("instance1")
        .addToLabels("key1", "value1")
        .endMetadata()
        .withNewSpec()
        .withClusterServiceClassExternalName("class1")
        .withClusterServicePlanExternalName("default")
        .endSpec()
        .build();

    ServiceInstance instance2 = new ServiceInstanceBuilder()
        .withNewMetadata()
        .withName("instance2")
        .addToLabels("key2", "value2")
        .endMetadata()
        .withNewSpec()
        .withClusterServiceClassExternalName("class2")
        .withClusterServicePlanExternalName("default")
        .endSpec()
        .build();

    ServiceInstance instance3 = new ServiceInstanceBuilder()
        .withNewMetadata()
        .withName("instance3")
        .addToLabels("key3", "value3")
        .endMetadata()
        .withNewSpec()
        .withClusterServiceClassExternalName("class3")
        .withClusterServicePlanExternalName("default")
        .endSpec()
        .build();

    ServiceInstance instance4 = new ServiceInstanceBuilder()
        .withNewMetadata()
        .withName("instance4")
        .addToLabels("key4", "value4")
        .endMetadata()
        .withNewSpec()
        .withClusterServiceClassExternalName("class4")
        .withClusterServicePlanExternalName("default")
        .endSpec()
        .build();

    //Create
    client.serviceInstances().inNamespace("testns").create(instance1);
    client.serviceInstances().inNamespace("testns").create(instance2);
    client.serviceInstances().inNamespace("testns").create(instance3);
    client.serviceInstances().inNamespace("otherns").create(instance4);

    //Read
    ServiceInstanceList instances = client.serviceInstances().inNamespace("testns").list();
    assertNotNull(instances);
    assertEquals(3, instances.getItems().size());

    instances = client.serviceInstances().inNamespace("otherns").list();
    assertNotNull(instances);
    assertEquals(1, instances.getItems().size());

    ServiceInstance r1 = client.serviceInstances().inNamespace("testns").withName("instance1").get();
    assertNotNull(r1);

    //Update
    ServiceInstance u1 = client.serviceInstances().inNamespace("testns").withName("instance1")
        .edit(s -> new ServiceInstanceBuilder(s)
            .editMetadata()
            .addToLabels("updated", "true")
            .endMetadata()
            .build());

    assertNotNull(u1);
    assertEquals("true", u1.getMetadata().getLabels().get("updated"));

    //Delete
    assertEquals(1, client.serviceInstances().inNamespace("testns").withName("instance1").delete().size());
    assertNull(client.serviceInstances().inNamespace("testns").withName("instance1").get());
  }
}
