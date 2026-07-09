package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretObjectReferenceBuilder extends SecretObjectReferenceFluent<SecretObjectReferenceBuilder> implements VisitableBuilder<SecretObjectReference,SecretObjectReferenceBuilder>{

  SecretObjectReferenceFluent<?> fluent;

  public SecretObjectReferenceBuilder() {
    this(new SecretObjectReference());
  }
  
  public SecretObjectReferenceBuilder(SecretObjectReferenceFluent<?> fluent) {
    this(fluent, new SecretObjectReference());
  }
  
  public SecretObjectReferenceBuilder(SecretObjectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretObjectReferenceBuilder(SecretObjectReferenceFluent<?> fluent,SecretObjectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretObjectReference build() {
    SecretObjectReference buildable = new SecretObjectReference(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}