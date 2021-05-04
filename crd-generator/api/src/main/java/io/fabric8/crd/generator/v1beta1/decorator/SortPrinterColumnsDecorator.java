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
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpecFluent;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersion;
import java.util.List;

public class SortPrinterColumnsDecorator extends Decorator<CustomResourceDefinitionSpecFluent<?>> {

  @Override
  public void visit(CustomResourceDefinitionSpecFluent<?> spec) {
    final List<CustomResourceDefinitionVersion> versions = spec.buildVersions();
    for (CustomResourceDefinitionVersion version : versions) {
      List<CustomResourceColumnDefinition> columns = version.getAdditionalPrinterColumns();
      if (columns != null && !columns.isEmpty()) {
        columns.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getJSONPath(), o2.getJSONPath()));
      }
    }
    spec.withVersions(versions);
  }

  @Override
  public Class<? extends Decorator>[] after() {
    return new Class[] {AddAdditionPrinterColumnDecorator.class};
  }
}
