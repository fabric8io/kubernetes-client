package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadGroupObjectMetaBuilder extends WorkloadGroupObjectMetaFluent<WorkloadGroupObjectMetaBuilder> implements VisitableBuilder<WorkloadGroupObjectMeta,WorkloadGroupObjectMetaBuilder>{

  WorkloadGroupObjectMetaFluent<?> fluent;

  public WorkloadGroupObjectMetaBuilder() {
    this(new WorkloadGroupObjectMeta());
  }
  
  public WorkloadGroupObjectMetaBuilder(WorkloadGroupObjectMetaFluent<?> fluent) {
    this(fluent, new WorkloadGroupObjectMeta());
  }
  
  public WorkloadGroupObjectMetaBuilder(WorkloadGroupObjectMeta instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadGroupObjectMetaBuilder(WorkloadGroupObjectMetaFluent<?> fluent,WorkloadGroupObjectMeta instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadGroupObjectMeta build() {
    WorkloadGroupObjectMeta buildable = new WorkloadGroupObjectMeta(fluent.getAnnotations(), fluent.getLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}