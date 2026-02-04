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
package io.fabric8.kubeapitest.junit;

import io.fabric8.kubeapitest.cert.CertManager;
import io.fabric8.mockwebserver.MockWebServer;
import io.fabric8.mockwebserver.http.Dispatcher;
import io.fabric8.mockwebserver.http.MockResponse;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.bouncycastle.asn1.x509.GeneralName;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * JUnit 5 extension that manages the lifecycle of a MockWebServer for webhook testing.
 * Uses certificates generated with proper Subject Alternative Names for localhost.
 */
public class WebhookServerExtension implements BeforeAllCallback, AfterAllCallback {

  private static final Logger logger = LoggerFactory.getLogger(WebhookServerExtension.class);

  private MockWebServer server;
  private File certFile;
  private int actualPort;

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    Optional<EnableWebhookServer> annotation = context.getTestClass()
        .flatMap(clazz -> Optional.ofNullable(clazz.getAnnotation(EnableWebhookServer.class)));

    if (annotation.isEmpty()) {
      return;
    }

    EnableWebhookServer config = annotation.get();
    Class<?> testClass = context.getRequiredTestClass();

    // Initialize certificate and key files
    certFile = new File(config.certFile());
    if (!certFile.isAbsolute()) {
      certFile = new File("target", config.certFile());
    }
    if (certFile.getParentFile() != null) {
      certFile.getParentFile().mkdirs();
    }

    File keyFile = new File(certFile.getParentFile(),
        certFile.getName().replace(".crt", ".key").replace(".pem", ".key"));

    // Generate certificates with proper DNS SANs for localhost
    logger.info("Generating webhook certificates with DNS SAN for localhost");
    CertManager.generateKeyAndCertificate("CN=localhost", keyFile, certFile,
        new GeneralName(GeneralName.dNSName, "localhost"));

    // Find webhook handler methods
    Map<String, Method> handlers = findWebhookHandlers(testClass);

    if (handlers.isEmpty()) {
      throw new IllegalStateException(
          "No @WebhookHandler methods found in " + testClass.getName() + ". " +
              "At least one static method annotated with @WebhookHandler is required.");
    }

    // Create and configure server
    server = new MockWebServer();
    server.usePemCertificates(keyFile, certFile);
    server.setDispatcher(createDispatcher(handlers));

    // Start server
    int configuredPort = config.port();
    server.start(Math.max(configuredPort, 0));

    actualPort = server.getPort();
    logger.info("Webhook server started on port {} with proper DNS SAN certificate", actualPort);

    // Inject fields
    injectFields(testClass);
  }

  @Override
  public void afterAll(ExtensionContext context) {
    if (server != null) {
      logger.info("Stopping webhook server on port {}", actualPort);
      server.shutdown();
      server = null;
    }
  }

  private Map<String, Method> findWebhookHandlers(Class<?> testClass) {
    Map<String, Method> handlers = new HashMap<>();

    for (Method method : testClass.getDeclaredMethods()) {
      WebhookHandler annotation = method.getAnnotation(WebhookHandler.class);
      if (annotation != null) {
        validateHandlerMethod(method);
        String path = annotation.path().isEmpty() ? "*" : annotation.path();
        handlers.put(path, method);
        logger.debug("Registered webhook handler: {} -> {}", path, method.getName());
      }
    }

    return handlers;
  }

  private void validateHandlerMethod(Method method) {
    if (!Modifier.isStatic(method.getModifiers())) {
      throw new IllegalStateException(
          "@WebhookHandler method must be static: " + method.getName());
    }

    if (method.getParameterCount() != 1 ||
        !RecordedRequest.class.isAssignableFrom(method.getParameterTypes()[0])) {
      throw new IllegalStateException(
          "@WebhookHandler method must have signature: static MockResponse methodName(RecordedRequest request). " +
              "Invalid method: " + method.getName());
    }

    if (!MockResponse.class.isAssignableFrom(method.getReturnType())) {
      throw new IllegalStateException(
          "@WebhookHandler method must return MockResponse. Invalid method: " + method.getName());
    }
  }

  @SuppressWarnings("java:S3011")
  private Dispatcher createDispatcher(Map<String, Method> handlers) {
    return new Dispatcher() {
      @Override
      public MockResponse dispatch(RecordedRequest request) {
        try {
          String path = request.getPath();

          // First try exact path match
          Method handler = handlers.get(path);

          // If no exact match, try wildcard handler
          if (handler == null) {
            handler = handlers.get("*");
          }

          // If still no handler, try prefix matching
          if (handler == null) {
            handler = getHandler(path, handlers);
          }

          if (handler == null) {
            logger.warn("No webhook handler found for path: {}", path);
            return new MockResponse()
                .setResponseCode(404)
                .setBody("No webhook handler configured for path: " + path);
          }
          handler.setAccessible(true);
          return (MockResponse) handler.invoke(null, request);

        } catch (Exception e) {
          logger.error("Error dispatching webhook request", e);
          return new MockResponse()
              .setResponseCode(500)
              .setHeader("Content-Type", "text/plain")
              .setBody("Error processing webhook: " + e.getMessage());
        }
      }
    };
  }

  private static Method getHandler(String path, Map<String, Method> handlers) {
    for (Map.Entry<String, Method> entry : handlers.entrySet()) {
      if (!entry.getKey().equals("*") && path.startsWith(entry.getKey())) {
        return entry.getValue();
      }
    }
    return null;
  }

  private void injectFields(Class<?> testClass) throws IllegalAccessException {
    for (Field field : testClass.getDeclaredFields()) {
      if (field.isAnnotationPresent(WebhookCertFile.class)) {
        injectCertFile(field);
      } else if (field.isAnnotationPresent(WebhookPort.class)) {
        injectPort(field);
      }
    }
  }

  @SuppressWarnings("java:S3011")
  private void injectCertFile(Field field) throws IllegalAccessException {
    if (!Modifier.isStatic(field.getModifiers())) {
      throw new IllegalStateException(
          "@WebhookCertFile field must be static: " + field.getName());
    }

    if (!File.class.isAssignableFrom(field.getType())) {
      throw new IllegalStateException(
          "@WebhookCertFile field must be of type File: " + field.getName());
    }

    field.setAccessible(true);
    field.set(null, certFile);
    logger.debug("Injected cert file into field: {}", field.getName());
  }

  @SuppressWarnings("java:S3011")
  private void injectPort(Field field) throws IllegalAccessException {
    if (!Modifier.isStatic(field.getModifiers())) {
      throw new IllegalStateException(
          "@WebhookPort field must be static: " + field.getName());
    }

    if (field.getType() != int.class && field.getType() != Integer.class) {
      throw new IllegalStateException(
          "@WebhookPort field must be of type int or Integer: " + field.getName());
    }

    field.setAccessible(true);
    field.set(null, actualPort);
    logger.debug("Injected port {} into field: {}", actualPort, field.getName());
  }
}
