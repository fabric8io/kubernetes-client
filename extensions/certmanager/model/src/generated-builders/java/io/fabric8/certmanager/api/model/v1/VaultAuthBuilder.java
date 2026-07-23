package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VaultAuthBuilder extends VaultAuthFluent<VaultAuthBuilder> implements VisitableBuilder<VaultAuth,VaultAuthBuilder>{

  VaultAuthFluent<?> fluent;

  public VaultAuthBuilder() {
    this(new VaultAuth());
  }
  
  public VaultAuthBuilder(VaultAuthFluent<?> fluent) {
    this(fluent, new VaultAuth());
  }
  
  public VaultAuthBuilder(VaultAuth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VaultAuthBuilder(VaultAuthFluent<?> fluent,VaultAuth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VaultAuth build() {
    VaultAuth buildable = new VaultAuth(fluent.buildAppRole(), fluent.buildClientCertificate(), fluent.buildKubernetes(), fluent.buildTokenSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}