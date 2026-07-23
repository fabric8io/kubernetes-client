package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceColumnDefinitionBuilder extends CustomResourceColumnDefinitionFluent<CustomResourceColumnDefinitionBuilder> implements VisitableBuilder<CustomResourceColumnDefinition,CustomResourceColumnDefinitionBuilder>{

  CustomResourceColumnDefinitionFluent<?> fluent;

  public CustomResourceColumnDefinitionBuilder() {
    this(new CustomResourceColumnDefinition());
  }
  
  public CustomResourceColumnDefinitionBuilder(CustomResourceColumnDefinitionFluent<?> fluent) {
    this(fluent, new CustomResourceColumnDefinition());
  }
  
  public CustomResourceColumnDefinitionBuilder(CustomResourceColumnDefinition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceColumnDefinitionBuilder(CustomResourceColumnDefinitionFluent<?> fluent,CustomResourceColumnDefinition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceColumnDefinition build() {
    CustomResourceColumnDefinition buildable = new CustomResourceColumnDefinition(fluent.getDescription(), fluent.getFormat(), fluent.getJsonPath(), fluent.getName(), fluent.getPriority(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}