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

import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshot;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotList;

public class VolumeSnapshotOperationsImpl extends HasMetadataOperation<VolumeSnapshot, VolumeSnapshotList, VolumeSnapshotResource> implements VolumeSnapshotResource {

  public VolumeSnapshotOperationsImpl(ClientContext clientContext) {
    this(HasMetadataOperationsImpl.defaultContext(clientContext));
  }

  public VolumeSnapshotOperationsImpl(OperationContext ctx) {
    super(ctx.withApiGroupName("snapshot.storage.k8s.io").withApiGroupVersion("v1").withPlural("volumesnapshots"),
            VolumeSnapshot.class, VolumeSnapshotList.class);
  }

  @Override
  public BaseOperation<VolumeSnapshot, VolumeSnapshotList, VolumeSnapshotResource> newInstance(OperationContext context) {
    return new VolumeSnapshotOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return true;
  }
}
