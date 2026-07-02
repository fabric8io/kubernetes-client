package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodDNSConfigBuilder extends PodDNSConfigFluent<PodDNSConfigBuilder> implements VisitableBuilder<PodDNSConfig,PodDNSConfigBuilder>{

  PodDNSConfigFluent<?> fluent;

  public PodDNSConfigBuilder() {
    this(new PodDNSConfig());
  }
  
  public PodDNSConfigBuilder(PodDNSConfigFluent<?> fluent) {
    this(fluent, new PodDNSConfig());
  }
  
  public PodDNSConfigBuilder(PodDNSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodDNSConfigBuilder(PodDNSConfigFluent<?> fluent,PodDNSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodDNSConfig build() {
    PodDNSConfig buildable = new PodDNSConfig(fluent.getNameservers(), fluent.buildOptions(), fluent.getSearches());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}