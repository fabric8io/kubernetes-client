package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretReferenceBuilder extends SecretReferenceFluent<SecretReferenceBuilder> implements VisitableBuilder<SecretReference,SecretReferenceBuilder>{

  SecretReferenceFluent<?> fluent;

  public SecretReferenceBuilder() {
    this(new SecretReference());
  }
  
  public SecretReferenceBuilder(SecretReferenceFluent<?> fluent) {
    this(fluent, new SecretReference());
  }
  
  public SecretReferenceBuilder(SecretReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretReferenceBuilder(SecretReferenceFluent<?> fluent,SecretReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretReference build() {
    SecretReference buildable = new SecretReference(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}