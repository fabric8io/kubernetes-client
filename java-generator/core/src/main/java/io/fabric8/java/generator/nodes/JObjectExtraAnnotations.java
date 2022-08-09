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

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;

public interface JObjectExtraAnnotations {

  default void addExtraAnnotations(ClassOrInterfaceDeclaration clz) {
    clz.addAnnotation("lombok.ToString");
    if (clz.getExtendedTypes().isEmpty()) {
      clz.addAnnotation("lombok.EqualsAndHashCode");
    } else {
      clz.addAnnotation(new SingleMemberAnnotationExpr(
          new Name("lombok.EqualsAndHashCode"),
          new NameExpr("callSuper = true")));
    }
    clz.addAnnotation("lombok.Setter");

    clz.addAnnotation(
        new SingleMemberAnnotationExpr(
            new Name("lombok.experimental.Accessors"),
            new NameExpr("prefix = {\n" + "    \"_\",\n" + "    \"\"\n" + "}")));

    clz.addAnnotation(
        new SingleMemberAnnotationExpr(
            new Name("io.sundr.builder.annotations.Buildable"),
            new NameExpr(
                "editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, builderPackage = \"io.fabric8.kubernetes.api.builder\", refs = {\n"
                    + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),\n"
                    + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),\n"
                    + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),\n"
                    + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.Container.class),\n"
                    + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.EnvVar.class),\n"
                    + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.ContainerPort.class),\n"
                    + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.Volume.class),\n"
                    + "    @io.sundr.builder.annotations.BuildableReference(io.fabric8.kubernetes.api.model.VolumeMount.class)\n"
                    + "}")));
  }
}
