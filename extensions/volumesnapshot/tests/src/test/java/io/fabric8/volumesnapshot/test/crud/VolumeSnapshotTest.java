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
package io.fabric8.volumesnapshot.test.crud;


import io.fabric8.volumesnapshot.api.model.VolumeSnapshot;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotBuilder;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotList;
import io.fabric8.volumesnapshot.client.VolumeSnapshotClient;
import io.fabric8.volumesnapshot.server.mock.VolumeSnapshotServer;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableRuleMigrationSupport
class VolumeSnapshotTest {

  @Rule
  public VolumeSnapshotServer server = new VolumeSnapshotServer(true, true);

  @Test
  void testCrud() {
    VolumeSnapshotClient client = server.get();
    VolumeSnapshot vs1 = new VolumeSnapshotBuilder()
      .withNewMetadata()
      .withName("my-snapshot1")
      .addToLabels("key1", "value1")
      .endMetadata()
      .withNewSpec()
      .withNewVolumeSnapshotClassName("my-vsc")
      .withNewSource()
      .withNewPersistentVolumeClaimName("my-pvc1")
      .endSource()
      .endSpec()
      .build();
    VolumeSnapshot vs2 = new VolumeSnapshotBuilder()
      .withNewMetadata()
      .withName("my-snapshot2")
      .addToLabels("key2", "value2")
      .endMetadata()
      .withNewSpec()
      .withNewVolumeSnapshotClassName("my-vsc")
      .withNewSource()
      .withNewPersistentVolumeClaimName("my-pvc1")
      .endSource()
      .endSpec()
      .build();
    VolumeSnapshot vs3 = new VolumeSnapshotBuilder()
      .withNewMetadata()
      .withName("my-snapshot3")
      .addToLabels("key3", "value3")
      .endMetadata()
      .withNewSpec()
      .withNewVolumeSnapshotClassName("my-vsc")
      .withNewSource()
      .withNewPersistentVolumeClaimName("my-pvc2")
      .endSource()
      .endSpec()
      .build();

    //Create
    client.volumeSnapshots().create(vs1);
    client.volumeSnapshots().create(vs2);
    client.volumeSnapshots().create(vs3);

    //Read
    VolumeSnapshotList vsList = client.volumeSnapshots().list();
    assertNotNull(vsList);
    assertEquals(3, vsList.getItems().size());

    VolumeSnapshot s1 = client.volumeSnapshots().withName("my-snapshot1").get();
    assertNotNull(s1);


    //Update
    VolumeSnapshot u1 = client.volumeSnapshots().withName("my-snapshot1").edit(v -> new VolumeSnapshotBuilder(v)
      .editMetadata()
      .addToLabels("updated", "true")
      .endMetadata()
      .build());

    assertNotNull(u1);
    assertEquals("true", u1.getMetadata().getLabels().get("updated"));

    //Delete
    assertTrue(client.volumeSnapshots().withName("my-snapshot1").delete());
    assertNull(client.volumeSnapshots().withName("my-snapshot1").get());
  }
}
