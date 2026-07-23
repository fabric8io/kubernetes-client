package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceDefinitionConditionBuilder extends CustomResourceDefinitionConditionFluent<CustomResourceDefinitionConditionBuilder> implements VisitableBuilder<CustomResourceDefinitionCondition,CustomResourceDefinitionConditionBuilder>{

  CustomResourceDefinitionConditionFluent<?> fluent;

  public CustomResourceDefinitionConditionBuilder() {
    this(new CustomResourceDefinitionCondition());
  }
  
  public CustomResourceDefinitionConditionBuilder(CustomResourceDefinitionConditionFluent<?> fluent) {
    this(fluent, new CustomResourceDefinitionCondition());
  }
  
  public CustomResourceDefinitionConditionBuilder(CustomResourceDefinitionCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceDefinitionConditionBuilder(CustomResourceDefinitionConditionFluent<?> fluent,CustomResourceDefinitionCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceDefinitionCondition build() {
    CustomResourceDefinitionCondition buildable = new CustomResourceDefinitionCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}