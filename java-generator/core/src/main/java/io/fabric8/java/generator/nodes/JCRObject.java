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
package io.fabric8.java.generator.nodes;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.expr.SuperExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import io.fabric8.java.generator.Config;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JCRObject extends JObject implements JObjectExtraAnnotations {

  private final String group;
  private final String version;
  private final String scope;
  private final String singular;
  private final String plural;

  private final boolean storage;
  private final boolean served;

  public JCRObject(
      String pkg,
      String type,
      String group,
      String version,
      String scope,
      Map<String, JSONSchemaProps> toplevelProps,
      List<String> required,
      boolean preserveUnknownFields,
      String description,
      boolean storage,
      boolean served,
      String singular,
      String plural,
      Config config) {
    super(pkg, type, toplevelProps, required, preserveUnknownFields, config, description, false, null);
    this.group = group;
    this.version = version;
    this.scope = scope;
    this.storage = storage;
    this.served = served;
    this.singular = singular;
    this.plural = plural;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public GeneratorResult generateJava() {
    CompilationUnit cu = new CompilationUnit();
    if (!pkg.isEmpty()) {
      cu.setPackageDeclaration(new PackageDeclaration(new Name(pkg)));
    }
    ClassOrInterfaceDeclaration clz = cu.addClass(className);

    clz.addAnnotation(
        new SingleMemberAnnotationExpr(
            new Name("io.fabric8.kubernetes.model.annotation.Version"),
            new NameExpr(
                "value = \""
                    + version
                    + "\" , storage = "
                    + storage
                    + " , served = "
                    + served)));
    clz.addAnnotation(
        new SingleMemberAnnotationExpr(
            new Name("io.fabric8.kubernetes.model.annotation.Group"),
            new StringLiteralExpr(group)));

    if (singular != null) {
      clz.addAnnotation(
          new SingleMemberAnnotationExpr(
              new Name("io.fabric8.kubernetes.model.annotation.Singular"),
              new StringLiteralExpr(singular)));
    }

    if (plural != null) {
      clz.addAnnotation(
          new SingleMemberAnnotationExpr(
              new Name("io.fabric8.kubernetes.model.annotation.Plural"),
              new StringLiteralExpr(plural)));
    }

    ClassOrInterfaceType jlVoid = new ClassOrInterfaceType().setName("java.lang.Void");

    ClassOrInterfaceType spec = (fields.containsKey("spec"))
        ? new ClassOrInterfaceType().setName(type + "Spec")
        : jlVoid;
    fields.remove("spec");
    if (required.contains("spec")) {
      clz.addMethod("getSpec", Modifier.Keyword.PUBLIC)
          .setType(spec)
          .setBody(new BlockStmt().addStatement(new ReturnStmt(new MethodCallExpr(new SuperExpr(), "getSpec"))))
          .addAnnotation(new NormalAnnotationExpr(new Name("java.lang.Override"), new NodeList<>()))
          .addAnnotation(new NormalAnnotationExpr(new Name("io.fabric8.generator.annotation.Required"), new NodeList<>()));
    }

    ClassOrInterfaceType status = (fields.containsKey("status"))
        ? new ClassOrInterfaceType().setName(type + "Status")
        : jlVoid;
    fields.remove("status");
    if (required.contains("status")) {
      clz.addMethod("getStatus", Modifier.Keyword.PUBLIC)
          .setType(status)
          .setBody(new BlockStmt().addStatement(new ReturnStmt(new MethodCallExpr(new SuperExpr(), "getStatus"))))
          .addAnnotation(new NormalAnnotationExpr(new Name("java.lang.Override"), new NodeList<>()))
          .addAnnotation(new NormalAnnotationExpr(new Name("io.fabric8.generator.annotation.Required"), new NodeList<>()));
    }

    ClassOrInterfaceType crType = new ClassOrInterfaceType()
        .setName("io.fabric8.kubernetes.client.CustomResource")
        .setTypeArguments(spec, status);

    clz.addExtendedType(crType);

    if (scope.equals("Namespaced")) {
      clz.addImplementedType("io.fabric8.kubernetes.api.model.Namespaced");
    }

    if (config.isGeneratedAnnotations()) {
      clz.addAnnotation(newGeneratedAnnotation());
    }
    if (config.isObjectExtraAnnotations()) {
      addExtraAnnotations(clz);
    }

    List<GeneratorResult.ClassResult> buffer = generateJavaFields(clz);

    List<GeneratorResult.ClassResult> results = new ArrayList<>();
    results.add(new GeneratorResult.ClassResult(className, cu));
    results.addAll(buffer);
    return new GeneratorResult(
        Collections.unmodifiableList(results));
  }
}
