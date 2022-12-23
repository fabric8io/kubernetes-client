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
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ConfigMapResource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.createNewConfigMapFromDirOrFile;

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
  public ConfigMapResource fromFile(String dirOrFilePath) {
    if (dirOrFilePath == null || dirOrFilePath.isEmpty()) {
      throw new IllegalArgumentException("invalid file path provided");
    }
    File file = Paths.get(dirOrFilePath).toFile();
    if (!file.exists()) {
      throw new IllegalArgumentException(String.format("File %s doesn't exist", dirOrFilePath));
    }

    return resource(createNewConfigMap(file.getName(), dirOrFilePath));
  }

  private ConfigMap createNewConfigMap(String fileName, String dirOrFilePath) {
    try {
      return createNewConfigMapFromDirOrFile(name, fileName, dirOrFilePath);
    } catch (IOException ioException) {
      throw new KubernetesClientException("Unable to create ConfigMap " + name, ioException);
    }
  }
}
