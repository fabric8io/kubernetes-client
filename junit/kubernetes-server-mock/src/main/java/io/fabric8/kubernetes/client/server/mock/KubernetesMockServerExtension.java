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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.MockWebServer;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.http.Dispatcher;
import io.fabric8.mockwebserver.internal.MockDispatcher;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

/**
 * The class that implements JUnit5 extension mechanism. You can use it directly in your JUnit test
 * by annotating it with <code>@ExtendWith(KubernetesMockServerExtension.class)</code> or through
 * <code>@EnableKubernetesMockClient</code> annotation
 */
public class KubernetesMockServerExtension
    implements AfterEachCallback, AfterAllCallback, BeforeEachCallback, BeforeAllCallback {

  private KubernetesMockServer staticMock;
  private NamespacedKubernetesClient staticClient;
  private KubernetesMockServer instantMock;
  private NamespacedKubernetesClient instantClient;

  public interface SetTestClassField {
    void apply(Object instance, Field f) throws IllegalAccessException;
  }

  @Override
  public void afterEach(ExtensionContext context) {
    destroy();
  }

  @Override
  public void afterAll(ExtensionContext context) {
    destroyStatic();
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    setKubernetesClientAndMockServerFields(context, false);
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    setKubernetesClientAndMockServerFields(context, true);
  }

  protected void setFieldIfKubernetesClientOrMockServer(ExtensionContext context, boolean isStatic, Field field)
      throws IllegalAccessException {
    if (extensionMatches(field.getType())) {
      final NamespacedKubernetesClient client;
      if (isStatic) {
        client = staticClient;
      } else {
        client = instantClient;
      }
      setFieldIfEqualsToProvidedType(context, isStatic, field, Client.class,
          (i, f) -> f.set(i, client.adapt((Class<Client>) f.getType())));
    } else {
      final KubernetesMockServer mock;
      if (isStatic) {
        mock = staticMock;
      } else {
        mock = instantMock;
      }
      setFieldIfEqualsToProvidedType(context, isStatic, field, getKubernetesMockServerType(), (i, f) -> f.set(i, mock));
    }
  }

  protected void setFieldIfEqualsToProvidedType(ExtensionContext context, boolean isStatic, Field field, Class<?> fieldType,
      SetTestClassField setTestClassField) throws IllegalAccessException {
    if (fieldType.isAssignableFrom(field.getType()) && Modifier.isStatic(field.getModifiers()) == isStatic) {
      setKubernetesClientStaticOrMemberField(context, isStatic, field, setTestClassField);
    }
  }

  protected void initializeKubernetesClientAndMockServer(Class<?> testClass, boolean isStatic) {
    EnableKubernetesMockClient a = testClass.getAnnotation(EnableKubernetesMockClient.class);
    final Map<ServerRequest, Queue<ServerResponse>> responses = new HashMap<>();
    final Dispatcher dispatcher;
    if (a.crud()) {
      dispatcher = new KubernetesMixedDispatcher(responses);
    } else {
      dispatcher = new MockDispatcher(responses);
    }
    final KubernetesMockServer mock = new KubernetesMockServer(new Context(Serialization.jsonMapper()),
        new MockWebServer(), responses, dispatcher, a.https());
    mock.init();
    if (isStatic) {
      staticMock = mock;
    } else {
      instantMock = mock;
    }
    try {
      final NamespacedKubernetesClient client = mock.createClient(
          a.kubernetesClientBuilderCustomizer().getConstructor().newInstance());
      if (isStatic) {
        staticClient = client;
      } else {
        instantClient = client;
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("The provided kubernetesClientBuilder is invalid", e);
    }
  }

  protected void destroy() {
    if (instantMock != null) {
      instantMock.destroy();
    }
    if (instantClient != null) {
      instantClient.close();
    }
  }

  protected void destroyStatic() {
    staticMock.destroy();
    staticClient.close();
  }

  protected Class<?> getKubernetesMockServerType() {
    return KubernetesMockServer.class;
  }

  private boolean extensionMatches(Class<?> type) {
    return Client.class.isAssignableFrom(type);
  }

  private void setKubernetesClientAndMockServerFields(ExtensionContext context, boolean isStatic)
      throws IllegalAccessException {
    Optional<Class<?>> optClass = context.getTestClass();
    if (optClass.isPresent()) {
      Class<?> testClass = optClass.get();
      initializeKubernetesClientAndMockServer(testClass, isStatic);
      processTestClassDeclaredFields(context, isStatic, testClass);
    }
  }

  private void processTestClassDeclaredFields(ExtensionContext context, boolean isStatic, Class<?> testClass)
      throws IllegalAccessException {
    Field[] fields = testClass.getDeclaredFields();
    for (Field field : fields) {
      setFieldIfKubernetesClientOrMockServer(context, isStatic, field);
    }
  }

  private void setKubernetesClientStaticOrMemberField(ExtensionContext context, boolean isStatic, Field f,
      SetTestClassField setTestClassField) throws IllegalAccessException {
    f.setAccessible(true);
    if (isStatic) {
      setTestClassField.apply(null, f);
    } else {
      Optional<Object> optTestInstance = context.getTestInstance();
      if (optTestInstance.isPresent())
        setTestClassField.apply(optTestInstance.get(), f);
    }
  }
}
