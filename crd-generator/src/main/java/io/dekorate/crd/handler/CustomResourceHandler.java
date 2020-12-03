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

import java.util.Optional;

import javax.lang.model.element.TypeElement;

import io.dekorate.Handler;
import io.dekorate.Resources;
import io.dekorate.crd.Defaults;
import io.dekorate.crd.annotation.Status;
import io.dekorate.crd.annotation.Autodetect;
import io.dekorate.crd.annotation.LabelSelector;
import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.config.EditableCustomResourceConfig;
import io.dekorate.crd.config.Keys;
import io.dekorate.crd.config.Scale;
import io.dekorate.crd.decorator.AddSpecReplicasPathDecorator;
import io.dekorate.crd.decorator.AddLabelSelectorPathDecorator;
import io.dekorate.crd.decorator.AddStatusReplicasPathDecorator;
import io.dekorate.crd.decorator.AddStatusSubresourceDecorator;
import io.dekorate.crd.decorator.AddSubresourcesDecorator;
import io.dekorate.crd.util.JsonSchema;
import io.dekorate.crd.visitor.SpecReplicasPathDetector;
import io.dekorate.crd.visitor.LabelSelectorPathDetector;
import io.dekorate.crd.visitor.StatusReplicasPathDetector;
import io.dekorate.kubernetes.config.Configuration;
import io.dekorate.utils.Strings;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.sundr.codegen.CodegenContext;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.ClassRef;
import io.sundr.codegen.model.ClassRefBuilder;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeDefBuilder;
import io.sundr.codegen.model.TypeRef;

import static io.dekorate.crd.util.Types.*;

public class CustomResourceHandler implements Handler<CustomResourceConfig> {

  private final Resources resources;

  public CustomResourceHandler(Resources resources) {
    this.resources = resources;
  }

  @Override
  public int order() {
    return 400;
  }

  @Override
  public String getKey() {
    return "crd";
  }

  @Override
  public void handle(CustomResourceConfig config) {
    TypeDef def = config.getAttribute(Keys.TYPE_DEFINITION);
    String name = config.getPlural() + "." + config.getGroup();

    Optional<TypeRef> statusType = findStatusType(config, def);

    SpecReplicasPathDetector specReplicasPathDetector = new SpecReplicasPathDetector();
    StatusReplicasPathDetector statusReplicasPathDetector = new StatusReplicasPathDetector();
    LabelSelectorPathDetector  labalSelectorPathDetector = new LabelSelectorPathDetector();

    //This is going to be used in order to scan the status provided as `@CustomResource(status = MyStatus.class)`.
    StatusReplicasPathDetector externalStatusReplicasPathDetector = new StatusReplicasPathDetector(".spec.");
    LabelSelectorPathDetector  externalLabalSelectorPathDetector = new LabelSelectorPathDetector(".spec.");

    if (statusType.isPresent()) {
      TypeDefBuilder builder = new TypeDefBuilder(def);
      Optional<Property> statusProperty = findStatusProperty(config, def);

      statusProperty.ifPresent(p -> {
          builder.removeFromProperties(p);
      });

      def = builder
        .addNewProperty()
        .withName("status")
        .withTypeRef(statusType.get())
        .endProperty()
        .build();

      if (Strings.isNotNullOrEmpty(config.getStatusClassName())) {
          TypeElement externalStatusElement = CodegenContext.getContext().getElements().getTypeElement(config.getStatusClassName());
          TypeRef externalStatusRef = ElementTo.TYPEDEF.apply(externalStatusElement).toReference();
          if (externalStatusRef instanceof ClassRef) {
            TypeDef externalStatusDef = ((ClassRef) externalStatusRef).getDefinition();

            if (externalStatusDef.getName().equals(Autodetect.class.getSimpleName())) {
              new TypeDefBuilder(externalStatusDef)
                .accept(externalStatusReplicasPathDetector)
                .accept(externalLabalSelectorPathDetector)
                .build();
            }
          }
      }
    }

    def = new TypeDefBuilder(def)
      .accept(specReplicasPathDetector)
      .accept(statusReplicasPathDetector)
      .accept(labalSelectorPathDetector)
      .build();
    
    resources.add(new CustomResourceDefinitionBuilder()
        .withApiVersion("apiextensions.k8s.io/v1beta1")
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withScope(config.getScope().name())
        .withGroup(config.getGroup())
        .withVersion(config.getVersion())
        .withNewNames()
        .withKind(config.getKind())
        .withShortNames(config.getShortName())
        .withPlural(config.getPlural())
        .withSingular(config.getKind().toLowerCase())
        .endNames()
        .withNewValidation()
        .withOpenAPIV3Schema(JsonSchema.from(def))
        .endValidation()
        .endSpec()
        .build());

    String specReplicasPath = Strings.isNotNullOrEmpty(config.getScale().getSpecReplicasPath()) ? config.getScale().getSpecReplicasPath() : specReplicasPathDetector.getPath().orElse(null);
    String statusReplicasPath = Strings.isNotNullOrEmpty(config.getScale().getStatusReplicasPath()) ? config.getScale().getStatusReplicasPath() : statusReplicasPathDetector.getPath().orElse(externalStatusReplicasPathDetector.getPath().orElse(null));
    String labalSelectorPath = Strings.isNotNullOrEmpty(config.getScale().getLabelSelectorPath()) ? config.getScale().getLabelSelectorPath() : labalSelectorPathDetector.getPath().orElse(externalLabalSelectorPathDetector.getPath().orElse(null));

    if (Strings.isNotNullOrEmpty(specReplicasPath)) {
       resources.decorate(new AddSubresourcesDecorator(name));
       resources.decorate(new AddSpecReplicasPathDecorator(name, specReplicasPath));
    }

    if (Strings.isNotNullOrEmpty(statusReplicasPath)) {
       resources.decorate(new AddSubresourcesDecorator(name));
       resources.decorate(new AddStatusReplicasPathDecorator(name, statusReplicasPath));
    }

    if (Strings.isNotNullOrEmpty(labalSelectorPath)) {
       resources.decorate(new AddSubresourcesDecorator(name));
       resources.decorate(new AddLabelSelectorPathDecorator(name, labalSelectorPath));
    }

    if (statusType.isPresent()) {
       resources.decorate(new AddSubresourcesDecorator(name));
       resources.decorate(new AddStatusSubresourceDecorator(name));
    }
  }

  @Override
  public boolean canHandle(Class<? extends Configuration> config) {
    return CustomResourceConfig.class.equals(config) || EditableCustomResourceConfig.class.equals(config);
  }

  protected static boolean hasNonDefaultScaleConfig(Scale scale) {
    return Strings.isNotNullOrEmpty(scale.getSpecReplicasPath())
      || Strings.isNotNullOrEmpty(scale.getStatusReplicasPath())
      || Strings.isNotNullOrEmpty(scale.getLabelSelectorPath());
  }
}
