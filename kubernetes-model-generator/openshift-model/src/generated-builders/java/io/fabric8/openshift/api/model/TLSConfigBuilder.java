package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSConfigBuilder extends TLSConfigFluent<TLSConfigBuilder> implements VisitableBuilder<TLSConfig,TLSConfigBuilder>{

  TLSConfigFluent<?> fluent;

  public TLSConfigBuilder() {
    this(new TLSConfig());
  }
  
  public TLSConfigBuilder(TLSConfigFluent<?> fluent) {
    this(fluent, new TLSConfig());
  }
  
  public TLSConfigBuilder(TLSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSConfigBuilder(TLSConfigFluent<?> fluent,TLSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSConfig build() {
    TLSConfig buildable = new TLSConfig(fluent.getCaCertificate(), fluent.getCertificate(), fluent.getDestinationCACertificate(), fluent.buildExternalCertificate(), fluent.getInsecureEdgeTerminationPolicy(), fluent.getKey(), fluent.getTermination());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}