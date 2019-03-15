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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.storage.DoneableStorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;

public class StorageClassOperationsImpl extends HasMetadataOperation<StorageClass, StorageClassList, DoneableStorageClass, Resource<StorageClass, DoneableStorageClass>> {

  public StorageClassOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public StorageClassOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("storage.k8s.io")
      .withApiGroupVersion("v1")
      .withPlural("storageclasses"));
    this.type = StorageClass.class;
    this.listType = StorageClassList.class;
    this.doneableType = DoneableStorageClass.class;
  }

  @Override
  public StorageClassOperationsImpl newInstance(OperationContext context) {
    return new StorageClassOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
