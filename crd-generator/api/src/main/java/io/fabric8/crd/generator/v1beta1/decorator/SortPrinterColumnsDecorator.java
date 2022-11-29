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
package io.fabric8.crd.generator.v1beta1.decorator;

import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceColumnDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersionFluent;

import java.util.List;

public class SortPrinterColumnsDecorator
    extends CustomResourceDefinitionVersionDecorator<CustomResourceDefinitionVersionFluent<?>> {

  public SortPrinterColumnsDecorator(String name, String version) {
    super(name, version);
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionVersionFluent<?> version) {
    List<CustomResourceColumnDefinition> columns = version.buildAdditionalPrinterColumns();
    if (columns != null && !columns.isEmpty()) {
      columns.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getJSONPath(), o2.getJSONPath()));
    }
    version.withAdditionalPrinterColumns(columns);
  }

  @Override
  public Class<? extends Decorator>[] after() {
    return new Class[] { AddCustomResourceDefinitionVersionDecorator.class, AddAdditionPrinterColumnDecorator.class };
  }
}
