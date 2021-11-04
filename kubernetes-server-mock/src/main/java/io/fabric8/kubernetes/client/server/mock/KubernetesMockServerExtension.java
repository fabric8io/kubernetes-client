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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * The class that implements JUnit5 extension mechanism. You can use it directly in your JUnit test
 * by annotating it with <code>@ExtendWith(KubernetesMockServerExtension.class)</code> or through
 * <code>@EnableKubernetesMockClient</code> annotation
 */
public class KubernetesMockServerExtension implements AfterEachCallback, AfterAllCallback, BeforeEachCallback, BeforeAllCallback {

  private KubernetesMockServer mock;
  private NamespacedKubernetesClient client;

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
    setFieldIfEqualsToProvidedType(context, isStatic, field, getClientType(), (i, f) -> f.set(i, client));
    setFieldIfEqualsToProvidedType(context, isStatic, field, getKubernetesMockServerType(), (i, f) -> f.set(i, mock));
  }

  protected void setFieldIfEqualsToProvidedType(ExtensionContext context, boolean isStatic, Field field, Class<?> fieldType, SetTestClassField setTestClassField) throws IllegalAccessException {
    if (field.getType().equals(fieldType) && Modifier.isStatic(field.getModifiers()) == isStatic) {
      setKubernetesClientStaticOrMemberField(context, isStatic, field, setTestClassField);
    }
  }

  protected void initializeKubernetesClientAndMockServer(Class<?> testClass) {
    EnableKubernetesMockClient a = testClass.getAnnotation(EnableKubernetesMockClient.class);
    final Map<ServerRequest, Queue<ServerResponse>> responses = new HashMap<>();
    mock = a.crud()
      ? new KubernetesMockServer(new Context(), new MockWebServer(), responses, new KubernetesMixedDispatcher(responses), a.https())
      : new KubernetesMockServer(a.https());
    mock.init();
    client = mock.createClient();
  }

  protected void destroy() {
    mock.destroy();
    client.close();
  }

  protected Class<?> getClientType() {
    return KubernetesClient.class;
  }

  protected Class<?> getKubernetesMockServerType() {
    return KubernetesMockServer.class;
  }

  private Field findField(Class<?> testClass, boolean isStatic) {
    Field[] fields = testClass.getDeclaredFields();
    for (Field f : fields) {
      if (Modifier.isStatic(f.getModifiers()) == isStatic &&
        (f.getType().equals(getClientType()) || f.getType().equals(getKubernetesMockServerType()))) {
        return f;
      }
    }
    return null;
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
