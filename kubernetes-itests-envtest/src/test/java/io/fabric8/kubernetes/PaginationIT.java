/*
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
package io.fabric8.kubernetes;

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.PartialObjectMetadataList;
import io.fabric8.kubernetes.api.model.Table;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubeAPIServer
class PaginationIT {

  static KubernetesClient client;

  private static final String TEST_NAMESPACE = "pagination-test";

  @BeforeAll
  static void setUp() {
    client.resource(new NamespaceBuilder()
        .withNewMetadata().withName(TEST_NAMESPACE).endMetadata()
        .build()).create();

    for (int i = 1; i <= 3; i++) {
      client.configMaps().inNamespace(TEST_NAMESPACE).resource(new ConfigMapBuilder()
          .withNewMetadata()
          .withName("cm-" + i)
          .endMetadata()
          .addToData("key", "value-" + i)
          .build()).create();
    }
  }

  @AfterAll
  static void tearDown() {
    client.namespaces().withName(TEST_NAMESPACE).delete();
  }

  @Test
  void listAsPartialObjectMetadataWithContinueTokenPaginates() {
    PartialObjectMetadataList firstPage = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .listAsPartialObjectMetadata(new ListOptionsBuilder().withLimit(2L).build());

    assertThat(firstPage.getItems()).hasSize(2);
    assertThat(firstPage.getMetadata().getContinue()).isNotBlank();

    String continueToken = firstPage.getMetadata().getContinue();

    PartialObjectMetadataList secondPage = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .listAsPartialObjectMetadata(new ListOptionsBuilder()
            .withLimit(2L)
            .withContinue(continueToken)
            .build());

    assertThat(secondPage.getItems()).hasSize(1);
    // second page is the last page, so the server should not emit another continue token
    assertThat(secondPage.getMetadata().getContinue()).isNullOrEmpty();
    // the union of both pages covers every ConfigMap exactly once — proves the server
    // honored the continue token rather than restarting from the beginning
    Set<String> visitedNames = new HashSet<>();
    firstPage.getItems().forEach(i -> visitedNames.add(i.getMetadata().getName()));
    secondPage.getItems().forEach(i -> visitedNames.add(i.getMetadata().getName()));
    assertThat(visitedNames).containsExactlyInAnyOrder("cm-1", "cm-2", "cm-3");
  }

  @Test
  void listAsTableWithContinueTokenPaginates() {
    Table firstPage = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .listAsTable(new ListOptionsBuilder().withLimit(2L).build());

    assertThat(firstPage.getRows()).hasSize(2);
    assertThat(firstPage.getMetadata().getContinue()).isNotBlank();

    String continueToken = firstPage.getMetadata().getContinue();

    Table secondPage = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .listAsTable(new ListOptionsBuilder()
            .withLimit(2L)
            .withContinue(continueToken)
            .build());

    assertThat(secondPage.getRows()).hasSize(1);
    // second page is the last page, so the server should not emit another continue token
    assertThat(secondPage.getMetadata().getContinue()).isNullOrEmpty();
  }
}
