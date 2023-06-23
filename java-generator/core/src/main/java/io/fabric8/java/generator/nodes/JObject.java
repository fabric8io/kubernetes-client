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
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.utils.StringEscapeUtils;
import io.fabric8.java.generator.Config;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

import static io.fabric8.java.generator.nodes.JPrimitiveNameAndType.DATETIME_NAME;

public class JObject extends AbstractJSONSchema2Pojo implements JObjectExtraAnnotations {

  public static final String DEPRECATED_FIELD_MARKER = "deprecated";
  private final String type;
  private final String className;
  private final String pkg;
  private final Map<String, AbstractJSONSchema2Pojo> fields;
  private final Set<String> required;
  private final Set<String> deprecated = new HashSet<>();

  private final boolean preserveUnknownFields;

  public JObject(
      String pkg,
      String type,
      Map<String, JSONSchemaProps> fields,
      List<String> required,
      boolean preserveUnknownFields,
      Config config,
      String description,
      final boolean isNullable,
      JsonNode defaultValue) {
    super(config, description, isNullable, defaultValue, null);
    this.required = new HashSet<>(Optional.ofNullable(required).orElse(Collections.emptyList()));
    this.fields = new HashMap<>();
    this.preserveUnknownFields = preserveUnknownFields;

    this.pkg = (pkg == null) ? "" : pkg.trim();
    String pkgPrefix = (this.pkg.isEmpty()) ? this.pkg : this.pkg + ".";
    String upperCasedClassName = type.substring(0, 1).toUpperCase() + type.substring(1);
    this.className = AbstractJSONSchema2Pojo.sanitizeString(upperCasedClassName);
    this.type = pkgPrefix + this.className;

    if (fields == null) {
      // no fields
    } else {
      String nextPackagePath = pkgPrefix + AbstractJSONSchema2Pojo.packageName(this.className);

      // in order to handle duplicated fields, first let's build a map of fields grouped by their sanitized names, i.e.:
      // 1(fieldName) -> n(fieldDefinition(key, props))
      final Map<String, Map<String, JSONSchemaProps>> groupedFieldDefinitions = fields.entrySet().stream()
          .collect(Collectors.groupingBy(
              f -> AbstractJSONSchema2Pojo.sanitizeString(f.getKey()),
              Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

      for (Map.Entry<String, JSONSchemaProps> field : fields.entrySet()) {
        String fieldKey = field.getKey();
        // lookup the duplicated field properties map
        final Map<String, JSONSchemaProps> fieldDuplicatesDefinition = groupedFieldDefinitions
            .get(AbstractJSONSchema2Pojo.sanitizeString(field.getKey()));
        final int duplicatesCount = fieldDuplicatesDefinition.size();
        if (duplicatesCount > 1) {
          // ok, duplicates exist...
          // we want to throw an exception on some duplicates missing requirements. the first one that we enforce is
          // for exactly 1 field duplicate to exist
          if (duplicatesCount > 2) {
            throw new JavaGeneratorException(
                String.format("The %s field has %d duplicates, which is not a supported configuration",
                    field.getKey(),
                    duplicatesCount - 1));
          }
          // another requirement that we enforce is that if one field duplicate exists, then it's because it has
          // been marked as deprecated
          final boolean deprecatedDuplicatesExist = fieldDuplicatesDefinition.entrySet().stream()
              .anyMatch(d -> d.getValue().getDescription().trim().toLowerCase().startsWith(DEPRECATED_FIELD_MARKER));
          if (!deprecatedDuplicatesExist) {
            throw new JavaGeneratorException(
                String.format(
                    "The %s field has a duplicate, but it's not marked as deprecated, which is not a supported configuration",
                    field.getKey()));
          }
          // let's mangle the deprecated duplicated field name
          if (field.getValue().getDescription().trim().toLowerCase().startsWith(DEPRECATED_FIELD_MARKER)) {
            fieldKey += "-deprecated";
            this.deprecated.add(fieldKey);
          }
        }
        // and finally add the field definition
        this.fields.put(
            fieldKey,
            AbstractJSONSchema2Pojo.fromJsonSchema(
                fieldKey,
                field.getValue(),
                nextPackagePath,
                config));
      }
    }
  }

  @Override
  public String getType() {
    return this.type;
  }

  private String getSortedFieldsAsParam(Set<String> list) {
    List<String> sortedFields = list.stream().map(AbstractJSONSchema2Pojo::escapeQuotes).sorted().collect(Collectors.toList());

    StringBuilder sb = new StringBuilder();
    sb.append("{");
    while (!sortedFields.isEmpty()) {
      sb.append("\"" + sortedFields.remove(0) + "\"");
      if (!sortedFields.isEmpty()) {
        sb.append(",");
      }
    }
    sb.append("}");
    return sb.toString();
  }

  @Override
  public GeneratorResult generateJava() {
    CompilationUnit cu = new CompilationUnit();
    if (!this.pkg.isEmpty()) {
      cu.setPackageDeclaration(new PackageDeclaration(new Name(this.pkg)));
    }
    ClassOrInterfaceDeclaration clz = cu.addClass(this.className);

    clz.addAnnotation(
        new SingleMemberAnnotationExpr(
            new Name("com.fasterxml.jackson.annotation.JsonInclude"),
            new NameExpr(
                "com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL")));

    clz.addAnnotation(
        new SingleMemberAnnotationExpr(
            new Name("com.fasterxml.jackson.annotation.JsonPropertyOrder"),
            new NameExpr(getSortedFieldsAsParam(this.fields.keySet()))));

    clz.addAnnotation(
        new SingleMemberAnnotationExpr(
            new Name("com.fasterxml.jackson.databind.annotation.JsonDeserialize"),
            new NameExpr(
                "using = com.fasterxml.jackson.databind.JsonDeserializer.None.class")));

    if (config.isGeneratedAnnotations()) {
      clz.addAnnotation(newGeneratedAnnotation());
    }
    if (config.isObjectExtraAnnotations()) {
      addExtraAnnotations(clz);
    }

    clz.addImplementedType(new ClassOrInterfaceType(null, "io.fabric8.kubernetes.api.model.KubernetesResource"));

    List<GeneratorResult.ClassResult> buffer = new ArrayList<>(this.fields.size() + 1);

    List<String> sortedKeys = this.fields.keySet().stream().sorted().collect(Collectors.toList());
    for (String k : sortedKeys) {
      AbstractJSONSchema2Pojo prop = this.fields.get(k);
      boolean isRequired = this.required.contains(k);
      boolean isDeprecated = this.deprecated.contains(k);

      GeneratorResult gr = prop.generateJava();

      // For now the inner types are only for enums
      boolean isEnum = !gr.getInnerClasses().isEmpty();
      if (isEnum) {
        for (GeneratorResult.ClassResult enumCR : gr.getInnerClasses()) {
          Optional<EnumDeclaration> ed = enumCR.getEnumByName(enumCR.getName());
          if (ed.isPresent()) {
            clz.addMember(ed.get());
          }
        }
      }
      buffer.addAll(gr.getTopLevelClasses());

      String originalFieldName = AbstractJSONSchema2Pojo.escapeQuotes(k);
      String fieldName = AbstractJSONSchema2Pojo.sanitizeString(k);
      String fieldType = prop.getType();

      try {
        FieldDeclaration objField = clz.addField(toClassOrInterfaceType(fieldType), fieldName, Modifier.Keyword.PRIVATE);
        objField.addAnnotation(
            new SingleMemberAnnotationExpr(
                new Name("com.fasterxml.jackson.annotation.JsonProperty"),
                new StringLiteralExpr(originalFieldName)));

        if (prop.getClassType().equals(DATETIME_NAME)) {
          objField.addAnnotation(new SingleMemberAnnotationExpr(
              new Name("com.fasterxml.jackson.annotation.JsonFormat"),
              new NameExpr("timezone = \"UTC\", pattern = \"" + DATETIME_FORMAT + "\"")));
        }

        if (isRequired) {
          objField.addAnnotation("io.fabric8.generator.annotation.Required");
        }
        if (prop.getMaximum() != null) {
          objField.addAnnotation(
              new SingleMemberAnnotationExpr(
                  new Name("io.fabric8.generator.annotation.Max"),
                  new DoubleLiteralExpr(prop.getMaximum())));
        }
        if (prop.getMinimum() != null) {
          objField.addAnnotation(
              new SingleMemberAnnotationExpr(
                  new Name("io.fabric8.generator.annotation.Min"),
                  new DoubleLiteralExpr(prop.getMinimum())));
        }
        if (prop.getPattern() != null) {
          objField.addAnnotation(
              new SingleMemberAnnotationExpr(
                  new Name("io.fabric8.generator.annotation.Pattern"),
                  new StringLiteralExpr(StringEscapeUtils.escapeJava(prop.getPattern()))));
        }

        objField.createGetter();
        objField.createSetter();

        if (Utils.isNotNullOrEmpty(prop.getDescription())) {
          objField.setJavadocComment(prop.getDescription().replace("*/", "&#042;&#047;"));

          objField.addAnnotation(
              new SingleMemberAnnotationExpr(
                  new Name(
                      "com.fasterxml.jackson.annotation.JsonPropertyDescription"),
                  new StringLiteralExpr(
                      StringEscapeUtils.escapeJava(prop.getDescription()))));
        }

        if (!prop.isNullable) {
          // from https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#defaulting-and-nullable :
          // "_null values for fields that either don't specify the nullable flag, or give it a false
          // value, will be pruned before defaulting happens. If a default is present, it will be applied_"
          objField.addAnnotation(
              new SingleMemberAnnotationExpr(
                  new Name("com.fasterxml.jackson.annotation.JsonSetter"),
                  new NameExpr("nulls = com.fasterxml.jackson.annotation.Nulls.SKIP")));
        } else {
          // from https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#defaulting-and-nullable :
          // "... _When nullable is true, null values will be conserved..._"
          objField.addAnnotation(
              new SingleMemberAnnotationExpr(
                  new Name("com.fasterxml.jackson.annotation.JsonSetter"),
                  new NameExpr("nulls = com.fasterxml.jackson.annotation.Nulls.SET")));
          objField
              .addAnnotation(new NormalAnnotationExpr(new Name("io.fabric8.generator.annotation.Nullable"), new NodeList<>()));
        }

        if (prop.getDefaultValue() != null) {
          Expression primitiveDefault = (isEnum) ? null : generatePrimitiveDefaultInitializerExpression(prop);

          if (primitiveDefault != null) {
            objField.getVariable(0).setInitializer(primitiveDefault);
          } else {
            objField.getVariable(0).setInitializer(
                new NameExpr(
                    "io.fabric8.kubernetes.client.utils.Serialization.unmarshal("
                        + "\"" + StringEscapeUtils.escapeJava(Serialization.asJson(prop.getDefaultValue())) + "\""
                        + ", "
                        + prop.getClassType() + ".class"
                        + ")"));
          }
        }

        if (isDeprecated) {
          objField.addAnnotation("java.lang.Deprecated");
        }
      } catch (Exception cause) {
        throw new JavaGeneratorException(
            "Error generating field " + fieldName + " with type " + prop.getType(),
            cause);
      }
    }

    if (this.preserveUnknownFields) {
      ClassOrInterfaceType mapType = new ClassOrInterfaceType()
          .setName(Keywords.JAVA_UTIL_MAP)
          .setTypeArguments(
              new ClassOrInterfaceType().setName("String"),
              new ClassOrInterfaceType().setName("Object"));
      FieldDeclaration objField = clz.addField(mapType, Keywords.ADDITIONAL_PROPERTIES, Modifier.Keyword.PRIVATE);
      objField.setVariables(
          new NodeList<>(
              new VariableDeclarator()
                  .setName(Keywords.ADDITIONAL_PROPERTIES)
                  .setType(mapType)
                  .setInitializer("new java.util.HashMap<>()")));

      objField
          .addAnnotation(new NormalAnnotationExpr(new Name("com.fasterxml.jackson.annotation.JsonIgnore"), new NodeList<>()));

      objField.createGetter().addAnnotation(
          new NormalAnnotationExpr(new Name("com.fasterxml.jackson.annotation.JsonAnyGetter"), new NodeList<>()));
      objField.createSetter().addAnnotation(
          new NormalAnnotationExpr(new Name("com.fasterxml.jackson.annotation.JsonAnySetter"), new NodeList<>()));

      MethodDeclaration additionalSetter = clz.addMethod("setAdditionalProperty", Modifier.Keyword.PUBLIC);
      additionalSetter.addAnnotation(
          new NormalAnnotationExpr(new Name("com.fasterxml.jackson.annotation.JsonAnySetter"), new NodeList<>()));
      additionalSetter.addParameter(new ClassOrInterfaceType(null, "java.lang.String"), "key");
      additionalSetter.addParameter(new ClassOrInterfaceType(null, "java.lang.Object"), "value");
      additionalSetter
          .setBody(new BlockStmt().addStatement(new NameExpr("this." + Keywords.ADDITIONAL_PROPERTIES + ".put(key, value)")));
    }

    buffer.add(new GeneratorResult.ClassResult(this.className, cu));

    return new GeneratorResult(buffer);
  }

  /**
   * This method is responsible for creating an expression that will initialize the default value if primitive
   *
   * @return a {@link Expression} instance that contains a call to the
   *         {@link Serialization#unmarshal(String, Class)} method.
   */
  private Expression generatePrimitiveDefaultInitializerExpression(AbstractJSONSchema2Pojo prop) {
    if (prop.getDefaultValue().isValueNode()) {
      String value = prop.getDefaultValue().toString();
      if (prop.getClassType().equals("Long") && prop.getDefaultValue().canConvertToLong()) {
        return new LongLiteralExpr(value + "L");
      } else if (prop.getClassType().equals("Float") && prop.getDefaultValue().isFloatingPointNumber()) {
        return new DoubleLiteralExpr(value + "f");
      } else if (prop.getClassType().equals("Boolean") && prop.getDefaultValue().isBoolean()) {
        return new BooleanLiteralExpr(prop.getDefaultValue().booleanValue());
      } else if (prop.getClassType().equals(DATETIME_NAME) && prop.getDefaultValue().isTextual()) {
        return new NameExpr(DATETIME_NAME + ".parse(" + prop.getDefaultValue()
            + ", java.time.format.DateTimeFormatter.ofPattern(\"" + DATETIME_FORMAT + "\"))");
      } else {
        return new NameExpr(value);
      }
    } else {
      return null;
    }
  }

  static ClassOrInterfaceType toClassOrInterfaceType(String className) {
    String withoutDollars = className.replace("$", "."); // nested class in Java cannot be used in casts
    return withoutDollars.indexOf('<') >= 0 ? StaticJavaParser.parseClassOrInterfaceType(withoutDollars)
        : new ClassOrInterfaceType(null, withoutDollars);
  }
}
