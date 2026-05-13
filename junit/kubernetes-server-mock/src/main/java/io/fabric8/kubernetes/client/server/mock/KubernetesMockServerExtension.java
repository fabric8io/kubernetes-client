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
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.MockWebServer;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.http.Dispatcher;
import io.fabric8.mockwebserver.internal.MockDispatcher;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
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

  // Per-JVM shared resources amortize Vert.x/Netty cold-start across the fork. The first
  // test pays the ~7-8 s TLS/event-loop/class-load cost; subsequent tests reuse the same
  // Vertx and MockWebServer instances rather than re-running it on every @BeforeEach.
  private static final Object SHARED_LOCK = new Object();
  private static volatile Vertx sharedVertx;
  private static volatile MockWebServer sharedHttpServer;
  private static volatile MockWebServer sharedHttpsServer;
  private static volatile HttpClient.Factory sharedFactory;
  private static volatile boolean shutdownHookRegistered;

  private KubernetesMockServer staticMock;
  private NamespacedKubernetesClient staticClient;
  private Dispatcher staticDispatcher;
  private KubernetesMockServer instantMock;
  private NamespacedKubernetesClient instantClient;
  private Dispatcher instantDispatcher;

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
    final MockWebServer mockWebServer = getOrCreateSharedServer(a.https());
    // The DefaultMockServer constructor wires our fresh dispatcher (and responses map)
    // into the shared MockWebServer via setDispatcher — atomically swapping out the
    // previous test's dispatcher before we touch the request queue.
    // There is a microsecond window between this constructor returning and mock.onStart()
    // populating the responses map. A stray in-flight request from a previous test's
    // leaked connection would see an empty responses map and get a default empty
    // response. Acceptable because the previous test's destroy() closes its client
    // (and therefore its connections) before this @BeforeEach runs.
    final KubernetesMockServer mock = new KubernetesMockServer(new Context(Serialization.jsonMapper()),
        mockWebServer, responses, dispatcher, a.https());
    // Skip mock.init() — the shared MockWebServer is already started. Run onStart()
    // directly to register the / and /version expectations into this test's responses map.
    mock.onStart();
    // Now (with the new dispatcher in place) clear request count and queue carried over
    // from the previous test in this fork.
    mockWebServer.reset();
    if (isStatic) {
      staticMock = mock;
      staticDispatcher = dispatcher;
    } else {
      instantMock = mock;
      instantDispatcher = dispatcher;
    }
    try {
      final Consumer<KubernetesClientBuilder> userCustomizer = a.kubernetesClientBuilderCustomizer().getConstructor()
          .newInstance();
      final NamespacedKubernetesClient client = mock.createClient(builder -> {
        builder.withHttpClientFactory(sharedHttpClientFactory());
        userCustomizer.accept(builder);
      });
      if (isStatic) {
        staticClient = client;
      } else {
        instantClient = client;
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("The provided kubernetesClientBuilder is invalid", e);
    }
  }

  /**
   * Returns the per-JVM MockWebServer for the requested transport (HTTP or HTTPS), creating
   * and starting it on first use. Shared across all tests in this fork to avoid paying
   * Vert.x/Netty cold-start on each test.
   */
  private static MockWebServer getOrCreateSharedServer(boolean useHttps) {
    MockWebServer existing = useHttps ? sharedHttpsServer : sharedHttpServer;
    if (existing != null) {
      return existing;
    }
    synchronized (SHARED_LOCK) {
      existing = useHttps ? sharedHttpsServer : sharedHttpServer;
      if (existing != null) {
        return existing;
      }
      final MockWebServer fresh = new MockWebServer();
      if (useHttps) {
        fresh.useHttps();
      }
      fresh.start();
      if (useHttps) {
        sharedHttpsServer = fresh;
      } else {
        sharedHttpServer = fresh;
      }
      registerShutdownHook();
      return fresh;
    }
  }

  /**
   * Returns the per-JVM Vertx used for the test HTTP client. Shared across all tests in
   * this fork. Event-loop threads are daemons so they don't keep the JVM alive after the
   * test runner exits.
   */
  private static Vertx getOrCreateSharedVertx() {
    Vertx v = sharedVertx;
    if (v != null) {
      return v;
    }
    synchronized (SHARED_LOCK) {
      if (sharedVertx == null) {
        sharedVertx = Vertx.vertx(new VertxOptions().setUseDaemonThread(true));
        registerShutdownHook();
      }
      return sharedVertx;
    }
  }

  /**
   * Returns an {@link HttpClient.Factory} that reuses the per-JVM shared Vertx, if the
   * ServiceLoader-resolved factory exposes a {@code (Vertx)} constructor (true for both
   * the Vert.x 4 and Vert.x 5 implementations). For any other factory (OkHttp, JDK, ...)
   * the default instance is returned unchanged. The result is cached after the first call
   * so the ServiceLoader scan and reflective probe are paid once per JVM.
   */
  private static HttpClient.Factory sharedHttpClientFactory() {
    HttpClient.Factory cached = sharedFactory;
    if (cached != null) {
      return cached;
    }
    synchronized (SHARED_LOCK) {
      if (sharedFactory != null) {
        return sharedFactory;
      }
      final HttpClient.Factory defaultFactory = HttpClientUtils.getHttpClientFactory();
      try {
        final Constructor<?> ctor = defaultFactory.getClass().getConstructor(Vertx.class);
        sharedFactory = (HttpClient.Factory) ctor.newInstance(getOrCreateSharedVertx());
      } catch (NoSuchMethodException e) {
        // Factory has no (Vertx) constructor (OkHttp, JDK, ...) — fall back to the default
        // singleton. ServiceLoader returns the same instance for repeated lookups, so
        // caching it here is consistent with prior behavior.
        sharedFactory = defaultFactory;
      } catch (ReflectiveOperationException e) {
        throw new IllegalStateException("Failed to instantiate shared-Vertx HttpClient.Factory", e);
      }
      return sharedFactory;
    }
  }

  private static void registerShutdownHook() {
    // Called only from inside SHARED_LOCK (getOrCreateSharedServer / getOrCreateSharedVertx),
    // so the check-then-set sequence is safe today. Keeping the synchronized block to make
    // the invariant explicit and to keep the method safe if a future caller forgets the lock.
    synchronized (SHARED_LOCK) {
      if (shutdownHookRegistered) {
        return;
      }
      shutdownHookRegistered = true;
      Runtime.getRuntime().addShutdownHook(new Thread(KubernetesMockServerExtension::shutdownSharedResources,
          "fabric8-mock-shared-shutdown"));
    }
  }

  private static void shutdownSharedResources() {
    final MockWebServer http = sharedHttpServer;
    if (http != null) {
      try {
        http.shutdown();
      } catch (Exception ignored) {
        // best-effort
      }
    }
    final MockWebServer https = sharedHttpsServer;
    if (https != null) {
      try {
        https.shutdown();
      } catch (Exception ignored) {
        // best-effort
      }
    }
    final Vertx v = sharedVertx;
    if (v != null) {
      try {
        // Bounded wait so a stuck Vert.x close doesn't hold up JVM exit indefinitely.
        v.close().toCompletionStage().toCompletableFuture().get(5, TimeUnit.SECONDS);
      } catch (Exception ignored) {
        // best-effort
      }
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
    // Do NOT call instantMock.destroy(): it would shut down the per-fork shared
    // MockWebServer. The shared server is reset() at the start of each test and torn
    // down by the JVM shutdown hook.
    if (instantClient != null) {
      instantClient.close();
    }
    // Shut down the per-test dispatcher to release any WebSocket sessions it accumulated
    // (the shared MockWebServer's setDispatcher would otherwise silently replace it next
    // test without invoking shutdown).
    if (instantDispatcher != null) {
      instantDispatcher.shutdown();
    }
  }

  protected void destroyStatic() {
    // Do NOT call staticMock.destroy(): see destroy().
    if (staticClient != null) {
      staticClient.close();
    }
    if (staticDispatcher != null) {
      staticDispatcher.shutdown();
    }
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
