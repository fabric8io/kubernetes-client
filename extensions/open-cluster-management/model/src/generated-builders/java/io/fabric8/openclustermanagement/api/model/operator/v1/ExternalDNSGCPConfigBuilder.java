package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalDNSGCPConfigBuilder extends ExternalDNSGCPConfigFluent<ExternalDNSGCPConfigBuilder> implements VisitableBuilder<ExternalDNSGCPConfig,ExternalDNSGCPConfigBuilder>{

  ExternalDNSGCPConfigFluent<?> fluent;

  public ExternalDNSGCPConfigBuilder() {
    this(new ExternalDNSGCPConfig());
  }
  
  public ExternalDNSGCPConfigBuilder(ExternalDNSGCPConfigFluent<?> fluent) {
    this(fluent, new ExternalDNSGCPConfig());
  }
  
  public ExternalDNSGCPConfigBuilder(ExternalDNSGCPConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalDNSGCPConfigBuilder(ExternalDNSGCPConfigFluent<?> fluent,ExternalDNSGCPConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalDNSGCPConfig build() {
    ExternalDNSGCPConfig buildable = new ExternalDNSGCPConfig(fluent.buildCredentials());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}