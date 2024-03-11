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
package io.fabric8.crd.generator.v1beta1.decorator;

import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersionFluent;

public class SetDeprecatedVersionDecorator
    extends CustomResourceDefinitionVersionDecorator<CustomResourceDefinitionVersionFluent<?>> {

  private final boolean deprecated;
  private final String deprecationWarning;

  public SetDeprecatedVersionDecorator(String name, String version, boolean deprecated, String deprecationWarning) {
    super(name, version);
    this.deprecated = deprecated;
    this.deprecationWarning = deprecationWarning;
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionVersionFluent<?> version) {
    if (deprecated) {
      version.withDeprecated(true);
      version.withDeprecationWarning(deprecationWarning);
    }
  }

  @Override
  public String toString() {
    return getClass().getName() + " [name:" + getName() + ", version:" + getVersion()
        + ", deprecated:" + deprecated + ", deprecationWarning:" + deprecationWarning + "]";
  }
}
