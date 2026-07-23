package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceDefinitionStatusBuilder extends CustomResourceDefinitionStatusFluent<CustomResourceDefinitionStatusBuilder> implements VisitableBuilder<CustomResourceDefinitionStatus,CustomResourceDefinitionStatusBuilder>{

  CustomResourceDefinitionStatusFluent<?> fluent;

  public CustomResourceDefinitionStatusBuilder() {
    this(new CustomResourceDefinitionStatus());
  }
  
  public CustomResourceDefinitionStatusBuilder(CustomResourceDefinitionStatusFluent<?> fluent) {
    this(fluent, new CustomResourceDefinitionStatus());
  }
  
  public CustomResourceDefinitionStatusBuilder(CustomResourceDefinitionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceDefinitionStatusBuilder(CustomResourceDefinitionStatusFluent<?> fluent,CustomResourceDefinitionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceDefinitionStatus build() {
    CustomResourceDefinitionStatus buildable = new CustomResourceDefinitionStatus(fluent.buildAcceptedNames(), fluent.buildConditions(), fluent.getStoredVersions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}