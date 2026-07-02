package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LabelSelectorRequirementBuilder extends LabelSelectorRequirementFluent<LabelSelectorRequirementBuilder> implements VisitableBuilder<LabelSelectorRequirement,LabelSelectorRequirementBuilder>{

  LabelSelectorRequirementFluent<?> fluent;

  public LabelSelectorRequirementBuilder() {
    this(new LabelSelectorRequirement());
  }
  
  public LabelSelectorRequirementBuilder(LabelSelectorRequirementFluent<?> fluent) {
    this(fluent, new LabelSelectorRequirement());
  }
  
  public LabelSelectorRequirementBuilder(LabelSelectorRequirement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LabelSelectorRequirementBuilder(LabelSelectorRequirementFluent<?> fluent,LabelSelectorRequirement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LabelSelectorRequirement build() {
    LabelSelectorRequirement buildable = new LabelSelectorRequirement(fluent.getKey(), fluent.getOperator(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}