package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSOverTLSConfigBuilder extends DNSOverTLSConfigFluent<DNSOverTLSConfigBuilder> implements VisitableBuilder<DNSOverTLSConfig,DNSOverTLSConfigBuilder>{

  DNSOverTLSConfigFluent<?> fluent;

  public DNSOverTLSConfigBuilder() {
    this(new DNSOverTLSConfig());
  }
  
  public DNSOverTLSConfigBuilder(DNSOverTLSConfigFluent<?> fluent) {
    this(fluent, new DNSOverTLSConfig());
  }
  
  public DNSOverTLSConfigBuilder(DNSOverTLSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSOverTLSConfigBuilder(DNSOverTLSConfigFluent<?> fluent,DNSOverTLSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSOverTLSConfig build() {
    DNSOverTLSConfig buildable = new DNSOverTLSConfig(fluent.getCaBundle(), fluent.getServerName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}