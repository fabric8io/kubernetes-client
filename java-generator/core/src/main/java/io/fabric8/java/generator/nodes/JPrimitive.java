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
import io.fabric8.java.generator.Config;

import java.util.ArrayList;

public class JPrimitive extends AbstractJSONSchema2Pojo {
  private final String type;

  private static final GeneratorResult empty = new GeneratorResult(new ArrayList<>(), new ArrayList<>());

  public JPrimitive(String type, Config config, String description, final boolean isNullable, JsonNode defaultValue,
      final ValidationProperties validationProperties) {
    super(config, description, isNullable, defaultValue, validationProperties);
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
}
