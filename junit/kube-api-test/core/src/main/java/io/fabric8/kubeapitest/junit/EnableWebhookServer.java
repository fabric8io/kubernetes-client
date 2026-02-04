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

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * JUnit 5 extension to automatically start and manage a MockWebServer for webhook testing.
 *
 * <p>
 * Usage example:
 * <pre>{@code
 * &#64;EnableKubeAPIServer
 * &#64;EnableWebhookServer(port = 8443)
 * class MyWebhookTest {
 *
 *   &#64;WebhookHandler
 *   static MockResponse handleWebhook(RecordedRequest request) {
 *     AdmissionReview review = WebhookServerUtils.parseAdmissionReview(request);
 *     // ... validation logic
 *     return WebhookServerUtils.createJsonResponse(responseReview);
 *   }
 *
 *   &#64;WebhookCertFile
 *   static File certFile;  // Injected automatically
 *
 *   &#64;WebhookPort
 *   static int actualPort;  // Injected automatically
 *
 *   &#64;Test
 *   void testWebhook(KubernetesClient client) {
 *     // Use certFile and actualPort in your test
 *   }
 * }
 * }</pre>
 */
@ExtendWith(WebhookServerExtension.class)
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Inherited
public @interface EnableWebhookServer {

  /**
   * The port for the webhook server to listen on.
   * If set to 0, a random available port will be used.
   *
   * @return the port number
   */
  int port() default 0;

  /**
   * The path where the certificate file will be written.
   * Relative paths are resolved relative to the target directory.
   *
   * @return the certificate file path
   */
  String certFile() default "webhook-server.crt";
}
