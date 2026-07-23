package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RedirectReferenceBuilder extends RedirectReferenceFluent<RedirectReferenceBuilder> implements VisitableBuilder<RedirectReference,RedirectReferenceBuilder>{

  RedirectReferenceFluent<?> fluent;

  public RedirectReferenceBuilder() {
    this(new RedirectReference());
  }
  
  public RedirectReferenceBuilder(RedirectReferenceFluent<?> fluent) {
    this(fluent, new RedirectReference());
  }
  
  public RedirectReferenceBuilder(RedirectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RedirectReferenceBuilder(RedirectReferenceFluent<?> fluent,RedirectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RedirectReference build() {
    RedirectReference buildable = new RedirectReference(fluent.getGroup(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}