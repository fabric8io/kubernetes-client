package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SignatureSubjectBuilder extends SignatureSubjectFluent<SignatureSubjectBuilder> implements VisitableBuilder<SignatureSubject,SignatureSubjectBuilder>{

  SignatureSubjectFluent<?> fluent;

  public SignatureSubjectBuilder() {
    this(new SignatureSubject());
  }
  
  public SignatureSubjectBuilder(SignatureSubjectFluent<?> fluent) {
    this(fluent, new SignatureSubject());
  }
  
  public SignatureSubjectBuilder(SignatureSubject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SignatureSubjectBuilder(SignatureSubjectFluent<?> fluent,SignatureSubject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SignatureSubject build() {
    SignatureSubject buildable = new SignatureSubject(fluent.getCommonName(), fluent.getOrganization(), fluent.getPublicKeyID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}