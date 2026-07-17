package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostSelectorRequirementBuilder extends HostSelectorRequirementFluent<HostSelectorRequirementBuilder> implements VisitableBuilder<HostSelectorRequirement,HostSelectorRequirementBuilder>{

  HostSelectorRequirementFluent<?> fluent;

  public HostSelectorRequirementBuilder() {
    this(new HostSelectorRequirement());
  }
  
  public HostSelectorRequirementBuilder(HostSelectorRequirementFluent<?> fluent) {
    this(fluent, new HostSelectorRequirement());
  }
  
  public HostSelectorRequirementBuilder(HostSelectorRequirement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostSelectorRequirementBuilder(HostSelectorRequirementFluent<?> fluent,HostSelectorRequirement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostSelectorRequirement build() {
    HostSelectorRequirement buildable = new HostSelectorRequirement(fluent.getKey(), fluent.getOperator(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}