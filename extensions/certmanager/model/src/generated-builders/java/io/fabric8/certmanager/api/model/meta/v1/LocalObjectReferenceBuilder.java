package io.fabric8.certmanager.api.model.meta.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LocalObjectReferenceBuilder extends LocalObjectReferenceFluent<LocalObjectReferenceBuilder> implements VisitableBuilder<LocalObjectReference,LocalObjectReferenceBuilder>{

  LocalObjectReferenceFluent<?> fluent;

  public LocalObjectReferenceBuilder() {
    this(new LocalObjectReference());
  }
  
  public LocalObjectReferenceBuilder(LocalObjectReferenceFluent<?> fluent) {
    this(fluent, new LocalObjectReference());
  }
  
  public LocalObjectReferenceBuilder(LocalObjectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LocalObjectReferenceBuilder(LocalObjectReferenceFluent<?> fluent,LocalObjectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LocalObjectReference build() {
    LocalObjectReference buildable = new LocalObjectReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}