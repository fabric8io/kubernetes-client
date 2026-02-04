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

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Marks a static method as a webhook request handler.
 *
 * <p>
 * The annotated method must have the signature:
 * <pre>{@code
 * static MockResponse methodName(RecordedRequest request)
 * }</pre>
 *
 * <p>
 * Example:
 * <pre>{@code
 * &#64;WebhookHandler
 * static MockResponse handleWebhook(RecordedRequest request) {
 *   AdmissionReview review = WebhookServerUtils.parseAdmissionReview(request);
 *   // ... process the request
 *   return WebhookServerUtils.createJsonResponse(response);
 * }
 * }</pre>
 *
 * <p>
 * Multiple handlers can be registered by specifying different paths:
 * <pre>{@code
 * &#64;WebhookHandler(path = "/validate")
 * static MockResponse handleValidation(RecordedRequest request) { ... }
 *
 * &#64;WebhookHandler(path = "/mutate")
 * static MockResponse handleMutation(RecordedRequest request) { ... }
 * }</pre>
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface WebhookHandler {

  /**
   * The path this handler should respond to.
   * If not specified, the handler will respond to all requests.
   *
   * @return the path pattern
   */
  String path() default "";
}
