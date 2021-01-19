/**
 * Copyright 2018 The original authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.dekorate.crd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.dekorate.crd.config.Scope;

/**
 * This indicates that the annotated classs represents a `CustomResource` from which a `CustomResourceDefinition` needs to be generated.
 */
@Target({ ElementType.CONSTRUCTOR, ElementType.TYPE })
@Retention(RetentionPolicy.SOURCE)
public @interface Crd {

  /**
   * The custom resource group.
   * 
   * @return The group, or the package name if group if empty.
   */
  String group() default "";

  /**
   * The custom resource kind.
   * 
   * @return The kind or the classname if kind is empty.
   */
  String kind() default "";

  /**
   * The custom resource name.
   * 
   * @return The name, or the kind in lower case if empty.
   */
  String name() default "";

  /**
   * The custom resource plural name.
   * 
   * @return The plural, or the actual name converted automatically to plural.
   */
  String plural() default "";

  /**
   * The custom resource short name.
   * 
   * @return The short name, or a calculated short name (based on camelcase) if shortname is empty.
   */
  String shortName() default "";

  /**
   * The custom resource version.
   * 
   * @return The version, or the project version if empty.
   */
  String version() default "";


  /**
   * Flag that indicates that version is enabled.
   * @return true if version is enabled.
   */
  boolean served() default true;

  /**
   * Flag that indicates that the version is the storage version.
   * Only one version should be set as 'storage' at a time.
   * @return true if version is the storage version.
   */ 
  boolean storage() default false;

  /**
   * The resource scope.
   * 
   * @return The scope, defaults to Namespaced.
   */
  Scope scope() default Scope.Namespaced;


  /**
   * The scale configuration.
   * @return the scale configuration.
   */
  Scale scale() default @Scale();

  /**
   * The class that defines the status.
   * When no status is present, autodetection will be attempted.
   * @return The class or Autodetect.class if no class is specified.
   */
  Class status() default Autodetect.class;

}
