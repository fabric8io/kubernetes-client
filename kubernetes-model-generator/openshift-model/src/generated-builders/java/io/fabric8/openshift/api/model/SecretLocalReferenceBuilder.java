package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretLocalReferenceBuilder extends SecretLocalReferenceFluent<SecretLocalReferenceBuilder> implements VisitableBuilder<SecretLocalReference,SecretLocalReferenceBuilder>{

  SecretLocalReferenceFluent<?> fluent;

  public SecretLocalReferenceBuilder() {
    this(new SecretLocalReference());
  }
  
  public SecretLocalReferenceBuilder(SecretLocalReferenceFluent<?> fluent) {
    this(fluent, new SecretLocalReference());
  }
  
  public SecretLocalReferenceBuilder(SecretLocalReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretLocalReferenceBuilder(SecretLocalReferenceFluent<?> fluent,SecretLocalReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretLocalReference build() {
    SecretLocalReference buildable = new SecretLocalReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}