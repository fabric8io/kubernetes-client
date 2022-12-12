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
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.extension.ExtensionRootClientAdapter;
import io.fabric8.kubernetes.client.extension.SupportTestingClient;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshot;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClass;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClassList;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotContent;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotContentList;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotList;

public class DefaultVolumeSnapshotClient extends ExtensionRootClientAdapter<DefaultVolumeSnapshotClient>
    implements NamespacedVolumeSnapshotClient, SupportTestingClient {

  public DefaultVolumeSnapshotClient() {
    super();
  }

  public DefaultVolumeSnapshotClient(Config configuration) {
    super(configuration);
  }

  public DefaultVolumeSnapshotClient(Client client) {
    super(client);
  }

  @Override
  protected DefaultVolumeSnapshotClient newInstance(Client client) {
    return new DefaultVolumeSnapshotClient(client);
  }

  @Override
  public NonNamespaceOperation<VolumeSnapshotClass, VolumeSnapshotClassList, VolumeSnapshotClassResource> volumeSnapshotClasses() {
    return resources(VolumeSnapshotClass.class, VolumeSnapshotClassList.class, VolumeSnapshotClassResource.class);
  }

  @Override
  public NonNamespaceOperation<VolumeSnapshotContent, VolumeSnapshotContentList, VolumeSnapshotContentResource> volumeSnapshotContents() {
    return resources(VolumeSnapshotContent.class, VolumeSnapshotContentList.class, VolumeSnapshotContentResource.class);
  }

  @Override
  public MixedOperation<VolumeSnapshot, VolumeSnapshotList, VolumeSnapshotResource> volumeSnapshots() {
    return resources(VolumeSnapshot.class, VolumeSnapshotList.class, VolumeSnapshotResource.class);
  }

  @Override
  public FunctionCallable<NamespacedVolumeSnapshotClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public boolean isSupported() {
    return getClient().hasApiGroup(VolumeSnapshotExtensionAdapter.API_GROUP, false);
  }
}
