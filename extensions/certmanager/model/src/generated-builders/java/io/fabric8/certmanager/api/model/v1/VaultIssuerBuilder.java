package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VaultIssuerBuilder extends VaultIssuerFluent<VaultIssuerBuilder> implements VisitableBuilder<VaultIssuer,VaultIssuerBuilder>{

  VaultIssuerFluent<?> fluent;

  public VaultIssuerBuilder() {
    this(new VaultIssuer());
  }
  
  public VaultIssuerBuilder(VaultIssuerFluent<?> fluent) {
    this(fluent, new VaultIssuer());
  }
  
  public VaultIssuerBuilder(VaultIssuer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VaultIssuerBuilder(VaultIssuerFluent<?> fluent,VaultIssuer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VaultIssuer build() {
    VaultIssuer buildable = new VaultIssuer(fluent.buildAuth(), fluent.getCaBundle(), fluent.buildCaBundleSecretRef(), fluent.buildClientCertSecretRef(), fluent.buildClientKeySecretRef(), fluent.getNamespace(), fluent.getPath(), fluent.getServer(), fluent.getServerName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}