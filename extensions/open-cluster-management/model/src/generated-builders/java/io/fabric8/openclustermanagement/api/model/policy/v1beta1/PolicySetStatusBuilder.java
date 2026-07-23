package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicySetStatusBuilder extends PolicySetStatusFluent<PolicySetStatusBuilder> implements VisitableBuilder<PolicySetStatus,PolicySetStatusBuilder>{

  PolicySetStatusFluent<?> fluent;

  public PolicySetStatusBuilder() {
    this(new PolicySetStatus());
  }
  
  public PolicySetStatusBuilder(PolicySetStatusFluent<?> fluent) {
    this(fluent, new PolicySetStatus());
  }
  
  public PolicySetStatusBuilder(PolicySetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicySetStatusBuilder(PolicySetStatusFluent<?> fluent,PolicySetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicySetStatus build() {
    PolicySetStatus buildable = new PolicySetStatus(fluent.getCompliant(), fluent.buildPlacement(), fluent.getStatusMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}