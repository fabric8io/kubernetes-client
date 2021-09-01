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
package io.fabric8.volumesnapshot.client.internal;

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotContent;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotContentBuilder;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotContentList;
import okhttp3.OkHttpClient;


public class VolumeSnapshotContentOperationsImpl extends HasMetadataOperation<VolumeSnapshotContent, VolumeSnapshotContentList, VolumeSnapshotContentResource> implements VolumeSnapshotContentResource {

  public VolumeSnapshotContentOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public VolumeSnapshotContentOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("snapshot.storage.k8s.io").withApiGroupVersion("v1").withPlural("volumesnapshotcontents"),
            VolumeSnapshotContent.class, VolumeSnapshotContentList.class);
  }

  @Override
  public BaseOperation<VolumeSnapshotContent, VolumeSnapshotContentList, VolumeSnapshotContentResource> newInstance(OperationContext context) {
    return new VolumeSnapshotContentOperationsImpl(context);
  }

  @Override
  public VolumeSnapshotContent edit(Visitor... visitors) {
    return patch(new VolumeSnapshotContentBuilder(getMandatory()).accept(visitors).build());
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
