package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadListBuilder extends WorkloadListFluent<WorkloadListBuilder> implements VisitableBuilder<WorkloadList,WorkloadListBuilder>{

  WorkloadListFluent<?> fluent;

  public WorkloadListBuilder() {
    this(new WorkloadList());
  }
  
  public WorkloadListBuilder(WorkloadListFluent<?> fluent) {
    this(fluent, new WorkloadList());
  }
  
  public WorkloadListBuilder(WorkloadList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadListBuilder(WorkloadListFluent<?> fluent,WorkloadList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadList build() {
    WorkloadList buildable = new WorkloadList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}