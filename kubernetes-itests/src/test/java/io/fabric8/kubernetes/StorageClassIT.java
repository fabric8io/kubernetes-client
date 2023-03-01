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
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassBuilder;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/storageclass-it.yml")
class StorageClassIT {

  KubernetesClient client;

  @Test
  void load() {
    StorageClass storageClassLoaded = client.storage().storageClasses()
        .load(getClass().getResourceAsStream("/test-storageclass.yml")).item();
    assertNotNull(storageClassLoaded);
    assertEquals("gluster-vol-default", storageClassLoaded.getMetadata().getName());
  }

  @Test
  void get() {
    StorageClass storageClass = client.storage().storageClasses().withName("storageclass-get").get();
    assertNotNull(storageClass);
  }

  @Test
  void list() {
    StorageClassList storageClassList = client.storage().storageClasses().list();
    assertNotNull(storageClassList);
    assertTrue(storageClassList.getItems().size() >= 1);
  }

  @Test
  void update() {
    StorageClass storageClass = client.storage().storageClasses().withName("storageclass-update")
        .edit(s -> new StorageClassBuilder(s)
            .editMetadata().withResourceVersion(null).addToLabels("testLabel", "testLabelValue").endMetadata().build());
    assertNotNull(storageClass);
    assertEquals("testLabelValue", storageClass.getMetadata().getLabels().get("testLabel"));
  }

  @Test
  void delete() {
    assertTrue(client.storage().storageClasses().withName("storageclass-delete").delete().size() == 1);
  }

}
