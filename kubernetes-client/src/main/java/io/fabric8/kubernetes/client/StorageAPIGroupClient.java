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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.storage.CSIDriver;
import io.fabric8.kubernetes.api.model.storage.CSIDriverList;
import io.fabric8.kubernetes.api.model.storage.CSINode;
import io.fabric8.kubernetes.api.model.storage.CSINodeList;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachment;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachmentList;
import io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacity;
import io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.StorageAPIGroupDSL;
import okhttp3.OkHttpClient;

public class StorageAPIGroupClient extends BaseClient implements StorageAPIGroupDSL {

  public StorageAPIGroupClient() {
    super();
  }

  public StorageAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<StorageClass, StorageClassList, Resource<StorageClass>> storageClasses() {
    return Handlers.getOperation(StorageClass.class, StorageClassList.class, httpClient, getConfiguration());
  }

  @Override
  public NonNamespaceOperation<CSIDriver, CSIDriverList, Resource<CSIDriver>> csiDrivers() {
    return Handlers.getOperation(CSIDriver.class, CSIDriverList.class, httpClient, getConfiguration());
  }

  @Override
  public NonNamespaceOperation<CSINode, CSINodeList, Resource<CSINode>> csiNodes() {
    return Handlers.getOperation(CSINode.class, CSINodeList.class, httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<CSIStorageCapacity, CSIStorageCapacityList, Resource<CSIStorageCapacity>> csiStorageCapacities() {
    return Handlers.getOperation(CSIStorageCapacity.class, CSIStorageCapacityList.class, httpClient, getConfiguration());
  }

  @Override
  public NonNamespaceOperation<VolumeAttachment, VolumeAttachmentList, Resource<VolumeAttachment>> volumeAttachments() {
    return Handlers.getOperation(VolumeAttachment.class, VolumeAttachmentList.class, httpClient, getConfiguration());
  }
}
