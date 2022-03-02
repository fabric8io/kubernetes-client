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
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClass;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClassBuilder;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotClassList;
import io.fabric8.volumesnapshot.api.model.VolumeSnapshotList;

import java.util.HashMap;
import java.util.Map;


public class VolumeSnapshotClassOperationsImpl extends HasMetadataOperation<VolumeSnapshotClass, VolumeSnapshotClassList, VolumeSnapshotClassResource> implements VolumeSnapshotClassResource {

  public VolumeSnapshotClassOperationsImpl(ClientContext clientContext) {
    this(HasMetadataOperationsImpl.defaultContext(clientContext));
  }

  public VolumeSnapshotClassOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("snapshot.storage.k8s.io").withApiGroupVersion("v1").withPlural("volumesnapshotclasses"),
            VolumeSnapshotClass.class, VolumeSnapshotClassList.class);
  }

  @Override
  public VolumeSnapshotClassOperationsImpl newInstance(OperationContext context) {
    return new VolumeSnapshotClassOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }

  @Override
  public VolumeSnapshotList listSnapshots() {
    VolumeSnapshotClass item = get();
    Map<String, String> fields = new HashMap<>();
    fields.put("spec.volumeSnapshotClassName", item.getMetadata().getName());
    return new VolumeSnapshotOperationsImpl(context.withName(null))
      .withFields(fields)
      .list();
  }

  @Override
  public VolumeSnapshotClass edit(Visitor... visitors) {
    return patch(new VolumeSnapshotClassBuilder(getMandatory()).accept(visitors).build());
  }

}
