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
package io.fabric8.crd.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines an additional printer column. Must be placed at the root of the custom resource.
 */
@Repeatable(AdditionalPrinterColumns.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AdditionalPrinterColumn {

  /**
   * The name of the column.
   * An empty column name implies the use of the last path element
   *
   * @return the column name, or empty string if the last path element should be used.
   */
  String name() default "";

  /**
   * The printer column format.
   *
   * @return the format or empty string if no format is specified.
   */
  String format() default "";

  /**
   * The printer column priority.
   *
   * @return the priority or 0 if no priority is specified.
   */
  int priority() default 0;

  /**
   * The JSON Path to the field
   * 
   * @return
   */
  String path();

  /**
   * The type of the printer column
   * 
   * @return the type
   */
  String getType();

  /**
   * The description of the printer column
   * 
   * @return the description
   */
  String getDescription() default "";
}
