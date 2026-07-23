package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadReferenceBuilder extends WorkloadReferenceFluent<WorkloadReferenceBuilder> implements VisitableBuilder<WorkloadReference,WorkloadReferenceBuilder>{

  WorkloadReferenceFluent<?> fluent;

  public WorkloadReferenceBuilder() {
    this(new WorkloadReference());
  }
  
  public WorkloadReferenceBuilder(WorkloadReferenceFluent<?> fluent) {
    this(fluent, new WorkloadReference());
  }
  
  public WorkloadReferenceBuilder(WorkloadReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadReferenceBuilder(WorkloadReferenceFluent<?> fluent,WorkloadReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadReference build() {
    WorkloadReference buildable = new WorkloadReference(fluent.getName(), fluent.getPodGroup(), fluent.getPodGroupReplicaKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}