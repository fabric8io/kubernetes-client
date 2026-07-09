package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadBuilder extends WorkloadFluent<WorkloadBuilder> implements VisitableBuilder<Workload,WorkloadBuilder>{

  WorkloadFluent<?> fluent;

  public WorkloadBuilder() {
    this(new Workload());
  }
  
  public WorkloadBuilder(WorkloadFluent<?> fluent) {
    this(fluent, new Workload());
  }
  
  public WorkloadBuilder(Workload instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadBuilder(WorkloadFluent<?> fluent,Workload instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Workload build() {
    Workload buildable = new Workload(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}