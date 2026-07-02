package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TypedObjectReferenceBuilder extends TypedObjectReferenceFluent<TypedObjectReferenceBuilder> implements VisitableBuilder<TypedObjectReference,TypedObjectReferenceBuilder>{

  TypedObjectReferenceFluent<?> fluent;

  public TypedObjectReferenceBuilder() {
    this(new TypedObjectReference());
  }
  
  public TypedObjectReferenceBuilder(TypedObjectReferenceFluent<?> fluent) {
    this(fluent, new TypedObjectReference());
  }
  
  public TypedObjectReferenceBuilder(TypedObjectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TypedObjectReferenceBuilder(TypedObjectReferenceFluent<?> fluent,TypedObjectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TypedObjectReference build() {
    TypedObjectReference buildable = new TypedObjectReference(fluent.getApiGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}