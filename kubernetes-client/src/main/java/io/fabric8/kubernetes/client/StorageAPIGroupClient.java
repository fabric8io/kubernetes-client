/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import io.fabric8.kubernetes.api.model.storage.DoneableStorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.StorageAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.internal.StorageClassOperationsImpl;
import okhttp3.OkHttpClient;

public class StorageAPIGroupClient extends BaseClient implements StorageAPIGroupDSL {

  public StorageAPIGroupClient() throws KubernetesClientException {
    super();
  }

  public StorageAPIGroupClient(OkHttpClient httpClient, final Config config) throws KubernetesClientException {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<StorageClass, StorageClassList, DoneableStorageClass, Resource<StorageClass, DoneableStorageClass>> storageClasses() {
    return new StorageClassOperationsImpl(httpClient, getConfiguration());
  }
}
