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

package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/configmap-it.yml")
class ConfigMapIT {

  KubernetesClient client;

  @Test
  void load() {
    ConfigMap aConfigMap = client.configMaps().load(getClass().getResourceAsStream("/test-configmap.yml")).item();
    assertThat(aConfigMap).isNotNull();
    assertEquals("game-config", aConfigMap.getMetadata().getName());
  }

  @Test
  void get() {
    ConfigMap configMap = client.configMaps().withName("configmap-get").get();
    assertThat(configMap).isNotNull();
  }

  @Test
  void list() {
    ConfigMapList aConfigMapList = client.configMaps().list();
    assertNotNull(aConfigMapList);
    assertTrue(aConfigMapList.getItems().size() >= 1);
  }

  @Test
  void update() {
    ConfigMap configMap = client.configMaps().withName("configmap-update").edit(c -> new ConfigMapBuilder(c)
        .editMetadata().withResourceVersion(null).endMetadata()
        .addToData("MSSQL", "Microsoft Database").build());

    assertNotNull(configMap);
    assertEquals("Microsoft Database", configMap.getData().get("MSSQL"));
  }

  @Test
  void delete() {
    // Given
    String configMapName = "configmap-delete";

    // When
    List<StatusDetails> deleteStatus = client.configMaps().withName(configMapName).delete();

    // Then
    assertThat(deleteStatus).hasSize(1);
  }
}
