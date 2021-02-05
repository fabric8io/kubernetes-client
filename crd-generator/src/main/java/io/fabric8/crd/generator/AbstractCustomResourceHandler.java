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
package io.fabric8.crd.generator;

import static io.fabric8.crd.generator.utils.Types.findStatusProperty;

import io.fabric8.crd.generator.apt.CustomResourceInfo;
import io.fabric8.crd.generator.apt.Resources;
import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.crd.generator.utils.Strings;
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

public abstract class AbstractCustomResourceHandler {

  protected final Resources resources;

  protected AbstractCustomResourceHandler(Resources resources) {
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

    final boolean statusExists = statusType.isPresent();
    if (statusExists) {
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

    addDecorators(config, def, specReplicasPathDetector.getPath(),
      statusReplicasPathDetector.getPath(), labelSelectorPathDetector.getPath(), statusExists);

    Map<String, Property> additionalPrinterColumns = new HashMap<>();
    additionalPrinterColumns.putAll(additionalPrinterColumnDetector.getProperties());
    additionalPrinterColumns.forEach((path, property) -> {
      Map<String, Object> parameters = property.getAnnotations().stream()
        .filter(a -> a.getClassRef().getName().equals("PrinterColumn")).map(a -> a.getParameters())
        .findFirst().orElse(Collections.emptyMap());
      String type = JsonSchema.COMMON_MAPPINGS.getOrDefault(property.getTypeRef(), "object");
      String column = (String) parameters.get("name");
      if (Strings.isNullOrEmpty(column)) {
        column = property.getName().toUpperCase();
      }
      String description = property.getComments().stream().filter(l -> !l.trim().startsWith("@"))
        .collect(Collectors.joining(" ")).trim();
      String format = (String) parameters.get("format");

      resources.decorate(
        getPrinterColumnDecorator(name, version, path, type, column, description, format));
    });
  }

  protected abstract Decorator getPrinterColumnDecorator(String name, String version, String path,
    String type, String column, String description, String format);

  protected abstract void addDecorators(CustomResourceInfo config, TypeDef def,
    Optional<String> specReplicasPath, Optional<String> statusReplicasPath,
    Optional<String> labelSelectorPath, boolean statusExists);
}
