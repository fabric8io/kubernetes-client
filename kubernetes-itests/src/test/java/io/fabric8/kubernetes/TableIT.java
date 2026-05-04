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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Table;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@LoadKubernetesManifests("/table-it.yml")
class TableIT {

  KubernetesClient client;

  @Test
  void get() {
    assertThat(client.configMaps().withName("table-cm-one").getAsTable())
        .isNotNull()
        .returns("Table", Table::getKind)
        .returns("meta.k8s.io/v1", Table::getApiVersion)
        .satisfies(t -> {
          assertThat(t.getColumnDefinitions()).isNotEmpty();
          assertThat(t.getRows()).hasSize(1);
        });
  }

  @Test
  void getReturnsNullForMissingResource() {
    assertThat(client.configMaps().withName("nonexistent").getAsTable())
        .isNull();
  }

  @Test
  void list() {
    assertThat(client.configMaps().listAsTable())
        .isNotNull()
        .returns("Table", Table::getKind)
        .returns("meta.k8s.io/v1", Table::getApiVersion)
        .satisfies(t -> {
          assertThat(t.getColumnDefinitions()).isNotEmpty();
          assertThat(t.getRows().size()).isGreaterThanOrEqualTo(2);
        });
  }

  @Test
  void listWithLimitRespectsLimit() {
    assertThat(client.configMaps().listAsTable(new ListOptionsBuilder().withLimit(1L).build()))
        .returns("Table", Table::getKind)
        .returns("meta.k8s.io/v1", Table::getApiVersion)
        .extracting(Table::getRows)
        .asList()
        .hasSize(1);
  }

  @Test
  void getWorksForClusterScopedResource() {
    Namespace ns = client.namespaces().list().getItems().stream().findFirst().orElseThrow();

    assertThat(client.namespaces().withName(ns.getMetadata().getName()).getAsTable())
        .isNotNull()
        .returns("Table", Table::getKind)
        .returns("meta.k8s.io/v1", Table::getApiVersion)
        .extracting(Table::getRows)
        .asList()
        .hasSize(1);
  }

  @Test
  void listWithLabelSelectorFiltersResults() {
    assertThat(client.configMaps().withLabel("app", "table-test").listAsTable())
        .returns("Table", Table::getKind)
        .extracting(Table::getRows)
        .asList()
        .hasSizeGreaterThanOrEqualTo(2);
  }
}