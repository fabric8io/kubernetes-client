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
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import io.fabric8.java.generator.Config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static io.fabric8.java.generator.nodes.Keywords.JAVA_UTIL_LIST;

public class JArray extends AbstractJSONSchema2Pojo {

  private final String type;
  private final AbstractJSONSchema2Pojo nested;

  public JArray(AbstractJSONSchema2Pojo nested, Config config, String description, final boolean isNullable) {
    super(config, description, isNullable);
    this.type = new ClassOrInterfaceType()
        .setName(JAVA_UTIL_LIST)
        .setTypeArguments(new ClassOrInterfaceType().setName(nested.getType()))
        .toString();
    this.nested = nested;
    this.skipDefault = nested.skipDefault;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public GeneratorResult generateJava() {
    return nested.generateJava();
  }

  @Override
  protected Expression generateDefaultInstance(JsonNode defaultValue) {
    return new NameExpr("new java.util.ArrayList<>()");
  }

  @Override
  protected List<Statement> expandDefaultInstance(final String scope, JsonNode defaultValue) {
    final List<Statement> statements = new ArrayList<>();

    AtomicInteger counter = new AtomicInteger(0);
    Iterator<JsonNode> elements = defaultValue.elements();
    while (elements.hasNext()) {
      JsonNode element = elements.next();
      statements.add(new ExpressionStmt(
          new NameExpr(scope + ".add(" + this.nested.generateDefaultInstance(element) + ")")));
      statements.addAll(this.nested.expandDefaultInstance(scope + ".get(" + counter.getAndIncrement() + ")", element));
    }
    return statements;
  }
}
