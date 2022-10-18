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

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClass;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClassBuilder;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClassList;
import io.fabric8.volumesnapshot.client.VolumeSnapshotClassResource;
import io.fabric8.volumesnapshot.client.VolumeSnapshotClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient(crud = true)
class VolumeSnapshotClassTest {
  VolumeSnapshotClient client;

  @Test
  void testCrud() {

    VolumeSnapshotClass vsc1 = new VolumeSnapshotClassBuilder()
        .withNewMetadata()
        .withName("csi-snapclass1")
        .addToLabels("key1", "value1")
        .endMetadata()
        .withDriver("foo.csi.k8s.io")
        .withDeletionPolicy("Delete")
        .build();
    VolumeSnapshotClass vsc2 = new VolumeSnapshotClassBuilder()
        .withNewMetadata()
        .withName("csi-snapclass2")
        .addToLabels("key2", "value2")
        .endMetadata()
        .withDriver("foo.csi.k8s.io")
        .withDeletionPolicy("Delete")
        .build();
    VolumeSnapshotClass vsc3 = new VolumeSnapshotClassBuilder()
        .withNewMetadata()
        .withName("csi-snapclass3")
        .addToLabels("key3", "value3")
        .endMetadata()
        .withDriver("foo.csi.k8s.io")
        .withDeletionPolicy("Delete")
        .build();

    //Create
    client.volumeSnapshotClasses().create(vsc1);
    client.volumeSnapshotClasses().create(vsc2);
    client.volumeSnapshotClasses().create(vsc3);

    //Read
    VolumeSnapshotClassList vscList = client.volumeSnapshotClasses().list();
    assertNotNull(vscList);
    assertEquals(3, vscList.getItems().size());

    VolumeSnapshotClassResource scr1 = client.volumeSnapshotClasses().withName("csi-snapclass1");
    VolumeSnapshotClass sc1 = scr1.get();
    assertNotNull(sc1);

    //Update
    VolumeSnapshotClass u1 = client.volumeSnapshotClasses().withName("csi-snapclass2")
        .edit(v -> new VolumeSnapshotClassBuilder(v)
            .editMetadata()
            .addToLabels("updated", "true")
            .endMetadata()
            .build());

    assertNotNull(u1);
    assertEquals("true", u1.getMetadata().getLabels().get("updated"));

    //Delete
    assertEquals(1, scr1.delete().size());
    assertNull(scr1.get());
  }
}
