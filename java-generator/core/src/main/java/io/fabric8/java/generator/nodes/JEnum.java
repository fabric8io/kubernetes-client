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

import static io.fabric8.java.generator.nodes.Keywords.JAVA_LANG_STRING;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JEnum extends AbstractJSONSchema2Pojo {

    private static final String VALUE = "value";

    private final String type;
    // TODO: handle number enum
    private final List<String> values;

    public JEnum(String type, List<JsonNode> values) {
        this.type =
                AbstractJSONSchema2Pojo.sanitizeString(
                        type.substring(0, 1).toUpperCase() + type.substring(1));
        this.values = values.stream().map(JsonNode::asText).collect(Collectors.toList());
    }

    @Override
    public String getType() {
        return this.type;
    }

    private String sanitizeEnumEntry(String str) {
        str = str.replace(" ", "_");
        str = str.replace("/", "_");
        return str;
    }

    @Override
    public GeneratorResult generateJava(CompilationUnit cu) {
        EnumDeclaration en = cu.getEnumByName(this.type).orElse(null);

        if (en == null) {
            en = cu.addEnum(this.type);

            boolean degraded = false;
            for (String k : this.values) {
                try {
                    Integer.valueOf(k);
                    degraded = true;
                } catch (Exception e) {
                    // Ignored
                }
            }

            if (!degraded) {
                for (String k : this.values) {
                    en.addEnumConstant(sanitizeEnumEntry(sanitizeString(k)));
                }
            } else {
                // TODO: test this properly eventually
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

                for (String k : this.values) {
                    String constantName = sanitizeEnumEntry(sanitizeString(k));
                    try {
                        Integer.valueOf(k);
                        constantName = "V_" + constantName;
                    } catch (Exception e) {
                        // Ignored
                    }
                    en.addEnumConstant(constantName + "(\"" + k + "\")");
                }
            }
        }

        return new GeneratorResult(new ArrayList<>(), Collections.singletonList(getType()));
    }
}
