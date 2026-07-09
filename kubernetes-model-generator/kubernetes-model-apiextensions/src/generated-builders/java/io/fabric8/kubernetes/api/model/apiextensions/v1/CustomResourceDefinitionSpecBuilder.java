package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceDefinitionSpecBuilder extends CustomResourceDefinitionSpecFluent<CustomResourceDefinitionSpecBuilder> implements VisitableBuilder<CustomResourceDefinitionSpec,CustomResourceDefinitionSpecBuilder>{

  CustomResourceDefinitionSpecFluent<?> fluent;

  public CustomResourceDefinitionSpecBuilder() {
    this(new CustomResourceDefinitionSpec());
  }
  
  public CustomResourceDefinitionSpecBuilder(CustomResourceDefinitionSpecFluent<?> fluent) {
    this(fluent, new CustomResourceDefinitionSpec());
  }
  
  public CustomResourceDefinitionSpecBuilder(CustomResourceDefinitionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceDefinitionSpecBuilder(CustomResourceDefinitionSpecFluent<?> fluent,CustomResourceDefinitionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceDefinitionSpec build() {
    CustomResourceDefinitionSpec buildable = new CustomResourceDefinitionSpec(fluent.buildConversion(), fluent.getGroup(), fluent.buildNames(), fluent.getPreserveUnknownFields(), fluent.getScope(), fluent.buildVersions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}