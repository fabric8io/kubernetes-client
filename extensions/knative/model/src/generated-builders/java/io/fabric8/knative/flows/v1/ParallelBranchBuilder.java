package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParallelBranchBuilder extends ParallelBranchFluent<ParallelBranchBuilder> implements VisitableBuilder<ParallelBranch,ParallelBranchBuilder>{

  ParallelBranchFluent<?> fluent;

  public ParallelBranchBuilder() {
    this(new ParallelBranch());
  }
  
  public ParallelBranchBuilder(ParallelBranchFluent<?> fluent) {
    this(fluent, new ParallelBranch());
  }
  
  public ParallelBranchBuilder(ParallelBranch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParallelBranchBuilder(ParallelBranchFluent<?> fluent,ParallelBranch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParallelBranch build() {
    ParallelBranch buildable = new ParallelBranch(fluent.buildDelivery(), fluent.buildFilter(), fluent.buildReply(), fluent.buildSubscriber());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}