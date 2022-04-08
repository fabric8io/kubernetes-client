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
package io.fabric8.jupiter;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class KubernetesNamespacedTestExtension implements BeforeAllCallback, BeforeEachCallback, AfterAllCallback {

  private static final ExtensionContext.Namespace EXT_NAMESPACE = ExtensionContext.Namespace
      .create(KubernetesNamespacedTestExtension.class);

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    final KubernetesClient client = new KubernetesClientBuilder().build();
    context.getStore(EXT_NAMESPACE).put(Namespace.class, initNamespace(client));
    context.getStore(EXT_NAMESPACE).put(KubernetesClient.class,
        client.adapt(NamespacedKubernetesClient.class).inNamespace(getNamespace(context).getMetadata().getName()));
    for (Field field : extractFields(context, KubernetesClient.class, f -> Modifier.isStatic(f.getModifiers()))) {
      setFieldValue(field, null, getClient(context).adapt((Class<Client>) field.getType()));
    }
    for (Field field : extractFields(context, Namespace.class, f -> Modifier.isStatic(f.getModifiers()))) {
      setFieldValue(field, null, getNamespace(context));
    }
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    for (Field field : extractFields(context, KubernetesClient.class, f -> !Modifier.isStatic(f.getModifiers()))) {
      setFieldValue(field, context.getRequiredTestInstance(), getClient(context).adapt((Class<Client>) field.getType()));
    }
    for (Field field : extractFields(context, Namespace.class, f -> !Modifier.isStatic(f.getModifiers()))) {
      setFieldValue(field, context.getRequiredTestInstance(), getNamespace(context));
    }
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    final KubernetesClient client = getClient(context);
    client.resource(getNamespace(context)).withGracePeriod(0L).delete();
    client.close();
  }

  private static KubernetesClient getClient(ExtensionContext context) {
    final KubernetesClient client = context.getStore(EXT_NAMESPACE).get(KubernetesClient.class, KubernetesClient.class);
    if (client == null) {
      throw new IllegalStateException("No KubernetesClient found");
    }
    return client;
  }

  /**
   * Creates a new Namespace and waits for the required resources to be created.
   *
   * It waits for the ServiceAccount to be initialized, and for its Secrets to be created too.
   *
   * @param client the KubernetesClient to use.
   * @return the created Namespace
   */
  private static Namespace initNamespace(KubernetesClient client) {
    final Namespace namespace = client
      .resource(new NamespaceBuilder()
        .withNewMetadata()
        .withName(UUID.randomUUID().toString())
        .addToLabels("app", "fabric8-kubernetes-client-test")
        .endMetadata()
        .build())
      .create();
    final List<ObjectReference> secrets = client.serviceAccounts()
        .inNamespace(namespace.getMetadata().getName())
        .withName("default")
        .waitUntilCondition(sa -> sa != null && sa.getSecrets() != null && !sa.getSecrets().isEmpty(), 5, TimeUnit.SECONDS)
        .getSecrets();
    for (ObjectReference secret : secrets) {
      client.secrets().inNamespace(namespace.getMetadata().getName()).withName(secret.getName())
        .waitUntilCondition(Objects::nonNull, 5, TimeUnit.SECONDS);
    }
    return namespace;
  }

  private static Namespace getNamespace(ExtensionContext context) {
    final Namespace namespace = context.getStore(EXT_NAMESPACE).get(Namespace.class, Namespace.class);
    if (namespace == null) {
      throw new IllegalStateException("No Kubernetes Namespace found");
    }
    return namespace;
  }

  private static Field[] extractFields(ExtensionContext context, Class<?> clazz, Predicate<Field>... predicates) {
    final Class<?> testClass = context.getTestClass().orElse(null);
    if (testClass != null) {
      Stream<Field> fieldStream = Arrays.stream(testClass.getDeclaredFields())
          .filter(f -> clazz.isAssignableFrom(f.getType()));
      for (Predicate<Field> p : predicates) {
        fieldStream = fieldStream.filter(p);
      }
      return fieldStream.toArray(Field[]::new);
    }
    return new Field[0];
  }

  private static void setFieldValue(Field field, Object entity, Object value) throws IllegalAccessException {
    final boolean isAccessible = field.isAccessible();
    field.setAccessible(true);
    field.set(entity, value);
    field.setAccessible(isAccessible);
  }
}
