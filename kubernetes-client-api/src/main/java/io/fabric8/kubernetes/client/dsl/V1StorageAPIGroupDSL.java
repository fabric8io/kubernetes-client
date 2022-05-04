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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.storage.CSIDriver;
import io.fabric8.kubernetes.api.model.storage.CSIDriverList;
import io.fabric8.kubernetes.api.model.storage.CSINode;
import io.fabric8.kubernetes.api.model.storage.CSINodeList;
import io.fabric8.kubernetes.api.model.storage.CSIStorageCapacity;
import io.fabric8.kubernetes.api.model.storage.CSIStorageCapacityList;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachment;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachmentList;
import io.fabric8.kubernetes.client.Client;

public interface V1StorageAPIGroupDSL extends Client {

  /**
   * DSL entrypoint for storage.k8s.io/v1 StorageClass
   *
   * @return {@link NonNamespaceOperation} for StorageClass
   */
  NonNamespaceOperation<StorageClass, StorageClassList, Resource<StorageClass>> storageClasses();

  /**
   * DSL entrypoint for storage.k8s.io/v1 CSIDriver
   *
   * @return {@link NonNamespaceOperation} for CSIDriver resource
   */
  NonNamespaceOperation<CSIDriver, CSIDriverList, Resource<CSIDriver>> csiDrivers();

  /**
   * DSL entrypoint for storage.k8s.io/v1 CSINode
   *
   * @return {@link NonNamespaceOperation} for CSINode resource
   */
  NonNamespaceOperation<CSINode, CSINodeList, Resource<CSINode>> csiNodes();

  /**
   * DSL entrypoint for storage.k8s.io/v1 CSIStorageCapacity
   *
   * @return {@link MixedOperation} for CSIStorageCapacity resource
   */
  MixedOperation<CSIStorageCapacity, CSIStorageCapacityList, Resource<CSIStorageCapacity>> csiStorageCapacities();

  /**
   * DSL entrypoint for storage.k8s.io/v1 VolumeAttachment
   *
   * @return {@link NonNamespaceOperation} for VolumeAttachment resource
   */
  NonNamespaceOperation<VolumeAttachment, VolumeAttachmentList, Resource<VolumeAttachment>> volumeAttachments();
}
