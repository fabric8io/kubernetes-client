package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FieldSelectorRequirementBuilder extends FieldSelectorRequirementFluent<FieldSelectorRequirementBuilder> implements VisitableBuilder<FieldSelectorRequirement,FieldSelectorRequirementBuilder>{

  FieldSelectorRequirementFluent<?> fluent;

  public FieldSelectorRequirementBuilder() {
    this(new FieldSelectorRequirement());
  }
  
  public FieldSelectorRequirementBuilder(FieldSelectorRequirementFluent<?> fluent) {
    this(fluent, new FieldSelectorRequirement());
  }
  
  public FieldSelectorRequirementBuilder(FieldSelectorRequirement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FieldSelectorRequirementBuilder(FieldSelectorRequirementFluent<?> fluent,FieldSelectorRequirement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FieldSelectorRequirement build() {
    FieldSelectorRequirement buildable = new FieldSelectorRequirement(fluent.getKey(), fluent.getOperator(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}