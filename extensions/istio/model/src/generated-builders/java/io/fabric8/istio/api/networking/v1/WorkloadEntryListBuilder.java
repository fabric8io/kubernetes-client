package io.fabric8.istio.api.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadEntryListBuilder extends WorkloadEntryListFluent<WorkloadEntryListBuilder> implements VisitableBuilder<WorkloadEntryList,WorkloadEntryListBuilder>{

  WorkloadEntryListFluent<?> fluent;

  public WorkloadEntryListBuilder() {
    this(new WorkloadEntryList());
  }
  
  public WorkloadEntryListBuilder(WorkloadEntryListFluent<?> fluent) {
    this(fluent, new WorkloadEntryList());
  }
  
  public WorkloadEntryListBuilder(WorkloadEntryList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadEntryListBuilder(WorkloadEntryListFluent<?> fluent,WorkloadEntryList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadEntryList build() {
    WorkloadEntryList buildable = new WorkloadEntryList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}