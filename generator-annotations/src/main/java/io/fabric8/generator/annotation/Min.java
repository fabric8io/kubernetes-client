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
package io.fabric8.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Java representation of the {@code minimum} field of JSONSchemaProps.
 *
 * @see <a href=
 *      "https://kubernetes.io/docs/reference/kubernetes-api/extend-resources/custom-resource-definition-v1/#JSONSchemaProps">
 *      Kubernetes Docs - API Reference - CRD v1 - JSONSchemaProps
 *      </a>
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Min {
  /**
   * @return the value of the minimum constraint
   */
  double value();

  /**
   * Specifies whether the specified minimum is inclusive or exclusive.
   * By default, it is inclusive.
   *
   * @return {@code true} if the value must be higher or equal to the specified minimum,
   *         {@code false} if the value must be higher
   */
  boolean inclusive() default true;
}
