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
package io.fabric8.crd.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that allows replacing a nested schema with one from another class.
 *
 * This is an alternative to {@link SchemaFrom} for cases when the classes
 * are coming from an external source and fields cannot be annotated directly.
 *
 * @see SchemaFrom
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(SchemaSwaps.class)
public @interface SchemaSwap {
  /**
   * The owning class of the field whose type is to be replaced.
   * <p>
   * It is an error if the type is not used in the same schema hierarchy where the {@link SchemaSwap} is used.
   */
  Class<?> originalType();

  /**
   * Name of the field whose type is to be replaced.
   * <p>
   * The name should be specified exactly as defined in the Java class, before any renames
   * and transformations ({@code @JsonProperty} and similar) take place.
   * <p>
   * It is an error if the field does not exist on {@link #originalType()}
   */
  String fieldName();

  /**
   * The replacement schema that will be used for the {@link #fieldName()} instead of its specified type
   * <p>
   * The default value of {@code void.class} causes the field to be skipped
   */
  Class<?> targetType() default void.class;

  /**
   * For fields that may include a reference cycle, how many expansions to include in the output before including the
   * {@link #targetType()}
   * <p>
   * The default value of 0 replaces the field with the {@link #targetType()} without any expansion
   */
  int depth() default 0;
}
