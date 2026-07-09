package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyAncestorStatusBuilder extends PolicyAncestorStatusFluent<PolicyAncestorStatusBuilder> implements VisitableBuilder<PolicyAncestorStatus,PolicyAncestorStatusBuilder>{

  PolicyAncestorStatusFluent<?> fluent;

  public PolicyAncestorStatusBuilder() {
    this(new PolicyAncestorStatus());
  }
  
  public PolicyAncestorStatusBuilder(PolicyAncestorStatusFluent<?> fluent) {
    this(fluent, new PolicyAncestorStatus());
  }
  
  public PolicyAncestorStatusBuilder(PolicyAncestorStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyAncestorStatusBuilder(PolicyAncestorStatusFluent<?> fluent,PolicyAncestorStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyAncestorStatus build() {
    PolicyAncestorStatus buildable = new PolicyAncestorStatus(fluent.buildAncestorRef(), fluent.getConditions(), fluent.getControllerName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}