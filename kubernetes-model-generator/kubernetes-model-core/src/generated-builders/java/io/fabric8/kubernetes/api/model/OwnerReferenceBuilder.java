package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OwnerReferenceBuilder extends OwnerReferenceFluent<OwnerReferenceBuilder> implements VisitableBuilder<OwnerReference,OwnerReferenceBuilder>{

  OwnerReferenceFluent<?> fluent;

  public OwnerReferenceBuilder() {
    this(new OwnerReference());
  }
  
  public OwnerReferenceBuilder(OwnerReferenceFluent<?> fluent) {
    this(fluent, new OwnerReference());
  }
  
  public OwnerReferenceBuilder(OwnerReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OwnerReferenceBuilder(OwnerReferenceFluent<?> fluent,OwnerReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OwnerReference build() {
    OwnerReference buildable = new OwnerReference(fluent.getApiVersion(), fluent.getBlockOwnerDeletion(), fluent.getController(), fluent.getKind(), fluent.getName(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}