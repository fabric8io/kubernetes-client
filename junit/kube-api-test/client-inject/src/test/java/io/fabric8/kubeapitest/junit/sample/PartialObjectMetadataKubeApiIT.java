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
import io.fabric8.kubernetes.api.model.PartialObjectMetadata;
import io.fabric8.kubernetes.api.model.PartialObjectMetadataList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubeAPIServer
class PartialObjectMetadataKubeApiIT {

  static KubernetesClient client;

  private static final String TEST_NAMESPACE = "partial-metadata-test";

  @BeforeAll
  static void setUp() {
    client.resource(new NamespaceBuilder()
        .withNewMetadata().withName(TEST_NAMESPACE).endMetadata()
        .build()).create();

    client.configMaps().inNamespace(TEST_NAMESPACE).resource(new ConfigMapBuilder()
        .withNewMetadata()
        .withName("cm-one")
        .withLabels(Map.of("app", "test", "tier", "frontend"))
        .withAnnotations(Map.of("note", "first"))
        .endMetadata()
        .addToData("key1", "value1")
        .build()).create();

    client.configMaps().inNamespace(TEST_NAMESPACE).resource(new ConfigMapBuilder()
        .withNewMetadata()
        .withName("cm-two")
        .withLabels(Map.of("app", "test", "tier", "backend"))
        .endMetadata()
        .addToData("key2", "value2")
        .build()).create();
  }

  @AfterAll
  static void tearDown() {
    client.namespaces().withName(TEST_NAMESPACE).delete();
  }

  @Test
  void getAsPartialObjectMetadataReturnsPartialMetadataKind() {
    PartialObjectMetadata result = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .withName("cm-one")
        .getAsPartialObjectMetadata();

    assertThat(result).isNotNull();
    assertThat(result.getKind()).isEqualTo("PartialObjectMetadata");
    assertThat(result.getApiVersion()).isEqualTo("meta.k8s.io/v1");
    assertThat(result.getMetadata().getName()).isEqualTo("cm-one");
    assertThat(result.getMetadata().getNamespace()).isEqualTo(TEST_NAMESPACE);
    assertThat(result.getMetadata().getLabels())
        .containsEntry("app", "test")
        .containsEntry("tier", "frontend");
    assertThat(result.getMetadata().getAnnotations()).containsEntry("note", "first");
    assertThat(result.getMetadata().getUid()).isNotBlank();
    assertThat(result.getMetadata().getResourceVersion()).isNotBlank();
  }

  @Test
  void getAsPartialObjectMetadataReturnsNullForMissingResource() {
    PartialObjectMetadata result = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .withName("nonexistent")
        .getAsPartialObjectMetadata();

    assertThat(result).isNull();
  }

  @Test
  void listAsPartialObjectMetadataReturnsPartialMetadataListKind() {
    PartialObjectMetadataList result = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .listAsPartialObjectMetadata();

    assertThat(result.getKind()).isEqualTo("PartialObjectMetadataList");
    assertThat(result.getApiVersion()).isEqualTo("meta.k8s.io/v1");
    assertThat(result.getItems())
        .extracting("metadata.name")
        .contains("cm-one", "cm-two");
    assertThat(result.getItems()).allSatisfy(item -> {
      assertThat(item.getKind()).isEqualTo("PartialObjectMetadata");
      assertThat(item.getApiVersion()).isEqualTo("meta.k8s.io/v1");
    });
  }

  @Test
  void listAsPartialObjectMetadataWithLabelSelectorFiltersResults() {
    PartialObjectMetadataList result = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .withLabel("tier", "backend")
        .listAsPartialObjectMetadata();

    assertThat(result.getKind()).isEqualTo("PartialObjectMetadataList");
    assertThat(result.getItems())
        .hasSize(1)
        .extracting("metadata.name")
        .containsExactly("cm-two");
  }

  @Test
  void getAsPartialObjectMetadataWorksForClusterScopedResource() {
    PartialObjectMetadata result = client.namespaces()
        .withName(TEST_NAMESPACE)
        .getAsPartialObjectMetadata();

    assertThat(result).isNotNull();
    assertThat(result.getKind()).isEqualTo("PartialObjectMetadata");
    assertThat(result.getApiVersion()).isEqualTo("meta.k8s.io/v1");
    assertThat(result.getMetadata().getName()).isEqualTo(TEST_NAMESPACE);
    assertThat(result.getMetadata().getUid()).isNotBlank();
  }

  @Test
  void listAsPartialObjectMetadataWithListOptionsRespectsLimit() {
    PartialObjectMetadataList result = client.configMaps()
        .inNamespace(TEST_NAMESPACE)
        .listAsPartialObjectMetadata(new ListOptionsBuilder().withLimit(1L).build());

    assertThat(result.getKind()).isEqualTo("PartialObjectMetadataList");
    assertThat(result.getApiVersion()).isEqualTo("meta.k8s.io/v1");
    assertThat(result.getItems()).hasSize(1);
    assertThat(result.getItems().get(0).getKind()).isEqualTo("PartialObjectMetadata");
  }
}