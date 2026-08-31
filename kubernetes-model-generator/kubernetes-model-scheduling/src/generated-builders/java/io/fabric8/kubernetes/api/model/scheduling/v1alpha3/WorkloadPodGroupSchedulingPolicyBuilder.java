package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadPodGroupSchedulingPolicyBuilder extends WorkloadPodGroupSchedulingPolicyFluent<WorkloadPodGroupSchedulingPolicyBuilder> implements VisitableBuilder<WorkloadPodGroupSchedulingPolicy,WorkloadPodGroupSchedulingPolicyBuilder>{

  WorkloadPodGroupSchedulingPolicyFluent<?> fluent;

  public WorkloadPodGroupSchedulingPolicyBuilder() {
    this(new WorkloadPodGroupSchedulingPolicy());
  }
  
  public WorkloadPodGroupSchedulingPolicyBuilder(WorkloadPodGroupSchedulingPolicyFluent<?> fluent) {
    this(fluent, new WorkloadPodGroupSchedulingPolicy());
  }
  
  public WorkloadPodGroupSchedulingPolicyBuilder(WorkloadPodGroupSchedulingPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadPodGroupSchedulingPolicyBuilder(WorkloadPodGroupSchedulingPolicyFluent<?> fluent,WorkloadPodGroupSchedulingPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadPodGroupSchedulingPolicy build() {
    WorkloadPodGroupSchedulingPolicy buildable = new WorkloadPodGroupSchedulingPolicy(fluent.buildBasic(), fluent.buildGang());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}