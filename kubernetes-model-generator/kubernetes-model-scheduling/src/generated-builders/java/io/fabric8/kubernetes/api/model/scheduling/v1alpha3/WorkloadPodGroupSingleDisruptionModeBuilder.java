package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadPodGroupSingleDisruptionModeBuilder extends WorkloadPodGroupSingleDisruptionModeFluent<WorkloadPodGroupSingleDisruptionModeBuilder> implements VisitableBuilder<WorkloadPodGroupSingleDisruptionMode,WorkloadPodGroupSingleDisruptionModeBuilder>{

  WorkloadPodGroupSingleDisruptionModeFluent<?> fluent;

  public WorkloadPodGroupSingleDisruptionModeBuilder() {
    this(new WorkloadPodGroupSingleDisruptionMode());
  }
  
  public WorkloadPodGroupSingleDisruptionModeBuilder(WorkloadPodGroupSingleDisruptionModeFluent<?> fluent) {
    this(fluent, new WorkloadPodGroupSingleDisruptionMode());
  }
  
  public WorkloadPodGroupSingleDisruptionModeBuilder(WorkloadPodGroupSingleDisruptionMode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadPodGroupSingleDisruptionModeBuilder(WorkloadPodGroupSingleDisruptionModeFluent<?> fluent,WorkloadPodGroupSingleDisruptionMode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadPodGroupSingleDisruptionMode build() {
    WorkloadPodGroupSingleDisruptionMode buildable = new WorkloadPodGroupSingleDisruptionMode();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}