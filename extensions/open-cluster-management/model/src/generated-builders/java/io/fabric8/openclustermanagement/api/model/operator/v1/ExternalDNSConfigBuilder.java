package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalDNSConfigBuilder extends ExternalDNSConfigFluent<ExternalDNSConfigBuilder> implements VisitableBuilder<ExternalDNSConfig,ExternalDNSConfigBuilder>{

  ExternalDNSConfigFluent<?> fluent;

  public ExternalDNSConfigBuilder() {
    this(new ExternalDNSConfig());
  }
  
  public ExternalDNSConfigBuilder(ExternalDNSConfigFluent<?> fluent) {
    this(fluent, new ExternalDNSConfig());
  }
  
  public ExternalDNSConfigBuilder(ExternalDNSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalDNSConfigBuilder(ExternalDNSConfigFluent<?> fluent,ExternalDNSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalDNSConfig build() {
    ExternalDNSConfig buildable = new ExternalDNSConfig(fluent.buildAws(), fluent.buildGcp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}