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
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ConfigMapResource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;

import java.io.IOException;
import java.nio.file.Path;

public class ConfigMapOperationsImpl extends HasMetadataOperation<ConfigMap, ConfigMapList, ConfigMapResource>
    implements ConfigMapResource {

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
  public ConfigMapResource fromFile(String key, Path dirOrFilePath) {
    return new ConfigMapOperationsImpl(context.withItem(createNewOrMergeWithExistingConfigMap(key, dirOrFilePath)));
  }

  private ConfigMap createNewOrMergeWithExistingConfigMap(String key, Path dirOrFilePath) {
    try {
      ConfigMap item = getItem();
      if (item == null) {
        item = get();
      }
      ConfigMapBuilder builder = null;
      if (item == null) {
        builder = new ConfigMapBuilder().withNewMetadata().withName(getName()).endMetadata();
      } else {
        builder = new ConfigMapBuilder(item);
      }
      return KubernetesResourceUtil.addEntriesFromDirOrFileToConfigMap(builder, key, dirOrFilePath).build();
    } catch (IOException ioException) {
      throw new KubernetesClientException("Unable to create ConfigMap entry " + key, ioException);
    }
  }
}
