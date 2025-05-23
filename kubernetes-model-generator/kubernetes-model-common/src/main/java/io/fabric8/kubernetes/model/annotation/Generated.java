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
package io.fabric8.kubernetes.model.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Drop-in replacement for javax.annotation.Generated, meant to be used internally to avoid bringing in the whole jar.
 */
@Documented
@Retention(SOURCE)
@Target({ PACKAGE, TYPE, ANNOTATION_TYPE, METHOD, CONSTRUCTOR, FIELD,
    LOCAL_VARIABLE, PARAMETER })
public @interface Generated {

  /**
   * The value element must have the name of the code generator.
   * The recommended convention is to use the fully qualified name of the
   * code generator. For example: <code>com.acme.generator.CodeGen</code>.
   */
  String[] value();

  /**
   * Date when the source was generated.
   */
  String date() default "";

  /**
   * A place holder for any comments that the code generator may want to
   * include in the generated code.
   */
  String comments() default "";

}
