package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadSpecBuilder extends WorkloadSpecFluent<WorkloadSpecBuilder> implements VisitableBuilder<WorkloadSpec,WorkloadSpecBuilder>{

  WorkloadSpecFluent<?> fluent;

  public WorkloadSpecBuilder() {
    this(new WorkloadSpec());
  }
  
  public WorkloadSpecBuilder(WorkloadSpecFluent<?> fluent) {
    this(fluent, new WorkloadSpec());
  }
  
  public WorkloadSpecBuilder(WorkloadSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadSpecBuilder(WorkloadSpecFluent<?> fluent,WorkloadSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadSpec build() {
    WorkloadSpec buildable = new WorkloadSpec(fluent.buildControllerRef(), fluent.buildPodGroupTemplates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}