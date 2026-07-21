package io.fabric8.istio.api.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadGroupBuilder extends WorkloadGroupFluent<WorkloadGroupBuilder> implements VisitableBuilder<WorkloadGroup,WorkloadGroupBuilder>{

  WorkloadGroupFluent<?> fluent;

  public WorkloadGroupBuilder() {
    this(new WorkloadGroup());
  }
  
  public WorkloadGroupBuilder(WorkloadGroupFluent<?> fluent) {
    this(fluent, new WorkloadGroup());
  }
  
  public WorkloadGroupBuilder(WorkloadGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadGroupBuilder(WorkloadGroupFluent<?> fluent,WorkloadGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadGroup build() {
    WorkloadGroup buildable = new WorkloadGroup(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}