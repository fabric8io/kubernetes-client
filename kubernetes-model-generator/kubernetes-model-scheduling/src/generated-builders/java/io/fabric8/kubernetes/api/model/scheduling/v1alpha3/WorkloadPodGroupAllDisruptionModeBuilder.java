package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadPodGroupAllDisruptionModeBuilder extends WorkloadPodGroupAllDisruptionModeFluent<WorkloadPodGroupAllDisruptionModeBuilder> implements VisitableBuilder<WorkloadPodGroupAllDisruptionMode,WorkloadPodGroupAllDisruptionModeBuilder>{

  WorkloadPodGroupAllDisruptionModeFluent<?> fluent;

  public WorkloadPodGroupAllDisruptionModeBuilder() {
    this(new WorkloadPodGroupAllDisruptionMode());
  }
  
  public WorkloadPodGroupAllDisruptionModeBuilder(WorkloadPodGroupAllDisruptionModeFluent<?> fluent) {
    this(fluent, new WorkloadPodGroupAllDisruptionMode());
  }
  
  public WorkloadPodGroupAllDisruptionModeBuilder(WorkloadPodGroupAllDisruptionMode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadPodGroupAllDisruptionModeBuilder(WorkloadPodGroupAllDisruptionModeFluent<?> fluent,WorkloadPodGroupAllDisruptionMode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadPodGroupAllDisruptionMode build() {
    WorkloadPodGroupAllDisruptionMode buildable = new WorkloadPodGroupAllDisruptionMode();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}