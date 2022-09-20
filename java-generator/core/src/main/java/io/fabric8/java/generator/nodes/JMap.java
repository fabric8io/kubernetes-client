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
/* (C)2015 */
package io.fabric8.java.generator.nodes;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import io.fabric8.java.generator.Config;

import static io.fabric8.java.generator.nodes.Keywords.JAVA_LANG_STRING;
import static io.fabric8.java.generator.nodes.Keywords.JAVA_UTIL_MAP;

public class JMap extends AbstractJSONSchema2Pojo {

  private final String type;

  private final AbstractJSONSchema2Pojo nested;

  public JMap(AbstractJSONSchema2Pojo nested, Config config, String description, final boolean isNullable,
      JsonNode defaultValue) {
    super(config, description, isNullable, defaultValue, null);
    this.type = new ClassOrInterfaceType()
        .setName(JAVA_UTIL_MAP)
        .setTypeArguments(
            new ClassOrInterfaceType().setName(JAVA_LANG_STRING),
            new ClassOrInterfaceType().setName(nested.getType()))
        .toString();
    this.nested = nested;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  protected String getClassType() {
    return JAVA_UTIL_MAP;
  }

  @Override
  public GeneratorResult generateJava() {
    return nested.generateJava();
  }
}
