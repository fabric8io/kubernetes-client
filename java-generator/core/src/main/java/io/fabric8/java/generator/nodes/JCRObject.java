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

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import java.util.Collections;

public class JCRObject extends AbstractJSONSchema2Pojo {

    private final String type;
    private final String group;
    private final String version;
    private final boolean withSpec;
    private final boolean withStatus;

    private final boolean storage;
    private final boolean served;

    public JCRObject(
            String type,
            String group,
            String version,
            boolean withSpec,
            boolean withStatus,
            boolean storage,
            boolean served) {
        this.type = type;
        this.group = group;
        this.version = version;
        this.withSpec = withSpec;
        this.withStatus = withStatus;
        this.storage = storage;
        this.served = served;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public GeneratorResult generateJava(CompilationUnit cu) {
        ClassOrInterfaceDeclaration clz =
                cu.getClassByName(this.type).orElse(cu.addClass(this.type));

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

        ClassOrInterfaceType spec = new ClassOrInterfaceType().setName(this.type + "Spec");
        if (!withSpec) {
            spec = new ClassOrInterfaceType().setName("java.lang.Void");
        }

        ClassOrInterfaceType status = new ClassOrInterfaceType().setName(this.type + "Status");
        if (!withStatus) {
            status = new ClassOrInterfaceType().setName("java.lang.Void");
        }

        ClassOrInterfaceType crType =
                new ClassOrInterfaceType()
                        .setName("io.fabric8.kubernetes.client.CustomResource")
                        .setTypeArguments(spec, status);

        clz.addExtendedType(crType);
        clz.addImplementedType("io.fabric8.kubernetes.api.model.Namespaced");

        return new GeneratorResult(Collections.singletonList(getType()));
    }
}
