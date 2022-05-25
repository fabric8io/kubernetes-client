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
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@LoadKubernetesManifests("/patch-it.yml")
class PatchIT {

  KubernetesClient client;

  @Test
  void testJsonPatch() {
    // Given
    String name = "patchit-testjsonpatch";

    // When
    ConfigMap patchedConfigMap = client.configMaps().withName(name).patch("{\"metadata\":{\"labels\":{\"version\":\"v1\"}}}");

    // Then
    assertThat(patchedConfigMap).isNotNull();
    assertThat(patchedConfigMap.getMetadata().getLabels()).isNotNull()
        .hasFieldOrPropertyWithValue("version", "v1");
  }

  @Test
  void testJsonMergePatch() {
    // Given
    String name = "patchit-testjsonmergepatch";
    PatchContext patchContext = new PatchContext.Builder().withPatchType(PatchType.JSON_MERGE).build();

    // When
    ConfigMap patchedConfigMap = client.configMaps().withName(name)
        .patch(patchContext, "{\"metadata\":{\"annotations\":{\"foo\":null}}}");

    // Then
    assertThat(patchedConfigMap).isNotNull();
    assertThat(patchedConfigMap.getMetadata().getAnnotations()).isNullOrEmpty();
  }

  @Test
  void testJsonPatchWithPositionalArrays() {
    // Given
    String name = "patchit-testjsonpatchpositionalarray";
    PatchContext patchContext = new PatchContext.Builder().withPatchType(PatchType.JSON).build();

    // When
    ReplicaSet patchedReplicaSet = client.apps().replicaSets().withName(name)
        .patch(patchContext,
            "[{\"op\": \"replace\", \"path\":\"/spec/template/spec/containers/0/image\", \"value\":\"foo/gb-frontend:v4\"}]");

    // Then
    assertThat(patchedReplicaSet).isNotNull();
    assertThat(patchedReplicaSet.getSpec().getTemplate().getSpec().getContainers().get(0).getImage())
        .isEqualTo("foo/gb-frontend:v4");
  }

  @Test
  void testYamlPatch() {
    // Given
    String name = "patchit-testyamlpatch";

    // When
    ConfigMap patchedConfigMap = client.configMaps().withName(name)
        .patch("data:\n  version: v1\n  status: patched");

    // Then
    assertThat(patchedConfigMap).isNotNull();
    assertThat(patchedConfigMap.getData())
        .hasFieldOrPropertyWithValue("version", "v1")
        .hasFieldOrPropertyWithValue("status", "patched");
  }

  @Test
  void testFullObjectPatch() {
    // Given
    String name = "patchit-fullobjectpatch";

    // When
    ConfigMap configMapFromServer = client.configMaps().withName(name).get();
    configMapFromServer.setData(Collections.singletonMap("foo", "bar"));
    ConfigMap patchedConfigMap = client.configMaps().withName(name).patch(configMapFromServer);

    // Then
    assertThat(patchedConfigMap).isNotNull();
    assertThat(patchedConfigMap.getData()).hasFieldOrPropertyWithValue("foo", "bar");
  }

  @Test
  void testFullObjectPatchWithConcurrentChange() {
    // Given
    String name = "patchit-fullobjectpatch";

    // When
    ConfigMap configMapFromServer = client.configMaps().withName(name).get();
    configMapFromServer.setData(Collections.singletonMap("conflicting", "change"));
    ConfigMap base = client.configMaps().withName(name).patch(configMapFromServer);

    // concurrent change to empty
    ConfigMap baseCopy = new ConfigMapBuilder(base).build();
    baseCopy.setData(Collections.emptyMap());
    client.configMaps().withName(name).patch(baseCopy);

    // concurrent change to empty
    ConfigMap baseCopy2 = new ConfigMapBuilder(base).build();
    baseCopy2.setData(Collections.singletonMap("conflicting", "second"));

    // optimistically locking should work because the resource version is set
    assertThrows(KubernetesClientException.class, () -> client.configMaps().withName(name)
        .patch(new PatchContext.Builder().withPatchType(PatchType.JSON_MERGE).build(), baseCopy2));

    baseCopy2.getMetadata().setResourceVersion(null);
    // will succeed when not locked
    client.configMaps().withName(name).patch(new PatchContext.Builder().withPatchType(PatchType.JSON_MERGE).build(), baseCopy2);
  }

}
