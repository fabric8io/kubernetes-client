package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretNameReferenceBuilder extends SecretNameReferenceFluent<SecretNameReferenceBuilder> implements VisitableBuilder<SecretNameReference,SecretNameReferenceBuilder>{

  SecretNameReferenceFluent<?> fluent;

  public SecretNameReferenceBuilder() {
    this(new SecretNameReference());
  }
  
  public SecretNameReferenceBuilder(SecretNameReferenceFluent<?> fluent) {
    this(fluent, new SecretNameReference());
  }
  
  public SecretNameReferenceBuilder(SecretNameReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretNameReferenceBuilder(SecretNameReferenceFluent<?> fluent,SecretNameReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretNameReference build() {
    SecretNameReference buildable = new SecretNameReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}