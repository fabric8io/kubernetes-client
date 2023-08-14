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
package io.fabric8.crd.generator.v1beta1;

import io.fabric8.crd.generator.AbstractCustomResourceHandler;
import io.fabric8.crd.generator.CustomResourceInfo;
import io.fabric8.crd.generator.Resources;
import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.crd.generator.v1beta1.decorator.AddAdditionPrinterColumnDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.AddCustomResourceDefinitionResourceDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.AddCustomResourceDefinitionVersionDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.AddLabelSelectorPathDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.AddSchemaToCustomResourceDefinitionVersionDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.AddSpecReplicasPathDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.AddStatusReplicasPathDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.AddStatusSubresourceDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.AddSubresourcesDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.EnsureSingleStorageVersionDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.PromoteSingleVersionAttributesDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.SetServedVersionDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.SetStorageVersionDecorator;
import io.fabric8.crd.generator.v1beta1.decorator.SortPrinterColumnsDecorator;
import io.sundr.model.TypeDef;

import java.util.Optional;

public class CustomResourceHandler extends AbstractCustomResourceHandler {
  public static final String VERSION = "v1beta1";

  public CustomResourceHandler(Resources resources, boolean parallel) {
    super(resources, parallel);
  }

  @Override
  protected Decorator<?> getPrinterColumnDecorator(
      String name, String version, String path, String type, String column,
      String description, String format, int priority) {
    return new AddAdditionPrinterColumnDecorator(name, version, type, column, path, format,
        description, priority);
  }

  @Override
  protected void addDecorators(CustomResourceInfo config, TypeDef def,
      Optional<String> specReplicasPath, Optional<String> statusReplicasPath,
      Optional<String> labelSelectorPath) {
    final String name = config.crdName();
    final String version = config.version();
    resources.decorate(
        new AddCustomResourceDefinitionResourceDecorator(name, config.group(), config.kind(),
            config.scope().value(), config.shortNames(), config.plural(), config.singular(), config.annotations(),
            config.labels()));

    resources.decorate(new AddCustomResourceDefinitionVersionDecorator(name, version));

    resources.decorate(new AddSchemaToCustomResourceDefinitionVersionDecorator(name, version,
        JsonSchema.from(def, "kind", "apiVersion", "metadata")));

    specReplicasPath.ifPresent(path -> {
      resources.decorate(new AddSubresourcesDecorator(name, version));
      resources.decorate(new AddSpecReplicasPathDecorator(name, version, path));
    });

    statusReplicasPath.ifPresent(path -> {
      resources.decorate(new AddSubresourcesDecorator(name, version));
      resources.decorate(new AddStatusReplicasPathDecorator(name, version, path));
    });

    labelSelectorPath.ifPresent(path -> {
      resources.decorate(new AddSubresourcesDecorator(name, version));
      resources.decorate(new AddLabelSelectorPathDecorator(name, version, path));
    });

    if (config.statusClassName().isPresent()) {
      resources.decorate(new AddSubresourcesDecorator(name, version));
      resources.decorate(new AddStatusSubresourceDecorator(name, version));
    }

    resources.decorate(new SetServedVersionDecorator(name, version, config.served()));
    resources.decorate(new SetStorageVersionDecorator(name, version, config.storage()));
    resources.decorate(new EnsureSingleStorageVersionDecorator(name));
    resources.decorate(new PromoteSingleVersionAttributesDecorator(name));
    resources.decorate(new SortPrinterColumnsDecorator(name, version));
  }

  @Override
  public void handle(CustomResourceInfo config) {
    super.handle(config);
  }
}
