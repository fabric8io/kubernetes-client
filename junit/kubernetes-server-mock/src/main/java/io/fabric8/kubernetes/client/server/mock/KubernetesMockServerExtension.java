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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    context.getTestClass().ifPresent(testClass -> initializeKubernetesClientAndMockServer(testClass, false));
    for (Object testInstance : context.getRequiredTestInstances().getAllInstances()) {
      for (Field field : extractFields(context, Client.class, f -> !Modifier.isStatic(f.getModifiers()))) {
        if (field.getDeclaringClass().isAssignableFrom(testInstance.getClass())) {
          setFieldValue(field, testInstance, instantClient.adapt((Class<Client>) field.getType()));
        }
      }
      for (Field field : extractFields(context, KubernetesMockServer.class, f -> !Modifier.isStatic(f.getModifiers()))) {
        if (field.getDeclaringClass().isAssignableFrom(testInstance.getClass())) {
          setFieldValue(field, testInstance, instantMock);
        }
      }
    }
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    context.getTestClass().ifPresent(testClass -> initializeKubernetesClientAndMockServer(testClass, true));
    for (Field field : extractFields(context, Client.class, f -> Modifier.isStatic(f.getModifiers()))) {
      setFieldValue(field, null, staticClient.adapt((Class<Client>) field.getType()));
    }
    for (Field field : extractFields(context, KubernetesMockServer.class, f -> Modifier.isStatic(f.getModifiers()))) {
      setFieldValue(field, null, staticMock);
    }
  }

  protected void initializeKubernetesClientAndMockServer(Class<?> testClass, boolean isStatic) {
    EnableKubernetesMockClient a = extractEnabledKubernetesMockClient(testClass);
    if (a == null) {
      return;
    }
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

  private static EnableKubernetesMockClient extractEnabledKubernetesMockClient(Class<?> testClass) {
    EnableKubernetesMockClient a = testClass.getAnnotation(EnableKubernetesMockClient.class);
    Class<?> enclosingClass = testClass;
    while (a == null && enclosingClass.getEnclosingClass() != null) {
      enclosingClass = enclosingClass.getEnclosingClass();
      a = enclosingClass.getAnnotation(EnableKubernetesMockClient.class);
    }
    Class<?> superClass = testClass;
    while (a == null && superClass.getSuperclass() != null && superClass != Object.class) {
      superClass = superClass.getSuperclass();
      a = superClass.getAnnotation(EnableKubernetesMockClient.class);
    }
    return a;
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

  // Copied from io.fabric8.junit.jupiter.BaseExtension.extractFields TODO: remove duplication
  private static Field[] extractFields(ExtensionContext context, Class<?> clazz, Predicate<Field>... predicates) {
    final List<Field> fields = new ArrayList<>();
    if (context.getTestClass().isPresent()) {
      Class<?> testClass = context.getTestClass().orElse(Object.class);
      fields.addAll(extractFields(testClass, clazz, predicates));
      Class<?> enclosingTestClass = testClass.getEnclosingClass();
      while (enclosingTestClass != null) {
        fields.addAll(extractFields(enclosingTestClass, clazz, predicates));
        enclosingTestClass = enclosingTestClass.getEnclosingClass();
      }
    }
    return fields.toArray(new Field[0]);
  }

  // Copied from io.fabric8.junit.jupiter.BaseExtension.extractFields TODO: remove duplication
  private static List<Field> extractFields(Class<?> testClass, Class<?> clazz, Predicate<Field>... predicates) {
    final List<Field> fields = new ArrayList<>();
    do {
      fields.addAll(extractFieldsFromClass(testClass, clazz, predicates));
      testClass = testClass.getSuperclass();
    } while (testClass != Object.class);
    return fields;
  }

  // Copied from io.fabric8.junit.jupiter.BaseExtension.extractFields TODO: remove duplication
  private static List<Field> extractFieldsFromClass(Class<?> classWhereFieldIs, Class<?> fieldType,
      Predicate<Field>... predicates) {
    if (classWhereFieldIs != null && classWhereFieldIs != Object.class) {
      Stream<Field> fieldStream = Arrays.stream(classWhereFieldIs.getDeclaredFields())
          .filter(f -> fieldType.isAssignableFrom(f.getType()));
      for (Predicate<Field> p : predicates) {
        fieldStream = fieldStream.filter(p);
      }
      return fieldStream.collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

  // Copied from io.fabric8.junit.jupiter.BaseExtension.setFieldValue TODO: remove duplication
  private static void setFieldValue(Field field, Object entity, Object value) throws IllegalAccessException {
    final boolean isAccessible = field.isAccessible();
    field.setAccessible(true);
    field.set(entity, value);
    field.setAccessible(isAccessible);
  }
}
