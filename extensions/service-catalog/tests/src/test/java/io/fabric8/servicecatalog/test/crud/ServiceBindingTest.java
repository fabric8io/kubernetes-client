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
import io.fabric8.servicecatalog.api.model.ServiceBinding;
import io.fabric8.servicecatalog.api.model.ServiceBindingBuilder;
import io.fabric8.servicecatalog.api.model.ServiceBindingList;
import io.fabric8.servicecatalog.client.ServiceCatalogClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient(crud = true)
class ServiceBindingTest {

  ServiceCatalogClient client;

  @Test
  void testCrud() {

    ServiceBinding binding1 = new ServiceBindingBuilder()
        .withNewMetadata()
        .withName("binding1")
        .addToLabels("key1", "value1")
        .endMetadata()
        .withNewSpec()
        .withSecretName("secret1")
        .withNewInstanceRef("instance1")
        .endSpec()
        .build();

    ServiceBinding binding2 = new ServiceBindingBuilder()
        .withNewMetadata()
        .withName("binding2")
        .addToLabels("key2", "value2")
        .endMetadata()
        .withNewSpec()
        .withSecretName("secret2")
        .withNewInstanceRef("instance2")
        .endSpec()
        .build();

    ServiceBinding binding3 = new ServiceBindingBuilder()
        .withNewMetadata()
        .withName("binding3")
        .addToLabels("key3", "value3")
        .endMetadata()
        .withNewSpec()
        .withSecretName("secret3")
        .withNewInstanceRef("instance3")
        .endSpec()
        .build();

    ServiceBinding binding4 = new ServiceBindingBuilder()
        .withNewMetadata()
        .withName("binding4")
        .addToLabels("key4", "value4")
        .endMetadata()
        .withNewSpec()
        .withSecretName("secret4")
        .withNewInstanceRef("instance4")
        .endSpec()
        .build();

    //Create
    client.serviceBindings().inNamespace("testns").create(binding1);
    client.serviceBindings().inNamespace("testns").create(binding2);
    client.serviceBindings().inNamespace("testns").create(binding3);
    client.serviceBindings().inNamespace("otherns").create(binding4);

    //Read
    ServiceBindingList bindings = client.serviceBindings().inNamespace("testns").list();
    assertNotNull(bindings);
    assertEquals(3, bindings.getItems().size());

    bindings = client.serviceBindings().inNamespace("otherns").list();
    assertNotNull(bindings);
    assertEquals(1, bindings.getItems().size());

    ServiceBinding r1 = client.serviceBindings().inNamespace("testns").withName("binding1").get();
    assertNotNull(r1);

    //Update
    ServiceBinding u1 = client.serviceBindings().inNamespace("testns").withName("binding1")
        .edit(s -> new ServiceBindingBuilder(s)
            .editMetadata()
            .addToLabels("updated", "true")
            .endMetadata()
            .build());

    assertNotNull(u1);
    assertEquals("true", u1.getMetadata().getLabels().get("updated"));

    //Delete
    assertEquals(1, client.serviceBindings().inNamespace("testns").withName("binding1").delete().size());
    assertNull(client.serviceBindings().inNamespace("testns").withName("binding1").get());
  }
}
