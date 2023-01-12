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

import io.fabric8.junit.jupiter.api.KubernetesTest;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class NamespaceExtension implements HasKubernetesClient, BeforeAllCallback, BeforeEachCallback, AfterAllCallback {

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    final KubernetesClient client = new KubernetesClientBuilder().build();
    getStore(context).put(KubernetesClient.class, client);
    if (shouldCreateNamespace(context)) {
      getStore(context).put(Namespace.class, initNamespace(client));
      getStore(context).put(KubernetesClient.class,
          client.adapt(NamespacedKubernetesClient.class).inNamespace(getKubernetesNamespace(context).getMetadata().getName()));
    }
    for (Field field : extractFields(context, Namespace.class, f -> Modifier.isStatic(f.getModifiers()))) {
      setFieldValue(field, null, getKubernetesNamespace(context));
    }
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    for (Field field : extractFields(context, Namespace.class, f -> !Modifier.isStatic(f.getModifiers()))) {
      setFieldValue(field, context.getRequiredTestInstance(), getKubernetesNamespace(context));
    }
  }

  @Override
  public void afterAll(ExtensionContext context) {
    final KubernetesClient client = getClient(context);
    if (shouldCreateNamespace(context)) {
      client.resource(getKubernetesNamespace(context)).withGracePeriod(0L).delete();
    }
    // Note that the ThreadPoolExecutor in OkHttp's RealConnectionPool is shared amongst all the OkHttp client
    // instances. This means that closing one OkHttp client instance effectively closes all the others.
    // In order to be able to use this safely, we should transition to one of the other HttpClient implementations
    client.close();
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
    // If < v1.24, wait for ServiceAccount secret to be ready
    final int major = Integer.parseInt(client.getKubernetesVersion().getMajor().replaceAll("\\D+", ""));
    final int minor = Integer.parseInt(client.getKubernetesVersion().getMinor().replaceAll("\\D+", ""));
    if (major < 1 || (major == 1 && minor < 24)) {
      final List<ObjectReference> secrets = client.serviceAccounts()
          .inNamespace(namespace.getMetadata().getName())
          .withName("default")
          .waitUntilCondition(sa -> sa != null && sa.getSecrets() != null
              && sa.getSecrets().stream().anyMatch(s -> s.getName().matches("default-token.+")),
              5, TimeUnit.SECONDS)
          .getSecrets();
      for (ObjectReference secret : secrets) {
        client.secrets().inNamespace(namespace.getMetadata().getName()).withName(secret.getName())
            .waitUntilCondition(Objects::nonNull, 5, TimeUnit.SECONDS);
      }
    }
    return namespace;
  }

  private boolean shouldCreateNamespace(ExtensionContext context) {
    final KubernetesTest annotation = findAnnotation(context.getRequiredTestClass(), KubernetesTest.class);
    return annotation == null || annotation.createEphemeralNamespace();
  }

  private Namespace getKubernetesNamespace(ExtensionContext context) {
    final Namespace namespace = getStore(context).get(Namespace.class, Namespace.class);
    if (namespace == null) {
      throw new IllegalStateException("No Kubernetes Namespace found");
    }
    return namespace;
  }
}
