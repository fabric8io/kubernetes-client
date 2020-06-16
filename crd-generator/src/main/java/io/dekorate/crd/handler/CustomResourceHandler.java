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

import io.dekorate.Handler;
import io.dekorate.Resources;
import io.dekorate.crd.confg.Keys;
import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.config.EditableCustomResourceConfig;
import io.dekorate.crd.util.JsonSchema;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.dekorate.kubernetes.config.Configuration;
import io.sundr.codegen.model.TypeDef;

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

    resources.add(new CustomResourceDefinitionBuilder()
      .withApiVersion("apiextensions.k8s.io/v1beta1")
      .withNewMetadata()
        .withName(config.getPlural() + "." + config.getGroup())
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
  }

  @Override
  public boolean canHandle(Class<? extends Configuration> config) {
    return CustomResourceConfig.class.equals(config) || EditableCustomResourceConfig.class.equals(config);
  }
}
