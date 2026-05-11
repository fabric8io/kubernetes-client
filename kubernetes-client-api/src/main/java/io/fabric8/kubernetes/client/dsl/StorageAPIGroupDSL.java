/*
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
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachment;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachmentList;
import io.fabric8.kubernetes.api.model.storage.VolumeAttributesClass;
import io.fabric8.kubernetes.api.model.storage.VolumeAttributesClassList;
import io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacity;
import io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityList;
import io.fabric8.kubernetes.client.Client;

public interface StorageAPIGroupDSL extends Client {

  /**
   * DSL entrypoint for storage.k8s.io/v1 StorageClass
   *
   * @deprecated Use <code>client.storage().v1().storageClasses()</code> instead
   * @return {@link NonNamespaceOperation} for StorageClass
   */
  @Deprecated
  NonNamespaceOperation<StorageClass, StorageClassList, Resource<StorageClass>> storageClasses();

  /**
   * DSL entrypoint for storage.k8s.io/v1 CSIDriver
   *
   * @deprecated Use <code>client.storage().v1().csiDrivers()</code> instead
   * @return {@link NonNamespaceOperation} for CSIDriver resource
   */
  @Deprecated
  NonNamespaceOperation<CSIDriver, CSIDriverList, Resource<CSIDriver>> csiDrivers();

  /**
   * DSL entrypoint for storage.k8s.io/v1 CSINode
   *
   * @deprecated Use <code>client.storage().v1().csiDrivers()</code> instead
   * @return {@link NonNamespaceOperation} for CSINode resource
   */
  @Deprecated
  NonNamespaceOperation<CSINode, CSINodeList, Resource<CSINode>> csiNodes();

  /**
   * DSL entrypoint for storage.k8s.io/v1 CSIStorageCapacities
   *
   * @deprecated Use <code>client.storage().v1beta1().csiStorageCapacities()</code> instead
   * @return {@link NonNamespaceOperation} for CSIStorageCapacity
   */
  @Deprecated
  MixedOperation<CSIStorageCapacity, CSIStorageCapacityList, Resource<CSIStorageCapacity>> csiStorageCapacities();

  /**
   * DSL entrypoint for storage.k8s.io/v1 VolumeAttachment
   *
   * @deprecated Use <code>client.storage().v1().volumeAttachments()</code> instead
   * @return {@link NonNamespaceOperation} for VolumeAttachment resource
   */
  @Deprecated
  NonNamespaceOperation<VolumeAttachment, VolumeAttachmentList, Resource<VolumeAttachment>> volumeAttachments();

  /**
   * DSL entrypoint for storage.k8s.io/v1 VolumeAttributesClass
   *
   * @deprecated Use <code>client.storage().v1().volumeAttributesClasses()</code> instead
   * @return {@link NonNamespaceOperation} for VolumeAttributesClass resource
   */
  @Deprecated
  NonNamespaceOperation<VolumeAttributesClass, VolumeAttributesClassList, Resource<VolumeAttributesClass>> volumeAttributesClasses();

  /**
   * DSL entrypoint for resources in storage.k8s.io/v1 apiGroup
   *
   * @return {@link V1StorageAPIGroupDSL}
   */
  V1StorageAPIGroupDSL v1();

  /**
   * DSL entrypoint for resources in storage.k8s.io/v1beta1 apiGroup
   *
   * @return {@link V1beta1StorageAPIGroupDSL}
   */
  V1beta1StorageAPIGroupDSL v1beta1();
}
