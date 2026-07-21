package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DecisionGroupStatusBuilder extends DecisionGroupStatusFluent<DecisionGroupStatusBuilder> implements VisitableBuilder<DecisionGroupStatus,DecisionGroupStatusBuilder>{

  DecisionGroupStatusFluent<?> fluent;

  public DecisionGroupStatusBuilder() {
    this(new DecisionGroupStatus());
  }
  
  public DecisionGroupStatusBuilder(DecisionGroupStatusFluent<?> fluent) {
    this(fluent, new DecisionGroupStatus());
  }
  
  public DecisionGroupStatusBuilder(DecisionGroupStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DecisionGroupStatusBuilder(DecisionGroupStatusFluent<?> fluent,DecisionGroupStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DecisionGroupStatus build() {
    DecisionGroupStatus buildable = new DecisionGroupStatus(fluent.getClusterCount(), fluent.getDecisionGroupIndex(), fluent.getDecisionGroupName(), fluent.getDecisions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}