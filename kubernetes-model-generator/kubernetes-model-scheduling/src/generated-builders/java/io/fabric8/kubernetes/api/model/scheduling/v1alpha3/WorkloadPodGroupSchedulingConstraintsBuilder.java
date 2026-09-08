package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadPodGroupSchedulingConstraintsBuilder extends WorkloadPodGroupSchedulingConstraintsFluent<WorkloadPodGroupSchedulingConstraintsBuilder> implements VisitableBuilder<WorkloadPodGroupSchedulingConstraints,WorkloadPodGroupSchedulingConstraintsBuilder>{

  WorkloadPodGroupSchedulingConstraintsFluent<?> fluent;

  public WorkloadPodGroupSchedulingConstraintsBuilder() {
    this(new WorkloadPodGroupSchedulingConstraints());
  }
  
  public WorkloadPodGroupSchedulingConstraintsBuilder(WorkloadPodGroupSchedulingConstraintsFluent<?> fluent) {
    this(fluent, new WorkloadPodGroupSchedulingConstraints());
  }
  
  public WorkloadPodGroupSchedulingConstraintsBuilder(WorkloadPodGroupSchedulingConstraints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadPodGroupSchedulingConstraintsBuilder(WorkloadPodGroupSchedulingConstraintsFluent<?> fluent,WorkloadPodGroupSchedulingConstraints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadPodGroupSchedulingConstraints build() {
    WorkloadPodGroupSchedulingConstraints buildable = new WorkloadPodGroupSchedulingConstraints(fluent.buildTopology());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}