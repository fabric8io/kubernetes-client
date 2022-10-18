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
import io.fabric8.servicecatalog.api.model.ClusterServicePlan;
import io.fabric8.servicecatalog.api.model.ClusterServicePlanBuilder;
import io.fabric8.servicecatalog.api.model.ClusterServicePlanList;
import io.fabric8.servicecatalog.client.ServiceCatalogClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient(crud = true)
class ClusterServicePlanTest {

  ServiceCatalogClient client;

  @Test
  void testCrud() {

    ClusterServicePlan plan1 = new ClusterServicePlanBuilder()
        .withNewMetadata()
        .withName("plan1")
        .addToLabels("key1", "value1")
        .endMetadata()
        .withNewSpec()
        .withExternalName("plan1")
        .endSpec()
        .build();

    ClusterServicePlan plan2 = new ClusterServicePlanBuilder()
        .withNewMetadata()
        .withName("plan2")
        .addToLabels("key2", "value2")
        .endMetadata()
        .withNewSpec()
        .withExternalName("plan1")
        .endSpec()
        .build();

    ClusterServicePlan plan3 = new ClusterServicePlanBuilder()
        .withNewMetadata()
        .withName("plan3")
        .addToLabels("key3", "value3")
        .endMetadata()
        .withNewSpec()
        .withExternalName("plan1")
        .endSpec()
        .build();

    //Create
    client.clusterServicePlans().create(plan1);
    client.clusterServicePlans().create(plan2);
    client.clusterServicePlans().create(plan3);

    //Read
    ClusterServicePlanList plans = client.clusterServicePlans().list();
    assertNotNull(plans);
    assertEquals(3, plans.getItems().size());

    ClusterServicePlan r1 = client.clusterServicePlans().withName("plan1").get();
    assertNotNull(r1);

    //Update
    ClusterServicePlan u1 = client.clusterServicePlans().withName("plan1").edit(c -> new ClusterServicePlanBuilder(c)
        .editMetadata()
        .addToLabels("updated", "true")
        .endMetadata()
        .build());

    assertNotNull(u1);
    assertEquals("true", u1.getMetadata().getLabels().get("updated"));

    //Delete
    assertEquals(1, client.clusterServicePlans().withName("plan1").delete().size());
    assertNull(client.clusterServicePlans().withName("plan1").get());
  }
}
