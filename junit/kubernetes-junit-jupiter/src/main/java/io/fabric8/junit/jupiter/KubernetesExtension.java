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
package io.fabric8.junit.jupiter;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class KubernetesExtension implements HasKubernetesClient, BeforeAllCallback, BeforeEachCallback {

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    for (Field field : extractFields(context, KubernetesClient.class, f -> Modifier.isStatic(f.getModifiers()))) {
      setFieldValue(field, null, getClient(context).adapt((Class<Client>) field.getType()));
    }
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    for (Field field : extractFields(context, KubernetesClient.class, f -> !Modifier.isStatic(f.getModifiers()))) {
      setFieldValue(field, context.getRequiredTestInstance(), getClient(context).adapt((Class<Client>) field.getType()));
    }
  }
}
