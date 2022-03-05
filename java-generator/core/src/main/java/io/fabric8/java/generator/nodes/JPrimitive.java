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
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.DoubleLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.LongLiteralExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.Statement;
import io.fabric8.java.generator.Config;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JPrimitive extends AbstractJSONSchema2Pojo {
  private final String type;

  private static final GeneratorResult empty = new GeneratorResult(new ArrayList<>(), new ArrayList<>());

  public JPrimitive(String type, Config config, String description, final boolean isNullable) {
    super(config, description, isNullable);
    this.type = type;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public GeneratorResult generateJava() {
    return empty;
  }

  @Override
  protected BlockStmt generateDefaultInitializerBody(JsonNode defaultValue) {
    BlockStmt body = new BlockStmt();
    // return value representation
    body.addStatement(new ReturnStmt(this.generateDefaultInstance(defaultValue)));
    return body;
  }

  @Override
  protected Expression generateDefaultInstance(JsonNode defaultValue) {
    Expression expr;
    if (!JPrimitiveNameAndType.STRING.getName().equals(this.type)) {
      if (JPrimitiveNameAndType.BOOL.getName().equals(this.type)) {
        expr = new BooleanLiteralExpr(defaultValue.asBoolean());
      } else if (JPrimitiveNameAndType.INTEGER.getName().equals(this.type)) {
        expr = new IntegerLiteralExpr(defaultValue.toString());
      } else if (JPrimitiveNameAndType.LONG.getName().equals(this.type)) {
        expr = new LongLiteralExpr(defaultValue.toString() + "L");
      } else if (JPrimitiveNameAndType.FLOAT.getName().equals(this.type)
          || JPrimitiveNameAndType.DOUBLE.getName().equals(this.type)) {
        expr = new DoubleLiteralExpr(defaultValue.asDouble());
      } else {
        throw new JavaGeneratorException(
            String.format(
                "Error while generating a default value: unknown primitive data type detected (%s)",
                this.type));
      }
    } else {
      expr = new NameExpr(defaultValue.toString());
    }
    return expr;
  }

  @Override
  protected List<Statement> expandDefaultInstance(final String scope, JsonNode defaultValue) {
    return Collections.emptyList();
  }
}
