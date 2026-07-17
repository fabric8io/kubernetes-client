package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSTransportConfigBuilder extends DNSTransportConfigFluent<DNSTransportConfigBuilder> implements VisitableBuilder<DNSTransportConfig,DNSTransportConfigBuilder>{

  DNSTransportConfigFluent<?> fluent;

  public DNSTransportConfigBuilder() {
    this(new DNSTransportConfig());
  }
  
  public DNSTransportConfigBuilder(DNSTransportConfigFluent<?> fluent) {
    this(fluent, new DNSTransportConfig());
  }
  
  public DNSTransportConfigBuilder(DNSTransportConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSTransportConfigBuilder(DNSTransportConfigFluent<?> fluent,DNSTransportConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSTransportConfig build() {
    DNSTransportConfig buildable = new DNSTransportConfig(fluent.buildTls(), fluent.getTransport());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}