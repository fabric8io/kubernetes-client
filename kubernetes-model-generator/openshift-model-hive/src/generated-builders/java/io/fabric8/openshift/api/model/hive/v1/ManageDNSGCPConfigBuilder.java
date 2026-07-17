package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManageDNSGCPConfigBuilder extends ManageDNSGCPConfigFluent<ManageDNSGCPConfigBuilder> implements VisitableBuilder<ManageDNSGCPConfig,ManageDNSGCPConfigBuilder>{

  ManageDNSGCPConfigFluent<?> fluent;

  public ManageDNSGCPConfigBuilder() {
    this(new ManageDNSGCPConfig());
  }
  
  public ManageDNSGCPConfigBuilder(ManageDNSGCPConfigFluent<?> fluent) {
    this(fluent, new ManageDNSGCPConfig());
  }
  
  public ManageDNSGCPConfigBuilder(ManageDNSGCPConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManageDNSGCPConfigBuilder(ManageDNSGCPConfigFluent<?> fluent,ManageDNSGCPConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManageDNSGCPConfig build() {
    ManageDNSGCPConfig buildable = new ManageDNSGCPConfig(fluent.buildCredentialsSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}