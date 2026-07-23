package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FrontendTLSConfigBuilder extends FrontendTLSConfigFluent<FrontendTLSConfigBuilder> implements VisitableBuilder<FrontendTLSConfig,FrontendTLSConfigBuilder>{

  FrontendTLSConfigFluent<?> fluent;

  public FrontendTLSConfigBuilder() {
    this(new FrontendTLSConfig());
  }
  
  public FrontendTLSConfigBuilder(FrontendTLSConfigFluent<?> fluent) {
    this(fluent, new FrontendTLSConfig());
  }
  
  public FrontendTLSConfigBuilder(FrontendTLSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FrontendTLSConfigBuilder(FrontendTLSConfigFluent<?> fluent,FrontendTLSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FrontendTLSConfig build() {
    FrontendTLSConfig buildable = new FrontendTLSConfig(fluent.buildDefault(), fluent.buildPerPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}