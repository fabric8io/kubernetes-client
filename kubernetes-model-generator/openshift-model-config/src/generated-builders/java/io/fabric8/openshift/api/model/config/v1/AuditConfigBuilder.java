package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuditConfigBuilder extends AuditConfigFluent<AuditConfigBuilder> implements VisitableBuilder<AuditConfig,AuditConfigBuilder>{

  AuditConfigFluent<?> fluent;

  public AuditConfigBuilder() {
    this(new AuditConfig());
  }
  
  public AuditConfigBuilder(AuditConfigFluent<?> fluent) {
    this(fluent, new AuditConfig());
  }
  
  public AuditConfigBuilder(AuditConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuditConfigBuilder(AuditConfigFluent<?> fluent,AuditConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuditConfig build() {
    AuditConfig buildable = new AuditConfig(fluent.getAuditFilePath(), fluent.getEnabled(), fluent.getLogFormat(), fluent.getMaximumFileRetentionDays(), fluent.getMaximumFileSizeMegabytes(), fluent.getMaximumRetainedFiles(), fluent.getPolicyConfiguration(), fluent.getPolicyFile(), fluent.getWebHookKubeConfig(), fluent.getWebHookMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}