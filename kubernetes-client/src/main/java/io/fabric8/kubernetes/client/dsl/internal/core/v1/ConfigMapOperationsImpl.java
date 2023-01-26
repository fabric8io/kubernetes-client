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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.FromFileCreatableOperation;
import io.fabric8.kubernetes.client.dsl.FromFileCreatableResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;

import java.io.IOException;
import java.nio.file.Path;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.createNewConfigMapWithEntry;
import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.mergeConfigMapData;

public class ConfigMapOperationsImpl extends HasMetadataOperation<ConfigMap, ConfigMapList, Resource<ConfigMap>>
    implements FromFileCreatableResource<ConfigMap>, FromFileCreatableOperation<ConfigMap, ConfigMapList, Resource<ConfigMap>> {

  public ConfigMapOperationsImpl(Client client) {
    this(HasMetadataOperationsImpl.defaultContext(client));
  }

  public ConfigMapOperationsImpl(OperationContext context) {
    super(context.withPlural("configmaps"), ConfigMap.class, ConfigMapList.class);
  }

  @Override
  public ConfigMapOperationsImpl newInstance(OperationContext context) {
    return new ConfigMapOperationsImpl(context);
  }

  @Override
  public FromFileCreatableResource<ConfigMap> fromFile(String key, Path dirOrFilePath) {
    return new ConfigMapOperationsImpl(context.withItem(createNewOrMergeWithExistingConfigMap(key, dirOrFilePath)));
  }

  @Override
  public ConfigMapOperationsImpl withName(String name) {
    ConfigMap item = getItem();
    if (item != null) {
      if (item.getMetadata() != null) {
        item.getMetadata().setName(name);
      } else {
        item.setMetadata(new ObjectMetaBuilder().withName(name).build());
      }
    }
    return new ConfigMapOperationsImpl(context.withName(name).withItem(item));
  }

  private ConfigMap createNewOrMergeWithExistingConfigMap(String key, Path dirOrFilePath) {
    try {
      ConfigMap item = getItem();
      ConfigMap tempConfigMap = createNewConfigMapWithEntry(key, dirOrFilePath);

      ConfigMap mergedConfigMap = mergeConfigMapData(item, tempConfigMap);
      if (item != null) {
        mergedConfigMap.setMetadata(item.getMetadata());
      }
      return mergedConfigMap;
    } catch (IOException ioException) {
      throw new KubernetesClientException("Unable to create ConfigMap " + key, ioException);
    }
  }
}
