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

import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.function.Function;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation that is used for enabling KubernetesMockExtension JUnit5 extension.
 * You may set parameters of `KubernetesServer`: crudMode and https
 * And exclude apis from being supported with unsupported
 */
@Target({ TYPE, METHOD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@ExtendWith(KubernetesMockServerExtension.class)
public @interface EnableKubernetesMockClient {

  boolean https() default true;

  boolean crud() default false;

  /**
   * No-arg constructor class implementing {@link Function} interface that returns {@link KubernetesClientBuilder} instance.
   * <p>
   * Enables the customization of the automatically bootstrapped and injected
   * {@link io.fabric8.kubernetes.client.KubernetesClient} instance.
   */
  Class<? extends Function<String, KubernetesClientBuilder>> kubernetesClientBuilder() default KubernetesMockClientKubernetesClientBuilder.class;

}
