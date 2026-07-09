package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadPodGroupTemplateReferenceBuilder extends WorkloadPodGroupTemplateReferenceFluent<WorkloadPodGroupTemplateReferenceBuilder> implements VisitableBuilder<WorkloadPodGroupTemplateReference,WorkloadPodGroupTemplateReferenceBuilder>{

  WorkloadPodGroupTemplateReferenceFluent<?> fluent;

  public WorkloadPodGroupTemplateReferenceBuilder() {
    this(new WorkloadPodGroupTemplateReference());
  }
  
  public WorkloadPodGroupTemplateReferenceBuilder(WorkloadPodGroupTemplateReferenceFluent<?> fluent) {
    this(fluent, new WorkloadPodGroupTemplateReference());
  }
  
  public WorkloadPodGroupTemplateReferenceBuilder(WorkloadPodGroupTemplateReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadPodGroupTemplateReferenceBuilder(WorkloadPodGroupTemplateReferenceFluent<?> fluent,WorkloadPodGroupTemplateReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadPodGroupTemplateReference build() {
    WorkloadPodGroupTemplateReference buildable = new WorkloadPodGroupTemplateReference(fluent.getPodGroupTemplateName(), fluent.getWorkloadName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}