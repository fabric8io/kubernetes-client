package io.fabric8.istio.api.api.type.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadSelectorBuilder extends WorkloadSelectorFluent<WorkloadSelectorBuilder> implements VisitableBuilder<WorkloadSelector,WorkloadSelectorBuilder>{

  WorkloadSelectorFluent<?> fluent;

  public WorkloadSelectorBuilder() {
    this(new WorkloadSelector());
  }
  
  public WorkloadSelectorBuilder(WorkloadSelectorFluent<?> fluent) {
    this(fluent, new WorkloadSelector());
  }
  
  public WorkloadSelectorBuilder(WorkloadSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadSelectorBuilder(WorkloadSelectorFluent<?> fluent,WorkloadSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadSelector build() {
    WorkloadSelector buildable = new WorkloadSelector(fluent.getMatchLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}