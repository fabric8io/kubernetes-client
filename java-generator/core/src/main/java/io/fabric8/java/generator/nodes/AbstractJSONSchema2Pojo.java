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
package io.fabric8.java.generator.nodes;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import io.fabric8.java.generator.Config;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;

import java.util.Locale;
import java.util.function.Function;

import static io.fabric8.java.generator.nodes.Keywords.*;

public abstract class AbstractJSONSchema2Pojo {

  static final String BOOLEAN_CRD_TYPE = "boolean";
  static final String INTEGER_CRD_TYPE = "integer";
  static final String INT32_CRD_TYPE = "int32";
  static final String INT64_CRD_TYPE = "int64";
  static final String NUMBER_CRD_TYPE = "number";
  static final String FLOAT_CRD_TYPE = "float";
  static final String DOUBLE_CRD_TYPE = "double";
  static final String STRING_CRD_TYPE = "string";
  static final String DATETIME_CRD_TYPE = "date-time";
  static final String OBJECT_CRD_TYPE = "object";
  static final String ARRAY_CRD_TYPE = "array";

  public static final AnnotationExpr newGeneratedAnnotation() {
    return new SingleMemberAnnotationExpr(
        new Name("javax.annotation.processing.Generated"),
        new StringLiteralExpr("io.fabric8.java.generator.CRGeneratorRunner"));
  }

  protected final String description;
  protected final Config config;
  protected final boolean isNullable;
  protected final JsonNode defaultValue;

  protected Double maximum;
  protected Double minimum;
  protected String pattern;

  public Double getMaximum() {
    return maximum;
  }

  public Double getMinimum() {
    return minimum;
  }

  public String getPattern() {
    return pattern;
  }

  public abstract String getType();

  public abstract GeneratorResult generateJava();

  /** Takes a string and return the corresponding package name */
  public static String packageName(String str) {
    String pkg = str.toLowerCase(Locale.ROOT);
    if (pkg.equals(str)) { // avoid package/class name clash
      pkg = "_" + pkg;
    }
    // https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html
    // if the package name contains a reserved Java keyword ... the suggested convention is to add an underscore
    if (JAVA_KEYWORDS.contains(pkg)) {
      pkg = pkg + "_";
    }
    return pkg;
  }

  public String getDescription() {
    return description;
  }

  protected JsonNode getDefaultValue() {
    return defaultValue;
  }

  protected String getClassType() {
    return getType();
  }

  protected AbstractJSONSchema2Pojo(Config config, String description, final boolean isNullable, JsonNode defaultValue,
      final ValidationProperties validationProperties) {
    this.config = config;
    this.description = description;
    this.isNullable = isNullable;
    this.defaultValue = defaultValue;
    if (validationProperties != null) {
      this.maximum = validationProperties.getMaximum();
      this.minimum = validationProperties.getMinimum();
      this.pattern = validationProperties.getPattern();
    }
  }

  /** Takes a random string and manipulate it to be a valid Java identifier */
  public static String sanitizeString(String str) {
    str = str.trim();
    String sanitized = "";
    // https://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.8
    if (JAVA_KEYWORDS.contains(str) || (!str.isEmpty() && !Character.isJavaIdentifierStart(str.charAt(0)))) {
      sanitized = "_" + str;
    } else {
      sanitized = str;
    }

    if (sanitized.startsWith("-")) {
      sanitized = sanitized.replaceFirst("-", "minus");
    }

    int index = sanitized.indexOf('-');
    while (index != -1) {
      int next = Math.min(index + 2, sanitized.length());
      sanitized = sanitized.substring(0, index)
          + sanitized.substring(index + 1, next).toUpperCase()
          + sanitized.substring(next);
      index = sanitized.indexOf('-');
    }

    StringBuilder sanitizedSb = new StringBuilder(sanitized.length());
    for (char originalChar : sanitized.toCharArray()) {
      char sanitizedChar = Character.isJavaIdentifierPart(originalChar) ? originalChar : '_';
      sanitizedSb.append(sanitizedChar);
    }
    sanitized = sanitizedSb.toString();

    return sanitized;
  }

  public static String escapeQuotes(String str) {
    return str.replace("\"", "\\\"").replace("\'", "\\\'");
  }

  private static String getRefinedIntegerType(String format) {
    if (format == null || format.equals(INT64_CRD_TYPE)) {
      return INT64_CRD_TYPE;
    } else if (format.equals(INT32_CRD_TYPE)) {
      return INT32_CRD_TYPE;
    } else {
      throw new JavaGeneratorException("Unsupported format for integer found " + format);
    }
  }

  private static String getRefinedNumberType(String format) {
    if (format == null || format.equals(DOUBLE_CRD_TYPE)) {
      return DOUBLE_CRD_TYPE;
    } else if (format.equals(FLOAT_CRD_TYPE)) {
      return FLOAT_CRD_TYPE;
    } else {
      throw new JavaGeneratorException("Unsupported format for number found " + format);
    }
  }

  private static String getRefinedStringType(String format) {
    if (format == null || format.equals(STRING_CRD_TYPE)) {
      return STRING_CRD_TYPE;
    } else if (format.equals(DATETIME_CRD_TYPE)) {
      return DATETIME_CRD_TYPE;
    } else {
      // TODO: there are more string format to support: byte, date etc.
      return STRING_CRD_TYPE;
    }
  }

