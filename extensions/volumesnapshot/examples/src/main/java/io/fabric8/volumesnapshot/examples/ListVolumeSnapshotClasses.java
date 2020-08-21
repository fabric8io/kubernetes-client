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

import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClassList;
import io.fabric8.volumesnapshot.client.VolumeSnapshotClient;

public class ListVolumeSnapshotClasses {

  @SuppressWarnings("java:S106")
  public static void main(String[] args) {
    try (VolumeSnapshotClient client = ClientFactory.newClient(args)) {
      System.out.println("Listing Volume Snapshot Classes:");
      VolumeSnapshotClassList list = client.volumeSnapshotClasses().list();
      list.getItems().forEach(b -> System.out.println(b.getDriver() + "\t\t\t\t" + b.getMetadata().getName()));
      System.out.println("Done");
    }
  }
}
