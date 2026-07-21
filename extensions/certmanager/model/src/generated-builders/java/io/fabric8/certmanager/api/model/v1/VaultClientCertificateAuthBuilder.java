package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VaultClientCertificateAuthBuilder extends VaultClientCertificateAuthFluent<VaultClientCertificateAuthBuilder> implements VisitableBuilder<VaultClientCertificateAuth,VaultClientCertificateAuthBuilder>{

  VaultClientCertificateAuthFluent<?> fluent;

  public VaultClientCertificateAuthBuilder() {
    this(new VaultClientCertificateAuth());
  }
  
  public VaultClientCertificateAuthBuilder(VaultClientCertificateAuthFluent<?> fluent) {
    this(fluent, new VaultClientCertificateAuth());
  }
  
  public VaultClientCertificateAuthBuilder(VaultClientCertificateAuth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VaultClientCertificateAuthBuilder(VaultClientCertificateAuthFluent<?> fluent,VaultClientCertificateAuth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VaultClientCertificateAuth build() {
    VaultClientCertificateAuth buildable = new VaultClientCertificateAuth(fluent.getMountPath(), fluent.getName(), fluent.getSecretName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}