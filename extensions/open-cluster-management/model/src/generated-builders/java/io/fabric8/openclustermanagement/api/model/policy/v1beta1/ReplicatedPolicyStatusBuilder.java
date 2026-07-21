package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicatedPolicyStatusBuilder extends ReplicatedPolicyStatusFluent<ReplicatedPolicyStatusBuilder> implements VisitableBuilder<ReplicatedPolicyStatus,ReplicatedPolicyStatusBuilder>{

  ReplicatedPolicyStatusFluent<?> fluent;

  public ReplicatedPolicyStatusBuilder() {
    this(new ReplicatedPolicyStatus());
  }
  
  public ReplicatedPolicyStatusBuilder(ReplicatedPolicyStatusFluent<?> fluent) {
    this(fluent, new ReplicatedPolicyStatus());
  }
  
  public ReplicatedPolicyStatusBuilder(ReplicatedPolicyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicatedPolicyStatusBuilder(ReplicatedPolicyStatusFluent<?> fluent,ReplicatedPolicyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicatedPolicyStatus build() {
    ReplicatedPolicyStatus buildable = new ReplicatedPolicyStatus(fluent.getCompliant(), fluent.buildDetails(), fluent.getViolationMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}