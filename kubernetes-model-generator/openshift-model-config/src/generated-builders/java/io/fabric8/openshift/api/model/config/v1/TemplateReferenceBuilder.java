package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TemplateReferenceBuilder extends TemplateReferenceFluent<TemplateReferenceBuilder> implements VisitableBuilder<TemplateReference,TemplateReferenceBuilder>{

  TemplateReferenceFluent<?> fluent;

  public TemplateReferenceBuilder() {
    this(new TemplateReference());
  }
  
  public TemplateReferenceBuilder(TemplateReferenceFluent<?> fluent) {
    this(fluent, new TemplateReference());
  }
  
  public TemplateReferenceBuilder(TemplateReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TemplateReferenceBuilder(TemplateReferenceFluent<?> fluent,TemplateReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TemplateReference build() {
    TemplateReference buildable = new TemplateReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}