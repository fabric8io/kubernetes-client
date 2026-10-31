package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VaultAWSAuthBuilder extends VaultAWSAuthFluent<VaultAWSAuthBuilder> implements VisitableBuilder<VaultAWSAuth,VaultAWSAuthBuilder>{

  VaultAWSAuthFluent<?> fluent;

  public VaultAWSAuthBuilder() {
    this(new VaultAWSAuth());
  }
  
  public VaultAWSAuthBuilder(VaultAWSAuthFluent<?> fluent) {
    this(fluent, new VaultAWSAuth());
  }
  
  public VaultAWSAuthBuilder(VaultAWSAuth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VaultAWSAuthBuilder(VaultAWSAuthFluent<?> fluent,VaultAWSAuth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VaultAWSAuth build() {
    VaultAWSAuth buildable = new VaultAWSAuth(fluent.getIamRoleArn(), fluent.getMountPath(), fluent.getRegion(), fluent.getRole(), fluent.buildServiceAccountRef(), fluent.getVaultHeaderValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}