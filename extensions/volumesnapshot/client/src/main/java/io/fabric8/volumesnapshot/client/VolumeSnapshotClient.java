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
package io.fabric8.volumesnapshot.client;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshot;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClass;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClassList;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotContent;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotContentList;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotList;

/**
 * Main interface for VolumeSnapshot Client library.
 */
public interface VolumeSnapshotClient extends Client {

  /**
   * API entrypoint for dealing with VolumeSnapshotClass(snapshot.storage.k8s.io/v1)
   *
   * @return NonNamespaceOperation for VolumeSnapshotClass class
   */
  NonNamespaceOperation<VolumeSnapshotClass, VolumeSnapshotClassList, VolumeSnapshotClassResource> volumeSnapshotClasses();

  /**
   * API entrypoint for dealing with VolumeSnapshotContent(snapshot.storage.k8s.io/v1)
   *
   * @return NonNamespaceOperation for VolumeSnapshotContent class
   */
  NonNamespaceOperation<VolumeSnapshotContent, VolumeSnapshotContentList, VolumeSnapshotContentResource> volumeSnapshotContents();

  /**
   * API entrypoint for dealing with VolumeSnapshot(snapshot.storage.k8s.io/v1)
   *
   * @return MixedOperation for VolumeSnapshot class
   */
  MixedOperation<VolumeSnapshot, VolumeSnapshotList, VolumeSnapshotResource> volumeSnapshots();
}
