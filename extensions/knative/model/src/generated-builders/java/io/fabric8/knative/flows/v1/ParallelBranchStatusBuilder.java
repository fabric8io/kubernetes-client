package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParallelBranchStatusBuilder extends ParallelBranchStatusFluent<ParallelBranchStatusBuilder> implements VisitableBuilder<ParallelBranchStatus,ParallelBranchStatusBuilder>{

  ParallelBranchStatusFluent<?> fluent;

  public ParallelBranchStatusBuilder() {
    this(new ParallelBranchStatus());
  }
  
  public ParallelBranchStatusBuilder(ParallelBranchStatusFluent<?> fluent) {
    this(fluent, new ParallelBranchStatus());
  }
  
  public ParallelBranchStatusBuilder(ParallelBranchStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParallelBranchStatusBuilder(ParallelBranchStatusFluent<?> fluent,ParallelBranchStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParallelBranchStatus build() {
    ParallelBranchStatus buildable = new ParallelBranchStatus(fluent.buildFilterChannelStatus(), fluent.buildFilterSubscriptionStatus(), fluent.buildSubscriberSubscriptionStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}