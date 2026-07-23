package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyStatusBuilder extends PolicyStatusFluent<PolicyStatusBuilder> implements VisitableBuilder<PolicyStatus,PolicyStatusBuilder>{

  PolicyStatusFluent<?> fluent;

  public PolicyStatusBuilder() {
    this(new PolicyStatus());
  }
  
  public PolicyStatusBuilder(PolicyStatusFluent<?> fluent) {
    this(fluent, new PolicyStatus());
  }
  
  public PolicyStatusBuilder(PolicyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyStatusBuilder(PolicyStatusFluent<?> fluent,PolicyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyStatus build() {
    PolicyStatus buildable = new PolicyStatus(fluent.buildAncestors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}