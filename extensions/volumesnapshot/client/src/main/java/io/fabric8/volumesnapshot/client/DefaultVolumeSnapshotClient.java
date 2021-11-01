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

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshot;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClass;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClassList;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotContent;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotContentList;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotList;
import io.fabric8.volumesnapshot.client.internal.VolumeSnapshotClassOperationsImpl;
import io.fabric8.volumesnapshot.client.internal.VolumeSnapshotClassResource;
import io.fabric8.volumesnapshot.client.internal.VolumeSnapshotContentOperationsImpl;
import io.fabric8.volumesnapshot.client.internal.VolumeSnapshotContentResource;
import io.fabric8.volumesnapshot.client.internal.VolumeSnapshotOperationsImpl;
import io.fabric8.volumesnapshot.client.internal.VolumeSnapshotResource;

public class DefaultVolumeSnapshotClient extends BaseClient implements NamespacedVolumeSnapshotClient {

  public DefaultVolumeSnapshotClient() {
    super();
  }

  public DefaultVolumeSnapshotClient(Config configuration) {
    super(configuration);
  }

  public DefaultVolumeSnapshotClient(HttpClient httpClient, Config configuration) {
    super(httpClient, configuration);
  }

  @Override
public NonNamespaceOperation<VolumeSnapshotClass, VolumeSnapshotClassList, VolumeSnapshotClassResource> volumeSnapshotClasses() {
    return new VolumeSnapshotClassOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
public NonNamespaceOperation<VolumeSnapshotContent, VolumeSnapshotContentList, VolumeSnapshotContentResource> volumeSnapshotContents() {
    return new VolumeSnapshotContentOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
public MixedOperation<VolumeSnapshot, VolumeSnapshotList, VolumeSnapshotResource> volumeSnapshots() {
    return new VolumeSnapshotOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public NamespacedVolumeSnapshotClient inAnyNamespace() {
    return inNamespace(null);
  }

  @Override
  public NamespacedVolumeSnapshotClient inNamespace(String namespace) {
    Config updated = new ConfigBuilder(getConfiguration())
      .withNamespace(namespace)
      .build();

    return new DefaultVolumeSnapshotClient(getHttpClient(), updated);
  }

  @Override
  public FunctionCallable<NamespacedVolumeSnapshotClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }
}
