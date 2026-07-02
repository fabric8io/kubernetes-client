package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TopologySelectorLabelRequirementBuilder extends TopologySelectorLabelRequirementFluent<TopologySelectorLabelRequirementBuilder> implements VisitableBuilder<TopologySelectorLabelRequirement,TopologySelectorLabelRequirementBuilder>{

  TopologySelectorLabelRequirementFluent<?> fluent;

  public TopologySelectorLabelRequirementBuilder() {
    this(new TopologySelectorLabelRequirement());
  }
  
  public TopologySelectorLabelRequirementBuilder(TopologySelectorLabelRequirementFluent<?> fluent) {
    this(fluent, new TopologySelectorLabelRequirement());
  }
  
  public TopologySelectorLabelRequirementBuilder(TopologySelectorLabelRequirement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TopologySelectorLabelRequirementBuilder(TopologySelectorLabelRequirementFluent<?> fluent,TopologySelectorLabelRequirement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TopologySelectorLabelRequirement build() {
    TopologySelectorLabelRequirement buildable = new TopologySelectorLabelRequirement(fluent.getKey(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}