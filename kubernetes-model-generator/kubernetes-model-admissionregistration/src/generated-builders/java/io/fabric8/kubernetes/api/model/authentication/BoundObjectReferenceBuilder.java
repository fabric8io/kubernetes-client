package io.fabric8.kubernetes.api.model.authentication;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BoundObjectReferenceBuilder extends BoundObjectReferenceFluent<BoundObjectReferenceBuilder> implements VisitableBuilder<BoundObjectReference,BoundObjectReferenceBuilder>{

  BoundObjectReferenceFluent<?> fluent;

  public BoundObjectReferenceBuilder() {
    this(new BoundObjectReference());
  }
  
  public BoundObjectReferenceBuilder(BoundObjectReferenceFluent<?> fluent) {
    this(fluent, new BoundObjectReference());
  }
  
  public BoundObjectReferenceBuilder(BoundObjectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BoundObjectReferenceBuilder(BoundObjectReferenceFluent<?> fluent,BoundObjectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BoundObjectReference build() {
    BoundObjectReference buildable = new BoundObjectReference(fluent.getApiVersion(), fluent.getKind(), fluent.getName(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}