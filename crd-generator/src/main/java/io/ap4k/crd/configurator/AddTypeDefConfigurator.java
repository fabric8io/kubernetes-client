/**
 * Copyright 2018 The original authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.ap4k.crd.configurator;

import io.ap4k.crd.confg.Keys;
import io.ap4k.crd.config.CustomResourceConfigBuilder;
import io.ap4k.kubernetes.config.Configurator;
import io.sundr.codegen.model.TypeDef;

public class AddTypeDefConfigurator extends Configurator<CustomResourceConfigBuilder> {

  private final TypeDef typeDef;

  public AddTypeDefConfigurator(TypeDef typeDef) {
    this.typeDef = typeDef;
  }

  @Override
  public void visit(CustomResourceConfigBuilder customResourceConfig) {
    customResourceConfig.addToAttributes(Keys.TYPE_DEFINITION, typeDef);
  }
}
