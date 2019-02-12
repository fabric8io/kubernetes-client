package io.ap4k.crd.handler;

import io.ap4k.Handler;
import io.ap4k.Resources;
import io.ap4k.crd.confg.Keys;
import io.ap4k.crd.config.CustomResourceConfig;
import io.ap4k.crd.config.EditableCustomResourceConfig;
import io.ap4k.crd.util.JsonSchema;
import io.ap4k.deps.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.ap4k.kubernetes.config.Configuration;
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
  public void handle(CustomResourceConfig config) {
    TypeDef def = config.getAttribute(Keys.TYPE_DEFINITION);

    resources.add(new CustomResourceDefinitionBuilder()
      .withApiVersion("apiextensions.k8s.io/v1beta1")
      .withNewMetadata()
        .withName(config.getPlural() + "." + config.getGroup())
        .withLabels(resources.getLabels())
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
