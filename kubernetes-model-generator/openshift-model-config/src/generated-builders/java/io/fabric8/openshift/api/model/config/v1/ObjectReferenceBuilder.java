package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ObjectReferenceBuilder extends ObjectReferenceFluent<ObjectReferenceBuilder> implements VisitableBuilder<ObjectReference,ObjectReferenceBuilder>{

  ObjectReferenceFluent<?> fluent;

  public ObjectReferenceBuilder() {
    this(new ObjectReference());
  }
  
  public ObjectReferenceBuilder(ObjectReferenceFluent<?> fluent) {
    this(fluent, new ObjectReference());
  }
  
  public ObjectReferenceBuilder(ObjectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ObjectReferenceBuilder(ObjectReferenceFluent<?> fluent,ObjectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ObjectReference build() {
    ObjectReference buildable = new ObjectReference(fluent.getGroup(), fluent.getName(), fluent.getNamespace(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}