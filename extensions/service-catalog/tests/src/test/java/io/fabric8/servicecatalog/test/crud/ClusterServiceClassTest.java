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
import io.fabric8.servicecatalog.api.model.ClusterServiceClass;
import io.fabric8.servicecatalog.api.model.ClusterServiceClassBuilder;
import io.fabric8.servicecatalog.api.model.ClusterServiceClassList;
import io.fabric8.servicecatalog.client.ServiceCatalogClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient(crud = true)
class ClusterServiceClassTest {

  ServiceCatalogClient client;

  @Test
  void testCrud() {

    ClusterServiceClass class1 = new ClusterServiceClassBuilder()
        .withNewMetadata()
        .withName("class1")
        .addToLabels("key1", "value1")
        .endMetadata()
        .withNewSpec()
        .withExternalName("class1")
        .endSpec()
        .build();

    ClusterServiceClass class2 = new ClusterServiceClassBuilder()
        .withNewMetadata()
        .withName("class2")
        .addToLabels("key2", "value2")
        .endMetadata()
        .withNewSpec()
        .withExternalName("class1")
        .endSpec()
        .build();

    ClusterServiceClass class3 = new ClusterServiceClassBuilder()
        .withNewMetadata()
        .withName("class3")
        .addToLabels("key3", "value3")
        .endMetadata()
        .withNewSpec()
        .withExternalName("class1")
        .endSpec()
        .build();

    //Create
    client.clusterServiceClasses().create(class1);
    client.clusterServiceClasses().create(class2);
    client.clusterServiceClasses().create(class3);

    //Read
    ClusterServiceClassList classs = client.clusterServiceClasses().list();
    assertNotNull(classs);
    assertEquals(3, classs.getItems().size());

    ClusterServiceClass r1 = client.clusterServiceClasses().withName("class1").get();
    assertNotNull(r1);

    //Update
    ClusterServiceClass u1 = client.clusterServiceClasses().withName("class1").edit(c -> new ClusterServiceClassBuilder(c)
        .editMetadata()
        .addToLabels("updated", "true")
        .endMetadata()
        .build());

    assertNotNull(u1);
    assertEquals("true", u1.getMetadata().getLabels().get("updated"));

    //Delete
    assertEquals(1, client.clusterServiceClasses().withName("class1").delete().size());
    assertNull(client.clusterServiceClasses().withName("class1").get());
  }
}
