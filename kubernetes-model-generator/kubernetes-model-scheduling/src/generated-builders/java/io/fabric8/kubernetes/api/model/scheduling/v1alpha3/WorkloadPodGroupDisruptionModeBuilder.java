package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadPodGroupDisruptionModeBuilder extends WorkloadPodGroupDisruptionModeFluent<WorkloadPodGroupDisruptionModeBuilder> implements VisitableBuilder<WorkloadPodGroupDisruptionMode,WorkloadPodGroupDisruptionModeBuilder>{

  WorkloadPodGroupDisruptionModeFluent<?> fluent;

  public WorkloadPodGroupDisruptionModeBuilder() {
    this(new WorkloadPodGroupDisruptionMode());
  }
  
  public WorkloadPodGroupDisruptionModeBuilder(WorkloadPodGroupDisruptionModeFluent<?> fluent) {
    this(fluent, new WorkloadPodGroupDisruptionMode());
  }
  
  public WorkloadPodGroupDisruptionModeBuilder(WorkloadPodGroupDisruptionMode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadPodGroupDisruptionModeBuilder(WorkloadPodGroupDisruptionModeFluent<?> fluent,WorkloadPodGroupDisruptionMode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadPodGroupDisruptionMode build() {
    WorkloadPodGroupDisruptionMode buildable = new WorkloadPodGroupDisruptionMode(fluent.buildAll(), fluent.buildSingle());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}