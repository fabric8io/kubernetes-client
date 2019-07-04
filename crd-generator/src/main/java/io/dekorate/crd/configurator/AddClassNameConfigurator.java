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
package io.dekorate.crd.configurator;

import io.dekorate.crd.config.CustomResourceConfigBuilder;
import io.dekorate.crd.util.CamelCase;
import io.dekorate.crd.util.Pluralize;
import io.dekorate.kubernetes.config.Configurator;
import io.dekorate.utils.Strings;

public class AddClassNameConfigurator extends Configurator<CustomResourceConfigBuilder> {

  private final String className;

  public AddClassNameConfigurator(String className) {
    this.className = className;
  }

  @Override
  public void visit(CustomResourceConfigBuilder customResourceConfig) {
    if (Strings.isNullOrEmpty(customResourceConfig.getName())) {
      customResourceConfig.withName(CamelCase.TO_DASH_SEPARATED.andThen(String::toLowerCase).apply(className));
    }

    if (Strings.isNullOrEmpty(customResourceConfig.getKind())) {
      customResourceConfig.withKind(className);
    }

    if (Strings.isNullOrEmpty(customResourceConfig.getPlural())) {
      customResourceConfig.withPlural(Pluralize.FUNCTION.andThen(String::toLowerCase).apply(className));
    }

    if (Strings.isNullOrEmpty(customResourceConfig.getShortName())) {
      customResourceConfig.withShortName(CamelCase.TO_SHORTNAME.apply(className));
    }
  }
}
