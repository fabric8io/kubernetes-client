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
package io.fabric8.junit.jupiter.api;

import io.fabric8.junit.jupiter.KubernetesExtension;
import io.fabric8.junit.jupiter.NamespaceExtension;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Enables and configures the {@link KubernetesExtension} extension.
 *
 * <p>
 * Creates a {@link KubernetesClient} instance that will
 * be automatically injected into tests.
 *
 * <p>
 * Optionally, creates a Namespace for the tests and configures the client to use it. The Namespace
 * is deleted after the test suite execution.
 *
 * <pre>{@code
 * &#64;KubernetesTest
 * class MyTest {
 *   KubernetesClient client;
 *   static OpenShiftClient oc;
 * }
 * }</pre>
 */
@Target({ TYPE, METHOD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@ExtendWith(NamespaceExtension.class)
@ExtendWith(KubernetesExtension.class)
public @interface KubernetesTest {
  /**
   * Create an ephemeral Namespace for the test.
   */
  boolean createEphemeralNamespace() default true;
}
