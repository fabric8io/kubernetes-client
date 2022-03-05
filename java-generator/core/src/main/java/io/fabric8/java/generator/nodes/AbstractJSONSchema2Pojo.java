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
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.Statement;
import io.fabric8.java.generator.Config;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;

import static io.fabric8.java.generator.nodes.Keywords.JAVA_KEYWORDS;

public abstract class AbstractJSONSchema2Pojo {

  static final String BOOLEAN_CRD_TYPE = "boolean";
  static final String INTEGER_CRD_TYPE = "integer";
  static final String INT32_CRD_TYPE = "int32";
  static final String INT64_CRD_TYPE = "int64";
  static final String NUMBER_CRD_TYPE = "number";
  static final String FLOAT_CRD_TYPE = "float";
  static final String DOUBLE_CRD_TYPE = "double";
  static final String STRING_CRD_TYPE = "string";
  static final String OBJECT_CRD_TYPE = "object";
  static final String ARRAY_CRD_TYPE = "array";

  protected final String description;
  protected final Config config;
  protected final boolean isNullable;
  protected boolean skipDefault;

  public abstract String getType();

  public abstract GeneratorResult generateJava();

  /** Takes a string and return the corresponding package name */
  public static String packageName(String str) {
    return str.toLowerCase(Locale.ROOT);
  }

  public String getDescription() {
    return description;
  }

  protected AbstractJSONSchema2Pojo(Config config, String description, final boolean isNullable) {
    this.config = config;
    this.description = description;
    this.isNullable = isNullable;
    this.skipDefault = Boolean.FALSE;
  }

  /** Takes a random string and manipulate it to be a valid Java identifier */
  public static String sanitizeString(String str) {
    str = str.trim();
    String sanitized = "";
    if (JAVA_KEYWORDS.contains(str)) {
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

    return sanitized;
  }

  public static AbstractJSONSchema2Pojo fromJsonSchema(
      String key,
      JSONSchemaProps prop,
      String parentPkg,
      String classPrefix,
      String classSuffix,
      Config config) {
    Function<JavaNameAndType, AbstractJSONSchema2Pojo> fromJsonSchema = javaNameAndType -> fromJsonSchema(
        key,
        javaNameAndType,
        prop,
        parentPkg,
        classPrefix,
        classSuffix,
        config);
    String type = prop.getType();
    if (Boolean.TRUE.equals(prop.getXKubernetesIntOrString())) {
      return fromJsonSchema.apply(JPrimitiveNameAndType.INT_OR_STRING);
    } else if (type == null
        && Boolean.TRUE.equals(prop.getXKubernetesPreserveUnknownFields())) {
      return fromJsonSchema.apply(new JObjectNameAndType(key));
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
          String intFormat = prop.getFormat();
          if (intFormat == null)
            intFormat = INT64_CRD_TYPE;

          switch (intFormat) {
            case INT32_CRD_TYPE:
              return fromJsonSchema.apply(JPrimitiveNameAndType.INTEGER);
            case INT64_CRD_TYPE:
            default:
              return fromJsonSchema.apply(JPrimitiveNameAndType.LONG);
          }
        case NUMBER_CRD_TYPE:
          String numberFormat = prop.getFormat();
          if (numberFormat == null)
            numberFormat = DOUBLE_CRD_TYPE;

          switch (numberFormat) {
            case FLOAT_CRD_TYPE:
              return fromJsonSchema.apply(JPrimitiveNameAndType.FLOAT);
            case DOUBLE_CRD_TYPE:
            default:
              return fromJsonSchema.apply(JPrimitiveNameAndType.DOUBLE);
          }
        case STRING_CRD_TYPE:
          return fromJsonSchema.apply(JPrimitiveNameAndType.STRING);
        case OBJECT_CRD_TYPE:
          if (prop.getAdditionalProperties() != null
              && prop.getAdditionalProperties().getSchema() != null) {
            return fromJsonSchema.apply(new JMapNameAndType(key));
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
      String classPrefix,
      String classSuffix,
      Config config) {
    final boolean isNullable = Boolean.TRUE.equals(prop.getNullable());
    switch (nt.getType()) {
      case PRIMITIVE:
        return new JPrimitive(nt.getName(), config, prop.getDescription(), isNullable);
      case ARRAY:
        return new JArray(
            fromJsonSchema(
                key,
                prop.getItems().getSchema(),
                parentPkg,
                classPrefix,
                classSuffix,
                config),
            config,
            prop.getDescription(),
            isNullable);
      case MAP:
        return new JMap(
            fromJsonSchema(
                key,
                prop.getAdditionalProperties().getSchema(),
                parentPkg,
                classPrefix,
                classSuffix,
                config),
            config,
            prop.getDescription(),
            isNullable);
      case OBJECT:
        boolean preserveUnknownFields = Boolean.TRUE.equals(prop.getXKubernetesPreserveUnknownFields());
        return new JObject(
            parentPkg,
            key,
            prop.getProperties(),
            prop.getRequired(),
            preserveUnknownFields,
            classPrefix,
            classSuffix,
            config,
            prop.getDescription(),
            isNullable);
      case ENUM:
        return new JEnum(key, prop.getEnum(), config, prop.getDescription(), isNullable);
      default:
        throw new JavaGeneratorException("Unreachable " + nt.getType());
    }
  }

  /**
   * Part of the default value generation APIs, this method is responsible for creating a block statement that
   * represents the body of a default value initialization method.
   * 
   * @param defaultValue The {@link JsonNode} instance holding the actual default value
   * @return a {@link BlockStmt} instance that contains all the statements that code the default value initialization.
   */
  protected BlockStmt generateDefaultInitializerBody(JsonNode defaultValue) {
    BlockStmt body = new BlockStmt();
    final String scope = "tmp";
    // init local variable
    body.addStatement(new ExpressionStmt(
        new NameExpr(this.getType() + " " + scope + " = " + this.generateDefaultInstance(defaultValue))));
    // expand generation
    this.expandDefaultInstance(scope, defaultValue).stream().forEach(s -> body.addStatement(s));
    // return local variable
    body.addStatement(new ReturnStmt(scope));
    return body;
  }

  /**
   * Part of the default value generation APIs, this method actually generates the expression that will be used as the
   * default value <i>instance</i>, i.e. a constant for primitive values, or a call to a class constructor for complex
   * values.
   *
   * @param defaultValue The {@link JsonNode} instance holding the actual default value
   * @return An {@link Expression} instance that can be used to {@code set} a default value to a POJO field
   */
  protected abstract Expression generateDefaultInstance(JsonNode defaultValue);

  /**
   * Part of the default value generation APIs, this method expands the <i>complex</i> types default value generation
   * by returning a list of statements that fill the default instance properties with values.
   *
   * @param scope A string that represents the scope for setting a default value, e.g.: in
   *        {@code obj.getChild().setProp()}, {@code obj.getChild} is the scope
   * @param defaultValue The {@link JsonNode} instance holding the actual default value
   * @return A list of {@link Statement} instances that will be added to the default generation method.
   */
  protected abstract List<Statement> expandDefaultInstance(String scope, JsonNode defaultValue);
}
