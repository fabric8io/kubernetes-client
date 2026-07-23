package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CredentialBuilder extends CredentialFluent<CredentialBuilder> implements VisitableBuilder<Credential,CredentialBuilder>{

  CredentialFluent<?> fluent;

  public CredentialBuilder() {
    this(new Credential());
  }
  
  public CredentialBuilder(CredentialFluent<?> fluent) {
    this(fluent, new Credential());
  }
  
  public CredentialBuilder(Credential instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CredentialBuilder(CredentialFluent<?> fluent,Credential instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Credential build() {
    Credential buildable = new Credential(fluent.getAddress(), fluent.getCertificateVerification(), fluent.getHostName(), fluent.getPassword(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}