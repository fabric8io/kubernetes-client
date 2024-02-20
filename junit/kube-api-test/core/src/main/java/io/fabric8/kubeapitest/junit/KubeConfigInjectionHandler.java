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
package io.fabric8.kubeapitest.junit;

import io.fabric8.kubeapitest.KubeAPIServer;
import io.fabric8.kubeapitest.KubeAPITestException;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class KubeConfigInjectionHandler implements ClientInjectionHandler {

  public boolean isTargetFieldAvailable(ExtensionContext extensionContext,
      boolean staticField) {
    return getFieldForKubeConfigInjection(extensionContext, staticField).isPresent();
  }

  public void inject(ExtensionContext extensionContext,
      boolean staticField, KubeAPIServer kubeApiServer) {
    var field = getFieldForKubeConfigInjection(extensionContext, staticField).orElseThrow(IllegalStateException::new);
    setKubeConfigYamlToField(extensionContext, field, kubeApiServer);
  }

  private void setKubeConfigYamlToField(ExtensionContext extensionContext,
      Field kubeConfigField, KubeAPIServer kubeApiServer) {
    try {
      var target = extensionContext.getTestInstance()
          .orElseGet(() -> extensionContext.getTestClass().orElseThrow(IllegalStateException::new));
      kubeConfigField.setAccessible(true);
      kubeConfigField.set(target,
          kubeApiServer.getKubeConfigYaml());
    } catch (IllegalAccessException e) {
      throw new KubeAPITestException(e);
    }
  }

  public Optional<Field> getFieldForKubeConfigInjection(ExtensionContext extensionContext,
      boolean staticField) {
    Class<?> clazz = extensionContext.getTestClass().orElseThrow(IllegalStateException::new);
    java.util.List<Field> kubeConfigFields = Arrays.stream(clazz.getDeclaredFields())
        .filter(f -> f.getAnnotationsByType(KubeConfig.class).length > 0)
        .collect(Collectors.toList());
    if (kubeConfigFields.isEmpty()) {
      return Optional.empty();
    }
    if (kubeConfigFields.size() > 1) {
      throw new KubeAPITestException(
          "More fields annotation with @" + KubeConfig.class.getSimpleName() + " annotation");
    }
    var field = kubeConfigFields.get(0);
    if (!field.getType().equals(String.class)) {
      throw new KubeAPITestException(
          "Field annotated with @" + KubeConfig.class.getSimpleName() + " is not a String");
    }

    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) != staticField) {
      return Optional.empty();
    } else {
      return Optional.of(field);
    }
  }

}
