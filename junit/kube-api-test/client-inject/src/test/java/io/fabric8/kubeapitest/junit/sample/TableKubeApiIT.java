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
package io.fabric8.kubeapitest.junit.sample;

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Table;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubeAPIServer
class TableKubeApiIT {

  static KubernetesClient client;

  private static final String TEST_NAMESPACE = "table-test";

  @BeforeAll
  static void setUp() {
    client.resource(new NamespaceBuilder()
        .withNewMetadata().withName(TEST_NAMESPACE).endMetadata()
        .build()).create();

    client.configMaps().inNamespace(TEST_NAMESPACE).resource(new ConfigMapBuilder()
        .withNewMetadata()
        .withName("cm-one")
        .withLabels(Map.of("app", "test"))
        .endMetadata()
        .addToData("key1", "value1")
        .build()).create();

    client.configMaps().inNamespace(TEST_NAMESPACE).resource(new ConfigMapBuilder()
        .withNewMetadata()
        .withName("cm-two")
        .withLabels(Map.of("app", "test"))
        .endMetadata()
        .addToData("key2", "value2")
        .build()).create();
  }

  @AfterAll
  static void tearDown() {
    client.namespaces().withName(TEST_NAMESPACE).delete();
  }

  @Test
  void getAsTableReturnsSingleResourceAsTable() {
    Table result = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .withName("cm-one")
        .getAsTable();

    assertThat(result).isNotNull();
    assertThat(result.getKind()).isEqualTo("Table");
    assertThat(result.getApiVersion()).isEqualTo("meta.k8s.io/v1");
    assertThat(result.getColumnDefinitions()).isNotEmpty();
    assertThat(result.getRows()).hasSize(1);
  }

  @Test
  void getAsTableReturnsNullForMissingResource() {
    Table result = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .withName("nonexistent")
        .getAsTable();

    assertThat(result).isNull();
  }

  @Test
  void listAsTableReturnsAllResourcesAsTableRows() {
    Table result = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .listAsTable();

    assertThat(result).isNotNull();
    assertThat(result.getKind()).isEqualTo("Table");
    assertThat(result.getApiVersion()).isEqualTo("meta.k8s.io/v1");
    assertThat(result.getColumnDefinitions()).isNotEmpty();
    assertThat(result.getRows().size()).isGreaterThanOrEqualTo(2);
  }

  @Test
  void listAsTableWithListOptionsRespectsLimit() {
    Table result = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .listAsTable(new ListOptionsBuilder().withLimit(1L).build());

    assertThat(result.getKind()).isEqualTo("Table");
    assertThat(result.getApiVersion()).isEqualTo("meta.k8s.io/v1");
    assertThat(result.getRows()).hasSize(1);
  }

  @Test
  void getAsTableWorksForClusterScopedResource() {
    Table result = client.namespaces()
        .withName(TEST_NAMESPACE)
        .getAsTable();

    assertThat(result).isNotNull();
    assertThat(result.getKind()).isEqualTo("Table");
    assertThat(result.getApiVersion()).isEqualTo("meta.k8s.io/v1");
    assertThat(result.getRows()).hasSize(1);
  }

  @Test
  void listAsTableWithLabelSelectorFiltersResults() {
    Table result = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .withLabel("app", "test")
        .listAsTable();

    assertThat(result.getKind()).isEqualTo("Table");
    assertThat(result.getRows()).hasSizeGreaterThanOrEqualTo(2);
  }
}
