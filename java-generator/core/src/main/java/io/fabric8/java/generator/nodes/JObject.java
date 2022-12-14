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
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
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

public class JObject extends AbstractJSONSchema2Pojo implements JObjectExtraAnnotations {

  private final String type;
  private final String className;
  private final String pkg;
  private final Map<String, AbstractJSONSchema2Pojo> fields;
  private final Set<String> required;

  private final boolean preserveUnknownFields;

  public JObject(
      String pkg,
      String type,
      Map<String, JSONSchemaProps> fields,
      List<String> required,
      boolean preserveUnknownFields,
      String classPrefix,
      String classSuffix,
      Config config,
      String description,
      final boolean isNullable, JsonNode defaultValue) {
    super(config, description, isNullable, defaultValue, null);
    this.required = new HashSet<>(Optional.ofNullable(required).orElse(Collections.emptyList()));
    this.fields = new HashMap<>();
    this.preserveUnknownFields = preserveUnknownFields;

    this.pkg = (pkg == null) ? "" : pkg.trim();
    String pkgPrefix = (this.pkg.isEmpty()) ? this.pkg : this.pkg + ".";
    String clazzPrefix = (classPrefix == null) ? "" : classPrefix.trim();
    String clazzSuffix = (classSuffix == null
        || type.toLowerCase(Locale.ROOT)
            .endsWith(classSuffix.toLowerCase(Locale.ROOT)))
                ? ""
                : classSuffix.trim();
    String upperCasedClassName = type.substring(0, 1).toUpperCase() + type.substring(1);
    this.className = AbstractJSONSchema2Pojo.sanitizeString(
        clazzPrefix + upperCasedClassName + clazzSuffix);
    this.type = pkgPrefix + this.className;

    if (fields == null) {
      // no fields
    } else {
      String nextPackagePath = null;
      switch (config.getCodeStructure()) {
        case FLAT:
          nextPackagePath = this.pkg;
          break;
        case PACKAGE_NESTED:
          nextPackagePath = pkgPrefix + AbstractJSONSchema2Pojo.packageName(this.className);
          break;
      }

      for (Map.Entry<String, JSONSchemaProps> field : fields.entrySet()) {
        String nextPrefix = (config.getPrefixStrategy() == Config.Prefix.ALWAYS) ? classPrefix : "";
        String nextSuffix = (config.getSuffixStrategy() == Config.Suffix.ALWAYS) ? classSuffix : "";
        this.fields.put(
            field.getKey(),
            AbstractJSONSchema2Pojo.fromJsonSchema(
                field.getKey(),
                field.getValue(),
                nextPackagePath,
                nextPrefix,
                nextSuffix,
                config));
      }
    }
  }

  @Override
  public String getType() {
    return this.type;
  }

  private String getSortedFieldsAsParam(Set<String> list) {
    List<String> sortedFields = list.stream().sorted().collect(Collectors.toList());
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
      cu.setPackageDeclaration(this.pkg);
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
      clz.addAnnotation(GENERATED_ANNOTATION);
    }
    if (config.isObjectExtraAnnotations()) {
      addExtraAnnotations(clz);
    }

    clz.addImplementedType("io.fabric8.kubernetes.api.model.KubernetesResource");

    List<GeneratorResult.ClassResult> buffer = new ArrayList<>(this.fields.size() + 1);

    List<String> sortedKeys = this.fields.keySet().stream().sorted().collect(Collectors.toList());
    for (String k : sortedKeys) {
      AbstractJSONSchema2Pojo prop = this.fields.get(k);
      boolean isRequired = this.required.contains(k);

      GeneratorResult gr = prop.generateJava();

      // For now the inner types are only for enums
      boolean isEnum = !gr.getInnerClasses().isEmpty();
      if (isEnum) {
        for (GeneratorResult.ClassResult enumCR : gr.getInnerClasses()) {
          Optional<EnumDeclaration> ed = enumCR.getCompilationUnit().getEnumByName(enumCR.getName());
          if (ed.isPresent()) {
            clz.addMember(ed.get());
          }
        }
      }
      buffer.addAll(gr.getTopLevelClasses());

      String originalFieldName = k;
      String fieldName = AbstractJSONSchema2Pojo.sanitizeString(k);
      String fieldType = prop.getType();

      try {
        FieldDeclaration objField = clz.addField(fieldType, fieldName, Modifier.Keyword.PRIVATE);
        objField.addAnnotation(
            new SingleMemberAnnotationExpr(
                new Name("com.fasterxml.jackson.annotation.JsonProperty"),
                new StringLiteralExpr(originalFieldName)));

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
          objField.setJavadocComment(prop.getDescription());

          objField.addAnnotation(
              new SingleMemberAnnotationExpr(
                  new Name(
                      "com.fasterxml.jackson.annotation.JsonPropertyDescription"),
                  new StringLiteralExpr(
                      prop.getDescription().replace("\"", "\\\""))));
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
          objField.addAnnotation("io.fabric8.generator.annotation.Nullable");
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
      } catch (Exception cause) {
        throw new JavaGeneratorException(
            "Error generating field " + fieldName + " with type " + prop.getType(),
            cause);
      }
    }

    if (this.preserveUnknownFields || config.isAlwaysPreserveUnknownFields()) {
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

      objField.addAnnotation("com.fasterxml.jackson.annotation.JsonIgnore");

      objField.createGetter().addAnnotation("com.fasterxml.jackson.annotation.JsonAnyGetter");
      objField.createSetter().addAnnotation("com.fasterxml.jackson.annotation.JsonAnySetter");

      MethodDeclaration additionalSetter = clz.addMethod("setAdditionalProperty", Modifier.Keyword.PUBLIC);
      additionalSetter.addAnnotation("com.fasterxml.jackson.annotation.JsonAnySetter");
      additionalSetter.addParameter("String", "key");
      additionalSetter.addParameter("Object", "value");
      additionalSetter
          .setBody(new BlockStmt().addStatement(new NameExpr("this." + Keywords.ADDITIONAL_PROPERTIES + ".put(key, value);")));
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
      } else {
        return new NameExpr(value);
      }
    } else {
      return null;
    }
  }
}
