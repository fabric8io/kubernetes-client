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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/persistentvolumeclaims-it.yml")
class PersistentVolumeClaimIT {

  KubernetesClient client;

  @Test
  void get() {
    PersistentVolumeClaim persistentVolumeClaim = client.persistentVolumeClaims().withName("persistentvolumeclaims-get").get();
    assertThat(persistentVolumeClaim).isNotNull();
  }

  @Test
  void list() {
    PersistentVolumeClaimList aEndpointList = client.persistentVolumeClaims().list();
    assertNotNull(aEndpointList);
    assertTrue(aEndpointList.getItems().size() >= 1);
  }

  @Test
  void update() {
    PersistentVolumeClaim persistentVolumeClaim = client.persistentVolumeClaims()

        .withName("persistentvolumeclaims-update")
        .patch(PatchContext.of(PatchType.STRATEGIC_MERGE), new PersistentVolumeClaimBuilder()
            .withNewMetadata()
            .addToLabels("foo", "bar")
            .endMetadata()
            .build());

    assertNotNull(persistentVolumeClaim);
    assertEquals("bar", persistentVolumeClaim.getMetadata().getLabels().get("foo"));
  }

  @Test
  void delete() {
    assertTrue(client.persistentVolumeClaims().withName("persistentvolumeclaims-delete").delete().size() == 1);
  }

}
