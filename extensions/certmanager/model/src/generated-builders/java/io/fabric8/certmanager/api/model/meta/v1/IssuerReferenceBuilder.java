package io.fabric8.certmanager.api.model.meta.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IssuerReferenceBuilder extends IssuerReferenceFluent<IssuerReferenceBuilder> implements VisitableBuilder<IssuerReference,IssuerReferenceBuilder>{

  IssuerReferenceFluent<?> fluent;

  public IssuerReferenceBuilder() {
    this(new IssuerReference());
  }
  
  public IssuerReferenceBuilder(IssuerReferenceFluent<?> fluent) {
    this(fluent, new IssuerReference());
  }
  
  public IssuerReferenceBuilder(IssuerReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IssuerReferenceBuilder(IssuerReferenceFluent<?> fluent,IssuerReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IssuerReference build() {
    IssuerReference buildable = new IssuerReference(fluent.getGroup(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}