  public static AbstractJSONSchema2Pojo fromJsonSchema(
      String key,
      JSONSchemaProps prop,
      String parentPkg,
      Config config) {
    Function<JavaNameAndType, AbstractJSONSchema2Pojo> fromJsonSchema = javaNameAndType -> fromJsonSchema(
        key,
        javaNameAndType,
        prop,
        parentPkg,
        config);
    String type = prop.getType();
    if (Boolean.TRUE.equals(prop.getXKubernetesIntOrString())) {
      return fromJsonSchema.apply(JPrimitiveNameAndType.INT_OR_STRING);
    } else if (type == null
        && Boolean.TRUE.equals(prop.getXKubernetesPreserveUnknownFields())) {
      return fromJsonSchema.apply(JPrimitiveNameAndType.ANY_TYPE);
    } else if (prop.getEnum() != null && prop.getEnum().size() > 0) {
      return fromJsonSchema.apply(new JEnumNameAndType(key));
    } else {
      if (type == null) {
        throw new IllegalArgumentException("Type for key:" + key + " is null");
      }

      switch (type) {
        case BOOLEAN_CRD_TYPE:
          return fromJsonSchema.apply(JPrimitiveNameAndType.BOOL);
        case INTEGER_CRD_TYPE:
          switch (getRefinedIntegerType(prop.getFormat())) {
            case INT32_CRD_TYPE:
              return fromJsonSchema.apply(JPrimitiveNameAndType.INTEGER);
            case INT64_CRD_TYPE:
            default:
              return fromJsonSchema.apply(JPrimitiveNameAndType.LONG);
          }
        case NUMBER_CRD_TYPE:
          switch (getRefinedNumberType(prop.getFormat())) {
            case FLOAT_CRD_TYPE:
              return fromJsonSchema.apply(JPrimitiveNameAndType.FLOAT);
            case DOUBLE_CRD_TYPE:
            default:
              return fromJsonSchema.apply(JPrimitiveNameAndType.DOUBLE);
          }
        case STRING_CRD_TYPE:
          switch (getRefinedStringType(prop.getFormat())) {
            case DATETIME_CRD_TYPE:
              return fromJsonSchema.apply(JPrimitiveNameAndType.DATETIME);
            case STRING_CRD_TYPE:
            default:
              return fromJsonSchema.apply(JPrimitiveNameAndType.STRING);
          }
        case OBJECT_CRD_TYPE:
          if (prop.getAdditionalProperties() != null && prop.getAdditionalProperties().getSchema() != null) {
            return fromJsonSchema.apply(new JMapNameAndType(key));
          } else if (prop.getAdditionalProperties() != null
              && Boolean.TRUE.equals(prop.getAdditionalProperties().getAllows())) {
            return fromJsonSchema.apply(JPrimitiveNameAndType.ANY_TYPE);
          } else {
            return fromJsonSchema.apply(new JObjectNameAndType(key));
          }
        case ARRAY_CRD_TYPE:
          return fromJsonSchema.apply(new JArrayNameAndType(key));
        default:
          throw new JavaGeneratorException("Unmanaged type " + prop.getType());
      }
    }
  }

  private static AbstractJSONSchema2Pojo fromJsonSchema(
      String key,
      JavaNameAndType nt,
      JSONSchemaProps prop,
      String parentPkg,
      Config config) {
    final boolean isNullable = Boolean.TRUE.equals(prop.getNullable());
    switch (nt.getType()) {
      case PRIMITIVE:
        return new JPrimitive(
            nt.getName(),
            config,
            prop.getDescription(),
            isNullable,
            prop.getDefault(),
            ValidationProperties.Builder.getInstance()
                .withMaximum(prop.getMaximum())
                .withMinimum(prop.getMinimum())
                .withPattern(prop.getPattern())
                .build());
      case ARRAY:
        return new JArray(
            fromJsonSchema(
                key,
                prop.getItems().getSchema(),
                parentPkg,
                config),
            config,
            prop.getDescription(),
            isNullable,
            prop.getDefault());
      case MAP:
        return new JMap(
            fromJsonSchema(
                key,
                prop.getAdditionalProperties().getSchema(),
                parentPkg,
                config),
            config,
            prop.getDescription(),
            isNullable,
            prop.getDefault());
      case OBJECT:
        final boolean preserveUnknownFields = Boolean.TRUE.equals(prop.getXKubernetesPreserveUnknownFields());
        return new JObject(
            parentPkg,
            key,
            prop.getProperties(),
            prop.getRequired(),
            preserveUnknownFields,
            config,
            prop.getDescription(),
            isNullable,
            prop.getDefault());
      case ENUM:
        String enumType = JAVA_LANG_STRING;
        switch (prop.getType()) {
          case INTEGER_CRD_TYPE:
            switch (getRefinedIntegerType(prop.getFormat())) {
              case INT32_CRD_TYPE:
                enumType = JAVA_LANG_INTEGER;
                break;
              case INT64_CRD_TYPE:
              default:
                enumType = JAVA_LANG_LONG;
                break;
            }
            break;
          case STRING_CRD_TYPE:
            break;
          default:
            throw new JavaGeneratorException("Unsupported enumeration type/format" + prop.getType() + "/" + prop.getFormat());
        }
        return new JEnum(
            key,
            enumType,
            prop.getEnum(),
            config,
            prop.getDescription(),
            isNullable,
            prop.getDefault());
      default:
        throw new JavaGeneratorException("Unreachable " + nt.getType());
    }
  }
}
