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
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

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
   * Used to exclude support for the given apiGroups.
   * <br>
   * Each is a simple expression of the form: group[/version]
   * <br>
   * where * is a wildcard.
   * <br>
   * For example to exclude all openshift support, you would specify
   * openshift.io
   * <br>
   * To exclude a specific apiVersion, you would fully specify
   * route.openshift.io/v1
   * <p>
   * NOTE this affects calls to {@link Client#hasApiGroup(String, boolean)}
   * and {@link Client#supports(Class)}. Other calls to get the full root path or other
   * api group metadata will not return valid results in mock scenarios.
   * 
   * @return the list of unsupported patterns
   */
  String[] unsupported() default {};
}
