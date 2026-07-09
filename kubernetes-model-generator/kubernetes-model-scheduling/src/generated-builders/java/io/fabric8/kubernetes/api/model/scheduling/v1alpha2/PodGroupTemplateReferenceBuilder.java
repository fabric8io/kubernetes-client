package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupTemplateReferenceBuilder extends PodGroupTemplateReferenceFluent<PodGroupTemplateReferenceBuilder> implements VisitableBuilder<PodGroupTemplateReference,PodGroupTemplateReferenceBuilder>{

  PodGroupTemplateReferenceFluent<?> fluent;

  public PodGroupTemplateReferenceBuilder() {
    this(new PodGroupTemplateReference());
  }
  
  public PodGroupTemplateReferenceBuilder(PodGroupTemplateReferenceFluent<?> fluent) {
    this(fluent, new PodGroupTemplateReference());
  }
  
  public PodGroupTemplateReferenceBuilder(PodGroupTemplateReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupTemplateReferenceBuilder(PodGroupTemplateReferenceFluent<?> fluent,PodGroupTemplateReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupTemplateReference build() {
    PodGroupTemplateReference buildable = new PodGroupTemplateReference(fluent.buildWorkload());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}