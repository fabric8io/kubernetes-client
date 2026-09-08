package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadPodGroupGangSchedulingPolicyBuilder extends WorkloadPodGroupGangSchedulingPolicyFluent<WorkloadPodGroupGangSchedulingPolicyBuilder> implements VisitableBuilder<WorkloadPodGroupGangSchedulingPolicy,WorkloadPodGroupGangSchedulingPolicyBuilder>{

  WorkloadPodGroupGangSchedulingPolicyFluent<?> fluent;

  public WorkloadPodGroupGangSchedulingPolicyBuilder() {
    this(new WorkloadPodGroupGangSchedulingPolicy());
  }
  
  public WorkloadPodGroupGangSchedulingPolicyBuilder(WorkloadPodGroupGangSchedulingPolicyFluent<?> fluent) {
    this(fluent, new WorkloadPodGroupGangSchedulingPolicy());
  }
  
  public WorkloadPodGroupGangSchedulingPolicyBuilder(WorkloadPodGroupGangSchedulingPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadPodGroupGangSchedulingPolicyBuilder(WorkloadPodGroupGangSchedulingPolicyFluent<?> fluent,WorkloadPodGroupGangSchedulingPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadPodGroupGangSchedulingPolicy build() {
    WorkloadPodGroupGangSchedulingPolicy buildable = new WorkloadPodGroupGangSchedulingPolicy(fluent.getMinCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}