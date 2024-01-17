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

package io.fabric8.kubeapitest.junit;

import io.fabric8.kubeapitest.KubeAPIServer;
import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class Fabric8ClientInjectionHandler implements ClientInjectionHandler {

  private KubernetesClient client;

  public boolean isTargetFieldAvailable(ExtensionContext extensionContext,
      boolean staticField) {
    return getFieldForKubeClientInjection(extensionContext, staticField).isPresent();
  }

  @Override
  public void inject(ExtensionContext extensionContext,
      boolean staticField, KubeAPIServer kubeApiServer) {
    var field = getFieldForKubeClientInjection(extensionContext, staticField).orElseThrow();
    setKubernetesClientToField(extensionContext, field, kubeApiServer);
  }

  private void setKubernetesClientToField(ExtensionContext extensionContext,
      Field kubeClientField, KubeAPIServer kubeApiServer) {
    try {
      var target = extensionContext.getTestInstance()
          .orElseGet(() -> extensionContext.getTestClass().orElseThrow());
      client = new KubernetesClientBuilder()
          .withConfig(Config.fromKubeconfig(kubeApiServer.getKubeConfigYaml())).build();
      kubeClientField.setAccessible(true);
      kubeClientField.set(target, client);
    } catch (IllegalAccessException e) {
      throw new KubeAPITestException(e);
    }
  }

  @Override
  public void cleanup(ExtensionContext extensionContext) {
    if (client != null) {
      client.close();
    }
  }

  public static Optional<Field> getFieldForKubeClientInjection(ExtensionContext extensionContext,
      boolean staticField) {
    Class<?> clazz = extensionContext.getTestClass().orElseThrow();
    var kubeConfigFields = Arrays.stream(clazz.getDeclaredFields())
        .filter(f -> KubernetesClient.class.isAssignableFrom(f.getType()))
        .collect(Collectors.toList());
    if (kubeConfigFields.isEmpty()) {
      return Optional.empty();
    }
    if (kubeConfigFields.size() > 1) {
      throw new KubeAPITestException(
          "More fields type KubernetesClient found");
    }
    var field = kubeConfigFields.get(0);
    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) != staticField) {
      return Optional.empty();
    } else {
      return Optional.of(field);
    }
  }
}
