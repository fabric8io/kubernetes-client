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

import javax.lang.model.element.TypeElement;

import io.dekorate.Handler;
import io.dekorate.Resources;
import io.dekorate.crd.config.Keys;
import io.dekorate.crd.config.Scale;
import io.dekorate.crd.decorator.AddScaleSubresourceDecorator;
import io.dekorate.crd.decorator.AddStatusSubresourceDecorator;
import io.dekorate.crd.decorator.AddSubresourcesDecorator;
import io.dekorate.crd.Defaults;
import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.config.EditableCustomResourceConfig;
import io.dekorate.crd.util.JsonSchema;
import io.dekorate.kubernetes.config.Configuration;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.JSONSchemaProps;
import io.sundr.codegen.CodegenContext;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeDefBuilder;
import io.sundr.codegen.model.TypeRef;
import io.sundr.codegen.utils.ModelUtils;

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

    boolean isScalable = config.isScalable() || hasNonDefaultScaleConfig(config.getScale());
    boolean hasStatus = !CustomResourceConfig.VOID.equals(config.getStatusClassName());
    if (hasStatus) {
      TypeElement statusElement = CodegenContext.getContext().getElements().getTypeElement(config.getStatusClassName());
      TypeRef statusRef = ElementTo.TYPEDEF.apply(statusElement).toReference();
      def = new TypeDefBuilder(def)
        .addNewProperty()
          .withName("status")
          .withTypeRef(statusRef)
        .endProperty()
        .build();
    }
    JSONSchemaProps schema =JsonSchema.from(def);
    System.out.println("schema:" + schema);

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

    if (isScalable || hasStatus) {
       resources.decorate(new AddSubresourcesDecorator(name));
    }

    if (isScalable) {
       resources.decorate(new AddScaleSubresourceDecorator(name, config.getScale().getSpecReplicasPath(), config.getScale().getSpecReplicasPath(), config.getScale().getLabelSelectorPath()));
    }

    if (hasStatus) {
      resources.decorate(new AddStatusSubresourceDecorator(name));
    }
  }
    

  @Override
  public boolean canHandle(Class<? extends Configuration> config) {
    return CustomResourceConfig.class.equals(config) || EditableCustomResourceConfig.class.equals(config);
  }

  protected static boolean hasNonDefaultScaleConfig(Scale scale) {
    return !scale.getSpecReplicasPath().equals(Defaults.SPEC_REPLICAS_PATH)
      || !scale.getStatusReplicasPath().equals(Defaults.STATUS_REPLICAS_PATH)
      || !scale.getLabelSelectorPath().equals(Defaults.LABEL_SELECTOR_PATH);
  }
}
