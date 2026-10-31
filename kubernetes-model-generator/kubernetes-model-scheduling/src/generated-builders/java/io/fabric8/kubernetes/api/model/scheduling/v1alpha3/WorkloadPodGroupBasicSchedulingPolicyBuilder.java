package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadPodGroupBasicSchedulingPolicyBuilder extends WorkloadPodGroupBasicSchedulingPolicyFluent<WorkloadPodGroupBasicSchedulingPolicyBuilder> implements VisitableBuilder<WorkloadPodGroupBasicSchedulingPolicy,WorkloadPodGroupBasicSchedulingPolicyBuilder>{

  WorkloadPodGroupBasicSchedulingPolicyFluent<?> fluent;

  public WorkloadPodGroupBasicSchedulingPolicyBuilder() {
    this(new WorkloadPodGroupBasicSchedulingPolicy());
  }
  
  public WorkloadPodGroupBasicSchedulingPolicyBuilder(WorkloadPodGroupBasicSchedulingPolicyFluent<?> fluent) {
    this(fluent, new WorkloadPodGroupBasicSchedulingPolicy());
  }
  
  public WorkloadPodGroupBasicSchedulingPolicyBuilder(WorkloadPodGroupBasicSchedulingPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadPodGroupBasicSchedulingPolicyBuilder(WorkloadPodGroupBasicSchedulingPolicyFluent<?> fluent,WorkloadPodGroupBasicSchedulingPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadPodGroupBasicSchedulingPolicy build() {
    WorkloadPodGroupBasicSchedulingPolicy buildable = new WorkloadPodGroupBasicSchedulingPolicy();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}