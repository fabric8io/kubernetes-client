package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VaultKubernetesAuthBuilder extends VaultKubernetesAuthFluent<VaultKubernetesAuthBuilder> implements VisitableBuilder<VaultKubernetesAuth,VaultKubernetesAuthBuilder>{

  VaultKubernetesAuthFluent<?> fluent;

  public VaultKubernetesAuthBuilder() {
    this(new VaultKubernetesAuth());
  }
  
  public VaultKubernetesAuthBuilder(VaultKubernetesAuthFluent<?> fluent) {
    this(fluent, new VaultKubernetesAuth());
  }
  
  public VaultKubernetesAuthBuilder(VaultKubernetesAuth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VaultKubernetesAuthBuilder(VaultKubernetesAuthFluent<?> fluent,VaultKubernetesAuth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VaultKubernetesAuth build() {
    VaultKubernetesAuth buildable = new VaultKubernetesAuth(fluent.getMountPath(), fluent.getRole(), fluent.buildSecretRef(), fluent.buildServiceAccountRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}