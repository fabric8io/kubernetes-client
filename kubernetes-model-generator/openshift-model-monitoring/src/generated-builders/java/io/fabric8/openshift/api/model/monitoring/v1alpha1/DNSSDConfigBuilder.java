package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSSDConfigBuilder extends DNSSDConfigFluent<DNSSDConfigBuilder> implements VisitableBuilder<DNSSDConfig,DNSSDConfigBuilder>{

  DNSSDConfigFluent<?> fluent;

  public DNSSDConfigBuilder() {
    this(new DNSSDConfig());
  }
  
  public DNSSDConfigBuilder(DNSSDConfigFluent<?> fluent) {
    this(fluent, new DNSSDConfig());
  }
  
  public DNSSDConfigBuilder(DNSSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSSDConfigBuilder(DNSSDConfigFluent<?> fluent,DNSSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSSDConfig build() {
    DNSSDConfig buildable = new DNSSDConfig(fluent.getNames(), fluent.getPort(), fluent.getRefreshInterval(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}