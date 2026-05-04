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
import io.fabric8.kubernetes.api.model.PartialObjectMetadata;
import io.fabric8.kubernetes.api.model.PartialObjectMetadataList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;

@LoadKubernetesManifests("/partial-object-metadata-it.yml")
class PartialObjectMetadataIT {

  KubernetesClient client;

  @Test
  void get() {
    assertThat(client.configMaps().withName("partial-metadata-cm-one").getAsPartialObjectMetadata())
        .isNotNull()
        .returns("PartialObjectMetadata", PartialObjectMetadata::getKind)
        .returns("meta.k8s.io/v1", PartialObjectMetadata::getApiVersion)
        .extracting(PartialObjectMetadata::getMetadata)
        .returns("partial-metadata-cm-one", m -> m.getName())
        .extracting("labels", MAP)
        .containsEntry("app", "test")
        .containsEntry("tier", "frontend");
  }

  @Test
  void getReturnsNullForMissingResource() {
    assertThat(client.configMaps().withName("nonexistent").getAsPartialObjectMetadata())
        .isNull();
  }

  @Test
  void list() {
    assertThat(client.configMaps().listAsPartialObjectMetadata())
        .returns("PartialObjectMetadataList", PartialObjectMetadataList::getKind)
        .returns("meta.k8s.io/v1", PartialObjectMetadataList::getApiVersion)
        .extracting(PartialObjectMetadataList::getItems)
        .asList()
        .extracting("metadata.name")
        .contains("partial-metadata-cm-one", "partial-metadata-cm-two");
  }

  @Test
  void listWithLabelSelectorFiltersResults() {
    assertThat(client.configMaps().withLabel("tier", "backend").listAsPartialObjectMetadata().getItems())
        .hasSize(1)
        .extracting("metadata.name")
        .containsExactly("partial-metadata-cm-two");
  }

  @Test
  void getWorksForClusterScopedResource() {
    Namespace ns = client.namespaces().list().getItems().stream().findFirst().orElseThrow();

    assertThat(client.namespaces().withName(ns.getMetadata().getName()).getAsPartialObjectMetadata())
        .isNotNull()
        .returns("PartialObjectMetadata", PartialObjectMetadata::getKind)
        .returns("meta.k8s.io/v1", PartialObjectMetadata::getApiVersion);
  }

  @Test
  void listWithLimitRespectsLimit() {
    assertThat(client.configMaps().listAsPartialObjectMetadata(new ListOptionsBuilder().withLimit(1L).build()).getItems())
        .hasSize(1)
        .first()
        .returns("PartialObjectMetadata", PartialObjectMetadata::getKind);
  }
}