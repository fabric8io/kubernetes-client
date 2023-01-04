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
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import io.fabric8.java.generator.Config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static io.fabric8.java.generator.nodes.Keywords.JAVA_LANG_STRING;

public class JEnum extends AbstractJSONSchema2Pojo {

  private static final String VALUE = "value";

  private final String type;
  // TODO: handle number enum
  private final List<String> values;

  public JEnum(String type, List<JsonNode> values, Config config, String description, final boolean isNullable,
      JsonNode defaultValue) {
    super(config, description, isNullable, defaultValue, null);
    this.type = AbstractJSONSchema2Pojo.sanitizeString(
        type.substring(0, 1).toUpperCase() + type.substring(1));
    this.values = values.stream().map(JsonNode::asText).collect(Collectors.toList());
  }

  @Override
  public String getType() {
    return this.type;
  }

  private String sanitizeEnumEntry(final String str) {
    String ret = str;
    if (config.isUppercaseEnums()) {
      ret = ret.toUpperCase(Locale.ROOT);
    }
    if (ret.isEmpty()) {
      return "_EMPTY";
    } else {
      return ret.replaceAll("[\\s|\\./]", "_");
    }
  }

  @Override
  public GeneratorResult generateJava() {
    CompilationUnit cu = new CompilationUnit();
    EnumDeclaration en = cu.addEnum(this.type);

    en.addField(JAVA_LANG_STRING, VALUE);
    ConstructorDeclaration cd = en.addConstructor();
    cd.addParameter(JAVA_LANG_STRING, VALUE);
    cd.createBody();

    cd.setBody(
        new BlockStmt()
            .addStatement(
                new AssignExpr(
                    new NameExpr("this." + VALUE),
                    new NameExpr(VALUE),
                    AssignExpr.Operator.ASSIGN)));

    MethodDeclaration getValue = en
        .addMethod("getValue", Modifier.Keyword.PUBLIC);
    getValue.setType(JAVA_LANG_STRING);
    getValue
        .setBody(new BlockStmt().addStatement(new ReturnStmt(VALUE)));
    getValue.addAnnotation("com.fasterxml.jackson.annotation.JsonValue");

    for (String k : this.values) {
      String constantName;
      try {
        // If the value can be parsed as an Integer
        Integer.valueOf(k);
        // Prepend
        constantName = "V_" + sanitizeEnumEntry(sanitizeString(k));
      } catch (Exception e) {
        constantName = sanitizeEnumEntry(sanitizeString(k));
      }
      EnumConstantDeclaration decl = new EnumConstantDeclaration();
      decl.addAnnotation(
          new SingleMemberAnnotationExpr(
              new Name("com.fasterxml.jackson.annotation.JsonProperty"),
              new StringLiteralExpr(k)));
      decl.setName(constantName);
      decl.addArgument(new StringLiteralExpr(k));
      en.addEntry(decl);
    }

    return new GeneratorResult(
        new ArrayList<>(),
        Collections.singletonList(new GeneratorResult.ClassResult(this.type, cu)));
  }
}
