package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadBindingBuilder extends WorkloadBindingFluent<WorkloadBindingBuilder> implements VisitableBuilder<WorkloadBinding,WorkloadBindingBuilder>{

  WorkloadBindingFluent<?> fluent;

  public WorkloadBindingBuilder() {
    this(new WorkloadBinding());
  }
  
  public WorkloadBindingBuilder(WorkloadBindingFluent<?> fluent) {
    this(fluent, new WorkloadBinding());
  }
  
  public WorkloadBindingBuilder(WorkloadBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadBindingBuilder(WorkloadBindingFluent<?> fluent,WorkloadBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadBinding build() {
    WorkloadBinding buildable = new WorkloadBinding(fluent.buildConditions(), fluent.getGroup(), fluent.getName(), fluent.getNamespace(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}