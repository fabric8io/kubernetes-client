package io.fabric8.istio.api.networking.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadGroupListBuilder extends WorkloadGroupListFluent<WorkloadGroupListBuilder> implements VisitableBuilder<WorkloadGroupList,WorkloadGroupListBuilder>{

  WorkloadGroupListFluent<?> fluent;

  public WorkloadGroupListBuilder() {
    this(new WorkloadGroupList());
  }
  
  public WorkloadGroupListBuilder(WorkloadGroupListFluent<?> fluent) {
    this(fluent, new WorkloadGroupList());
  }
  
  public WorkloadGroupListBuilder(WorkloadGroupList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadGroupListBuilder(WorkloadGroupListFluent<?> fluent,WorkloadGroupList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadGroupList build() {
    WorkloadGroupList buildable = new WorkloadGroupList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}