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

import static io.fabric8.crd.generator.utils.Types.findStatusProperty;

import io.fabric8.crd.generator.apt.CustomResourceInfo;
import io.fabric8.crd.generator.apt.Resources;
import io.fabric8.crd.generator.utils.Strings;
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
import io.fabric8.crd.generator.visitor.AdditionalPrinterColumnDetector;
import io.fabric8.crd.generator.visitor.LabelSelectorPathDetector;
import io.fabric8.crd.generator.visitor.SpecReplicasPathDetector;
import io.fabric8.crd.generator.visitor.StatusReplicasPathDetector;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeDefBuilder;
import io.sundr.codegen.model.TypeRef;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.lang.model.element.TypeElement;

public class CustomResourceHandler {

  private final Resources resources;

  public CustomResourceHandler(Resources resources) {
    this.resources = resources;
  }

  public void handle(CustomResourceInfo config, TypeDef def) {
    final String name = config.crdName();
    final String version = config.version();

    Optional<TypeRef> statusType;
    final TypeElement status = config.status();
    if (!status.getQualifiedName().contentEquals(Void.class.getCanonicalName())) {
      statusType = Optional.of(ElementTo.TYPEDEF.apply(status).toReference());
    } else {
      statusType = Optional.empty();
    }

    SpecReplicasPathDetector specReplicasPathDetector = new SpecReplicasPathDetector();
    StatusReplicasPathDetector statusReplicasPathDetector = new StatusReplicasPathDetector();
    LabelSelectorPathDetector labelSelectorPathDetector = new LabelSelectorPathDetector();
    AdditionalPrinterColumnDetector additionalPrinterColumnDetector = new AdditionalPrinterColumnDetector();

    if (statusType.isPresent()) {
      TypeDefBuilder builder = new TypeDefBuilder(def);
      Optional<Property> statusProperty = findStatusProperty(def);

      statusProperty.ifPresent(p -> {
        builder.removeFromProperties(p);
      });

      def = builder
        .addNewProperty()
        .withName("status")
        .withTypeRef(statusType.get())
        .endProperty()
        .build();
    }

    def = new TypeDefBuilder(def)
      .accept(specReplicasPathDetector)
      .accept(statusReplicasPathDetector)
      .accept(labelSelectorPathDetector)
      .accept(additionalPrinterColumnDetector)
      .build();

    resources.decorate(
      new AddCustomResourceDefinitionResourceDecorator(name, config.group(), config.kind(),
        config.scope().name(), config.shortNames(), config.plural(), config.singular()));

    resources.decorate(new AddCustomResourceDefinitionVersionDecorator(name, version));
    // Let's ignore the parts that are mandatory in the examples
    resources.decorate(new AddSchemaToCustomResourceDefinitionVersionDecorator(name, version,
      JsonSchema.from(def, "kind", "apiVersion", "metadata")));

    Map<String, Property> additionalPrinterColumns = new HashMap<>();
    additionalPrinterColumns.putAll(additionalPrinterColumnDetector.getProperties());

    specReplicasPathDetector.getPath().ifPresent(specReplicasPath -> {
      resources.decorate(new AddSubresourcesDecorator(name, version));
      resources.decorate(new AddSpecReplicasPathDecorator(name, version, specReplicasPath));
    });

    statusReplicasPathDetector.getPath().ifPresent(statusReplicasPath -> {
      resources.decorate(new AddSubresourcesDecorator(name, version));
      resources.decorate(new AddStatusReplicasPathDecorator(name, version, statusReplicasPath));
    });

    labelSelectorPathDetector.getPath().ifPresent(labelSelectorPath -> {
      resources.decorate(new AddSubresourcesDecorator(name, version));
      resources.decorate(new AddLabelSelectorPathDecorator(name, version, labelSelectorPath));
    });

    if (statusType.isPresent()) {
      resources.decorate(new AddSubresourcesDecorator(name, version));
      resources.decorate(new AddStatusSubresourceDecorator(name, version));
    }

    resources.decorate(new SetServedVersionDecorator(name, version, config.served()));
    resources.decorate(new SetStorageVersionDecorator(name, version, config.storage()));
    resources.decorate(new EnsureSingleStorageVersionDecorator(name));

    resources.decorate(new PromoteSingleVersionAttributesDecorator(name));

    additionalPrinterColumns.forEach((path, property) -> {
      Map<String, Object> parameters = property.getAnnotations().stream()
        .filter(a -> a.getClassRef().getName().equals("PrinterColumn")).map(a -> a.getParameters())
        .findFirst().orElse(Collections.emptyMap());
      String type = JsonSchema.TYPE_MAP.getOrDefault(property.getTypeRef(), "object");
      String column = (String) parameters.get("name");
      if (Strings.isNullOrEmpty(column)) {
        column = property.getName().toUpperCase();
      }
      String description = property.getComments().stream().filter(l -> !l.trim().startsWith("@"))
        .collect(Collectors.joining(" ")).trim();
      String format = (String) parameters.get("format");

      resources.decorate(
        new AddAdditionPrinterColumnDecorator(name, version, type, column, path, format,
          description));
    });
  }
}
