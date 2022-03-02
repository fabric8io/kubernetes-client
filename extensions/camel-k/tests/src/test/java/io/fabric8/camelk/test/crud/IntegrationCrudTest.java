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
package io.fabric8.camelk.test.crud;

import io.fabric8.camelk.client.CamelKClient;
import io.fabric8.camelk.v1.Integration;
import io.fabric8.camelk.v1.IntegrationBuilder;
import io.fabric8.camelk.v1.IntegrationList;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMock;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMock(crud = true)
class IntegrationCrudTest {


  CamelKClient client;
  @Test
  void shouldReturnEmptyList() {

    IntegrationList list = client.v1().integrations().inNamespace("ns1").list();
    assertNotNull(list);
    assertTrue(list.getItems().isEmpty());
  }

  @Test
  void shouldListAndGetIntegration() {

    Integration integration2 = new IntegrationBuilder().withNewMetadata().withName("integration2").endMetadata().build();

    client.v1().integrations().inNamespace("ns2").create(integration2);
    IntegrationList integrationList = client.v1().integrations().inNamespace("ns2").list();
    assertNotNull(integrationList);
    assertEquals(1, integrationList.getItems().size());
    Integration integration = client.v1().integrations().inNamespace("ns2").withName("integration2").get();
    assertNotNull(integration);
    assertEquals("integration2", integration.getMetadata().getName());
  }

  @Test
  void shouldDeleteAIntegration() {

    Integration integration3 = new IntegrationBuilder().withNewMetadata().withName("integration3").endMetadata().build();

    client.v1().integrations().inNamespace("ns3").create(integration3);
    Boolean deleted = client.v1().integrations().inNamespace("ns3").withName("integration3").delete();
    assertTrue(deleted);
  }

  @Test
  void shouldLoadAIntegrationWithParams() {

    String definition = String.join("\n", Arrays.asList(
      "apiVersion: camel.apache.org/v1alpha1",
      "kind: Integration",
      "metadata:",
      "  name: integration4",
      "spec:",
      "  flows:",
      "  - from:",
      "      parameters:",
      "        period: \"1000\"",
      "      steps:",
      "      - set-body:",
      "          constant: Hello Camel K from yaml",
      "      - to: log:info",
      "      uri: timer:yaml",
      "  traits:",
      "    container:",
      "      configuration:",
      "        requestCPU: \"1\""
    ));

    Integration i = client.v1().integrations().inNamespace("ns4").load(new ByteArrayInputStream(definition.getBytes())).createOrReplace();
    assertNotNull(i);
  }

}
