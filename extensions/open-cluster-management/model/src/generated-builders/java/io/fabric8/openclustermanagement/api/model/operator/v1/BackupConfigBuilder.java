package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BackupConfigBuilder extends BackupConfigFluent<BackupConfigBuilder> implements VisitableBuilder<BackupConfig,BackupConfigBuilder>{

  BackupConfigFluent<?> fluent;

  public BackupConfigBuilder() {
    this(new BackupConfig());
  }
  
  public BackupConfigBuilder(BackupConfigFluent<?> fluent) {
    this(fluent, new BackupConfig());
  }
  
  public BackupConfigBuilder(BackupConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BackupConfigBuilder(BackupConfigFluent<?> fluent,BackupConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BackupConfig build() {
    BackupConfig buildable = new BackupConfig(fluent.getMinBackupPeriodSeconds(), fluent.buildVelero());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}