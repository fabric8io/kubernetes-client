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
import io.fabric8.junit.jupiter.LoadKubernetesManifestsExtension;
import io.fabric8.junit.jupiter.NamespaceExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Enables and configures the {@link LoadKubernetesManifestsExtension} extension.
 * <p>
 * Loads a (list of) resource YAML file into the Kubernetes cluster prior to the execution of the test suite.
 * <p>
 * The resources will be deleted after the test suite execution.
 */
@Target({ TYPE, METHOD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@ExtendWith(NamespaceExtension.class)
@ExtendWith(KubernetesExtension.class)
@ExtendWith(LoadKubernetesManifestsExtension.class)
public @interface LoadKubernetesManifests {

  String[] value();

  boolean deleteAfterTest() default true;

  long deleteGracePeriod() default 0L;
}
