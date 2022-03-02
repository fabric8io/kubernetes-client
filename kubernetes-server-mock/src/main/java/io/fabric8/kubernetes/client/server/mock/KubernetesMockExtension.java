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

package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

/**
 * The class that implements JUnit5 extension mechanism. You can use it directly in your JUnit test
 * by annotating it with <code>@ExtendWith(KubernetesMockExtension.class)</code> or through
 * <code>@EnableKubernetesMock</code> annotation
 */
public class KubernetesMockExtension implements AfterEachCallback, AfterAllCallback, BeforeEachCallback, BeforeAllCallback {

  private KubernetesMockServer mock;
  private DefaultKubernetesClient client;
  private Class<? extends Client>[] extensions;

  public interface SetTestClassField {
    void apply(Object instance, Field f) throws IllegalAccessException;
  }

  @Override
  public void afterEach(ExtensionContext context) {
    Optional<Class<?>> optClass = context.getTestClass();
    if (optClass.isPresent()) {
      Class<?> testClass = optClass.get();
      if (findField(testClass, true) == null) {
        destroy();
      }
    }
  }

  @Override
  public void afterAll(ExtensionContext context) {
    destroy();
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    setKubernetesClientAndMockServerFields(context, false);
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    setKubernetesClientAndMockServerFields(context, true);
  }

  protected void setFieldIfKubernetesClientOrMockServer(ExtensionContext context, boolean isStatic, Field field) throws IllegalAccessException {
    if (extensions.length == 0) {
      setFieldIfEqualsToProvidedType(context, isStatic, field, Client.class, (i, f) -> f.set(i, client.adapt(f.getType())));
    } else {
      for (Class<? extends Client> clazz : extensions) {
        setFieldIfEqualsToProvidedType(context, isStatic, field, clazz, (i, f) -> f.set(i, client.adapt(f.getType())));
      }
    }
    setFieldIfEqualsToProvidedType(context, isStatic, field, getKubernetesMockServerType(), (i, f) -> f.set(i, mock));
  }

  protected void setFieldIfEqualsToProvidedType(ExtensionContext context, boolean isStatic, Field field, Class<?> fieldType, SetTestClassField setTestClassField) throws IllegalAccessException {
    if (fieldType.isAssignableFrom(field.getType()) && Modifier.isStatic(field.getModifiers()) == isStatic) {
      setKubernetesClientStaticOrMemberField(context, isStatic, field, setTestClassField);
    }
  }

  protected void initializeKubernetesClientAndMockServer(Class<?> testClass) {
    EnableKubernetesMock a = testClass.getAnnotation(EnableKubernetesMock.class);
    final Map<ServerRequest, Queue<ServerResponse>> responses = new HashMap<>();
    mock = a.crud()
      ? new KubernetesMockServer(new Context(), new MockWebServer(), responses, new KubernetesMixedDispatcher(responses), a.https())
      : new KubernetesMockServer(a.https());
    mock.init();
    client = new DefaultKubernetesClient(mock.getMockConfiguration());
    client.setAdaptableOverride(this::extensionMatches);
    this.extensions = a.extensions();
  }

  protected void destroy() {
    mock.destroy();
    client.close();
  }

  protected Class<?> getKubernetesMockServerType() {
    return KubernetesMockServer.class;
  }

  private Field findField(Class<?> testClass, boolean isStatic) {
    Field[] fields = testClass.getDeclaredFields();
    for (Field f : fields) {
      if (Modifier.isStatic(f.getModifiers()) == isStatic &&
          (extensionMatches(f.getType()) || f.getType().equals(getKubernetesMockServerType()))) {
        return f;
      }
    }
    return null;
  }

  private boolean extensionMatches(Class<?> type) {
    return extensions.length == 0 && Client.class.isAssignableFrom(type)
        || Arrays.stream(extensions).anyMatch(c -> c.isAssignableFrom(type));
  }

  private void setKubernetesClientAndMockServerFields(ExtensionContext context, boolean isStatic) throws IllegalAccessException {
    Optional<Class<?>> optClass = context.getTestClass();
    if (optClass.isPresent()) {
      Class<?> testClass = optClass.get();
      initializeKubernetesClientAndMockServer(testClass);
      processTestClassDeclaredFields(context, isStatic, testClass);
    }
  }

  private void processTestClassDeclaredFields(ExtensionContext context, boolean isStatic, Class<?> testClass) throws IllegalAccessException {
    Field[] fields = testClass.getDeclaredFields();
    for (Field field : fields) {
      setFieldIfKubernetesClientOrMockServer(context, isStatic, field);
    }
  }

  private void setKubernetesClientStaticOrMemberField(ExtensionContext context, boolean isStatic, Field f, SetTestClassField setTestClassField) throws IllegalAccessException {
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
