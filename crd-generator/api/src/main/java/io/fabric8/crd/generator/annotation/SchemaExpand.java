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
 * Annotation that allows controlling/replacing a nested schema expansion.
 *
 * This is an alternative to {@link SchemaFrom} for cases when the classes
 * are coming from an external source and fields cannot be annotated directly.
 *
 * @see SchemaFrom
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(SchemaExpands.class)
public @interface SchemaExpand {
  /**
   * The class be replaced.
   * <p>
   * It is an error if the type is not used in the same schema hierarchy where the {@link SchemaExpand} is used.
   */
  Class<?> originalType();

  /**
   * The replacement schema that will be used for the {@link #originalType()} instead of its specified type once
   * the depth has been reached.
   * <p>
   * The default value of {@code void.class} causes the field to be skipped
   */
  Class<?> terminalType() default void.class;

  /**
   * For classes that include a reference cycle, how many expansions to include in the output
   * <p>
   * The default value of 0 replaces the {@link #originalType()} with the {@link #terminalType()} without any expansion
   */
  int depth() default 0;
}
