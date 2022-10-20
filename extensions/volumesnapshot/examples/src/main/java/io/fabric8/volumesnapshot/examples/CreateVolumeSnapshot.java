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
package io.fabric8.volumesnapshot.examples;

import io.fabric8.volumesnapshot.api.model.VolumeSnapshotBuilder;
import io.fabric8.volumesnapshot.client.VolumeSnapshotClient;

@SuppressWarnings("java:S106")
public class CreateVolumeSnapshot {

  public static void main(String[] args) {
    try (VolumeSnapshotClient client = ClientFactory.newClient(args)) {
      System.out.println("Creating a volume snapshot");
      client.volumeSnapshots().inNamespace("default").create(new VolumeSnapshotBuilder()
          .withNewMetadata()
          .withName("my-snapshot")
          .endMetadata()
          .withNewSpec()
          .withNewSource()
          .withPersistentVolumeClaimName("my-pvc")
          .endSource()
          .endSpec()
          .build());
    }
  }
}
