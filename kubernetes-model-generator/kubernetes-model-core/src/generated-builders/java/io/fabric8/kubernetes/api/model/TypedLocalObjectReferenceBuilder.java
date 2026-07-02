package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TypedLocalObjectReferenceBuilder extends TypedLocalObjectReferenceFluent<TypedLocalObjectReferenceBuilder> implements VisitableBuilder<TypedLocalObjectReference,TypedLocalObjectReferenceBuilder>{

  TypedLocalObjectReferenceFluent<?> fluent;

  public TypedLocalObjectReferenceBuilder() {
    this(new TypedLocalObjectReference());
  }
  
  public TypedLocalObjectReferenceBuilder(TypedLocalObjectReferenceFluent<?> fluent) {
    this(fluent, new TypedLocalObjectReference());
  }
  
  public TypedLocalObjectReferenceBuilder(TypedLocalObjectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TypedLocalObjectReferenceBuilder(TypedLocalObjectReferenceFluent<?> fluent,TypedLocalObjectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TypedLocalObjectReference build() {
    TypedLocalObjectReference buildable = new TypedLocalObjectReference(fluent.getApiGroup(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}