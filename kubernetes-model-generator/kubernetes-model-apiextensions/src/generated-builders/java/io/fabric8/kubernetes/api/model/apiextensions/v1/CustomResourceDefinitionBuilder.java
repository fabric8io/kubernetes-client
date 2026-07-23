package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceDefinitionBuilder extends CustomResourceDefinitionFluent<CustomResourceDefinitionBuilder> implements VisitableBuilder<CustomResourceDefinition,CustomResourceDefinitionBuilder>{

  CustomResourceDefinitionFluent<?> fluent;

  public CustomResourceDefinitionBuilder() {
    this(new CustomResourceDefinition());
  }
  
  public CustomResourceDefinitionBuilder(CustomResourceDefinitionFluent<?> fluent) {
    this(fluent, new CustomResourceDefinition());
  }
  
  public CustomResourceDefinitionBuilder(CustomResourceDefinition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceDefinitionBuilder(CustomResourceDefinitionFluent<?> fluent,CustomResourceDefinition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceDefinition build() {
    CustomResourceDefinition buildable = new CustomResourceDefinition(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}