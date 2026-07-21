package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParallelStatusBuilder extends ParallelStatusFluent<ParallelStatusBuilder> implements VisitableBuilder<ParallelStatus,ParallelStatusBuilder>{

  ParallelStatusFluent<?> fluent;

  public ParallelStatusBuilder() {
    this(new ParallelStatus());
  }
  
  public ParallelStatusBuilder(ParallelStatusFluent<?> fluent) {
    this(fluent, new ParallelStatus());
  }
  
  public ParallelStatusBuilder(ParallelStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParallelStatusBuilder(ParallelStatusFluent<?> fluent,ParallelStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParallelStatus build() {
    ParallelStatus buildable = new ParallelStatus(fluent.buildAddress(), fluent.buildAddresses(), fluent.getAnnotations(), fluent.buildAuth(), fluent.buildBranchStatuses(), fluent.buildConditions(), fluent.buildIngressChannelStatus(), fluent.getObservedGeneration(), fluent.buildPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}