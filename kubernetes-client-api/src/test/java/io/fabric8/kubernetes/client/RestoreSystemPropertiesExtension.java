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
package io.fabric8.kubernetes.client;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class RestoreSystemPropertiesExtension implements BeforeEachCallback, AfterEachCallback {

  private static final Namespace NAMESPACE = Namespace.create(RestoreSystemPropertiesExtension.class);
  private static final String SNAPSHOT_KEY = "snapshot";

  @Override
  public void beforeEach(ExtensionContext context) {
    final Set<String> keys = collectKeys(context);
    final Map<String, String> snapshot = new HashMap<>(keys.size());
    for (String key : keys) {
      snapshot.put(key, System.getProperty(key));
    }
    context.getStore(NAMESPACE).put(SNAPSHOT_KEY, snapshot);
  }

  @Override
  public void afterEach(ExtensionContext context) {
    @SuppressWarnings("unchecked")
    final Map<String, String> snapshot = context.getStore(NAMESPACE).remove(SNAPSHOT_KEY, Map.class);
    if (snapshot == null) {
      return;
    }
    snapshot.forEach((key, value) -> {
      if (value == null) {
        System.clearProperty(key);
      } else {
        System.setProperty(key, value);
      }
    });
  }

  private static Set<String> collectKeys(ExtensionContext context) {
    final Set<String> keys = new LinkedHashSet<>();
    context.getTestMethod().ifPresent(method -> {
      final RestoreSystemProperties annotation = method.getAnnotation(RestoreSystemProperties.class);
      if (annotation != null) {
        keys.addAll(Arrays.asList(annotation.value()));
      }
    });
    Class<?> klass = context.getTestClass().orElse(null);
    while (klass != null) {
      final RestoreSystemProperties annotation = klass.getAnnotation(RestoreSystemProperties.class);
      if (annotation != null) {
        keys.addAll(Arrays.asList(annotation.value()));
      }
      klass = klass.getEnclosingClass();
    }
    return keys;
  }
}
