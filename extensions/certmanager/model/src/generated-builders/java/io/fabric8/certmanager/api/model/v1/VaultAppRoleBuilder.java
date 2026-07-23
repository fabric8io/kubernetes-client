package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VaultAppRoleBuilder extends VaultAppRoleFluent<VaultAppRoleBuilder> implements VisitableBuilder<VaultAppRole,VaultAppRoleBuilder>{

  VaultAppRoleFluent<?> fluent;

  public VaultAppRoleBuilder() {
    this(new VaultAppRole());
  }
  
  public VaultAppRoleBuilder(VaultAppRoleFluent<?> fluent) {
    this(fluent, new VaultAppRole());
  }
  
  public VaultAppRoleBuilder(VaultAppRole instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VaultAppRoleBuilder(VaultAppRoleFluent<?> fluent,VaultAppRole instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VaultAppRole build() {
    VaultAppRole buildable = new VaultAppRole(fluent.getPath(), fluent.getRoleId(), fluent.buildSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}