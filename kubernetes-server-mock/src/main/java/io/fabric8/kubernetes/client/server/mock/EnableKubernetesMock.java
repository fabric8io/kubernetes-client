package io.fabric8.kubernetes.client.server.mock;
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

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.fabric8.kubernetes.client.Client;
import org.junit.jupiter.api.extension.ExtendWith;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation that is used for enabling KubernetesMockExtension JUnit5 extension.
 * You may set parameters of `KubernetesServer`: crudMode and https
 * And what the supported extensions are - empty supports all
 */
@Target({ TYPE, METHOD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@ExtendWith(KubernetesMockExtension.class)
public @interface EnableKubernetesMock {

	boolean https() default true;

	boolean crud() default false;

	Class<? extends Client>[] extensions() default {};
}
