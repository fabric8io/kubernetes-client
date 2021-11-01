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
import io.fabric8.kubernetes.client.ExtensionAdapter;
import io.fabric8.kubernetes.client.ExtensionAdapterSupport;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshot;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClass;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotContent;
import io.fabric8.volumesnapshot.client.internal.VolumeSnapshotClassOperationsImpl;
import io.fabric8.volumesnapshot.client.internal.VolumeSnapshotContentOperationsImpl;
import io.fabric8.volumesnapshot.client.internal.VolumeSnapshotOperationsImpl;

import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class VolumeSnapshotExtensionAdapter extends ExtensionAdapterSupport implements ExtensionAdapter<VolumeSnapshotClient> {

  static {
    Handlers.register(VolumeSnapshotClass.class, VolumeSnapshotClassOperationsImpl::new);
    Handlers.register(VolumeSnapshotContent.class, VolumeSnapshotContentOperationsImpl::new);
    Handlers.register(VolumeSnapshot.class, VolumeSnapshotOperationsImpl::new);
  }

  static final ConcurrentMap<URL, Boolean> IS_VOLUME_SNAPSHOT = new ConcurrentHashMap<>();
  static final ConcurrentMap<URL, Boolean> USES_VOLUME_SNAPSHOT_APIGROUPS = new ConcurrentHashMap<>();
  public static final String API_GROUP = "snapshot.storage.k8s.io";

  @Override
  public Class<VolumeSnapshotClient> getExtensionType() {
    return VolumeSnapshotClient.class;
  }

  @Override
  public Boolean isAdaptable(Client client) {
    return isAdaptable(client, IS_VOLUME_SNAPSHOT, USES_VOLUME_SNAPSHOT_APIGROUPS, API_GROUP);
  }

  @Override
  public VolumeSnapshotClient adapt(Client client) {
    return new DefaultVolumeSnapshotClient(client.adapt(HttpClient.class), client.getConfiguration());
  }

}
