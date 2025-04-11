/*
 * Copyright (C) 2025 Red Hat, Inc.
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

@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONSchema {

  /**
   * Marker interface used to restrict the class types that may be used for
   * properties of type boolean. This enables readers of the annotation to
   * distinguish between true, false, and undefined values.
   */
  interface Boolean {
  }

  /**
   * Marker class used as a default for annotation properties of type
   * {@code Class}.
   */
  public static final class Undefined implements Boolean {
    /**
     * Marker value used as a default for annotation properties of type
     * {@code String}.
     */
    public static final String STRING = "io.fabric8.generator.annotation.JSONSchema.UNSET";

    /**
     * Marker value used as a default for annotation properties of type
     * {@code double}.
     */
    public static final double DOUBLE = Double.POSITIVE_INFINITY;

    /**
     * Marker value used as a default for annotation properties of type
     * {@code long}. Same binary value used for Double.POSITIVE_INFINITY.
     */
    public static final long LONG = 0x7ff0000000000000L;

    private Undefined() {
    }
  }

  /**
   * Marker class to indicate that a boolean {@code true} schema should be used.
   * Additionally, this class is used to set a value of {@code true} for
   * properties that allow true, false, or undefined boolean values.
   */
  public static final class True implements Boolean {
    private True() {
    }
  }

  /**
   * Marker class to indicate that a boolean {@code false} schema should be used.
   * Additionally, this class is used to set a value of {@code false} for
   * properties that allow true, false, or undefined boolean values.
   */
  public static final class False implements Boolean {
    private False() {
    }
  }

  @Target({})
  @Retention(RetentionPolicy.RUNTIME)
  public @interface Map {
    String name();

    Class<?> value();
  }

  @Target({})
  @Retention(RetentionPolicy.RUNTIME)
  public @interface Dependency {
    String[] properties() default {};

    Class<?> schema() default Undefined.class;
  }

  @Target({})
  @Retention(RetentionPolicy.RUNTIME)
  public @interface DependencyMap {
    String name();

    Dependency value();
  }

  @Target({})
  @Retention(RetentionPolicy.RUNTIME)
  public @interface ExternalDocumentation {
    String description() default Undefined.STRING;

    String url();
  }

  /**
   * The implementation class allows for an additional type to be scanned as the
   * basis for this schema. After scanning the implementation (if specified), the
   * remaining properties will be set from this annotation, possibly overriding
   * those determine by scanning the implementation class.
   */
  Class<?> implementation() default Undefined.class;

  String $ref() default Undefined.STRING; // NOSONAR

  String $schema() default Undefined.STRING; // NOSONAR

  Class<?> additionalItems() default Undefined.class;

  Class<?> additionalProperties() default Undefined.class;

  Class<?>[] allOf() default {};

  Class<?>[] anyOf() default {};

  String defaultValue() default Undefined.STRING;

  Map[] definitions() default {};

  DependencyMap[] dependencies() default {};

  String description() default Undefined.STRING;

  /*
   * Parsed into com.fasterxml.jackson.databind.JsonNode depending on `type`
   */
  String[] enumeration() default {};

  /*
   * Parsed into com.fasterxml.jackson.databind.JsonNode depending on `type`
   */
  String example() default Undefined.STRING;

  Class<? extends Boolean> exclusiveMaximum() default Undefined.class;

  Class<? extends Boolean> exclusiveMinimum() default Undefined.class;

  ExternalDocumentation externalDocs() default @ExternalDocumentation(url = Undefined.STRING);

  String format() default Undefined.STRING;

  String id() default Undefined.STRING;

  Class<?>[] items() default {};

  long maxItems() default Undefined.LONG;

  long maxLength() default Undefined.LONG;

  long maxProperties() default Undefined.LONG;

  double maximum() default Undefined.DOUBLE;

  long minItems() default Undefined.LONG;

  long minLength() default Undefined.LONG;

  long minProperties() default Undefined.LONG;

  double minimum() default Undefined.DOUBLE;

  double multipleOf() default Undefined.DOUBLE;

  Class<?> not() default Undefined.class;

  Class<? extends Boolean> nullable() default Undefined.class;

  Class<?>[] oneOf() default {};

  String pattern() default Undefined.STRING;

  Map[] patternProperties() default {};

  Map[] properties() default {};

  String[] required() default {};

  String title() default Undefined.STRING;

  String type() default Undefined.STRING;

  Class<? extends Boolean> uniqueItems() default Undefined.class;

  Class<? extends Boolean> xKubernetesEmbeddedResource() default Undefined.class;

  Class<? extends Boolean> xKubernetesIntOrString() default Undefined.class;

  String[] xKubernetesListMapKeys() default {};

  String xKubernetesListType() default Undefined.STRING;

  String xKubernetesMapType() default Undefined.STRING;

  Class<? extends Boolean> xKubernetesPreserveUnknownFields() default Undefined.class;

  ValidationRule[] xKubernetesValidations() default {};
}
