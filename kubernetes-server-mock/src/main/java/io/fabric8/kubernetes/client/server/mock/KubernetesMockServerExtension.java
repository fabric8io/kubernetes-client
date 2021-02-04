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
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.mockwebserver.Context;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * The class that implements JUnit5 extension mechanism. You can use it directly in your JUnit test
 * by annotating it with `@ExtendWith(KubernetesMockServerExtension.class)` or through
 * \@EnableKubernetesMockClient annotation
 */
public class KubernetesMockServerExtension implements AfterEachCallback, AfterAllCallback, BeforeEachCallback, BeforeAllCallback {

  private KubernetesMockServer mock;
  private NamespacedKubernetesClient client;

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    Optional<Class<?>> optClass = context.getTestClass();
    if (optClass.isPresent()) {
      Class<?> testClass = optClass.get();
      if (findField(testClass, true) == null) {
        destroy();
      }
    }
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    destroy();
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    setKubernetesClientField(context, false);
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    setKubernetesClientField(context, true);
  }

  private void setKubernetesClientField(ExtensionContext context, boolean isStatic) throws IllegalAccessException {
    Optional<Class<?>> optClass = context.getTestClass();
    if (optClass.isPresent()) {
      Class<?> testClass = optClass.get();
      Field[] fields = testClass.getDeclaredFields();
      for (Field f : fields) {
        if (f.getType().equals(getClientType()) && Modifier.isStatic(f.getModifiers()) == isStatic) {
          setKubernetesClientField(context, isStatic, testClass, f);
        }
      }
    }
  }

  private void setKubernetesClientField(ExtensionContext context, boolean isStatic, Class<?> testClass, Field f) throws IllegalAccessException {
    createKubernetesClient(testClass);
    f.setAccessible(true);
    if (isStatic) {
      setKubernetesClientField(null, f);
    } else {
      Optional<Object> optTestInstance = context.getTestInstance();
      if (optTestInstance.isPresent())
        setKubernetesClientField(optTestInstance.get(), f);
    }
  }

  protected void setKubernetesClientField(Object instance, Field f) throws IllegalAccessException {
    f.set(instance, client);
  }

  protected void createKubernetesClient(Class<?> testClass) {
    EnableKubernetesMockClient a = testClass.getAnnotation(EnableKubernetesMockClient.class);
    mock = a.crud()
      ? new KubernetesMockServer(new Context(), new MockWebServer(), new HashMap<>(), new KubernetesCrudDispatcher(Collections.emptyList()), a.https())
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

  protected Field findField(Class<?> testClass, boolean isStatic) {
    Field[] fields = testClass.getDeclaredFields();
    for (Field f : fields) {
      if (f.getType().equals(getClientType()) && Modifier.isStatic(f.getModifiers()) == isStatic) {
        return f;
      }
    }
    return null;
  }

}
