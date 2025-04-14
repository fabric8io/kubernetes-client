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
import java.lang.reflect.Array;

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
    public static final String STRING = "io.fabric8.generator.annotation.JSONSchema.Undefined";

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

    public static boolean isUndefined(Object value) {
      if (value == Undefined.class) {
        return true;
      }
      if (STRING.equals(value)) {
        return true;
      }
      if (value instanceof Double && (Double) value == DOUBLE) {
        return true;
      }
      if (value instanceof Long && (Long) value == LONG) {
        return true;
      }
      if (value instanceof Map) {
        return isUndefined(((Map) value).value());
      }
      if (value instanceof DependencyMap) {
        return isUndefined(((DependencyMap) value).value());
      }
      if (value instanceof Dependency) {
        return isUndefined(((Dependency) value).schema());
      }
      if (value instanceof ExternalDocumentation) {
        return isUndefined(((ExternalDocumentation) value).url());
      }
      if (value instanceof ValidationRule) {
        return isUndefined(((ValidationRule) value).value());
      }
      return isUndefinedArray(value);
    }

    private static boolean isUndefinedArray(Object value) {
      if (value.getClass().isArray() && Array.getLength(value) == 1) {
        return isUndefined(Array.get(value, 0));
      }
      return false;
    }
  }

  /**
   * Marker class used to suppress annotation properties of type {@code Class} that may have been
   * set by the use of an `implementation` class.
   */
  public static final class Suppressed implements Boolean {
    /**
     * Marker value used to suppress annotation properties of type
     * {@code String} that may have been set by an {@code implementation} class.
     */
    public static final String STRING = "io.fabric8.generator.annotation.JSONSchema.Suppressed";

    /**
     * Marker value used to suppress annotation properties of type
     * {@code double} that may have been set by an {@code implementation} class.
     */
    public static final double DOUBLE = Double.NEGATIVE_INFINITY;

    /**
     * Marker value used to suppress annotation properties of type
     * {@code long} that may have been set by an {@code implementation} class.
     */
    public static final long LONG = 0xfff0000000000000L;

    private Suppressed() {
    }

    public static boolean isSuppressed(Object value) {
      if (value == Suppressed.class) {
        return true;
      }
      if (STRING.equals(value)) {
        return true;
      }
      if (value instanceof Double && (Double) value == DOUBLE) {
        return true;
      }
      if (value instanceof Long && (Long) value == LONG) {
        return true;
      }
      if (value instanceof ExternalDocumentation) {
        return isSuppressed(((ExternalDocumentation) value).url());
      }
      return isSuppressedArray(value);
    }

    private static boolean isSuppressedArray(Object value) {
      if (value.getClass().isArray()) {
        switch (Array.getLength(value)) {
          case 0:
            // Any of the annotation arrays can be set to length zero to indicate suppression.
            return true;
          case 1:
            return isSuppressed(Array.get(value, 0));
          default:
            break;
        }
      }
      return false;
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

  /**
   * When true, this property indicates that the schema for this element is structural. The CRD
   * generator will enhance the schema to conform to rules 2 and 3 of a Kubernetes structural schema.
   * <p>
   * From the Kubernetes documentation, these rules are as follows (rules 1 and 4 are omitted since they are not relevant to the
   * processing enabled by {@linkplain #structural}).
   * <ol start="2">
   * <li>for each field in an object and each item in an array which is specified within any of {@code allOf}, {@code anyOf},
   * {@code oneOf} or {@code not}, the schema also specifies the field/item outside of those logical junctors</li>
   * <li>does not set {@code description}, {@code type}, {@code default}, {@code additionalProperties}, {@code nullable} within
   * an {@code allOf}, {@code anyOf}, {@code oneOf} or {@code not}, with the exception of the two pattern for
   * {@code x-kubernetes-int-or-string: true}</li>
   * </ol>
   * <p>
   * This means that if this schema specifies classes within one or more of the logical junctors ({@code allOf}, {@code anyOf},
   * {@code oneOf} or {@code not}), the CRD generator will
   * ensure that
   * <ol>
   * <li>Each property/item of each entry within the logical junctors is also added to the properties of the structural schema.
   * If a property name is duplicated, only the first occurrence will be used. If two or more schemas specify array
   * {@code items}, only the first {@code items} will be used. Finally, if this schema itself specifies {@code items}, any
   * {@code items} of the schemas within the logical junctors will not be used.</li>
   * <li>The forbidden attributes of schemas within the logical junctors will be removed. These are {@code description},
   * {@code type}, {@code default}, {@code additionalProperties}, and {@code nullable}. Note that these attributes will be
   * present in the schemas that are set in the properties in step 1.</li>
   * </ol>
   *
   * @see https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#specifying-a-structural-schema
   */
  boolean structural() default false;

  String $ref() default Undefined.STRING; // NOSONAR

  String $schema() default Undefined.STRING; // NOSONAR

  Class<?> additionalItems() default Undefined.class;

  Class<?> additionalProperties() default Undefined.class;

  Class<?>[] allOf() default Undefined.class;

  Class<?>[] anyOf() default Undefined.class;

  String defaultValue() default Undefined.STRING;

  Map[] definitions() default @Map(name = Undefined.STRING, value = Undefined.class);

  DependencyMap[] dependencies() default @DependencyMap(name = Undefined.STRING, value = @Dependency());

  String description() default Undefined.STRING;

  /*
   * Parsed into com.fasterxml.jackson.databind.JsonNode depending on `type`
   */
  String[] enumeration() default Undefined.STRING;

  /*
   * Parsed into com.fasterxml.jackson.databind.JsonNode depending on `type`
   */
  String example() default Undefined.STRING;

  Class<? extends Boolean> exclusiveMaximum() default Undefined.class;

  Class<? extends Boolean> exclusiveMinimum() default Undefined.class;

  ExternalDocumentation externalDocs() default @ExternalDocumentation(url = Undefined.STRING);

  String format() default Undefined.STRING;

  String id() default Undefined.STRING;

  Class<?>[] items() default Undefined.class;

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

  Class<?>[] oneOf() default Undefined.class;

  String pattern() default Undefined.STRING;

  Map[] patternProperties() default @Map(name = Undefined.STRING, value = Undefined.class);

  Map[] properties() default @Map(name = Undefined.STRING, value = Undefined.class);

  String[] required() default Undefined.STRING;

  String title() default Undefined.STRING;

  String type() default Undefined.STRING;

  Class<? extends Boolean> uniqueItems() default Undefined.class;

  Class<? extends Boolean> xKubernetesEmbeddedResource() default Undefined.class;

  Class<? extends Boolean> xKubernetesIntOrString() default Undefined.class;

  String[] xKubernetesListMapKeys() default Undefined.STRING;

  String xKubernetesListType() default Undefined.STRING;

  String xKubernetesMapType() default Undefined.STRING;

  Class<? extends Boolean> xKubernetesPreserveUnknownFields() default Undefined.class;

  ValidationRule[] xKubernetesValidations() default @ValidationRule(value = Undefined.STRING);
}
