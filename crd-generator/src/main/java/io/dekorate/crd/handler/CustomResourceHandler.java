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
package io.dekorate.crd.handler;

import static io.dekorate.crd.util.Types.findStatusProperty;

import io.dekorate.Resources;
import io.dekorate.crd.annotation.Autodetect;
import io.dekorate.crd.apt.CustomResourceAnnotationProcessor.CRInfo;
import io.dekorate.crd.config.Scale;
import io.dekorate.crd.decorator.AddAdditionPrinterColumnDecorator;
import io.dekorate.crd.decorator.AddCustomResourceDefinitionResourceDecorator;
import io.dekorate.crd.decorator.AddCustomResourceDefintionVersionDecorator;
import io.dekorate.crd.decorator.AddLabelSelectorPathDecorator;
import io.dekorate.crd.decorator.AddSchemaToCustomResourceDefinitionVersionDecorator;
import io.dekorate.crd.decorator.AddSpecReplicasPathDecorator;
import io.dekorate.crd.decorator.AddStatusReplicasPathDecorator;
import io.dekorate.crd.decorator.AddStatusSubresourceDecorator;
import io.dekorate.crd.decorator.AddSubresourcesDecorator;
import io.dekorate.crd.decorator.EnsureSingleStorageVersionDecorator;
import io.dekorate.crd.decorator.PromoteSingleVersionAttributesDecorator;
import io.dekorate.crd.decorator.SetServedVersionDecorator;
import io.dekorate.crd.decorator.SetStorageVersionDecorator;
import io.dekorate.crd.util.JsonSchema;
import io.dekorate.crd.visitor.AdditionalPrineterColumnDetector;
import io.dekorate.crd.visitor.LabelSelectorPathDetector;
import io.dekorate.crd.visitor.SpecReplicasPathDetector;
import io.dekorate.crd.visitor.StatusReplicasPathDetector;
import io.dekorate.kubernetes.decorator.Decorator;
import io.dekorate.utils.Strings;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionBuilder;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.ClassRef;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeDefBuilder;
import io.sundr.codegen.model.TypeRef;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CustomResourceHandler {

  private final Set<Decorator> decorators = new TreeSet<>(DECORATOR_COMPARATOR);
  private static final Comparator<Decorator> DECORATOR_COMPARATOR = (a, b) -> a.compareTo(b) == 0
    ? b.compareTo(a)
    : a.equals(b) ? 0 : 1;

  private final Resources resources;

  public CustomResourceHandler(Resources resources) {
    this.resources = resources;
  }

  public Map<String, KubernetesList> handle(CRInfo config, TypeDef def) {
    final var name = config.crdName();
    final var version = config.version();

    Optional<TypeRef> statusType;
    final var status = config.status();
    if (!status.getQualifiedName().contentEquals(Void.TYPE.getCanonicalName())) {
      statusType = Optional.of(ElementTo.TYPEDEF.apply(status).toReference());
    } else {
      statusType = Optional.empty();
    }

    SpecReplicasPathDetector specReplicasPathDetector = new SpecReplicasPathDetector();
    StatusReplicasPathDetector statusReplicasPathDetector = new StatusReplicasPathDetector();
    LabelSelectorPathDetector labelSelectorPathDetector = new LabelSelectorPathDetector();
    AdditionalPrineterColumnDetector additionalPrineterColumnDetector = new AdditionalPrineterColumnDetector();

    //This is going to be used in order to scan the status provided as `@Crd(status = MyStatus.class)`.
    StatusReplicasPathDetector externalStatusReplicasPathDetector = new StatusReplicasPathDetector(
      ".spec.");
    LabelSelectorPathDetector externalLabelSelectorPathDetector = new LabelSelectorPathDetector(
      ".spec.");
    AdditionalPrineterColumnDetector externalAdditionalPrineterColumnDetector = new AdditionalPrineterColumnDetector(
      ".spec.");

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

      if (!status.getQualifiedName().contentEquals(Void.TYPE.getCanonicalName())) {
        TypeRef externalStatusRef = ElementTo.TYPEDEF.apply(config.status()).toReference();
        if (externalStatusRef instanceof ClassRef) {
          TypeDef externalStatusDef = ((ClassRef) externalStatusRef).getDefinition();

          if (externalStatusDef.getName().equals(Autodetect.class.getSimpleName())) {
            new TypeDefBuilder(externalStatusDef)
              .accept(externalStatusReplicasPathDetector)
              .accept(externalLabelSelectorPathDetector)
              .accept(externalAdditionalPrineterColumnDetector)
              .build();
          }
          }
      }
    }

    def = new TypeDefBuilder(def)
      .accept(specReplicasPathDetector)
      .accept(statusReplicasPathDetector)
      .accept(labelSelectorPathDetector)
      .accept(additionalPrineterColumnDetector)
      .build();

    if (resources.groups().isEmpty() && resources.global().getItems().isEmpty()) {
      resources.add(new CustomResourceDefinitionBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withScope(config.scope().name())
        .withGroup(config.group())
        .withNewNames()
        .withKind(config.kind())
        .withShortNames(config.shortNames())
        .withPlural(config.plural())
        .withSingular(config.singular())
        .endNames()
        .endSpec()
        .build());
    } else {
      resources.decorate(
        new AddCustomResourceDefinitionResourceDecorator(name, config.group(), config.kind(),
          config.scope().name(), config.shortNames(), config.plural(), config.singular()));
    }

    resources.decorate(new AddCustomResourceDefintionVersionDecorator(name, version));
    // Let's ignore the parts that are mandatory in the examples
    resources.decorate(new AddSchemaToCustomResourceDefinitionVersionDecorator(name, version, JsonSchema.from(def, "kind", "apiVersion", "metadata")));

    Map<String, Property> additionalPrinterColumns = new HashMap<>();
    additionalPrinterColumns.putAll(additionalPrineterColumnDetector.getProperties());
    additionalPrinterColumns.putAll(externalAdditionalPrineterColumnDetector.getProperties());

    specReplicasPathDetector.getPath().ifPresent(specReplicasPath -> {
      resources.decorate(new AddSubresourcesDecorator(name, version));
      resources.decorate(new AddSpecReplicasPathDecorator(name, version, specReplicasPath));
    });

    // todo: deal with external status?
    // statusReplicasPathDetector.getPath().orElse(externalStatusReplicasPathDetector.getPath().orElse(null))
    statusReplicasPathDetector.getPath().ifPresent(statusReplicasPath -> {
      resources.decorate(new AddSubresourcesDecorator(name, version));
      resources.decorate(new AddStatusReplicasPathDecorator(name, version, statusReplicasPath));
    });

    // todo: deal with external label?
    // labelSelectorPathDetector.getPath().orElse(externalLabelSelectorPathDetector.getPath().orElse(null))
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
        String description = property.getComments().stream().filter(l -> !l.trim().startsWith("@")).collect(Collectors.joining(" ")).trim();
        String format = (String) parameters.get("format");

        resources.decorate(new AddAdditionPrinterColumnDecorator(name, version, type, column, path, format, description));
    });

    return resources.generate();
  }

  protected static boolean hasNonDefaultScaleConfig(Scale scale) {
    return Strings.isNotNullOrEmpty(scale.getSpecReplicasPath())
      || Strings.isNotNullOrEmpty(scale.getStatusReplicasPath())
      || Strings.isNotNullOrEmpty(scale.getLabelSelectorPath());
  }
}
