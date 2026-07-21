package io.fabric8.istio.api.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadEntryBuilder extends WorkloadEntryFluent<WorkloadEntryBuilder> implements VisitableBuilder<WorkloadEntry,WorkloadEntryBuilder>{

  WorkloadEntryFluent<?> fluent;

  public WorkloadEntryBuilder() {
    this(new WorkloadEntry());
  }
  
  public WorkloadEntryBuilder(WorkloadEntryFluent<?> fluent) {
    this(fluent, new WorkloadEntry());
  }
  
  public WorkloadEntryBuilder(WorkloadEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadEntryBuilder(WorkloadEntryFluent<?> fluent,WorkloadEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadEntry build() {
    WorkloadEntry buildable = new WorkloadEntry(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}