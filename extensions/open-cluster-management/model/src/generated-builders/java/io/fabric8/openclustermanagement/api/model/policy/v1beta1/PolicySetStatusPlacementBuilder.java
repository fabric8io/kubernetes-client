package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicySetStatusPlacementBuilder extends PolicySetStatusPlacementFluent<PolicySetStatusPlacementBuilder> implements VisitableBuilder<PolicySetStatusPlacement,PolicySetStatusPlacementBuilder>{

  PolicySetStatusPlacementFluent<?> fluent;

  public PolicySetStatusPlacementBuilder() {
    this(new PolicySetStatusPlacement());
  }
  
  public PolicySetStatusPlacementBuilder(PolicySetStatusPlacementFluent<?> fluent) {
    this(fluent, new PolicySetStatusPlacement());
  }
  
  public PolicySetStatusPlacementBuilder(PolicySetStatusPlacement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicySetStatusPlacementBuilder(PolicySetStatusPlacementFluent<?> fluent,PolicySetStatusPlacement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicySetStatusPlacement build() {
    PolicySetStatusPlacement buildable = new PolicySetStatusPlacement(fluent.getPlacement(), fluent.getPlacementBinding(), fluent.getPlacementRule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}