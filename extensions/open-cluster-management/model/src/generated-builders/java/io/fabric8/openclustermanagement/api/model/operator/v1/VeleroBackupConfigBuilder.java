package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VeleroBackupConfigBuilder extends VeleroBackupConfigFluent<VeleroBackupConfigBuilder> implements VisitableBuilder<VeleroBackupConfig,VeleroBackupConfigBuilder>{

  VeleroBackupConfigFluent<?> fluent;

  public VeleroBackupConfigBuilder() {
    this(new VeleroBackupConfig());
  }
  
  public VeleroBackupConfigBuilder(VeleroBackupConfigFluent<?> fluent) {
    this(fluent, new VeleroBackupConfig());
  }
  
  public VeleroBackupConfigBuilder(VeleroBackupConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VeleroBackupConfigBuilder(VeleroBackupConfigFluent<?> fluent,VeleroBackupConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VeleroBackupConfig build() {
    VeleroBackupConfig buildable = new VeleroBackupConfig(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}